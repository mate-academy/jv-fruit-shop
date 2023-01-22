package core.basesyntax.serviceimpl;

import core.basesyntax.service.CsvFileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public List<String> readDataFromFileCsv(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<String> listOfLines = new ArrayList<>();
            reader.readLine();
            String line = reader.readLine();
            while (line != null) {
                listOfLines.add(line);
                line = reader.readLine();
            }
            return listOfLines;
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
    }
}
