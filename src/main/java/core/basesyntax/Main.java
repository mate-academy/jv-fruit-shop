package core.basesyntax;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.*;
import core.basesyntax.service.operation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    // HINT: In the `public static void main(String[] args)` it is better to create instances of your classes, 
    // and call their methods, but do not write any business logic in the `main` method!
    public static void main(String[] args) {
        // 1. Read the data from the input CSV file
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("src/reportToRead.csv");

        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        FruitTransactionDao dao = new FruitTransactionDaoImpl();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation(dao));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation(dao));
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation(dao));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation(dao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 5.Generate report based on the current Storage state
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        // 6. Write the received report into the destination file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}
