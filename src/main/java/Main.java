import core.basesyntax.dao.ReadFromFile;
import core.basesyntax.dao.WriteToFile;
import core.basesyntax.dao.daoimpl.ReadFromFileImpl;
import core.basesyntax.dao.daoimpl.WriteToFileImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.service.serviceimpl.ParserImpl;
import core.basesyntax.service.serviceimpl.ReportCreatorImpl;
import core.basesyntax.service.serviceimpl.TransactionHandlerImpl;
import core.basesyntax.service.serviceimpl.operationhandlers.BalanceHandlerImpl;
import core.basesyntax.service.serviceimpl.operationhandlers.OperationHandler;
import core.basesyntax.service.serviceimpl.operationhandlers.PurchaseHandlerImpl;
import core.basesyntax.service.serviceimpl.operationhandlers.SupplyHandlerImpl;
import core.basesyntax.strategy.TransactionStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<FruitTransaction.Operation, OperationHandler> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(FruitTransaction.Operation.BALANCE, new BalanceHandlerImpl());
        map.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandlerImpl());
        map.put(FruitTransaction.Operation.SUPPLY, new SupplyHandlerImpl());
        map.put(FruitTransaction.Operation.RETURN, new BalanceHandlerImpl());

        ReadFromFile reader = new ReadFromFileImpl();
        List<String> strings = reader.readFromFile("src/main/resources/input.csv");

        Parser parser = new ParserImpl();
        List<FruitTransaction> fruitTransactions = parser.parse(strings);

        TransactionStrategyImpl transactionStrategy = new TransactionStrategyImpl(map);
        TransactionHandler transactionHandler = new TransactionHandlerImpl(transactionStrategy);
        transactionHandler.handle(fruitTransactions);

        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport(Storage.fruitsAndAmount);

        WriteToFile writer = new WriteToFileImpl();
        writer.writeToFile(report, "src/main/resources/output");

    }
}
