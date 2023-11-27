package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String inputFileName) {
        List<String> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(inputFileName))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                transactions.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + inputFileName);
        }

        return transactions;
    }
}
