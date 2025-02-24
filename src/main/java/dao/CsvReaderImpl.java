package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderImpl implements CustomFileReader {
    public static final String CSV_DELIMITOR = ",";

    @Override
    public List<String[]> readFile(String filePath) {
        List<String[]> data = new ArrayList<>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while ((line = bufferedReader.readLine()) != null) {
                data.add(line.split(CSV_DELIMITOR));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(filePath + " doesn`t exist");
        } catch (IOException e) {
            throw new RuntimeException(filePath + " is not readable");
        }
        return data;
    }
}
