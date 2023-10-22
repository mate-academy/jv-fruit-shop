package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface InputReaderService {
    List<FruitTransaction> readInput(String source);
}
