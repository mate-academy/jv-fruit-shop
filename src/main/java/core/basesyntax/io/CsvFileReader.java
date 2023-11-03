package core.basesyntax.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader implements ReaderFromFile {
    private static final String EXCEPTION_FIND_FILE_MESSAGE = "Can't find file by path: ";

    @Override
    public List<String> readFile(String filePath) {
        File file = new File(filePath);
        List<String> inputData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int value = reader.read();
            while (value != -1) {
                inputData.add(String.valueOf(value));
            }
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_FIND_FILE_MESSAGE + filePath, e);
        }
        return inputData;
    }
}
