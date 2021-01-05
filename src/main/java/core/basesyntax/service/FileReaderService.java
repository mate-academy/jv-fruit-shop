package core.basesyntax.service;

import core.basesyntax.model.Transaction;

import java.util.List;

public interface FileReaderService {
    List<Transaction> readFromFile(String filePath);
}
