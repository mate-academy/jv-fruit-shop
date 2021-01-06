package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileReaderImpl implements CsvFileReader {
    private String filePath;

    public CsvFileReaderImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String readFromFile() {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from thr file ", e);
        }
    }

    @Override
    public String[] getDataFromFile(String filePath) {
        CsvFileReader fileReaderService = new CsvFileReaderImpl(filePath);
        String[] lines = fileReaderService.readFromFile().split(System.lineSeparator());
        String[] newData = new String[lines.length - 1];
        System.arraycopy(lines, 1, newData, 0, newData.length);
        return newData;
    }
}
