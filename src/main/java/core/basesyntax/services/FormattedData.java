package core.basesyntax.services;

import core.basesyntax.model.Operation;
import java.util.List;

public interface FormattedData {
    List<Operation> formattedData(List<String> dataFromFile);
}
