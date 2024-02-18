package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverterService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.TransactionProcessorService;
import core.basesyntax.service.impl.DataConverterServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.impl.TransactionProcessorServiceImpl;
import java.util.List;

public class Main {
    private static final String RELATIVE_PATH_FROM = "src/main/resources/operations.csv";
    private static final String RELATIVE_PATH_TO = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        DataConverterService dataConverterService = new DataConverterServiceImpl();
        TransactionProcessorService transactionProcessorService =
                new TransactionProcessorServiceImpl();
        ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();
        FileWriterService fileWriterService = new FileWriterServiceImpl();

        List<String> fileContents = fileReaderService.get(RELATIVE_PATH_FROM);
        List<FruitTransaction> fruitTransactions =
                dataConverterService.getListOfTransactions(fileContents);
        transactionProcessorService.processTransactions(fruitTransactions);
        String fullReport = reportGeneratorService.generateReport();
        fileWriterService.write(fullReport, RELATIVE_PATH_TO);
    }
}
