package core.basesyntax.service;

import core.basesyntax.model.Instruction;
import java.util.List;

public interface OperationExecutor {
    void proceedAll(List<Instruction> commands);
}
