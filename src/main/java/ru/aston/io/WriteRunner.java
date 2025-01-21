package ru.aston.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WriteRunner {
    public static void main(String[] args) throws IOException {
        //Path path = Path.of("resources", "simple.txt");
        File file = Path.of("resources", "writer.poem").toFile();

        System.out.println();

//        try (BufferedWriter fileWriter = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
//            fileWriter.append("Hello World!");
//            fileWriter.newLine();
//            fileWriter.append("Java");
//        }
        // по умолчанию UTF-8
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))) {
            fileWriter.append("Hello, world!");
            fileWriter.newLine();
            fileWriter.append("Java");
        }

    }
}
