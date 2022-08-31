package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface ParserService {
    List<Transaction> parseLines(List<String> inputData);
}
