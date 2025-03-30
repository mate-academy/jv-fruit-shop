package core.basesyntax;

import core.basesyntax.db.FruitShopInventory;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.strategy.Balance;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.Purchase;
import core.basesyntax.strategy.Return;
import core.basesyntax.strategy.Supply;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    public static void main(String[] arg) {
        String inputFile = "reportToRead.csv";
        FileReaderImpl fileReader = new FileReaderImpl();
        List<String[]> inputReport;

        try {
            inputReport = fileReader.processFile(inputFile);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + e.getMessage(), e);
        }

        Map<String, OperationStrategy> operationStrategies = new HashMap<>();
        operationStrategies.put("b", new Balance());
        operationStrategies.put("s", new Supply());
        operationStrategies.put("p", new Purchase());
        operationStrategies.put("r", new Return());

        FruitShopService fruitShopService = new FruitShopService();

        try {
            fruitShopService.processFile(inputFile);
        } catch (IOException e) {
            throw new RuntimeException("Error processing file: " + e.getMessage(), e);
        }

        String outputFile = "finalReport.csv";
        try {
            ReportWriter.writeReport(FruitShopInventory.inventory, outputFile);
        } catch (IOException e) {
            throw new RuntimeException("Error writing report to file: " + e.getMessage(), e);
        }

        System.out.println("The report has been written to file: " + outputFile);
    }
}

