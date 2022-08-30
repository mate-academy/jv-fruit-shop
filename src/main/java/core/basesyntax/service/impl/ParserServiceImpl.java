package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParseService {
    @Override
    public List<FruitTransaction> parse(List<String> list) {
        list.remove(0);
        return list.stream()
                .map(s -> s.split(","))
                .map(s -> new FruitTransaction(
                        Arrays.stream(FruitTransaction.Operation.values())
                                .filter(o -> o.getOperation().equals(s[0]))
                                .findFirst().get(),
                        s[1],
                        Integer.parseInt(s[2])))
                .collect(Collectors.toList());
    }
}
