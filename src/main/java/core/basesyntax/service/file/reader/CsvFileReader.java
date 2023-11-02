package core.basesyntax.service.file.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader implements FileReader {
    private static final String CANT_READ_DATA_FROM_FILE_MESSAGE = "Can't read data from file: ";
    private static final int AMOUNT_OF_LINES_TO_SKIP = 1;

    @Override
    public List<String> readFromFile(String path) {
        List<String> dataLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(path))) {
            reader.lines().skip(AMOUNT_OF_LINES_TO_SKIP)
                    .forEach(dataLines::add);
        } catch (IOException e) {
            throw new RuntimeException(CANT_READ_DATA_FROM_FILE_MESSAGE + path, e);
        }
        return dataLines;
    }
}
