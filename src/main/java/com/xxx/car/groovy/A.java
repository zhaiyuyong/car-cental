package com.xxx.car.groovy;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class A {

	public static void main(String[] args) {
		String a = "[超值1+1]微糖及时雨套餐";
		System.out.println(a.getBytes().length + "--" + a.length());
		System.out.println(URLEncoder.encode("http://www.welltang.com/webapp/bybapp.php?page=knowledge_detail&amp;id=3013&amp;cid=54"));
	}
}
