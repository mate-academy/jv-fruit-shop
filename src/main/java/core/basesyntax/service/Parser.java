package core.basesyntax.service;

import core.basesyntax.models.Transaction;
import java.util.List;

public interface Parser {
    List<Transaction> parse(List<String> list);
}
