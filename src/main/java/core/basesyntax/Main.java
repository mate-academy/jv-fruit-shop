package core.basesyntax;

import core.basesyntax.files.WriterCsvFile;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.files.ReaderCsvFile;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StorageServiceImpl;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionParserImpl;

import java.util.ArrayList;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/inputFile.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/outputFile.csv";

    public static void main(String[] args) {
        ReaderCsvFile readerCsvFile = new ReaderCsvFile();
        StorageService activityService = new StorageServiceImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        FruitShopService fruitShopService = new FruitShopServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        WriterCsvFile writerCsvFile = new WriterCsvFile();

        ArrayList<String> csvRowList = readerCsvFile.getLinesFromCsv(INPUT_FILE_NAME);
        ArrayList<FruitTransaction> fruitTransactionArrayList = transactionParser.parseCsvRow(csvRowList);
        activityService.fillActivityStorage(fruitTransactionArrayList);
        fruitShopService.processStorage();
        writerCsvFile.writeReport(reportService.createReport(), OUTPUT_FILE_NAME);
    }

}
