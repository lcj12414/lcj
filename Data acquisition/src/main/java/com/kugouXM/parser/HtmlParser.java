package com.kugouXM.parser;

import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;

import java.util.List;

public class HtmlParser {
    public static void main(String[] args) {
        //基于URL来创建JXDocument
        JXDocument jxd=JXDocument.createByUrl("https://www.kugou.com/yy/rank/home/1-8888.html?from=rank");
        //xpath语句
        String str="//*[@class='pc_temp_songlist ']/ul/li/a";
        //获取节点集合
        List<JXNode> list = jxd.selN(str);
        //循环遍历节点
        for(int i=0;i<list.size();i++){
            JXNode node = list.get(i);
            System.out.println("歌曲："+node.asElement().text()+"\t URL为："+node.asElement().attr("href"));
        }
    }
}
