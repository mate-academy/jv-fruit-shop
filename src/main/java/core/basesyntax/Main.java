package core.basesyntax;

import core.basesyntax.converter.StringToFruitTransactionConverter;
import core.basesyntax.data.ShopService;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import core.basesyntax.util.FileReaderImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReaderImpl fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("reportToRead.csv");

        StringToFruitTransactionConverter dataConverter = new StringToFruitTransactionConverter();
        List<FruitTransaction> transactions = dataConverter.applyList(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategy(operationHandlers);

        ShopService shopService = new ShopService(operationStrategy);
        shopService.process(transactions);

    }
}
