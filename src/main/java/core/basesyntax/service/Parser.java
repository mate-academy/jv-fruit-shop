package core.basesyntax.service;

import core.basesyntax.models.FruitTransaction;

import java.util.List;

public interface Parser {

    List<FruitTransaction> parse(List<String> parse);
}
