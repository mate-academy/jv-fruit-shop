package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.DataValidator;
import core.basesyntax.service.StrategyService;
import core.basesyntax.service.impl.strategy.BalanceOperation;
import core.basesyntax.service.impl.strategy.PurchaseOperation;
import core.basesyntax.service.impl.strategy.ReturnOperation;
import core.basesyntax.service.impl.strategy.SupplyOperation;
import java.util.List;

public class StrategyServiceImpl implements StrategyService {
    private static final DataValidator DATA_VALIDATOR = new DataValidatorImpl();
    private static final BalanceOperation BALANCE_OPERATION = new BalanceOperation();
    private static final PurchaseOperation PURCHASE_OPERATION = new PurchaseOperation();
    private static final ReturnOperation RETURN_OPERATION = new ReturnOperation();
    private static final SupplyOperation SUPPLY_OPERATION = new SupplyOperation();

    @Override
    public void processData(List<FruitTransactionDto> fruitTransactionDtoList) {
        for (FruitTransactionDto fruitTransactionDto : fruitTransactionDtoList) {
            DATA_VALIDATOR.validate(fruitTransactionDto);
            switch (fruitTransactionDto.operation()) {
                case "b" -> BALANCE_OPERATION.handle(fruitTransactionDto);
                case "p" -> PURCHASE_OPERATION.handle(fruitTransactionDto);
                case "r" -> RETURN_OPERATION.handle(fruitTransactionDto);
                default -> SUPPLY_OPERATION.handle(fruitTransactionDto);
            }
        }
    }
}
