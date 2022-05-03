package core.basesyntax;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.models.Transaction;
import core.basesyntax.service.ContentGenerator;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.Parser;
import core.basesyntax.service.TransactionsCalculator;
import core.basesyntax.service.impl.ContentGeneratorImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.TransactionsCalculatorImpl;
import java.util.List;

public class Main {
    private static final String PATH_FROM = "src/main/resources/inputData.csv";
    private static final String PATH_TO = "src/main/resources/outputData.csv";

    public static void main(String[] args) {
        // Read
        FileReader reader = new FileReaderImpl();
        List<String> list = reader.read(PATH_FROM);

        // Parse to transaction
        Parser parse = new ParserImpl();
        List<Transaction> transactionList = parse.parse(list);

        // Adding to storage
        StorageDaoImpl storageDaoImpl = new StorageDaoImpl();
        TransactionsCalculator handle = new TransactionsCalculatorImpl(storageDaoImpl);
        handle.handleTransactions(transactionList);

        // Generating report
        StorageDao storageDao = new StorageDaoImpl();
        ContentGenerator contentGenerator = new ContentGeneratorImpl(storageDao);
        String report = contentGenerator.generateContent();

        // Writing report to a file
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(report, PATH_TO);
    }

}
