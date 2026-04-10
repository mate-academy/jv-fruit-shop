package core.basesyntax.service;

import core.basesyntax.db.CsvFileReader;
import core.basesyntax.db.CsvFileReaderImpl;
import core.basesyntax.db.FileWriter;
import core.basesyntax.db.FileWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // 1. READ CSV
        CsvFileReader fileReader = new CsvFileReaderImpl();
        List<String> inputData = fileReader.read("reportToRead.csv");

        // 2. CONVERT TO OBJECTS
        DataConverter converter = new DataConverterImpl();

        // 3. CREATE HANDLERS MAP
        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();

        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy strategy = new OperationStrategyImpl(handlers);

        // 4. PROCESS TRANSACTIONS
        List<FruitTransaction> transactions =
                converter.convertToTransaction(inputData);
        ShopServiceImpl shopService = new ShopServiceImpl(strategy);
        shopService.process(transactions);

        // 5. GENERATE REPORT
        ReportGenerator reportGenerator =
                new ReportGeneratorImpl(shopService.getStorage());

        String report = reportGenerator.getReport();

        // 6. WRITE REPORT TO FILE
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report, "finalReport.csv");
    }
}
