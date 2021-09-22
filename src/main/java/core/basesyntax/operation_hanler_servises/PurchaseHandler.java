package core.basesyntax.operation_hanler_servises;

import core.basesyntax.model.TransferDto;
import core.basesyntax.operation_hanler_servises.OperationHandler;

import java.util.Map;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void apply(TransferDto transferDto, Map<String, Integer> storage) {
        if (transferDto.getAmount() > storage.get(transferDto.getProductName())) {
            throw new RuntimeException("purchase can't be < balance");
        }
        storage.put(transferDto.getProductName(),
                    storage.get(transferDto.getProductName()) - transferDto.getAmount());
    }
}
