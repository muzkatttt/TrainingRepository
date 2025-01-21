package ru.aston.patterns.tasks;

import java.util.regex.Pattern;

/*
1. Написать программу, проверяющую, является ли введённая
строка адресом почтового ящика.
В названии почтового ящика разрешить использование только
букв, цифр и нижних подчёркиваний, при этом оно должно
начинаться с буквы.
Возможные домены верхнего уровня: .org .com
 */
public class Task1 {
    public static void main(String[] args) {
        String regex = "[a-zA-Z]\\w*@\\w{3,}\\.(ru|com)";
        String input = "ptushagds@gmail.com";
        System.out.println(Pattern.matches(regex, input));
    }
}
