package core.basesyntax.procedures.classes;

import core.basesyntax.procedures.interfaces.Procedure;
import core.basesyntax.procedures.interfaces.ProcedureStrategy;
import java.util.Map;

public class ProcedureStrategyImpl implements ProcedureStrategy {
    private Map<Procedures, Procedure> procedureMap;

    public ProcedureStrategyImpl(Map<Procedures, Procedure> procedureMap) {
        this.procedureMap = procedureMap;
    }

    @Override
    public Procedure get(Procedures procedureType) {
        return procedureMap.get(procedureType);
    }
}
