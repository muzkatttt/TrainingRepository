package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderRunner {
    public static void main(String[] args) throws IOException {
        // по-старому
        //File file = Paths.get("resources", "test.txt").toFile();

//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
//            String s;
//            while ((s = bufferedReader.readLine()) != null) {
//                System.out.println(s);
//            }
//        }
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))){
//            String collect = fileReader.lines()
//                    .collect(Collectors.joining("\n"));
//            System.out.println(collect);
//        }

        // новый способ работы
        Path path = Path.of("resources", "test.txt");
        try (Stream<String> collect = Files.lines(path)) {
            collect.forEach(System.out::println);
        }
//        path.toString();
//        path.getFileName();
//        path.getParent();
//        path.getRoot();
//        path.toAbsolutePath();

    }
}
