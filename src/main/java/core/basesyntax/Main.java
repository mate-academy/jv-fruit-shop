package core.basesyntax;

import core.basesyntax.fileManagers.FileReaderImpl;
import core.basesyntax.fileManagers.FileWriterImpl;
import core.basesyntax.transactions.FruitTransaction;
import core.basesyntax.transactions.TransactionsFormer;
import core.basesyntax.transactions.TransactionExecutor;
import core.basesyntax.db.Storage;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String inputFilePath = "src/main/resources/input.csv";
        final String reportFilePath = "src/main/resources/report.csv";
        FileReaderImpl fileReader = new FileReaderImpl();
        List<String> data = fileReader.getData(inputFilePath);

        TransactionsFormer transactionsFormer = new TransactionsFormer();
        List<FruitTransaction> transactions = transactionsFormer.formTransactionList(data);

        TransactionExecutor executor = new TransactionExecutor();
        for (FruitTransaction transaction : transactions) {
            executor.transactionExecute(transaction);
        }

        FileWriterImpl fileWriter = new FileWriterImpl();
        fileWriter.writeReport(Storage.reportData, reportFilePath);
    }
}
