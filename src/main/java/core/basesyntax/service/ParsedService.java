package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface ParsedService {
    List<Transaction> parse(List<String> listFromParsed);
}
