package core.basesyntax.dao.csv.impl;

import core.basesyntax.dao.csv.CsvDao;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvDaoImpl implements CsvDao {
    private static final String WRITE_EXCEPTION = "Can`t write data to file";
    private static final String CLOSE_BUFFERED_WRITER_EXCEPTION = "Can`t close BufferedWriter";
    private static final String READ_FILE_PATH = "src/main/java/core/basesyntax/csv/database.csv";
    private static final String WRITE_FILE_PATH = "src/main/java/core/basesyntax/csv/report.csv";

    @Override
    public List<String> readCsv() {
        try {
            return Files.readAllLines(Path.of(READ_FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeToCsv(List<String> stringList) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(WRITE_FILE_PATH));
            for (String row : stringList) {
                bufferedWriter.write(row + System.lineSeparator());
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(WRITE_EXCEPTION, e);
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(CLOSE_BUFFERED_WRITER_EXCEPTION, e);
                }
            }
        }
    }
}
