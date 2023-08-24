package com.kugouXM.Dao;

import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class DBController {
    public static void main(String[] args) throws SQLException, BiffException, IOException {
        PangChongDao dao=new PangChongDao();
        dao.addUrl(new File("data/a.xlsx"));

    }
}


