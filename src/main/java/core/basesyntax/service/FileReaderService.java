package core.basesyntax.service;

import java.util.List;

public interface FileReaderService {
    List<TransactionLog> readFromFile(String filepath);
}
