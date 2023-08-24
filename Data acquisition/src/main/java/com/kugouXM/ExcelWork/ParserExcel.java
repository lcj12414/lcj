package com.kugouXM.ExcelWork;

import com.kugouXM.POJO.pojo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class ParserExcel {
    public static void main(String[] args) throws IOException {

    }
    public static void toExcel(List<pojo> list) throws IOException {
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建表
        XSSFSheet sheet = workbook.createSheet();
        //表头
        XSSFRow row = sheet.createRow(0);
        XSSFCell celltitle1=row.createCell(0);
        celltitle1.setCellValue("歌曲");
        XSSFCell celltitle2=row.createCell(1);
        celltitle2.setCellValue("链接");
        for (int i = 0;i<list.size();i++){
            XSSFRow rowcontent = sheet.createRow(i + 1);
            XSSFCell cell1 =rowcontent.createCell(0);
            XSSFCell cell2=rowcontent.createCell(1);
            //在单元格写入数据
            cell1.setCellValue(list.get(i).getName());
            cell2.setCellValue(list.get(i).geturl());
        }
        workbook.write(new FileOutputStream(new File("data/a.xlsx")));
        workbook.close();
    }

    public static void readExcel() throws IOException {
        //文件名称
        File file=new File("data/a.xlsx");
        //根据文件名称获取操作的工作薄
        Workbook workBook = getWorkBook(file);
        //获取新的工作薄
        Sheet sheet = workBook.getSheetAt(0);
        //获取行数
        int allRow=sheet.getLastRowNum();
        //按行读取数据
        for(int i=0;i<=allRow;i++){
            Row row = sheet.getRow(i);
            //获取列数
            short lastCellNum = row.getLastCellNum();
            for(int j=0;j<lastCellNum;j++){
                String cellValue = row.getCell(j).getStringCellValue();
                System.out.print(cellValue+"\t");
            }
            System.out.println();
        }
        workBook.close();
    }

    private static Workbook getWorkBook(File file) throws IOException {
        InputStream in=new FileInputStream(file);
        Workbook workbook=null;
        //Excel2003
        if(file.getName().endsWith("xls")){
            workbook=new HSSFWorkbook(in);
        }else if(file.getName().endsWith("xlsx")){
            //Excel2007以上版本
            workbook=new XSSFWorkbook(in);
        }
        in.close();
        return workbook;
    }

    public static void copyExcel() throws IOException {
        FileInputStream in = new FileInputStream(new File("data/a.xlsx"));
        File file = new File("data/b.xlsx");
        FileOutputStream out = new FileOutputStream(file);
        if (file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int temp;
        while ((temp=in.read())!=-1){
            out.write(temp);
        }
        in.close();
        out.close();
    }
}
