package core.basesyntax;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.Storage;
import model.FruitTransaction;
import service.DataConverter;
import service.FileReader;
import service.ReportGenerator;
import service.ShopService;
import service.impl.*;
import service.operation.*;
import strategy.OperationStrategy;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl("src/main/java/db/reportToRead.csv");
        List<String> inputReport = null;
        try {
            inputReport = fileReader.read("reportToRead.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Storage storage = new Storage();

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String resultingReport = reportGenerator.getReport();

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriterImpl("finalReport.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(resultingReport);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
