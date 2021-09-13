package core.basesyntax.services;

import core.basesyntax.model.Operation;
import java.util.List;

public interface CommandParser {
    List<Operation> parseData(List<String> dataFromFile);
}
