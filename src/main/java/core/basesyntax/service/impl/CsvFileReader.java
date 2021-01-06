package core.basesyntax.service.impl;

import core.basesyntax.model.Record;
import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReader implements FileReader {

    @Override
    public List<Record> readAll(String pathFromFile) {
        CsvToRecordParser parser = new CsvToRecordParser();
        try {
            return Files.lines(Path.of(pathFromFile))
                    .filter(line -> !line.startsWith("type"))
                    .map(parser::parse)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file " + pathFromFile, e);
        }
    }
}
