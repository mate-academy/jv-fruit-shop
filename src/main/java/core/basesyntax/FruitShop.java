package core.basesyntax;

import db.FruitStorage;
import db.Storage;
import java.util.List;
import model.FruitTransaction;
import service.ReaderService;
import service.ReportCreator;
import service.StrategyProcessor;
import service.TransactionConverter;
import service.WriterService;
import service.impl.CsvDataReader;
import service.impl.FruitReportCreator;
import service.impl.FruitTransactionConverter;
import service.impl.StorageStrategyProcessor;

/**
 * Feel free to remove this class and create your own.
 */
public class FruitShop {
    public static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    public static final String OUTPUT_FILE_PATH = "src/main/resources/fruitReport.csv";

    public static void main(String[] args) {

        ReaderService readerService = new CsvDataReader();
        List<String[]> readFromFile = readerService.readFromFile(INPUT_FILE_PATH);
        //read data from file

        TransactionConverter fr = new FruitTransactionConverter();
        List<FruitTransaction> listFruitTransaction = fr.convertToTransactionList(readFromFile);
        //convert data from file to java object

        Storage storage = new FruitStorage();

        StrategyProcessor strategyProcessor = new StorageStrategyProcessor(storage);
        strategyProcessor.processTransactionStrategies(listFruitTransaction);
        //process java object

        ReportCreator reportService = new FruitReportCreator(storage);
        WriterService fruitReportService = reportService.createReport();
        //create report
        fruitReportService.writeToFile(OUTPUT_FILE_PATH);
        //write report to file
    }
}
