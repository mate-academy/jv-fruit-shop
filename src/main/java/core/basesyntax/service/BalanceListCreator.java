package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface BalanceListCreator {
    List<String> create(Map<String,Integer> itemsQuantity);
}
