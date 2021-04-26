package core.basesyntax.service.parser;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface FileEntryParser {
    List<Transaction> parseProduct(List<String> records);
}
