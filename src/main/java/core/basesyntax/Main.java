package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String inputFilePath = "src/main/resources/fruits.csv";
        final String resultFilePath = "src/main/resources/statistics.csv";
        Map<FruitTransaction.Operation, OperationHandler> strategyMap =
                Map.of(FruitTransaction.Operation.BALANCE, new BalanceHandler(),
                        FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
                        FruitTransaction.Operation.RETURN, new ReturnHandler(),
                        FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        ReaderService readerService = new ReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategyMap);
        FruitDao fruitDao = new FruitDaoImpl();
        TransactionService transactionService =
                            new TransactionServiceImpl(operationStrategy, fruitDao);
        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> fruitsStrings = readerService.readFromFile(inputFilePath);
        List<FruitTransaction> transactions = parserService.parseData(fruitsStrings);
        transactionService.processTransactions(transactions);
        String report = reportCreatorService.createReport();
        writerService.writeToFile(resultFilePath, report);
    }
}
