package core.basesyntax.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader implements FileReader {
    private static final String CANT_READ_DATA_FROM_FILE_MESSAGE = "Can't read data from file: ";

    @Override
    public List<String> readFromFile(String path) {
        List<String> dataLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(path))) {
            String dataLine = reader.readLine();
            boolean isFirstLineRead = false;
            while (dataLine != null) {
                if(!isFirstLineRead) {
                    isFirstLineRead = true;
                    continue;
                }
                dataLines.add(dataLine);
                dataLine = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(CANT_READ_DATA_FROM_FILE_MESSAGE + path);
        }
        return dataLines;
    }
}
