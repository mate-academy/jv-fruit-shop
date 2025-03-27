package core.basesyntax;

import java.io.IOException;

public class HelloWorld {
    public static void main(String[] args) {
        // 1. Чтение данных из входного CSV файла
        String inputFile = "input.csv";
        String outputFile = "output.csv";

        try {
            FruitShopService fruitShopService = new FruitShopService();
            fruitShopService.processFile(inputFile);
            fruitShopService.writeToFile(outputFile);

            System.out.println("Отчёт успешно записан в файл " + outputFile);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла", e);
        }
    }
}

