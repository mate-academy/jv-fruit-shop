package dev;

import dev.input.FileReaderImpl;
import dev.input.Reader;
import dev.repository.Repository;
import dev.repository.RepositoryImp;
import dev.service.OperationStrategy;
import dev.service.OperationStrategyImpl;
import dev.service.ShopService;
import dev.service.ShopServiceImpl;
import dev.service.operation.BalanceOperation;
import dev.service.operation.OperationHandler;
import dev.service.operation.PurchaseOperation;
import dev.service.operation.ReturnOperation;
import dev.service.operation.SupplyOperation;
import dev.transaction.DataConverter;
import dev.transaction.DataConverterImpl;
import dev.transaction.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_READ_SRC = "reportToRead.csv";

    public static void main(String[] args) {
        // 1. Read the data from the input CSV file
        Reader reader = new FileReaderImpl();
        List<String> inputReport = reader.read(FILE_READ_SRC);
        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
        // 3. Create and feel the map with all OperationHandler implementations
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        // 4. Process the incoming transactions with applicable OperationHandler implementations
        Repository repository = new RepositoryImp();
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions, repository);
    }
}
