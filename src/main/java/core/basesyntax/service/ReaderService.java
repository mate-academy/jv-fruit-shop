package core.basesyntax.service;

import java.util.List;

public interface ReaderService {
    List<String> readTransactionWithFile(String fileName);
}
