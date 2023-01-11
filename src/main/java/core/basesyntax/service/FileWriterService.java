package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface FileWriterService {
    List<FruitTransaction> parse(List<FruitTransaction> parser);
}
