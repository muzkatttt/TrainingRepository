package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class InputStreamRunner {
    public static void main(String[] args) throws IOException {
        File file1 = new File(String.join(File.separator, "resource", "text.txt"));
        File file2 = Path.of("resources", "text.txt").toFile();
//        Path resources = Path.of("resources", "text.txt");

        try (FileInputStream inputStream = new FileInputStream(file2)) {
            byte[] bytes = new byte[inputStream.available()];
            int counter = 0;
            byte currentByte;
            while ((currentByte = (byte) inputStream.read()) != -1) {
                bytes[counter++] = currentByte;
            }

            String stringValue = new String(bytes);
            System.out.println(stringValue);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        //File file3 = new File(String.join(File.separator,"resources", "test.txt"));

//        inputStream.read();

        // современная работа с файлами через Path.of
        File newFile = Path.of("resources", "test.txt").toFile();
        try (FileInputStream inputStream = new FileInputStream(newFile)) {
            byte[] bytes = inputStream.readAllBytes(); // считывает байтвы в цикле

            inputStream.read();
            String stringValue = new String(bytes);
            System.out.println(stringValue);

            // более сложный вариант считывания из файла (попорционно)
//            byte[] bytes = new byte[inputStream.available()];
//            int count = 0;
//            byte currentByte;
//            while((currentByte=(byte) inputStream.read()) != -1) {
//                bytes[count++] = currentByte;
//            }
//            String stringValue = new String(bytes);
//            System.out.println(stringValue);
        }

    }
}
