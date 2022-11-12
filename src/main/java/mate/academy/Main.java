package mate.academy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mate.academy.model.FruitTransaction;
import mate.academy.service.FileReaderService;
import mate.academy.service.FileWriterService;
import mate.academy.service.ParseService;
import mate.academy.service.ReportCreatorService;
import mate.academy.service.TransactionService;
import mate.academy.service.impl.CsvFileReaderServiceImpl;
import mate.academy.service.impl.CsvFileWriterServiceImpl;
import mate.academy.service.impl.ParseServiceImpl;
import mate.academy.service.impl.ReportCreatorServiceImpl;
import mate.academy.service.impl.TransactionServiceImpl;
import mate.academy.strategy.ActivityStrategy;
import mate.academy.strategy.ActivityStrategyImpl;
import mate.academy.strategy.activities.ActivityHandler;
import mate.academy.strategy.activities.AddActivityHandler;
import mate.academy.strategy.activities.SubtractActivityHandler;

public class Main {
    private static final String FILE_NAME = "database.csv";
    private static final String FILE_REPORT_NAME = "report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(FruitTransaction.Operation.BALANCE, new AddActivityHandler());
        activityHandlerMap.put(FruitTransaction.Operation.SUPPLY, new AddActivityHandler());
        activityHandlerMap.put(FruitTransaction.Operation.PURCHASE, new SubtractActivityHandler());
        activityHandlerMap.put(FruitTransaction.Operation.RETURN, new AddActivityHandler());

        FileReaderService fileReaderService = new CsvFileReaderServiceImpl();
        List<String> dataFromFile = fileReaderService.readFromFile(FILE_NAME);

        ParseService parseFromString = new ParseServiceImpl();
        List<FruitTransaction> fruitTransactions = parseFromString.parse(dataFromFile);

        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activityHandlerMap);
        TransactionService transactionService = new TransactionServiceImpl(activityStrategy);
        Map<String, Integer> fruitsMap = transactionService.processedData(fruitTransactions);

        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        String report = reportCreatorService.createReport(fruitsMap);

        FileWriterService fileWriterService = new CsvFileWriterServiceImpl();
        fileWriterService.write(report, FILE_REPORT_NAME);
    }
}
