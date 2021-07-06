package core.basesyntax.service;

import core.basesyntax.dto.Transaction;
import java.util.List;

public interface Parser {
    List<Transaction> parseLine(List<String> lines);
}
