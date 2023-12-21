package core.basesyntax;

import core.basesyntax.fileRider.CsvFileReader;
import core.basesyntax.fileWriter.FileWriterService;

import core.basesyntax.operationHandler.BalanceHandler;
import core.basesyntax.operationHandler.PurchaseHandler;
import core.basesyntax.operationHandler.ReturnHandler;
import core.basesyntax.operationHandler.SupplyHandler;
import core.basesyntax.reportCreator.ReportCreator;
import core.basesyntax.transactionParser.CsvTransactionParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Storage storage = new Storage();
        SupplyHandler supplyHandler = new SupplyHandler();
        supplyHandler.handleOperation(new FruitTransaction( Operation.SUPPLY, "banana", 10), storage);
        supplyHandler.handleOperation(new FruitTransaction( Operation.SUPPLY, "apple", 20), storage);
        supplyHandler.handleOperation(new FruitTransaction( Operation.SUPPLY, "banana", 30), storage);
        supplyHandler.handleOperation(new FruitTransaction( Operation.SUPPLY, "apple", 40), storage);
        supplyHandler.handleOperation(new FruitTransaction( Operation.SUPPLY, "banana", 50), storage);

        PurchaseHandler purchaseHandler = new PurchaseHandler();
        purchaseHandler.handleOperation(new FruitTransaction( Operation.PURCHASE, "banana", 10), storage);
        purchaseHandler.handleOperation(new FruitTransaction( Operation.PURCHASE, "apple", 20), storage);

        BalanceHandler balanceHandler = new BalanceHandler();
        balanceHandler.handleOperation(new FruitTransaction( Operation.BALANCE, "banana", 10), storage);

        ReturnHandler returnHandler = new ReturnHandler();
        returnHandler.handleOperation(new FruitTransaction( Operation.RETURN, "banana", 10), storage);

        CsvFileReader fileReader = new CsvFileReader();
        CsvTransactionParser transactionParser = new CsvTransactionParser();
        List<String> lines = fileReader.readData("src/main/resources/input.csv");
        List<FruitTransaction> transactions = transactionParser.parseTransactions(lines);
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
