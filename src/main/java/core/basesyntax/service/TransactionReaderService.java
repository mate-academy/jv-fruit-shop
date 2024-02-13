package core.basesyntax.service;

import java.util.List;

public interface TransactionReaderService {
    List<String> read(String fileName);
}
