package core.basesyntax;

import core.basesyntax.dao.DataReader;
import core.basesyntax.dao.DataWriter;
import core.basesyntax.dao.FruitFileReader;
import core.basesyntax.dao.FruitFileWriter;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandlerProvider;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class Main {
    private static final String READ_FILE_NAME = "src\\main\\resources\\test.csv";
    private static final String WRITE_FILE_NAME = "src\\main\\resources\\result.csv";

    public static void main(String[] args) {
        DataReader fruitReader = new FruitFileReader(READ_FILE_NAME);
        List<String> activityList = fruitReader.readDataLines();
        ParserService parserService = new ParserServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(
                new OperationHandlerProvider().getOperationHandlers());
        for (String activity : activityList) {
            FruitTransaction fruitTransaction = parserService.parseToTransaction(activity);
            TransactionService transactionService = new
                    TransactionServiceImpl(operationStrategy, fruitTransaction);
            transactionService.doOperation();
        }
        ReportService reportService = new ReportServiceImpl();
        String storageOutput = reportService.createOutput(FruitStorage.fruits);
        DataWriter fruitWriter = new FruitFileWriter();
        fruitWriter.writeData(storageOutput, WRITE_FILE_NAME);
        System.out.println("Here is one more successful day in our fruit storage!");
    }
}
