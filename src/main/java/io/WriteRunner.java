package io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WriteRunner {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("resources", "simple.txt");

        System.out.println();

        try (BufferedWriter fileWriter = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            fileWriter.append("Hello World!");
            fileWriter.newLine();
            fileWriter.append("Java");
        }
    }
}
