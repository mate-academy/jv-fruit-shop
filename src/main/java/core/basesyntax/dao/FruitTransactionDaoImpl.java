package core.basesyntax.dao;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.Storage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

public class FruitTransactionDaoImpl implements FruitTransactionDao {

    @Override
    public void addToStorage(String nameOfFile) {
        File inputFile = new File(nameOfFile);
        List<String> linesFromInputFile;
        try {
            linesFromInputFile = Files.readAllLines(inputFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't find the file");
        }
        List<FruitTransaction> list = linesFromInputFile.stream()
                .map(s -> s.split(","))
                .map(s -> new FruitTransaction(s[0], s[1], Integer.parseInt(s[2])))
                .toList();
        Storage.storageFromInputFile.addAll(list);
    }

    @Override
    public void getReport() {
        String filePath = "report.CSV";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Integer> entry : Storage.storageForReport.entrySet()) {
                String line = entry.getKey() + "," + entry.getValue();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data has written successful: " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Error during writing to file: " + e.getMessage());
        }
    }
}
