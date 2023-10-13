package core.basesyntax.workwithfile;

import core.basesyntax.db.Storage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class WorkWithFileImpl implements WorkWithFile {
    private static final String SEPARATOR = ",";
    private static final int INDEX_OF_HEADING = 0;

    @Override
    public List<String[]> readFromFile(File file) {
        ArrayList<String[]> data = new ArrayList<>();
        try {
            for (String datum : Files.readAllLines(file.toPath())) {
                data.add(datum.split(SEPARATOR));
            }
        } catch (IOException ioException) {
            throw new RuntimeException("Cannot read data from file: " + file, ioException);
        }
        data.remove(INDEX_OF_HEADING);
        return data;
    }

    @Override
    public void writeToFile(File file, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(report);
        } catch (IOException ioException) {
            throw new RuntimeException("Cannot write data to file: " + file, ioException);
        }
    }

    @Override
    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity");
        for (String key : Storage.fruits.keySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(key)
                    .append(SEPARATOR).append(Storage.fruits.get(key));
        }
        return stringBuilder.toString();
    }
}

