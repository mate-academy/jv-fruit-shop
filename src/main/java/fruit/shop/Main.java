package fruit.shop;

import fruit.shop.model.FruitTransaction;
import fruit.shop.service.ReaderService;
import fruit.shop.service.ReaderServiceImpl;
import fruit.shop.service.ReportService;
import fruit.shop.service.ReportServiceImpl;
import fruit.shop.service.TransactionParserService;
import fruit.shop.service.TransactionParserServiceImpl;
import fruit.shop.service.TransactionStrategy;
import fruit.shop.service.TransactionStrategyImpl;
import fruit.shop.service.WriterService;
import fruit.shop.service.WriterServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csvFolderPath = "src/main/resources/";
        ReaderService readerService = new ReaderServiceImpl();
        TransactionParserService transactionParser = new TransactionParserServiceImpl();
        TransactionStrategy transactionStrategy = new TransactionStrategyImpl();
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> readFile = readerService.readFromFile(csvFolderPath + "Balance.csv");
        List<FruitTransaction> parsedTransactions = transactionParser.parse(readFile);
        for (FruitTransaction ft : parsedTransactions) {
            transactionStrategy.executeTransactionHandler(ft);
        }
        String report = reportService.generateReport();
        writerService.saveReport(report, csvFolderPath);
    }
}
