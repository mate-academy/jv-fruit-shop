package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ParseFruits {
    List<FruitTransaction> parse(List<String> lines);

    FruitTransaction transaction(String line);
}
