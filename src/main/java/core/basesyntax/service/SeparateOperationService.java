package core.basesyntax.service;

import core.basesyntax.operation.Operation;
import java.util.List;

public interface SeparateOperationService {
    List<String> getListOfActivity(List<String> listFromFile, Operation operation);
}
