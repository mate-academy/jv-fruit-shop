package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements Reader {
    private static final String FILE_PATH = "src/main/resources/input.csv";

    @Override
    public List<String> read() {
        List<String> result = new ArrayList<>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader(FILE_PATH))) {
            csvReader.readLine();
            String row;
            while ((row = csvReader.readLine()) != null) {
                result.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file");
        }
        return result;
    }
}
