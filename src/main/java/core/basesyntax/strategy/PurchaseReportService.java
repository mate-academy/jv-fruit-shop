package core.basesyntax.strategy;

import java.util.Map;
import java.util.Optional;

public class PurchaseReportService implements ReportService {
    @Override
    public void apply(Map<String, Integer> map, String data) {
        String key = data.split(SPLITTER, 2)[0];
        Integer purchasedAmount = Integer.parseInt(data.split(SPLITTER, 2)[1]);
        Integer initialAmount = Optional.ofNullable(map.get(key))
                .orElseThrow(() -> new RuntimeException("Fruit index does not exist"));
        if (purchasedAmount > initialAmount) {
            throw new RuntimeException("Can't purchase more than there is in stock");
        }
        map.put(key, initialAmount - purchasedAmount);
    }
}
