package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitOperation;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportMakerServiceImpl;
import core.basesyntax.service.operation.FruitBalanceOperation;
import core.basesyntax.service.operation.FruitPurchaseOperation;
import core.basesyntax.service.operation.FruitReturnOperation;
import core.basesyntax.service.operation.FruitSupplyOperation;
import core.basesyntax.strategy.impl.FruitStrategyImpl;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final File FROM_FILE = new File("src/main/resources/fileFrom.csv");
    private static final File TO_FILE = new File("src/main/resources/fileTo.csv");

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, FruitOperation> fruitOperations = new HashMap<>();
        fruitOperations.put(FruitTransaction.Operation.PURCHASE, new FruitPurchaseOperation());
        fruitOperations.put(FruitTransaction.Operation.BALANCE, new FruitBalanceOperation());
        fruitOperations.put(FruitTransaction.Operation.RETURN, new FruitReturnOperation());
        fruitOperations.put(FruitTransaction.Operation.SUPPLY, new FruitSupplyOperation());

        List<String> listOfTransactions = new FileReaderServiceImpl().readFromFile(FROM_FILE);
        List<FruitTransaction> parsedTransactions = new DataParserServiceImpl()
                .parseData(listOfTransactions);

        FruitStrategyImpl fruitStrategy = new FruitStrategyImpl(fruitOperations);
        parsedTransactions.forEach(fruitStrategy::operate);

        String report = new ReportMakerServiceImpl().createReport();
        new FileWriterServiceImpl().write(TO_FILE, report);
    }
}
