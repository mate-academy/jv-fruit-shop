package core.basesyntax;

import core.basesyntax.service.FruitShopService;
import java.io.IOException;

public class HelloWorld {
    public static void main(String[] args) {
        String inputFile = "input.csv";
        String outputFile = "output.csv";

        try {
            FruitShopService fruitShopService = new FruitShopService();
            fruitShopService.processFile(inputFile);
            fruitShopService.generateReport(outputFile);

            System.out.println("The report has been written to file: " + outputFile);
        } catch (IOException e) {
            throw new RuntimeException("Error processing file: " + e.getMessage(), e);
        }
    }
}
