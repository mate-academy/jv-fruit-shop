package core.basesyntax;

import db.Storage;
import db.StorageImpl;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import services.impl.DataConverterImpl;
import services.impl.FileReaderImpl;
import services.impl.FileWriterImpl;
import services.impl.ReportGeneratorImpl;
import services.impl.ShopServiceImpl;
import services.interfaces.DataConverter;
import services.interfaces.FileReader;
import services.interfaces.FileWriter;
import services.interfaces.ReportGenerator;
import services.interfaces.ShopService;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.impl.BalanceOperationHandler;
import strategy.impl.RemoveOperationHandler;
import strategy.impl.ReturnOperationHandler;
import strategy.impl.SupplyOperationHandler;

public class Main {
    public static void main(String[] arg) throws IOException {
        Storage storage = new StorageImpl();
        // 1. Read the data from the input CSV file
        FileReader fileReader = new FileReaderImpl();
        List<String> inputFile = fileReader.readFile(Path.of("src/main/resources/data.csv"));
        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(storage));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new RemoveOperationHandler(storage));
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(storage));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(storage));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        List<FruitTransaction> transactions = dataConverter.convertToFruitTransaction(inputFile);
        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport(storage.getAllData());

        // 6. Write the received report into the destination file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write("finalReport.csv", resultingReport);
    }
}
