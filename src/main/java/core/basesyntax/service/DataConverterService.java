package core.basesyntax.service;

import core.basesyntax.domain.Fruit;

import java.util.List;

public interface DataConverterService {
    List<Fruit> convertToFruit(List<String> inputReport);
}
