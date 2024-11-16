package patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindDemo {
    public static void main(String[] args) {
        String phoneNumber = "safsgg +7 (999) 888-99-00 afaerfaef+7 (777) 888-99-11 safvb nvcvbc +7 (997) 777-99-00sfgsg";
        //String regex = "(\\+7)?\\s?\\(\\d{3}\\)\\s\\d{3}-\\d{2}-\\d{2}";
        String regex = "(?:\\+7)?\\s?\\(\\d{3}\\)\\s?(\\d{3})-(\\d{2})-(\\d{2})";
        // исключить группу ?:
        // "(\\+7)? ?\\((?<code>\\d{3}\\) ?\\d{3}-\\d{2}-\\d{2}"; <code> - название группы внутри регулярки
        Pattern compile = Pattern.compile(regex);// создаем объект класса
        Matcher matcher = compile.matcher(phoneNumber); // у паттерна вызываем метод matcher()
//        while (matcher.find()) {
//            // метод group() - возвращает кол-во групп по названию или по индексу (если в скокбках укажем номер группы)
//            System.out.println(matcher.group());
//            //System.out.println(matcher.group("code"));
//        }
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            String str1 = matcher.group(1);
            String str2 = matcher.group(2);
            String str3 = matcher.group(3);
            matcher.appendReplacement(sb, "$1-$2-$3");
        }
        matcher.appendTail(sb);
        System.out.println(sb);
        // matcher.appendReplacement(sb, "$1-$2-$3") = phoneNumber.replaceAll(regex, "$1-$2-$3")
        System.out.println(phoneNumber.replaceAll(regex, "$1-$2-$3"));

    }


}
