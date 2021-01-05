package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface DataReader {
    List<Transaction> read(String filename);
}
