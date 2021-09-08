package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;

import java.util.List;

public interface ParseService {
    FruitRecord getParsedLine(String row);
}
