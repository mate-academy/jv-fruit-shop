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
import service.impl.WriterServiceImpl;

/**
 * Feel free to remove this class and create your own.
 */
public class FruitShop {
    public static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    public static final String OUTPUT_FILE_PATH = "src/main/resources/fruitReport.csv";

    public static void main(String[] args) {

        ReaderService readerService = new CsvDataReader();
        List<String[]> readFromFile = readerService.readFromFile(INPUT_FILE_PATH);

        TransactionConverter fr = new FruitTransactionConverter();
        List<FruitTransaction> listFruitTransaction = fr.convertToTransactionList(readFromFile);

        Storage storage = new FruitStorage();

        StrategyProcessor strategyProcessor = new StorageStrategyProcessor(storage);
        strategyProcessor.processTransactionStrategies(listFruitTransaction);

        ReportCreator reportService = new FruitReportCreator(storage);
        String fruitReportService = reportService.createReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(fruitReportService, OUTPUT_FILE_PATH);
    }
}
