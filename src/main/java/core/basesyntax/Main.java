package core.basesyntax;

import core.basesyntax.FileManagers.FileReaderImpl;
import core.basesyntax.FileManagers.FileWriterImpl;
import core.basesyntax.Transactions.FruitTransaction;
import core.basesyntax.Transactions.TransactionsFormer;
import core.basesyntax.Transactions.TransactionExecutor;
import core.basesyntax.db.Storage;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReaderImpl fileReader = new FileReaderImpl();
        final String READ_FILE_PATH = "src/main/java/input.csv";
        List<String> data = fileReader.getData(READ_FILE_PATH);

        TransactionsFormer transactionsFormer = new TransactionsFormer();
        List<FruitTransaction> transactions = transactionsFormer.formTransactionList(data);

        TransactionExecutor executor = new TransactionExecutor();
        for (FruitTransaction transaction : transactions) {
            executor.transactionExecute(transaction);
        }

        FileWriterImpl fileWriter = new FileWriterImpl();
        fileWriter.writeReport(Storage.reportData);
    }
}
