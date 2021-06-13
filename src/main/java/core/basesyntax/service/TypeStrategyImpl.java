package core.basesyntax.service;

import core.basesyntax.model.FruitDto;

public class TypeStrategyImpl implements TypeStrategy {
    @Override

    public TypeHandler getTypeHandler(FruitDto fruitDto) {
        if (fruitDto.getType().equals("b")) {
            return new BalanceOperation();
        } else if (fruitDto.getType().equals("p")) {
            return new PurchaseOperation();
        } else if (fruitDto.getType().equals("r")) {
            return new ReturnOperation();
        }
        return new SupplyOperation();
    }
}
