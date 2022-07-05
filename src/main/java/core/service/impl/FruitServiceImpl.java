package core.service.impl;

import core.db.FruitTransaction;
import core.service.FruitService;
import java.util.List;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    @Override
    public String getBalanceReport(List<FruitTransaction> transactions) {
        String summary = transactions.stream()
                .collect(Collectors.groupingBy(FruitTransaction::getFruit,
                        Collectors.summingInt(f -> f.getQuantity() * f.getSign())))
                .entrySet()
                .stream()
                .map(k -> String.format("%s,%d", k.getKey(), k.getValue()))
                .collect(Collectors.joining("\n"));
        return "fruit,quantity\n" + summary;
    }
}
