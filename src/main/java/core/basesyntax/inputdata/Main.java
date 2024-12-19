package core.basesyntax.inputdata;

import core.basesyntax.file.DataConverter;
import core.basesyntax.file.DataConverterImpl;
import core.basesyntax.file.FileReader;
import core.basesyntax.file.FileReaderImpl;
import core.basesyntax.file.ReportGenerator;
import core.basesyntax.file.ReportGeneratorImpl;
import core.basesyntax.file.ReportWriter;
import core.basesyntax.file.ReportWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.BalanceOperationHandler;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.PurchaseOperationHandler;
import core.basesyntax.operations.ReturnOperationHandler;
import core.basesyntax.operations.SupplyOperationHandler;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        // 1. Read the data from the input CSV file
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("src\\main\\resources\\inputValue.csv");

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        ReportWriter fileWriter = new ReportWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}
