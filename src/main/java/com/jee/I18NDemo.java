package com.jee;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18NDemo {
  public static void main(String[] args) {
//   locale();
//   i18n();
//    order();
    format();
  }

  //知道所在语言和地区
  static void locale(){
    Locale loc=Locale.getDefault();
    System.out.println(loc);
    System.out.println(Locale.forLanguageTag("zh_MO"));
  }
  //资源包,根据基本名+当前语言地区得到当前用哪个  msg msg_zh_CN msg_zh_MO
  //Properties Map

  static void i18n(){
    ResourceBundle bundle=ResourceBundle.getBundle("msg");
    String welmsg=bundle.getString("wel.msg");
    System.out.println(welmsg);
  }
  //资源包,根据基本名+当前地区语言，得到哪个用哪个 msg
  //找不到指定的就找默认的，找到默认的，去找父资源包

  //指定的语言_指定的地区 zh_CN
  //指定的语言 zh
  //缺省的语言_缺省的地区
  //缺省的语言
  //基本名
  //msg_zh msg
  static void order(){
    ResourceBundle bundle=ResourceBundle.getBundle("msg",Locale.forLanguageTag("fr"));
    String welmsg=bundle.getString("wel.msg");
    System.out.println(welmsg);
  }
  static void format(){
    ResourceBundle bundle=ResourceBundle.getBundle("msg");
    String pattern=bundle.getString("wel.arg");
    String res= MessageFormat.format(pattern,"zhangsan","123");
    System.out.println(res);
  }



}
