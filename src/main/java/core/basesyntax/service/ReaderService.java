package core.basesyntax.service;

import core.basesyntax.model.Fruit;

import java.util.List;

public interface ReaderService {
    List<String> readData(String fromFile);
}
