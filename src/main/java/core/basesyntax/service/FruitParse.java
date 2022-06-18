package core.basesyntax.service;

import core.basesyntax.model.TransactionInfo;
import java.util.List;

public interface FruitParse {
    List<TransactionInfo> parse(List<String> list);
}
