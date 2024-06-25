package core.basesyntax;

import core.basesyntax.data.DataConverter;
import core.basesyntax.data.DataConverterImpl;
import core.basesyntax.reader.FileReader;
import core.basesyntax.reader.FileReaderImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.transaction.BalanceOperation;
import core.basesyntax.transaction.FruitTransaction;
import core.basesyntax.transaction.Operation;
import core.basesyntax.transaction.OperationHandler;
import core.basesyntax.transaction.OperationStrategy;
import core.basesyntax.transaction.OperationStrategyImpl;
import core.basesyntax.transaction.PurchaseOperation;
import core.basesyntax.transaction.ReturnOperation;
import core.basesyntax.transaction.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1. Read the data from the input CSV file
        final String filePathRead = "reportToRead.csv";
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(filePathRead);
        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        // 3. Create and feel the map with all OperationHandler implementations
        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(Operation.RETURN, new ReturnOperation());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        // 4. Process the incoming transactions with applicable OperationHandler implementations
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);
    }
}
