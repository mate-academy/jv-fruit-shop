package core.basesyntax.strategy;

import core.basesyntax.model.Instruction;

public interface Operation {
    void proceed(Instruction instruction);
}
