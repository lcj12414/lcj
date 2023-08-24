package com.kugouXM.POJO;

import org.seimicrawler.xpath.JXNode;

import java.util.List;

public class pojo {

    private String name;
    private String url;

    public pojo() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geturl() {
        return url;
    }

    public void seturl(String url) {
        this.url = url;
    }







//    public static List<pojo> list() {
//
//        List<pojo> logList = new ArrayList<>();
//
//        for (int i = 0; i < 20; i++) {
//
//            pojo log = new pojo();
//            log.setId(1);
//            log.setName("DSANKL");
//            log.seturl("sAS");
//            logList.add(log);
//
//        }
//
//        return logList;
//
//    }


    @Override
    public String toString() {
        return "Product{" +
                "title='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public pojo(String name, String url) {
        super();
        this.name = name;
        this.url = url;
    }

    public void setName(List<JXNode> a) {
    }
}
