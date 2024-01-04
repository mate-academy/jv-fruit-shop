package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.impl.ParserServiceImpl;
import core.basesyntax.impl.ReaderServiceImpl;
import core.basesyntax.impl.WriterServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.operationhandler.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage();

        FruitShopService fruitShopService = new FruitShopService(new OperationStrategy());
        fruitShopService.processTransactions(List.of(
                new FruitTransaction(Operation.SUPPLY, "banana", 10),
                new FruitTransaction(Operation.PURCHASE, "banana", 3),
                new FruitTransaction(Operation.RETURN, "banana", 5),
                new FruitTransaction(Operation.SUPPLY, "apple", 5),
                new FruitTransaction(Operation.SUPPLY, "apple", 2),
                new FruitTransaction(Operation.PURCHASE, "apple", 1)
        ));

        ReaderServiceImpl fileReader = new ReaderServiceImpl();
        ParserServiceImpl transactionParser = new ParserServiceImpl();
        List<String> lines = fileReader.readData("src/main/resources/input.csv");
        List<FruitTransaction> transactions = transactionParser.parseTransactions(lines);
        OperationStrategy operationStrategy = new OperationStrategy();
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy
                    .getHandler(transaction.getOperation());
            operationHandler.handleOperation(transaction, storage);
        }
        ReportService reportCreator = new ReportService();
        WriterServiceImpl fileWriter = new WriterServiceImpl();
        fileWriter.writeToFile(reportCreator.generateReport(), "src/main/resources/report.csv");
    }
}
