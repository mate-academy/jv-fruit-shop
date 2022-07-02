package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.stream.Collectors;

public interface ProductParser {
    Fruit parse(String productInfo);

    default List<Fruit> parseAll(List<String> list) {
        return list.stream()
                .map(this::parse)
                .collect(Collectors.toList());
    }
}
