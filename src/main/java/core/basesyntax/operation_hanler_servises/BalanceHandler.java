package core.basesyntax.operation_hanler_servises;

import core.basesyntax.model.TransferDto;

import java.util.Map;

public class BalanceHandler implements OperationHandler {
    @Override
    public void apply(TransferDto transferDto, Map<String, Integer> storage) {
        storage.put(transferDto.getProductName(), transferDto.getAmount());
    }
}
