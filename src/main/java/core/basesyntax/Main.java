package core.basesyntax;

import core.basesyntax.strategy.DefaultOperationStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Ініціалізація магазину фруктів
        FruitStore fruitStore = new FruitStore();
        fruitStore.supplyFruit("banana", 100);
        fruitStore.supplyFruit("apple", 200);
        fruitStore.supplyFruit("orange", 300);
        fruitStore.supplyFruit("lemon", 400);

        fruitStore.supplyFruit("banana", 50);
        fruitStore.supplyFruit("apple", 100);

        fruitStore.sellFruit("banana", 50);
        fruitStore.sellFruit("apple", 100);

        fruitStore.sellFruit("lemon", 100);

        fruitStore.returnFruit("lemon", 100);

        fruitStore.sellFruit("lemon", 100);
        fruitStore.sellFruit("lemon", 100);
        fruitStore.sellFruit("lemon", 100);

        fruitStore.returnFruit("lemon", 100);


        fruitStore.balanceFruit();


        CsvFileReader csvFileReader = new CsvFileReader();
        List<String> transactionLines = csvFileReader.readTransactions("src/main/java/core/basesyntax/transactions.csv");

        CsvTransactionParser csvTransactionParser = new CsvTransactionParser();
        List<FruitTransaction> transactions = csvTransactionParser.parseTransactions(transactionLines);

        TransactionProcessor transactionProcessor = new TransactionProcessor(new DefaultOperationStrategy());
        transactionProcessor.processTransactions(transactions, fruitStore);

        ReportCreator reportCreator = new CsvReportCreator(new TextFileWriter());
        reportCreator.createReport(fruitStore, "src/main/java/core/basesyntax/report.csv");

    }
}
