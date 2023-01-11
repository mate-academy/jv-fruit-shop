package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface FileWriterService {
    void parse(List<String[]> report);
}
