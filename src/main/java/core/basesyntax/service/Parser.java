package core.basesyntax.service;

import core.basesyntax.dto.Operation;

import java.util.List;

public interface Parser {
    List<Operation> parseOperationsToList(List<String> list);
}
