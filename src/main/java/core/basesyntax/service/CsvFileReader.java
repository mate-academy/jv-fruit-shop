package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;

import java.util.List;

public interface CsvFileReader {
    List<String> readFile(String fileName);
}
