package com.kugouXM.Dao;

import com.kugouXM.POJO.pojo;
import com.kugouXM.Dao.utils.JdbcUtil;
import jxl.read.biff.BiffException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PangChongDao {



    public void addUrl(File file) throws SQLException, BiffException, IOException {
        String sql="insert into parser values(?,?)";

        Connection conn= JdbcUtil.createConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(file));
        //获取名称为sheet1的表格
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
        try {

            //3. 创建PreParedStatement
            pstmt = conn.prepareStatement(sql);
            //4. 执行sql操作
//            rs = pstmt.executeQuery();

            //5.处理结果集 （查询的时候会有结果集，增删改不会）
            int maxRow = sheet.getLastRowNum();
            for (int i = 1; i < maxRow; i++) {
                String name = " ";
                String url = " ";
                //获取最后单元格num，即总单元格数 ***注意：此处从1开始计数***
                int maxCol = sheet.getRow(i).getLastCellNum();
                for (int j = 0; j < maxCol; ) {
                    name =  sheet.getRow(i).getCell(j) + " ";
                    url = sheet.getRow(i).getCell(j+1)+ " ";
                    pstmt.setString(1,name);
                    pstmt.setString(2,url);
                    j=2;
                    int count=pstmt.executeUpdate();
                    if(count>0){
                        System.out.println("第"+i+"行数据写入成功");
                    }
                }

            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn,pstmt, (Connection) rs);
        }
    }
}
