package core.basesyntax;

import core.basesyntax.FruitTransaction.Operation;
import core.basesyntax.files.FileReader;
import core.basesyntax.files.FileReaderImpl;
import core.basesyntax.files.FileWriter;
import core.basesyntax.files.FileWriterImpl;
import core.basesyntax.operations.BalanceOperation;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.OperationStrategy;
import core.basesyntax.operations.OperationStrategyImpl;
import core.basesyntax.operations.PurchaseOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        FileReader fileReader = new FileReaderImpl();
        List<String> inputData = fileReader.read("src/main/resources/reportToRead.csv");

        // 2. Create and feel the map with all OperationHandler implementations
        Map<Operation, OperationHandler> operationHandler = new HashMap<>();
        operationHandler.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandler.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandler.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandler.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandler);

        // 3. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputData);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        Storage storage = new Storage();
        ShopService shopService = new ShopServiceImpl(operationStrategy, storage);
        shopService.process(transactions);

        // 5. Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl(storage);
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "src/main/resources/finalReport.csv");
    }
}


