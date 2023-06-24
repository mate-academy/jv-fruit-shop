package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ParserImpl;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReaderCsvImpl;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportCreatorImpl;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.TransactionHandlerImpl;
import core.basesyntax.service.Writer;
import core.basesyntax.service.WriterCsvImpl;
import core.basesyntax.service.operation.BalanceHandlerImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseHandlerImpl;
import core.basesyntax.service.operation.ReturnHandlerImpl;
import core.basesyntax.service.operation.SupplyHandlerImpl;
import core.basesyntax.strategy.TransactionStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<FruitTransaction.Operation,
            OperationHandler> handlersMap = new HashMap<>();

    public static void main(String[] args) {
        handlersMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandlerImpl());
        handlersMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandlerImpl());
        handlersMap.put(FruitTransaction.Operation.RETURN, new ReturnHandlerImpl());
        handlersMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandlerImpl());
        Reader reader = new ReaderCsvImpl();
        List<String> stringsTransactions = reader
                .readFromFile("src/main/resources/file.csv");
        Parser parser = new ParserImpl();
        List<FruitTransaction> fruitTransactions = parser.parse(stringsTransactions);
        TransactionStrategyImpl transactionStrategy = new TransactionStrategyImpl(handlersMap);
        TransactionHandler transactionHandler = new TransactionHandlerImpl(transactionStrategy);
        transactionHandler.handle(fruitTransactions);
        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport(Storage.fruits);
        Writer writer = new WriterCsvImpl();
        writer.writeToFile(report, "src/main/resources/report11.csv");
    }
}
