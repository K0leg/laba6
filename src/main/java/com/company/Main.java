package com.company;

public class Main {
    public static void main(String[] args) {
        String fileName = "example.txt";
        String resultFileName = "result.txt";

        // Створення файлу
        FileOperations.createFile(fileName);

        // Запис у файл
        FileOperations.writeToFile(fileName, "Привіт, світе! Сказав student\nЦе текст, записаний у файл.");

        // Читання файлу
        System.out.println("Вміст файлу:");
        FileOperations.readFromFile(fileName);

        // Заміна тексту "student" на "kursant" та запис у новий файл
        FileOperations.replaceTextInFile(fileName, resultFileName, "student", "kursant");
    }
}