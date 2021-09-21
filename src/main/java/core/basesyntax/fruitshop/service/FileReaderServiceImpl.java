package core.basesyntax.fruitshop.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    private final List<String> transactions = new ArrayList<>();

    public List<String> readFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                transactions.add(line);
                line = reader.readLine();
            }
            transactions.remove(0);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + e);
        }
        return transactions;
    }
}
