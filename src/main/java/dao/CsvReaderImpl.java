package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvReaderImpl implements CustomFileReader {

    @Override
    public String readFile(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(filePath + " doesn't exist", e);
        }
        return sb.toString();
    }
}
