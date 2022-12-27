package core.basesyntax.service.impl;

import core.basesyntax.service.OperationsParserService;
import java.util.List;
import java.util.stream.Collectors;

public class OperationsParserServiceImpl implements OperationsParserService {

    @Override
    public List<String[]> parseOperations(List<String> operationInfo) {
        return operationInfo.stream()
                .map(i -> i.split(","))
                .skip(1)
                .collect(Collectors.toList());
    }
}
