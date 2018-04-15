package com.cienet.sessionclient;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;

public class SessionInfo {

    public static void readXML() throws DocumentException {
        SAXReader sr = new SAXReader();// 获取读取xml的对象。
        Document doc = sr.read("D:\\LTEB-Session\\src\\main\\resources\\SessionInfo.xml");// 得到xml所在位置。然后开始读取。并将数据放入doc中
        Element el_root = doc.getRootElement();// 向外取数据，获取xml的根节点。
        Iterator it = el_root.elementIterator();// 从根节点下依次遍历，获取根节点下所有子节点

        while (it.hasNext()) {// 遍历该子节点
            Object o = it.next();// 再获取该子节点下的子节点
            Element el_row = (Element) o;
            String s = el_row.getText();
            System.out.println(s);
            Iterator it_row = el_row.elementIterator();
            while (it_row.hasNext()) {// 遍历节点
                Element el_ename = (Element) it_row.next();// 获取该节点下的所有数据。
                System.out.println(el_ename.getText());
            }
        }
    }

}
