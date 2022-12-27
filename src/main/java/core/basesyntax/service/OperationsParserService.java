package core.basesyntax.service;

import java.util.List;

public interface OperationsParserService {
    List<String[]> parseOperations(List<String> operationInfo);
}
