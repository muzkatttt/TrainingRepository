package serialization;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializationExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path path = Path.of("resources", "student.out");
//
        writeObject(path);
        seeObject(path);
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {

            Object object = objectInputStream.readObject();

            System.out.println(object);
        }
    }

    // сериализация объекта в файл
    private static void writeObject(Path path) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream
                (new FileOutputStream(path.toFile()))
        ) {

            Person max = new Person(26, "Max", new Client("some", 22));
            objectOutputStream.writeObject(max);
        }
    }

    // десериализация объекта из файла
    private static void seeObject(Path path) throws IOException, ClassNotFoundException {

//        try (BufferedReader resources = Files.newBufferedReader(Paths.get("resources", "text.txt"))) {
//            System.out.print(resources.readLine());
//        }
       try (ObjectInputStream resources = new ObjectInputStream(new FileInputStream(path.toFile()))){
            Object o = resources.readObject();
            System.out.println(o);
        }

    }

}
