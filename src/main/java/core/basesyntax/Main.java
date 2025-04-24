package core.basesyntax;

import model.FruitTransaction;
import service.*;
import service.impl.*;
import strategy.BalanceOperation;
import strategy.PurchaseOperation;
import strategy.ReturnOperation;
import strategy.SupplyOperation;
import java.io.IOException;
import java.util.*;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/reportToRead.csv";

    public static void main(String[] arg) throws IOException {

        FileReader fileReader = new FileReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();

        Map<FruitTransaction.Operation, OperationHandler> strategy = new HashMap<>();
        strategy.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        strategy.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        strategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        strategy.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(strategy);

        List<String> readingFile = fileReader.read(INPUT_FILE);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(readingFile);

        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy.get(transaction.getOperation());
            operationHandler.apply(transaction);
        }
    }
}
