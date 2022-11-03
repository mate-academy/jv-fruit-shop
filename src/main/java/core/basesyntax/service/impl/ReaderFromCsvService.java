package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderFromCsvService implements ReaderService {
    @Override
    public List<String[]> getActivities(String fileName) {
        try {
            List<String> records = Files.readAllLines(Path.of(fileName));
            records.remove(0);
            return records.stream()
                    .map(s -> s.split(","))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file" + fileName);
        }
    }
}
