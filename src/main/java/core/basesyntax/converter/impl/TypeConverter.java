package core.basesyntax.converter.impl;

import core.basesyntax.converter.Convertor;
import core.basesyntax.model.FruitTransaction;

public class TypeConverter implements Convertor<FruitTransaction.Operation> {
    @Override
    public FruitTransaction.Operation convertor(String string) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getTypeOfOperation().equals(string)) {
                return operation;
            }
        }
        throw new RuntimeException("Operation with name " + string + " not found.");
    }
}
