package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriterImpl implements CustomFileWriter {

    @Override
    public void writeFile(String filePath, List<String> data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (String row : data) {
                bufferedWriter.write(row);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Сan`t write a file " + e);
        }
    }
}


