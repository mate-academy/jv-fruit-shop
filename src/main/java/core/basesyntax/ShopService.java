package core.basesyntax;

import java.util.*;

public interface ShopService {
    void process(List<FruitTransaction> transactions);
    Map<String, Integer> getStorage();

}
