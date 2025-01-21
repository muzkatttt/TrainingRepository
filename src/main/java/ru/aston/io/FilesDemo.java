package ru.aston.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FilesDemo {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("resources", "writer.poem");
        Files.write(path, List.of("Hello", "Java"));

//        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
//            bufferedWriter.append("Hello");
//            bufferedWriter.newLine();
//            bufferedWriter.append("Java");
//        }

    }
}

