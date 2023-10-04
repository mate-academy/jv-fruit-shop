package core.basesyntax.dao.csv.impl;

import core.basesyntax.dao.csv.CsvFileHandlerDao;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileHandlerDaoImpl implements CsvFileHandlerDao {
    private static final String READ_EXCEPTION = "Can`t read data from file - %s";
    private static final String WRITE_EXCEPTION = "Can`t write data to file - %s";

    @Override
    public List<String> readCsv(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(String.format(READ_EXCEPTION, filePath));
        }
    }

    @Override
    public void writeToCsv(String filePath, List<String> stringList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (String row : stringList) {
                bufferedWriter.write(row);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(String.format(WRITE_EXCEPTION, filePath));
        }
    }
}
