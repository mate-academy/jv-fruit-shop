package core.basesyntax.service.impl;

import core.basesyntax.service.ImportOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImportOperationsImpl implements ImportOperations {

    @Override
    public List<String[]> getOperations(List<String> operationInfo) {
        return operationInfo.stream()
                .map(i -> i.split(","))
                .skip(1)
                .collect(Collectors.toList());
    }
}
