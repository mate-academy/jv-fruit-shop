package core.basesyntax;

import java.util.List;
import java.util.Map;

public interface ShopService {
    Map<String, Integer> process(List<FruitTransaction> transactions);
}
