package core.basesyntax;

import core.basesyntax.service.impl.DataConverterServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.impl.TransactionProcessorServiceImpl;

public class Main {
    private static final String RELATIVE_PATH_FROM = "src/main/resources/operations.csv";
    private static final String RELATIVE_PATH_TO = "src/main/resources/report.csv";

    public static void main(String[] args) {
        var fileReaderService = new FileReaderServiceImpl();
        var dataConverterService = new DataConverterServiceImpl();
        var transactionProcessorService = new TransactionProcessorServiceImpl();
        var reportGeneratorService = new ReportGeneratorServiceImpl();
        var fileWriterService = new FileWriterServiceImpl();

        var fileContents = fileReaderService.get(RELATIVE_PATH_FROM);
        var fruitTransactions = dataConverterService.getListOfTransactions(fileContents);
        transactionProcessorService.processTransactions(fruitTransactions);
        var fullReport = reportGeneratorService.generateReport();
        fileWriterService.write(fullReport, RELATIVE_PATH_TO);
    }
}
