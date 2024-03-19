package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface FileDataParser {
    List<Transaction> parse(List<String> data);
}
