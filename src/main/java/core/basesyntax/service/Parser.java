package core.basesyntax.service;

import core.basesyntax.model.TransactionLine;
import java.util.List;

public interface Parser {
    List<TransactionLine> parser(List<String> list);
}
