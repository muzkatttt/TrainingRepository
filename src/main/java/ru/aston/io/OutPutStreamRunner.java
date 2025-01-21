package ru.aston.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class OutPutStreamRunner {
    public static void main(String[] args) throws IOException {
        File file = Paths.get("resources", "text.txt").toFile();

        System.out.println();

        // если создаем new FileOutputStream(file, true) c true - добавляет в файл к уже имеющемуся тексту,
        // без true (new FileOutputStream(file) - перезаписывает
        //try (FileOutputStream outputStream = new FileOutputStream(file, true)) {

        //буферизация для ускорения записи
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            String value = "У лукоморья дуб зелёный;\n" +
                    "Златая цепь на дубе том:\n" +
                    "И днём и ночью кот учёный\n" +
                    "Всё ходит по цепи кругом;\n" +
                    "Идёт направо — песнь заводит,\n" +
                    "Налево — сказку говорит.\n" +
                    "Там чудеса: там леший бродит,\n" +
                    "Русалка на ветвях сидит;\n" +
                    "Там на неведомых дорожках\n" +
                    "Следы невиданных зверей;\n" +
                    "Избушка там на курьих ножках\n" +
                    "Стоит без окон, без дверей;";
            outputStream.write(value.getBytes());
            outputStream.write(System.lineSeparator().getBytes()); // запись в файл с новой строки

        }
    }

}
