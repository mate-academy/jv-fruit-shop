package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParseService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.TransactionProcessingService;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.DataParseServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.TransactionProcessingServiceImpl;
import java.io.File;
import java.util.List;

public class Main {
    private static final File activitiesCsv = new File("src/main/resources/activities.csv");
    private static final File reportCsv = new File("src/main/resources/report.csv");

    public static void main(String[] args) {
        FileReaderService csvFileReader = new CsvFileReader();
        List<String> data = csvFileReader.readFromFile(activitiesCsv);

        DataParseService dataParseService = new DataParseServiceImpl();
        List<FruitTransaction> transactions = dataParseService.parseData(data);

        TransactionProcessingService transactionProcessing = new TransactionProcessingServiceImpl();
        transactionProcessing.accept(transactions);

        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        List<String> report = reportCreatorService.getReport();

        FileWriterService csvFileWriter = new CsvFileWriter();
        csvFileWriter.writeToFile(reportCsv, report);
    }
}
