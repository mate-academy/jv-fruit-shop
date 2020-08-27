package core.basesyntax.service;

import core.basesyntax.Transaction;
import java.util.List;

public interface FileReadService {
    List<Transaction> readFile(String filePath);
}
