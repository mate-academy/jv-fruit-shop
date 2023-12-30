package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvDataReaderImpl implements CsvDataReader {
    private static final String LINE_SEPARATOR = ",";

    @Override
    public List<String[]> readDataFromFile(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(LINE_SEPARATOR);
                data.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + filePath, e);
        }
        return data;
    }
}
