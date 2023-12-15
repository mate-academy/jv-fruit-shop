package core.basesyntax;

import core.basesyntax.fileRider.CsvFileReader;
import core.basesyntax.fileWriter.FileWriterService;

import core.basesyntax.reportCreator.ReportCreator;
import core.basesyntax.transactionParser.CsvTransactionParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        добавить фрукты в хранилище

        Storage storage = new Storage();
        storage.supplyFruit("banana", 10);
        storage.supplyFruit("banana", 20);
        storage.supplyFruit("apple", 30);


        storage.returnFruit("banana", 10);

        storage.supplyFruit("banana", 10);



        storage.purchaseFruit("banana", 10);
        storage.returnFruit("banana", 10);
        storage.getBalance("banana");





        CsvFileReader fileReader = new CsvFileReader();
        CsvTransactionParser transactionParser = new CsvTransactionParser();
//        Storage storage = new Storage();
        TransactionProcessor transactionProcessor = new TransactionProcessor(storage);
        ReportCreator reportCreator = new ReportCreator();
        FileWriterService fileWriter = new FileWriterService();

        List<String> lines = fileReader.readData("src/main/resources/input.csv");
        List<FruitTransaction> transactions = transactionParser.parseTransactions(lines);
        transactionProcessor.processTransactions(transactions);


        String report = reportCreator.generateReport(storage);
        fileWriter.writeToFile(report, "src/main/resources/report.csv");

    }
}
