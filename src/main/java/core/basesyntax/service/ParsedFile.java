package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface ParsedFile {
    List<Transaction> parsedList(List<String> listFromParsed);
}
