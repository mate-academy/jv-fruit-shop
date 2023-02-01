package core.basesyntax.dao;

import core.basesyntax.service.CsvTransactionParser;
import core.basesyntax.service.CsvTransactionParserImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataReaderImpl implements DataReader {
    private static final String FILEPATH =
            "src/main/resources/InputFile.csv";
    private final CsvTransactionParser csvTransactionParser = new CsvTransactionParserImpl();

    @Override
    public List<String> readFromFile() {
        List<String> transactions = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(FILEPATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't read the file" + FILEPATH, e);
        }
        while (scanner.hasNext()) {
            transactions.add(scanner.next());
        }
        return transactions;
    }
}
