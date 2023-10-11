package core.basesyntax.fruittransact;

import java.util.List;

public interface FruitTransaction {
    void transact(String type, String name, int amount);

    void transactAll(List<String[]> data);
}
