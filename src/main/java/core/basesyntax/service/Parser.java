package core.basesyntax.service;

import core.basesyntax.model.Operation;
import java.util.List;

@FunctionalInterface
public interface Parser {
    List<Operation> parse(List<String> inputData);
}
