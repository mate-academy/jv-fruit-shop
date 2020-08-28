package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportBuilderImpl implements ReportBuilder {

    @Override
    public Map<String, Integer> buildReport(List<Storage.FruitBox> data) {
        if (data == null) {
            throw new RuntimeException();
        }
        List<String> fruitNames = data.stream()
                .sorted()
                .map(x -> x.getFruit().getName())
                .distinct()
                .collect(Collectors.toList());
        Map<String, Integer> balance = new HashMap<>();
        for (String name : fruitNames) {
            int quantitySum = data.stream()
                    .filter(x -> x.getFruit().getName().equals(name))
                    .mapToInt(Storage.FruitBox::getQuantity)
                    .sum();
            balance.put(name, quantitySum);
        }
        return balance;
    }
}
