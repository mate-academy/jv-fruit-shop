package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private static final String ERROR = "Failed to read file: ";

    @Override
    public List<FruitTransaction> readFromFile(String file) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        ParseServiceImpl fruitDaoCsv = new ParseServiceImpl();
        boolean isFirstLine = true;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                fruitTransactions.add(fruitDaoCsv.parseLine(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(ERROR + e.getMessage());
        }
        return fruitTransactions;
    }
}
