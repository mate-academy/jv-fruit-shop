package core.basesyntax.service;

import core.basesyntax.model.Operation;
import java.util.List;

public interface ParserService {
    List<Operation> parseOperations(List<String> lines);
}
