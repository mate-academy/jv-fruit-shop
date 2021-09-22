package fruitshop.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class InputDataReaderImpl implements InputDataReader {
    private static final String FILE_READING_ERROR_NOTIFICATION = "Can`t read file";

    public List<String> readFromFile(String inputFilePath) {
        File inputFile = new File(inputFilePath);
        try {
            List<String> inputFileInfo = Files.readAllLines(inputFile.toPath());
            return inputFileInfo;
        } catch (IOException e) {
            throw new RuntimeException(FILE_READING_ERROR_NOTIFICATION, e);
        }
    }
}
