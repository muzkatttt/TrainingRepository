package serialization;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializationExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path path = Path.of("resources", "student.json");
//
        writeObject(path);
        seeObject(path);
//        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
//
//            Object object = objectInputStream.readObject();
//
//            System.out.println(object);
//        }
    }

    private static void writeObject(Path path) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream
                (
                        new FileOutputStream(path.toFile()
                        )
                )
        ) {

            Person max = new Person(26, "Max", new Client("some", 22));

            objectOutputStream.writeObject(max);
        }
    }

    private static void seeObject(Path path) throws IOException {

        try (BufferedReader resources = Files.newBufferedReader(Paths.get("resources", "text.txt"))) {
            System.out.print(resources.readLine());
        }

    }

}
