package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements FileReader {
    private final String path;

    public CsvFileReaderImpl(String path) {
        this.path = path;
    }

    @Override
    public List<TransactionDto> readFromFile() {
        List<TransactionDto> list = new ArrayList<>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))) {
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                list.add(TransactionDtoFactory.build(line));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file!" + e);
        }
        return list;
    }
}
