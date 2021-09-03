package core.basesyntax.service.data;

import core.basesyntax.model.Operation;
import java.util.List;

public interface DataToOperationsFormatter {
    List<Operation> formatData(List<String> data);
}
