package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, CodeService> codeServiceMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, CodeService> codeServiceMap) {
        this.codeServiceMap = codeServiceMap;
    }

    public CodeService getCodeService(FruitTransaction.Operation code) {
        return codeServiceMap.get(code);
    }
}
