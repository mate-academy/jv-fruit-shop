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
            case (PURCHASE) :
                new PurchaseFruitHandlerImpl().applyFruit(fruitRecordDto);
                break;
            case (BALANCE) :
            case (SUPPLY) :
            case (RETURN) :
                new AddHandlerImpl().applyFruit(fruitRecordDto);
                break;
            default:
                throw new RuntimeException("No such operation allowed");
        }
        return fruitRecordDto.getAmount();
    }
}
