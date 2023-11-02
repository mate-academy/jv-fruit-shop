package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.parser.Parser;
import core.basesyntax.service.reader.CsvFileReader;
import core.basesyntax.service.reader.FileReader;
import core.basesyntax.service.reporter.CsvReporter;
import core.basesyntax.service.reporter.Reporter;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.impl.BalanceOperationHandler;
import core.basesyntax.service.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.service.strategy.impl.ReturnOperationHandler;
import core.basesyntax.service.strategy.impl.SupplyOperationHandler;
import core.basesyntax.service.writter.CsvFileWritter;
import core.basesyntax.service.writter.FileWritter;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_FROM = "src/main/resources/input.csv";
    private static final String PATH_TO = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReader();
        List<String> lines = fileReader.read(PATH_FROM);

        Parser parser = new Parser();

        List<FruitTransaction> fruitTransactionList = parser.parseStringToFruitTransaction(lines);

        StorageDao storageDao = new StorageDaoImpl();

        Map<FruitTransaction.Operation, OperationHandler> handlers = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(storageDao),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(storageDao),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(storageDao),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler(storageDao)
        );

        OperationStrategy operationStrategy = new OperationStrategy(handlers);

        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            operationStrategy.processOperation(fruitTransaction);
        }

        Reporter reporter = new CsvReporter();

        FileWritter fileWritter = new CsvFileWritter();
        fileWritter.write(reporter.makeReport(), PATH_TO);
    }
}
