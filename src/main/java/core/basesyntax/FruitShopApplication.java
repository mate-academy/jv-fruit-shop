package core.basesyntax;

import core.basesyntax.service.*;
import core.basesyntax.service.impl.InventoryImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReadImpl;
import core.basesyntax.service.impl.FileWriteImpl;
import core.basesyntax.strategy.FruitOperationHandler;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.SupplyOperation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopApplication {
    private final static Inventory inventory = new InventoryImpl();
    private final static FileRead fileRead = new FileReadImpl();
    private final static DataConverter dataConverter = new DataConverterImpl();
    private final static ReportGenerator reportGenerator = new ReportGeneratorImpl();
    private final static FileWrite fileWriter = new FileWriteImpl();

    public static void main(String[] arg) {
        List<String> inputReport = readDataFromFile("reportToRead.csv");
        List<FruitTransaction> transactions = convertToTransactions(inputReport);
        processTransactions(transactions);
        String resultingReport = generateReport();
        writeReportToFile(resultingReport, "finalReport.csv");
    }

    private static List<String> readDataFromFile(String fileName) {
        return fileRead.readDataFromFile(fileName);
    }

    private static List<FruitTransaction> convertToTransactions(List<String> inputReport) {
        return dataConverter.convertToTransaction(inputReport);
    }

    private static void processTransactions(List<FruitTransaction> transactions) {
        Map<Operation, FruitOperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceHandler());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(Operation.RETURN, new ReturnOperation());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions, inventory);
    }

    private static String generateReport() {
        return reportGenerator.getReport(inventory.getInventory());
    }

    private static void writeReportToFile(String report, String fileName) {
        fileWriter.write(report, fileName);
    }
}
