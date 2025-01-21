package ru.aston.io.tasks;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Task1 {
    /**
     * 1. Задан файл с текстом, найти и вывести в консоль все слова,
     * начинающиеся с гласной буквы.
     */

    private static final String VOWELS = "уеыаоэяию";
    public static void main(String[] args) throws IOException{
        Path path = Path.of("resources", "text.txt");
        try(Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                char firstSymbol = word.charAt(0); // берем по первой букве
                if(VOWELS.indexOf(firstSymbol) != -1) { // если не равен -1, значит элемент есть
                    System.out.println(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
