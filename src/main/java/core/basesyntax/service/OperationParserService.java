package core.basesyntax.service;

import core.basesyntax.model.Operation;

import java.util.List;

public interface OperationParserService {
    List<Operation> parseDataFromList(List<String> data);
}
