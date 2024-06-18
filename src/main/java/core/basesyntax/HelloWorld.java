package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HelloWorld {
    public static void main(String[] args) {
        CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();
        ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        ShopService shopService = new ShopServiceImpl(operationHandlers);

        try {
            List<String> inputReport = csvFileReaderService.readFromFile(
                    "src/main/resources/reportToRead.csv");
            List<FruitTransaction> transactions = inputReport.stream()
                    .skip(1)
                    .map(line -> line.split(","))
                    .map(parts -> new FruitTransaction(
                            FruitTransaction.Operation.fromCode(parts[0]),
                            parts[1],
                            Integer.parseInt(parts[2])
                    ))
                    .collect(Collectors.toList());

            shopService.processTransactions(transactions, Storage.getInventory());

            String resultingReport = reportGeneratorService.generateReport(Storage.getInventory());

            csvFileWriterService.writeToFile(resultingReport, "src/main/resources/finalReport.csv");
        } catch (IOException e) {
            throw new RuntimeException("Error reading or writing files", e);
        }
    }
}
