# lcj
kugou-top500爬取

运行环境：IDEA

用HttpClient获取网页信息后再用dom选择器遍历网页，根据标签和class获取元素。还有一个方法就是用JsoupXpath爬取网页，先创建一个JXDocument，再通过xpath语句获取标签节点，获取节点后循环遍历取出其中的元素。最后再将爬取酷狗top500榜单的内容并将其存到mysql数据库中，就是没有实现对网页的请求和响应，同时完成前端静态网页的设计。
