package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.DataReaderImpl;
import core.basesyntax.service.impl.DataWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.handler.BalanceOperation;
import core.basesyntax.strategy.handler.PurchaseOperation;
import core.basesyntax.strategy.handler.ReturnOperation;
import core.basesyntax.strategy.handler.SupplyOperation;
import core.basesyntax.strategy.handler.TransactionStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        DataReader fileReader = new DataReaderImpl();
        List<String> inputReport = fileReader
                .read("src/main/resources/toReport.csv");

        // 2. Convert the incoming data into FruitTransactions list
        DataParser dataParser = new DataParserImpl();

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        TransactionStrategy operationStrategy = new TransactionStrategy(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        List<FruitTransaction> transactions = dataParser.parseTransactions(inputReport);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        DataWriter fileWriter = new DataWriterImpl();
        fileWriter.write(resultingReport,
                "src/main/resources/finalReport.csv");
    }
}
