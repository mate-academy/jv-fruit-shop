package core.basesyntax;

import core.basesyntax.handler.*;

import java.util.*;

public class Main {
    public static void main( String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read();

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> fruitTransactionList = dataConverter.convert(inputReport);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);





    }
}
