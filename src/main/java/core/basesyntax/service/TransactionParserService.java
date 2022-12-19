package core.basesyntax.service;

import java.util.ArrayList;
import java.util.List;

public interface TransactionParserService {
    List<FruitTransaction> parse(List<String> list);

}
