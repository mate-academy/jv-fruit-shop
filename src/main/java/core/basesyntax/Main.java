package core.basesyntax;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> allLines = readerService.read("src/main/resources/input.csv");
        FruitMapper fruitMapper = new FruitMapperImpl();
        List<FruitTransaction> fruitTransactions = fruitMapper.convertData(allLines);
        Map<FruitTransaction.Operation, OperationHandler> handlers = createOperationHandlers();
        OperationStrategy operationStrategy = new OperationStrategy(handlers);
        OperationProcess operationProcess = new OperationProcessImpl(operationStrategy);
        operationProcess.processTransaction(fruitTransactions);
    }

    private static Map<FruitTransaction.Operation, OperationHandler> createOperationHandlers() {
        return Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler()
        );
    }
}
