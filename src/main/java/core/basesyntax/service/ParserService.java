package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface ParserService {
    List<Transaction> parseLine(List<String> inputData);
}
