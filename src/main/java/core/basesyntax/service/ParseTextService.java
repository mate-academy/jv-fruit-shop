package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface ParseTextService {
    List<FruitTransaction> parseReport(List<String> stringList);
}
