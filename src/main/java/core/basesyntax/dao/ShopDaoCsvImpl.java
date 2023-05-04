package core.basesyntax.dao;

import core.basesyntax.db.Storage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class ShopDaoCsvImpl implements ShopDao{
    private static final String DATA_BASE_FILE_NAME = "database.csv";
    private static final String REPORT_FILE_NAME = "report.csv";

    @Override
    public List<String> readData() {
        List<String> dataBase;
        try {
            dataBase = Files.readAllLines(Path.of(DATA_BASE_FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("File not found - " + DATA_BASE_FILE_NAME);
        }
        return dataBase;
    }

    @Override
    public void writeReport() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(REPORT_FILE_NAME, true))) {
            for (Map.Entry<String, Integer> entry: Storage.storage.entrySet()) {
                bufferedWriter.write(entry.getKey() + "," + entry.getValue());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + REPORT_FILE_NAME);
        }
    }
}
