package core.basesyntax.service;

import core.basesyntax.operation.Operation;
import java.util.List;
import java.util.stream.Collectors;

public class SeparateOperationServiceImpl implements SeparateOperationService {
    private static final int ACTIVITIES_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 2;

    @Override
    public List<String> getListOfActivity(List<String> listFromFile, Operation operation) {
        return listFromFile.stream()
                .filter(s -> s.split(",")[ACTIVITIES_INDEX].equals(operation.getOperation()))
                .map(s -> s.substring(FRUIT_NAME_INDEX))
                .collect(Collectors.toList());
    }
}
