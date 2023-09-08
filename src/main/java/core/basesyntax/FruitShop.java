package core.basesyntax;

import db.FruitStorage;
import db.Storage;
import java.io.File;
import java.util.List;
import model.Transaction;
import service.ReaderService;
import service.Report;
import service.ReportCreator;
import service.StrategyProcessor;
import service.TransactionConverter;
import service.impl.CsvDataReader;
import service.impl.FruitReportCreator;
import service.impl.FruitTransactionConverter;
import service.impl.StorageStrategyProcessor;

/**
 * Feel free to remove this class and create your own.
 */
public class FruitShop {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/input.csv";
        String outputFilePath = "src/main/resources/fruitReport.csv";

        ReaderService readerService = new CsvDataReader();
        List<String[]> readFromFile = readerService.readFromCsv(inputFilePath);

        TransactionConverter fr = new FruitTransactionConverter();
        List<Transaction> listFruitTransaction = fr.convertToTransactionList(readFromFile);

        Storage storage = new FruitStorage();

        StrategyProcessor strategyProcessor = new StorageStrategyProcessor(storage);
        strategyProcessor.processTransactionStrategies(listFruitTransaction);

        ReportCreator reportService = new FruitReportCreator();
        Report fruitReport = reportService.createReport(storage);

        File file = new File(outputFilePath);
        fruitReport.writeToCsvFile(file);
    }
}
