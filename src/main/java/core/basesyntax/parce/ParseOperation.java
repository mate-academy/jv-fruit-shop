package core.basesyntax.parce;

import core.basesyntax.operation.OperationGeneral;

import java.util.List;

public interface ParseOperation<T extends OperationGeneral> {
    T parse(List<String> data);
}
