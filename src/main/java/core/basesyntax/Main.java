package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.OperationServiceStrategy;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME
            = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_NAME
            = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        String data = fileReaderService.readFromFile(INPUT_FILE_NAME);
        List<Transaction> transactionList = new ParserServiceImpl().parse(data);
        OperationServiceStrategy operationServiceStrategy = new OperationServiceStrategy();
        for (Transaction transaction : transactionList) {
            operationServiceStrategy
                    .getOperationServiceByOperationType(transaction.getOperation())
                    .interact(transaction);
        }
        ReportService reportService = new ReportServiceImpl();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(reportService
                .createReport(), OUTPUT_FILE_NAME);
    }
}
