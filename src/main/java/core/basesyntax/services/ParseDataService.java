package core.basesyntax.services;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface ParseDataService {
    List<Transaction> parse(List<String> data);
}
