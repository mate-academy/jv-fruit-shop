package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConvertorService;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertorServiceImpl implements ConvertorService {
    @Override
    public List<FruitTransaction> convertData(List<String> data) {
        return data.stream()
                .map(s -> s.split(","))
                .filter(s -> Character.isDigit(s[2].charAt(0)))
                .map(s -> new FruitTransaction(s[0], s[1], Integer.parseInt(s[2])))
                .collect(Collectors.toList());
    }
}
