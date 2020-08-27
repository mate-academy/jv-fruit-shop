package core.basesyntax.operation;

import core.basesyntax.fruitservice.Transaction;
import java.util.Map;

public interface Operation {
    void operation(Map<String,Integer> fruitDao, Transaction transaction);
}
