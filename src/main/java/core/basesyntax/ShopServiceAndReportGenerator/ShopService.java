package core.basesyntax.ShopServiceAndReportGenerator;

import core.basesyntax.Operations.FruitTransaction;

import java.util.List;

import java.util.Map;

public interface ShopService {
    void process(List<FruitTransaction> transactions);
    Map<String, Integer> getStorage();
}
