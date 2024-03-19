package core.basesyntax.service;

import core.basesyntax.model.Operation;
import java.util.List;

public interface Parser {
    List<Operation> parseToOperations(List<String> record);
}
