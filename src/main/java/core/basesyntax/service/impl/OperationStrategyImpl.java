package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";

    @Override
    public int operation(FruitRecordDto fruitRecordDto) {
        switch (fruitRecordDto.getOperationType()) {
            case (BALANCE) :
                new SetBalanceHandlerImpl().applyFruit(fruitRecordDto);
                break;
            case (SUPPLY) :
                new SupplyFruitsImpl().applyFruit(fruitRecordDto);
                break;
            case (PURCHASE) :
                new PurchaseFruitHandlerImpl().applyFruit(fruitRecordDto);
                break;
            case (RETURN) :
                new ReturnFruitHandlerImpl().applyFruit(fruitRecordDto);
                break;
            default:
                throw new RuntimeException("No such operation allowed");
        }
        return fruitRecordDto.getAmount();
    }
}
