package core.basesyntax.parser;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface Parser {
    List<Transaction> parse(String data);
}
