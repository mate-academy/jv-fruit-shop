package core.basesyntax;

import java.io.IOException;

public class HelloWorld {
    public static void main(String[] args) {
        String inputFile = "input.csv";
        String outputFile = "output.csv";

        try {
            FruitShopService fruitShopService = new FruitShopService();
            fruitShopService.processFile(inputFile);
            fruitShopService.generateReport(outputFile);

            System.out.println("Отчёт успешно записан в файл " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при обработке файла: " + e.getMessage());
        }
    }
}
