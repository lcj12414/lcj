package com.kugouXM.ExcelWork;

//import com.kugouXM.Dao.PanChongDao;
import com.kugouXM.POJO.pojo;
import com.kugouXM.ExcelWork.ParserExcel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static void main(String[] args) throws IOException {
        List<pojo> list = null;
        list = JsoupExcel("https://www.kugou.com/yy/rank/home/1-8888.html?from=rank");
//        list=HtmlParser("https://www.kugou.com/yy/rank/home/1-8888.html?from=rank");
//        ParserExcel.toExcel(list);
//        ParserExcel.readExcel();
//        ParserExcel.copyExcel();
//        PanChongDao  user=new PanChongDao();
    }
    private static List<pojo> JsoupExcel(String url) throws IOException {
        List<pojo> userList=new ArrayList<pojo>();
        Document document = Jsoup.connect(url).get();
        Elements table = document.select("div.pc_temp_songlist");
        Elements uls = table.select("ul");
        Elements lis = uls.select("li");
        for (Element element : lis) {
            pojo user = new pojo();
            user.setName(element.select("a").text());
            user.seturl(element.select("a").attr("href"));
            userList.add(user);
        }
        return userList;
    }

//    private static List<pojo> HtmlParser(String url) throws IOException {
//        List<pojo> userList=new ArrayList<pojo>();
//        JXDocument document = JXDocument.createByUrl(url);
//        List<JXNode> table = document.selN("[@class='pc_temp_songlist ']/ul/li/a");
//        //循环遍历节点
//        for (JXNode element :table) {
//            pojo user=new pojo();
//            user.setName(element.sel("a"));
//            userList.add(user);
//        }
//        return userList;
//    }
}