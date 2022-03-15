package core.basesyntax;

import core.basesyntax.dao.FruitDataReader;
import core.basesyntax.dao.FruitDataWriter;
import core.basesyntax.dao.FruitFileReader;
import core.basesyntax.dao.FruitFileWriter;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.FruitTransaction;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import java.util.List;

public class Main {
    private static final String READ_FILE_NAME = "src\\main\\resources\\test.csv";
    private static final String WRITE_FILE_NAME = "src\\main\\resources\\result.csv";

    public static void main(String[] args) {
        FruitDataReader fruitReader = new FruitFileReader(READ_FILE_NAME);
        List<String> activityList = fruitReader.readTransactions();
        ParserService parserService = new ParserServiceImpl();
        for (String activity : activityList) {
            FruitTransaction fruitTransaction = parserService.parseToTransaction(activity);
            TransactionService transactionService = new TransactionServiceImpl(fruitTransaction);
            transactionService.doOperation();
        }
        ReportService reportService = new ReportServiceImpl();
        String storageOutput = reportService.createOutput(FruitStorage.fruits);
        FruitDataWriter fruitWriter = new FruitFileWriter(storageOutput, WRITE_FILE_NAME);
        fruitWriter.write();
        System.out.println("Here is one more successful day in our fruit storage!");
    }
}
