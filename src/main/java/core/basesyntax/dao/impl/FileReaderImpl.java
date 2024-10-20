package core.basesyntax.dao.impl;

import core.basesyntax.dao.FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String filename) {
        List<String> transactions = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new java.io.FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                transactions.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while reading file " + filename);
        }
        return transactions;
    }
}
