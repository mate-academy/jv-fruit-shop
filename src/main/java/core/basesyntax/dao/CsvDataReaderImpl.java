package core.basesyntax.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvDataReaderImpl implements CsvDataReader {
    private static final String FILEPATH =
            "src/main/resources/InputFile.csv";

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
