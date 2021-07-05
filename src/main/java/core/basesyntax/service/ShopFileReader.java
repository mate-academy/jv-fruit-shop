package core.basesyntax.service;

import core.basesyntax.dto.Transaction;
import java.util.List;

public interface ShopFileReader {
    List<Transaction> readFromFile(String fileName);
}
