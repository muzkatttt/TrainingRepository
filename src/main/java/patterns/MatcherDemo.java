package patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherDemo {
    public static void main(String[] args) {
        String phoneNumber = "+7 (999) 122-22-11";
        // "(\\+7)?\\s?\\(\\d{3}\\)\\s\\d{3}-\\d{2}-\\d{2}" - в скобках может быть выражение, а может и не быть
        // регулярные выражения \\экранирование \\s пробел \\d{3}числовое выражение 3 знака
        Pattern compile = Pattern.compile("\\+7\\s\\(\\d{3}\\)\\s\\d{3}-\\d{2}-\\d{2}");
        Matcher matcher1 = compile.matcher(phoneNumber);
        System.out.println(matcher1.matches());

//        Pattern pattern = Pattern.compile("\\d{3}");
//        Matcher matcher = pattern.matcher("123");
//        System.out.println(matcher.matches());


        final Pattern compile1 = Pattern.compile("\\d");

    }
}
