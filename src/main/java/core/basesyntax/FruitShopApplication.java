package core.basesyntax;

import core.basesyntax.config.AppConfig;
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
import core.basesyntax.strategy.OperationHandler;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitShopApplication {
    private final CsvFileReaderService csvFileReaderService;
    private final CsvFileWriterService csvFileWriterService;
    private final ReportGeneratorService reportGeneratorService;
    private final ShopService shopService;

    public FruitShopApplication(AppConfig appConfig) {
        csvFileReaderService = new CsvFileReaderServiceImpl();
        csvFileWriterService = new CsvFileWriterServiceImpl();
        reportGeneratorService = new ReportGeneratorServiceImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers =
                appConfig.getOperationHandlers();
        shopService = new ShopServiceImpl(operationHandlers);
    }

    public void run(String inputFilePath, String outputFilePath) {
        try {
            List<String> inputReport = csvFileReaderService.readFromFile(inputFilePath);
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

            csvFileWriterService.writeToFile(resultingReport, outputFilePath);
        } catch (IOException e) {
            throw new RuntimeException("Error reading or writing files", e);
        }
    }
}
