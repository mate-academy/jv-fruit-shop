package core.basesyntax;

import core.basesyntax.fileRider.CsvFileReader;
import core.basesyntax.fileWriter.FileWriterService;

import core.basesyntax.operationHandler.BalanceHandler;
import core.basesyntax.operationHandler.ReturnHandler;
import core.basesyntax.reportCreator.ReportCreator;
import core.basesyntax.transactionParser.CsvTransactionParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        добавить фрукты в хранилище
        Storage storage = new Storage();
        Storage.fruits.put("banana", 10);
        Storage.fruits.put("apple", 30);
        Storage.fruits.put("orange", 50);
        Storage.fruits.put("lemon", 40);
Storage.fruits.put("pineapple", 70);
Storage.fruits.put("peach", 20);
Storage.fruits.put("pear", 30);
Storage.fruits.put("mango", 40);
Storage.fruits.put("grape", 50);
Storage.fruits.put("kiwi", 60);
Storage.fruits.put("cherry", 70);
Storage.fruits.put("apricot", 80);
Storage.fruits.put("plum", 90);

Storage.fruits.get("banana");
Storage.fruits.get("apple");
Storage.fruits.get("orange");

Storage.fruits.remove("banana", 10);
Storage.fruits.remove("apple", 10);


        CsvFileReader fileReader = new CsvFileReader();
        CsvTransactionParser transactionParser = new CsvTransactionParser();
        List<String> lines = fileReader.readData("src/main/resources/input.csv");
        List<FruitTransaction> transactions = transactionParser.parseTransactions(lines);
        BalanceHandler balanceHandler = new BalanceHandler();
        ReturnHandler returnHandler = new ReturnHandler();
        ReportCreator reportCreator = new ReportCreator();
        FileWriterService fileWriter = new FileWriterService();
        for (FruitTransaction transaction : transactions) {
            if (transaction.getOperation().equals(Operation.BALANCE)) {
                balanceHandler.handleOperation(transaction, storage);
            } else {
                returnHandler.handleOperation(transaction, storage);
            }
        }
        String report = reportCreator.generateReport(storage);
        fileWriter.writeToFile(report, "src/main/resources/report.csv");




//        CsvTransactionParser transactionParser = new CsvTransactionParser();
//        TransactionProcessor transactionProcessor = new TransactionProcessor(storage);
//        ReportCreator reportCreator = new ReportCreator();
//        FileWriterService fileWriter = new FileWriterService();
//
//        List<String> lines = fileReader.readData("src/main/resources/input.csv");
//        List<FruitTransaction> transactions = transactionParser.parseTransactions(lines);
//        transactionProcessor.processTransactions(transactions);
//
//
//        String report = reportCreator.generateReport(storage);
//        fileWriter.writeToFile(report, "src/main/resources/report.csv");

    }
}

//Загальна логіка в мейні повинна бути така:
//Зчитуєш файл через рідер сервіс, потім цей лист обробляєш через CsvTransactionParser
//Потім TransactionProcessor використовуэш для того, щоб всі операції обробити
//Далі генеруєш репорт, та записуєш цей репорт
