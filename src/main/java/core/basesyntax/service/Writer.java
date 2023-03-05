package core.basesyntax.service;

import core.basesyntax.model.Fruit;

public interface Writer {
    void writeReport(String fileName, Fruit[] fruits);
}
