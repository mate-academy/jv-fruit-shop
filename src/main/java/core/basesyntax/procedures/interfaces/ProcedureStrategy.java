package core.basesyntax.procedures.interfaces;

import core.basesyntax.procedures.classes.Procedures;

public interface ProcedureStrategy {
    Procedure get(Procedures procedureType);
}
