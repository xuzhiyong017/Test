package com.web.sky.mylibrary;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 数字格式工具类
 * User: Xu zhiyong(18971269648@163.com)
 * Date: 17/3/15
 */
public class NumberFormatUtils {

    private final static String unit_10k = "万";
    private final static String unit_10m = "千万";
    private final static String unit_100m = "亿";


    //格式化数字保留两位小数点
    public static String formatWithTenMillionToPositiveNum(double value) {

        String strarr[];
        String tmp = "";
        if (value < 100000) {
            return String.valueOf(value) + " ";
        }
        if (value < 1000000) {
            tmp = String.valueOf(value / (float) 10000);

            strarr = tmp.split("\\.");

            if (strarr.length > 1 && strarr[1] != null && !"".equals(strarr[1])) {
                if (strarr[1].length() < 2) {
                    if (Long.valueOf(strarr[1]) <= 0) {
                        return strarr[0] + unit_10k;
                    } else if (strarr[1].length() == 1) {
                        return strarr[0] + "." + strarr[1] + unit_10k;
                    }
                } else {
                    return strarr[0] + "." + strarr[1].substring(0, 2) + unit_10k;
                }
            }
            return strarr[0] + unit_10k;
        }

        if (value < 100000000) {
            tmp = String.valueOf(value / (float) 10000);

            strarr = tmp.split("\\.");

            if (strarr.length > 1 && strarr[1] != null && !"".equals(strarr[1])) {
                if (strarr[1].length() < 2) {
                    if (Long.valueOf(strarr[1]) <= 0) {
                        return strarr[0] + unit_10k;
                    } else if (strarr[1].length() == 1) {
                        return strarr[0] + "." + strarr[1] + unit_10k;
                    }
                } else {
                    return strarr[0] + "." + strarr[1].substring(0, 2) + unit_10k;
                }
            }
            return strarr[0] + unit_10k;
        }

        tmp = String.valueOf(value / (float) 100000000);
        strarr = tmp.split("\\.");
        if (strarr.length > 1 && strarr[1] != null && !"".equals(strarr[1])) {
            if (strarr[1].length() < 2) {
                if (Long.valueOf(strarr[1]) <= 0) {
                    return strarr[0] + unit_100m;
                } else if (strarr[1].length() == 1) {
                    return strarr[0] + "." + strarr[1] + unit_100m;
                }
            } else {
                return strarr[0] + "." + strarr[1].substring(0, 2) + unit_100m;
            }
        }

        return strarr[0] + unit_100m;
    }


    public static String formatRankNum(double numbers){

        String strStart = formatWithTenMillionToNum(numbers);
        if(strStart.contains("万")){
            return strStart;
        }

        double value = Math.abs(Float.valueOf(strStart));
        if(value >= 1){
            return String.valueOf((int)value);
        }else {
            return "1";
        }
    }


    public static String formatWithTenMillionToNum(double numbers) {

        String finalStr = "";

        double value = Math.abs(numbers);
        String resultStr = formatWithTenMillionToPositiveNum(value);
        String endsStr = resultStr.substring(resultStr.length() - 1, resultStr.length());

        float result = Float.valueOf(resultStr.substring(0, resultStr.length() - 1));
        result = result / (float) 1;
        String[] arr = String.valueOf(result).split("\\.");
        if (arr.length > 1 && arr[1] != null && !"".equals(arr[1])) {
            if (Integer.valueOf(arr[1]) > 0) {
                finalStr = String.valueOf(result) + endsStr;
            } else {
                finalStr = arr[0] + endsStr;
            }
        }

        if (numbers < 0) {
            return "-" + finalStr;
        }
        return finalStr.trim();
    }
    //大于十万转化为小数点
    public static String formatWithShiwanToNum(double total) {
        String finalStr = "";
        if (total > 100000) {
            double tmp = total/10000;
            DecimalFormat decimalFormat = new DecimalFormat(".0");//构造方法的字符格式这里如果小数不足2位,会以0补足.
            String p = decimalFormat.format(tmp);//format 返回的是字符串
            finalStr = String.valueOf(p)+"万";
        }else {
            finalStr = String.valueOf((int)total);
        }
        return finalStr;
    }

    private static DecimalFormat sDecimalFormat = new DecimalFormat(".0");
    private static DecimalFormat sZhengDecimalFormat = new DecimalFormat("#");
    //大于一千用千表示，小数点后保留一位，大于一万，用万表示, 小数点后保留一位
    public static String formatWithPointBeforeOne(double total) {
        String finalStr = "";
        if (total > 0 && total < 1000) {
            finalStr = String.valueOf((int)total);
        }
        else if (total > 999 && total < 10000) {
            double tmp = total/1000;
            double tmpYu = total%1000;
            if (tmpYu > 0) {
                String p = sDecimalFormat.format(tmp);
                finalStr = String.valueOf(p)+"K";
            }else {
                String p = sZhengDecimalFormat.format(tmp);
                finalStr = String.valueOf(p)+"K";
            }
        }else if (total > 9999 && total < 10000000) {
            double tmp = total/10000;
            double tmpYu = total%10000;
            if (tmpYu > 0) {
                String p = sDecimalFormat.format(tmp);
                finalStr = String.valueOf(p) + "W";
            }else {
                String p = sZhengDecimalFormat.format(tmp);
                finalStr = String.valueOf(p) + "W";
            }
        }else {
            finalStr = "999W+";
        }
        return finalStr;
    }
    //获取不带小数点的double
    public static String formatWithZheng(double src) {
        return sZhengDecimalFormat.format(src);
    }

    private static DecimalFormat sTwoFormat = new DecimalFormat("00");
    public static String formatWithTwo(int total) {
        return sTwoFormat.format(total);
    }

    public static String getFormatTime(String data) {
        SimpleDateFormat df = new SimpleDateFormat("MM月dd日 HH:mm");
        Date date = getDate(data);
        String s = "";
        if (date != null) {
            s = df.format(date);
        }
        return s;
    }

    public static Date getDate(String data) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = null;
        try {
            date = df.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将时间变成分钟和秒的形式
     *
     * @param totalTime
     * @return
     */
    public static String formateMinuteAndSecond(long totalTime) {
        SimpleDateFormat df = new SimpleDateFormat("mm:ss");
        Date date = new Date(totalTime);
        return df.format(date);
    }

    /**
     * 用逗号格式化数字
     * Example:1234567890 -> 1,234,567,890; 123456789->123,456,789
     * @param number
     * @return
     */
    public static String formatNumberByComma(long number){
        String strNum = String.valueOf(number);
        String result = strNum;
        int n = strNum.length() % 3; //每三位用逗号分开。
        if(n == 0){
            result = strNum.replaceAll("(\\d{3})", ",$1").substring(1); //这里的$1是指前面正则中的第一个括号中的内容
        } else {
            result = strNum.substring(0, n)+strNum.substring(n).replaceAll("(\\d{3})", ",$1");
        }

        return result;
    }

    /**
     * 返回"，"分隔数字，末尾显示小数点两位
     * @param number
     * @return
     */
    public static String formatNumberByComma(double number){
        try {
            String strNum = String.format("%.2f",number);

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
        }catch (Exception e){
            e.printStackTrace();
            return "0";
        }
    }

    /**
     * 末尾显示小数点两位
     * @param number
     * @return
     */
    public static String formatNumberTwoDecimal(double number){
        try {
            String strNum = String.format("%.2f",number);

            String[] nums = strNum.split("\\.");
            String prefixNum = nums[0];
            String result = prefixNum;

            if(nums.length >1 && Long.valueOf(nums[1]) > 0){
                if(1 == nums[1].lastIndexOf("0")){
                    nums[1] = nums[1].substring(0,1);
                }
                result+="."+nums[1];
            }

            return result;
        }catch (Exception e){
            e.printStackTrace();
            return "0";
        }
    }
}
