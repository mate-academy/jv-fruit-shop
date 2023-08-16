package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;

public class Main {
    private static final String FILE_FROM = "src/main/resources/fruits.csv";
    private static final String FILE_TO = "src/main/resources/fruitsResult.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.readFromFile(FILE_FROM);
        ParseService transactionParseService = new ParseServiceImpl();
        List<FruitTransaction> fruitTransactionList =
                transactionParseService.getTransactionData(dataFromFile);
        OperationStrategy operationStrategy =
                new OperationStrategyImpl();
        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(operationStrategy);
        fruitTransactionService.processTransactions(fruitTransactionList);
        ReportService totalService = new ReportServiceImpl();
        String report = totalService.getReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, FILE_TO);
    }
}
