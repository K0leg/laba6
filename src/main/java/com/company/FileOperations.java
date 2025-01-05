package com.company;
import java.nio.file.*;
import java.io.*;
import java.util.stream.Collectors;

public class FileOperations {
    // Метод для створення файлу
    public static void createFile(String fileName) {
        Path filePath = Path.of(fileName);
        try {
            Files.createFile(filePath);
            System.out.println("Файл створено: " + filePath.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Файл уже існує або виникла помилка: " + e.getMessage());
        }
    }

    // Метод для запису даних у файл
    public static void writeToFile(String fileName, String content) {
        Path filePath = Path.of(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            writer.write(content);
            System.out.println("Дані успішно записано у файл.");
        } catch (IOException e) {
            System.out.println("Помилка запису у файл: " + e.getMessage());
        }
    }

    // Метод для читання даних із файлу
    public static void readFromFile(String fileName) {
        Path filePath = Path.of(fileName);
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Помилка читання файлу: " + e.getMessage());
        }
    }

    // Метод для заміни тексту у файлі
    public static void replaceTextInFile(String inputFileName, String outputFileName, String target, String replacement) {
        Path inputPath = Path.of(inputFileName);
        Path outputPath = Path.of(outputFileName);

        try {
            String content = Files.lines(inputPath)
                    .map(line -> line.replace(target, replacement))
                    .collect(Collectors.joining("\n"));

            Files.writeString(outputPath, content);
            System.out.println("Текст успішно змінено і записано у файл " + outputFileName);
        } catch (IOException e) {
            System.out.println("Помилка під час заміни тексту: " + e.getMessage());
        }
    }
}
