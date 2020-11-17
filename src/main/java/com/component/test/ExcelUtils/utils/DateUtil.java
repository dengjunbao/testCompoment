package com.component.test.ExcelUtils.utils;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: bao
 * @Date: 2020/8/28 0028 16:56
 */
public class DateUtil {
    public static final int DAYS_OF_WEEK = 7;
    public static final int SECS_OF_DAY = 86400;
    public static final String ISO_DATE_FORMAT = "yyyyMMdd";
    public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";
    private static final int ID_BYTES = 10;
    public static String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static String DATE_PATTERN = "yyyyMMddHHiotitss";
    private static boolean LENIENT_DATE = false;
    private static Random random = new Random();
    private static int[] SECONDS = new int[]{3600, 60, 1};

    public DateUtil() {
    }

    public static synchronized String generateId() {
        StringBuffer result = new StringBuffer();
        result = result.append(System.currentTimeMillis());

        for(int i = 0; i < 10; ++i) {
            result = result.append(random.nextInt(10));
        }

        return result.toString();
    }

    protected static final float normalizedJulian(float JD) {
        float f = (float)Math.round(JD + 0.5F) - 0.5F;
        return f;
    }

    public static final Date toDate(float JD) {
        float Z = normalizedJulian(JD) + 0.5F;
        float W = (float)((int)((Z - 1867216.2F) / 36524.25F));
        float X = (float)((int)(W / 4.0F));
        float A = Z + 1.0F + W - X;
        float B = A + 1524.0F;
        float C = (float)((int)(((double)B - 122.1D) / 365.25D));
        float D = (float)((int)(365.25F * C));
        float E = (float)((int)((double)(B - D) / 30.6001D));
        float F = (float)((int)(30.6001F * E));
        int day = (int)(B - D - F);
        int month = (int)(E - 1.0F);
        if (month > 12) {
            month -= 12;
        }

        int year = (int)(C - 4715.0F);
        if (month > 2) {
            --year;
        }

        Calendar c = Calendar.getInstance();
        c.set(1, year);
        c.set(2, month - 1);
        c.set(5, day);
        return c.getTime();
    }

    public static final int daysBetween(Date early, Date late) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(early);
        c2.setTime(late);
        return daysBetween(c1, c2);
    }

    public static final int daysBetween(Calendar early, Calendar late) {
        return (int)(toJulian(late) - toJulian(early));
    }

    public static final float toJulian(Calendar c) {
        int Y = c.get(1);
        int M = c.get(2);
        int D = c.get(5);
        int A = Y / 100;
        int B = A / 4;
        int C = 2 - A + B;
        float E = (float)((int)(365.25F * (float)(Y + 4716)));
        float F = (float)((int)(30.6001F * (float)(M + 1)));
        float JD = (float)(C + D) + E + F - 1524.5F;
        return JD;
    }

    public static final float toJulian(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return toJulian(c);
    }

    public static final String dateIncrease(String isoString, String fmt, int field, int amount) {
        try {
            Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT"));
            cal.setTime(stringToDate(isoString, fmt, true));
            cal.add(field, amount);
            return dateToString(cal.getTime(), fmt);
        } catch (Exception var5) {
            return null;
        }
    }

    public static final String roll(String isoString, String fmt, int field, boolean up) throws ParseException {
        Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.setTime(stringToDate(isoString, fmt));
        cal.roll(field, up);
        return dateToString(cal.getTime(), fmt);
    }

    public static final String roll(String isoString, int field, boolean up) throws ParseException {
        return roll(isoString, DATETIME_PATTERN, field, up);
    }

    public static Date stringToDate(String dateText, String format, boolean lenient) {
        if (dateText == null) {
            return null;
        } else {
            SimpleDateFormat df = null;

            try {
                if (format == null) {
                    df = new SimpleDateFormat();
                } else {
                    df = new SimpleDateFormat(format);
                }

                df.setLenient(false);
                return df.parse(dateText);
            } catch (ParseException var5) {
                return null;
            }
        }
    }

    public static Timestamp getCurrentTimestamp() {
        return new Timestamp((new Date()).getTime());
    }

    public static Date stringToDate(String dateString, String format) {
        return stringToDate(dateString, format, LENIENT_DATE);
    }

    public static Date stringToDate(String dateString) {
        return stringToDate(dateString, "yyyy-MM-dd", LENIENT_DATE);
    }

    public static Date intToDate(int time) {
        return stringToDate(date("Y-m-d H:i:s", time), "yyyy-MM-dd", LENIENT_DATE);
    }

    public static String dateToString(Date date, String pattern) {
        if (date == null) {
            return null;
        } else {
            try {
                SimpleDateFormat sfDate = new SimpleDateFormat(pattern);
                sfDate.setLenient(false);
                return sfDate.format(date);
            } catch (Exception var3) {
                return null;
            }
        }
    }

    public static String dateToString(Date date) {
        return dateToString(date, "yyyy-MM-dd");
    }

    public static Date getCurrentDateTime() {
        Calendar calNow = Calendar.getInstance();
        Date dtNow = calNow.getTime();
        return dtNow;
    }

    public static String getCurrentDateString(String pattern) {
        return dateToString(getCurrentDateTime(), pattern);
    }

    public static String getCurrentDateString() {
        return dateToString(getCurrentDateTime(), "yyyy-MM-dd");
    }

    public static String dateToStringWithTime() {
        return dateToString(new Date(), DATETIME_PATTERN);
    }

    public static String dateToStringWithTime(Date date) {
        return dateToString(date, DATETIME_PATTERN);
    }

    public static Date dateIncreaseByDay(Date date, int days) {
        Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
        cal.setTime(date);
        cal.add(5, days);
        return cal.getTime();
    }

    public static Date dateIncreaseByMonth(Date date, int mnt) {
        Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
        cal.setTime(date);
        cal.add(2, mnt);
        return cal.getTime();
    }

    public static Date dateIncreaseByYear(Date date, int mnt) {
        Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
        cal.setTime(date);
        cal.add(1, mnt);
        return cal.getTime();
    }

    public static String dateIncreaseByDay(String date, int days) {
        return dateIncreaseByDay(date, "yyyyMMdd", days);
    }

    public static String dateIncreaseByDay(String date, String fmt, int days) {
        return dateIncrease(date, fmt, 5, days);
    }

    public static String stringToString(String src, String srcfmt, String desfmt) {
        return dateToString(stringToDate(src, srcfmt), desfmt);
    }

    public static String getYear(Date date) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy");
        String cur_year = formater.format(date);
        return cur_year;
    }

    public static String getMonth(Date date) {
        SimpleDateFormat formater = new SimpleDateFormat("MM");
        String cur_month = formater.format(date);
        return cur_month;
    }

    public static String getDay(Date date) {
        SimpleDateFormat formater = new SimpleDateFormat("dd");
        String cur_day = formater.format(date);
        return cur_day;
    }

    public static String getHour(Date date) {
        SimpleDateFormat formater = new SimpleDateFormat("HH");
        String cur_day = formater.format(date);
        return cur_day;
    }

    public static int getMinsFromDate(Date dt) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(dt);
        int hour = cal.get(11);
        int min = cal.get(12);
        return hour * 60 + min;
    }

    public static Date convertToDate(String str, boolean isExpiry) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date dt = null;

        try {
            dt = fmt.parse(str);
        } catch (ParseException var6) {
            Calendar cal = Calendar.getInstance();
            if (isExpiry) {
                cal.add(5, 1);
                cal.set(11, 23);
                cal.set(12, 59);
            } else {
                cal.set(11, 0);
                cal.set(12, 0);
            }

            dt = cal.getTime();
        }

        return dt;
    }

    public static Date convertToDate(String str) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date dt = null;

        try {
            dt = fmt.parse(str);
        } catch (ParseException var4) {
            dt = new Date();
        }

        return dt;
    }

    public static String dateFromat(Date date, int minute) {
        String dateFormat = null;
        int year = Integer.parseInt(getYear(date));
        int month = Integer.parseInt(getMonth(date));
        int day = Integer.parseInt(getDay(date));
        int hour = minute / 60;
        int min = minute % 60;
        dateFormat = year + (month > 9 ? String.valueOf(month) : "0" + String.valueOf(month)) + (day > 9 ? String.valueOf(day) : "0" + String.valueOf(day)) + " " + (hour > 9 ? String.valueOf(hour) : "0" + String.valueOf(hour)) + (min > 9 ? String.valueOf(min) : "0" + String.valueOf(min)) + "00";
        return dateFormat;
    }

    public static String sDateFormat() {
        return (new SimpleDateFormat(DATE_PATTERN)).format(Calendar.getInstance().getTime());
    }

    public static long currentTimeLong() {
        return System.currentTimeMillis() / 1000L;
    }

    public static Integer currentTime() {
        Long timeStamp = currentTimeLong();
        return timeStamp.intValue();
    }

    public static String date(String fmt, Long time) {
        time = time * 1000L;
        fmt = handleFmt(fmt);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fmt);
        long lt = new Long(time);
        Date date = new Date(lt);
        String res = simpleDateFormat.format(date);
        return res;
    }

    public static String date(String fmt, Integer time) {
        return date(fmt, time.longValue());
    }

    private static String handleFmt(String fmt) {
        fmt = fmt.replaceAll("y", "yy").replaceAll("Y", "yyyy").replaceAll("M", "M").replaceAll("m", "MM").replaceAll("D", "d").replaceAll("d", "dd").replaceAll("H", "HH").replaceAll("h", "hh").replaceAll("i", "mm").replaceAll("I", "m").replaceAll("s", "ss").replaceAll("S", "s");
        return fmt;
    }

    public static String date(String fmt) {
        return date(fmt, currentTime());
    }

    public static long strtotime(String data) {
        if (data.trim().length() == 7) {
            data = data + "-01 00:00:00";
        } else if (data.trim().length() == 10) {
            data = data + " 00:00:00";
        }

        return strtotime(data, DATETIME_PATTERN);
    }

    public static long strtotime(String data, String fmt) {
        if (data.indexOf("/") >= 0) {
            data = data.replaceAll("/", "-");
        }

        if (data.indexOf(".") >= 0) {
            data = data.replaceAll("\\.", "-");
        }

        if (data.indexOf("年") >= 0) {
            data = data.replaceAll("年", "-");
        }

        if (data.indexOf("月") >= 0) {
            data = data.replaceAll("月", "-");
        }

        if (data.indexOf("日") >= 0) {
            data = data.replaceAll("日", " ");
        }

        if (data.indexOf("时") >= 0) {
            data = data.replaceAll("时", ":");
        }

        if (data.indexOf("分") >= 0) {
            data = data.replaceAll("分", ":");
        }

        if (data.indexOf("秒") >= 0) {
            data = data.replaceAll("秒", "");
        }

        long time = stringToDate(data, fmt, LENIENT_DATE).getTime() / 1000L;
        return time;
    }

    public static int IncreaseByYear(int time, int years) {
        return IncreaseByYear(date("Y-m-d H:i:s", time), years);
    }

    public static int IncreaseByYear(String time, int years) {
        Long rs = dateIncreaseByYear(convertToDate(time), years).getTime() / 1000L;
        return rs.intValue();
    }

    public static int IncreaseByMonth(int time, int months) {
        return IncreaseByMonth(date("Y-m-d H:i:s", time), months);
    }

    public static int IncreaseByMonth(String time, int months) {
        Long rs = dateIncreaseByMonth(convertToDate(time), months).getTime() / 1000L;
        return rs.intValue();
    }

    public static int IncreaseByWeek(int time, int weeks) {
        return time + 604800 * weeks;
    }

    public static int IncreaseByWeek(String time, int weeks) {
        return IncreaseByMonth(Long.valueOf(strtotime(time)).intValue(), weeks);
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(2);
        cal.setTime(date);
        return cal;
    }

    public static int getWeekOfYear(int time) {
        Date date = intToDate(time);
        Calendar cal = getCalendar(date);
        return cal.get(3);
    }

    public static int getWeek() {
        return getWeek(currentTime());
    }

    public static int getWeek(int time) {
        Date date = intToDate(time);
        Calendar cal = getCalendar(date);
        byte week;
        switch(cal.get(7)) {
            case 1:
                week = 7;
                break;
            case 2:
                week = 1;
                break;
            case 3:
                week = 2;
                break;
            case 4:
                week = 3;
                break;
            case 5:
                week = 4;
                break;
            case 6:
                week = 5;
                break;
            case 7:
                week = 6;
                break;
            default:
                week = 0;
        }

        return week;
    }

    public static int timeToSec(String times) {
        String[] arrTime = StringUtils.split(times, ":");
        int ret = 0;

        for(int i = 0; i < arrTime.length; ++i) {
            if (i < SECONDS.length) {
                ret += Integer.parseInt(arrTime[i]) * SECONDS[i];
            }
        }

        return ret;
    }

    public static String getMonthBetween(long dataS) {
        return (String)getMonthBetween(dataS, dataS).get(0);
    }

    public static List<String> getMonthBetween(long dataS, long dataE) {
        try {
            String minDate = dateToString(new Date(dataS));
            String maxDate = dateToString(new Date(dataE));
            ArrayList<String> result = new ArrayList();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            SimpleDateFormat resultSdf = new SimpleDateFormat("yyyyMM");
            Calendar min = Calendar.getInstance();
            Calendar max = Calendar.getInstance();
            min.setTime(sdf.parse(minDate));
            min.set(min.get(1), min.get(2), 1);
            max.setTime(sdf.parse(maxDate));
            max.set(max.get(1), max.get(2), 2);
            Calendar curr = min;

            while(curr.before(max)) {
                result.add(resultSdf.format(curr.getTime()));
                curr.add(2, 1);
            }

            return result;
        } catch (Exception var12) {
            var12.printStackTrace();
            return null;
        }
    }

    public static String date(Long s) {
        return date(s, DATETIME_PATTERN);
    }

    public static String date(Long s, String fmt) {
        Date date = new Date(s * 1000L);
        return (new SimpleDateFormat(fmt)).format(date);
    }

    public static String date(Integer s, String fmt) {
        Date date = new Date((long)(s * 1000));
        return (new SimpleDateFormat(fmt)).format(date);
    }

    public static int timestampToDataDay() {
        return timestampToDataDay(System.currentTimeMillis(), "yyyy-MM-dd");
    }

    public static int timestampToDataDay(long s) {
        return timestampToDataDay(s, "yyyy-MM-dd");
    }

    public static int timestampToDataDay(String format) {
        return timestampToDataDay(System.currentTimeMillis(), format);
    }

    public static int timestampToDataDay(long s, String format) {
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = df1.format(new Date(s));

        try {
            SimpleDateFormat df = new SimpleDateFormat(format);
            Date date = df.parse(dateStr);
            s = date.getTime();
            long res = s / 1000L;
            return (int)res;
        } catch (Exception var9) {
            return (int)System.currentTimeMillis() / 1000;
        }
    }

    public static void main(String[] args) {
        ComUtils.dump(timestampToDataDay());
    }
}

