package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReaderServiceImpl implements FileReaderService {
    private static final String INPUT_FILE_NAME = "input.csv";
    private static final String READER_FAILURE_MESSAGE = "Cannot read from file {%s}!";
    private static final int READ_END_INDEX = -1;

    @Override
    public String readInputData() {
        StringBuilder fileInputBuilder = new StringBuilder();
        try (FileInputStream dataStream = new FileInputStream(INPUT_FILE_NAME)) {
            int charInAscii;
            while ((charInAscii = dataStream.read()) != READ_END_INDEX) {
                fileInputBuilder.append((char) charInAscii);
            }
        } catch (IOException ex) {
            throw new RuntimeException(String.format(READER_FAILURE_MESSAGE, INPUT_FILE_NAME));
        }
        return fileInputBuilder.toString();
    }
}
