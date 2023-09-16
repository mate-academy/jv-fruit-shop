package fruitshop.service.serviceimpl;

import fruitshop.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements Reader {
    @Override
    public List<String> readDataFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file: " + fileName, e);
        }
        return lines;
    }
}
