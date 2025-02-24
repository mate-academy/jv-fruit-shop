package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriterImpl implements CustomFileWriter {
    public static final String CSV_DELIMITOR = ",";

    @Override
    public void writeFile(String filePath, List<String[]> data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                bufferedWriter.write(String.join(CSV_DELIMITOR, row));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("can`t write to the " + filePath);
        }
    }
}
