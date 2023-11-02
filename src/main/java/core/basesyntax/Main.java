package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.parser.Parser;
import core.basesyntax.service.parser.ParserImpl;
import core.basesyntax.service.performer.Performer;
import core.basesyntax.service.performer.PerformerImpl;
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
    private static final StorageDao storageDao = new StorageDaoImpl();
    private static final FileReader fileReader = new CsvFileReader();
    private static final Parser parser = new ParserImpl();
    private static final Reporter reporter = new CsvReporter();
    private static final FileWritter fileWritter = new CsvFileWritter();
    private static final Map<FruitTransaction.Operation, OperationHandler> handlers = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(storageDao),
            FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(storageDao),
            FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(storageDao),
            FruitTransaction.Operation.RETURN, new ReturnOperationHandler(storageDao)
    );
    private static final OperationStrategy operationStrategy = new OperationStrategy(handlers);
    private static final Performer performer = new PerformerImpl(operationStrategy);

    public static void main(String[] args) {
        List<String> lines = fileReader.read(PATH_FROM);
        List<FruitTransaction> fruitTransactionList = parser.parseStringToFruitTransaction(lines);
        performer.performTransaction(fruitTransactionList);
        fileWritter.write(reporter.makeReport(), PATH_TO);
    }
}
