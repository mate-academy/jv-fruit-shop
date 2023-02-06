package core.basesyntax.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvFileReaderImpl implements FileReader {

    @Override
    public List<String> readFromFile(String path) {
        List<String> transactions = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't read from the file" + path, e);
        }
        while (scanner.hasNext()) {
            transactions.add(scanner.next());
        }
        return transactions;
    }
}
