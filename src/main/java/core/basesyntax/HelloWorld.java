package core.basesyntax;

import core.basesyntax.models.Transaction;
import core.basesyntax.parse.Parser;
import core.basesyntax.parse.ParserImpl;
import core.basesyntax.reader.FileReader;
import core.basesyntax.reader.FileReaderImpl;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.TransactionOperations;
import core.basesyntax.strategy.implementation.TransactionHandler;

import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    private static final String PATH = "src/main/resources/data.csv";
    public static void main(String[] args) {
        // Read
        FileReader reader = new FileReaderImpl();
        List<String> list = reader.read(PATH);

        // Parse to transaction
        Parser parse = new ParserImpl();
        List<Transaction> transactionList = parse.parse(list);

        // Adding to temp. storage
        TransactionOperations handle = new TransactionOperations();
        handle.handleTransactions(transactionList);
        System.out.println(Storage.storage.entrySet());
    }

}
