package service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.ParseService;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private static final String ERROR = "Failed to read resource: ";
    private final ParseService parseService;

    public ReaderServiceImpl(ParseService parseService) {
        this.parseService = parseService;
    }

    @Override
    public List<FruitTransaction> readFromFile(String filePath) {
        List<FruitTransaction> transactions = new ArrayList<>();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                transactions.add(parseService.parseLine(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(ERROR + filePath + " (" + e.getMessage() + ")");
        }
        return transactions;
    }
}
