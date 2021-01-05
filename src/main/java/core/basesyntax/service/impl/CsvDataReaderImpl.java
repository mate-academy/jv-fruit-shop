package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.DataReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvDataReaderImpl implements DataReader {
    private CsvParser csvParser;

    public CsvDataReaderImpl(CsvParser csvParser) {
        this.csvParser = csvParser;
    }

    @Override
    public List<TransactionDto> read(String filePath) {
        try {
            List<String> allLines = Files.readAllLines(Path.of(filePath));
            allLines.remove(0);
            return csvParser.parse(allLines);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file" + filePath, e);
        }
    }
}
