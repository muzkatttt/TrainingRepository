package ru.aston.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuturePostgresExample {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final Logger logger = Logger.getLogger(FuturePostgresExample.class.getName());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        logger.info("Отправка запроса в PostgreSQL...");

        // Асинхронный запрос в базу данных Postgres
        Future<String> dbFuture = executor.submit(() -> {
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT data FROM my_table WHERE id=1")) {
                logger.info("Запрос успешно выполнен");
                if (rs.next()) {
                    return rs.getString("data");
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Ошибка при работе с БД", e);
            }
            return "Ошибка при получении данных из БД";
        });

        logger.info("Ожидание данных из PostgreSQL...");

        // Получаем результат
        String result = dbFuture.get();
        logger.info("Результат БД: " + result);

        executor.shutdown();
    }
}
