package com.web.sky.mylibrary;

import android.text.Html;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能：
 * Created by xuzhiyong on 17/8/17.
 */

public class Test {

    public static final String mRegexStr = "\\{.*?\\}";

    public static final String HIGHTLINETAG = "hightline";

    public static final String mRegexStrSZ = "([a-z|A-Z|0-9]*)";

    public static final String mUrlRegexStr = "\\{([http|https]+://[a-z|A-Z|\\d|\\?|&|=|/|,|\\.|\\-|_]*)\\}";

    public static void main(String[] args){


        testRegexHttp();



//        testRegex();

//        double a = 51125.115;
//        System.out.println(NumberFormatUtils.formatRankNum(a));
    }

    private static void testRegexHttp() {
        String content = "链接：{https://www.baidu.com}，{http://www.baidu.com}，链接高亮且可点击有没有问题？ \n" +
                "\n" +
                "（换行） 括号括起来高亮，客户端去掉括号：{SDFRFGGRF68992}\n" +
                "\n" +
                "再来个中文的 {哈哈哈我亮了吗？}\n" +
                "\n" +
                "么么哒，搞事情啊~~ 空一行来一句，撒哟啦啦~~";
        content = content.replaceAll(mUrlRegexStr,"<" + HIGHTLINETAG + " href='$1'>$1</" + HIGHTLINETAG + ">");
        content = content.replaceAll(mRegexStr,"<" + HIGHTLINETAG+ ">$0</" + HIGHTLINETAG + ">");
        content = content.replaceAll("\\{|\\}","");
        content = content.replaceAll("\\n","<br/>");
        System.out.println(Html.fromHtml(content,null,null));

    }


    public static void testRegex(){
        String content = "赠送{550钻石},送55大圣币";

        content = content.replaceAll(mRegexStr,"<" + HIGHTLINETAG+ ">$0</" + HIGHTLINETAG + ">").replaceAll("\\{|\\}","");
        System.out.println(content);
    }




    public static String formatNumberByComma(double number){
        String strNum = String .format("%.2f",number);

        String[] nums = strNum.split("\\.");
        String prefixNum = nums[0];
        String result = prefixNum;
        int n = prefixNum.length() % 3; //每三位用逗号分开。
        if(n == 0){
            result = prefixNum.replaceAll("(\\d{3})", ",$1").substring(1); //这里的$1是指前面正则中的第一个括号中的内容
        } else {
            result = prefixNum.substring(0, n)+prefixNum.substring(n).replaceAll("(\\d{3})", ",$1");
        }

        if(nums.length >1 && Long.valueOf(nums[1]) > 0){
            if(1 == nums[1].lastIndexOf("0")){
                nums[1] = nums[1].substring(0,1);
            }
            result+="."+nums[1];
        }

        return result;
    }

}
