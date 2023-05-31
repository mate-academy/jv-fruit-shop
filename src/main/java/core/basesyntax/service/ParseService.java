package core.basesyntax.service;

import core.basesyntax.model.FruitModel;

import java.util.List;

public interface ParseService {
    List<FruitModel> parsedData(List<String> dataFromFile);
}
