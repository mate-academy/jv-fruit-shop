package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitParser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileServiceImpl implements FileService {
    private final FruitParser fruitParser;

    public FileServiceImpl(FruitParser fruitParser) {
        this.fruitParser = fruitParser;
    }

    @Override
    public List<FruitTransaction> loadFromFile(String fileName) {
        List<FruitTransaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String header = br.readLine();
            if (header == null) {
                return transactions;
            }
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isBlank()) {
                    transactions.add(fruitParser.parse(line));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + fileName, e);
        }
        return transactions;
    }

    @Override
    public void saveToFile(Map<String, Integer> storageData, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("fruit,quantity");
            bw.newLine();
            for (Map.Entry<String, Integer> entry : storageData.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't save the file " + fileName, e);
        }
    }
}
