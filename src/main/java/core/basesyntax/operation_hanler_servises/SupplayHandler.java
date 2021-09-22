package core.basesyntax.operation_hanler_servises;

import core.basesyntax.model.TransferDto;
import core.basesyntax.operation_hanler_servises.OperationHandler;

import java.util.Map;

public class SupplayHandler implements OperationHandler {
    @Override
    public void apply(TransferDto transferDto, Map<String, Integer> storage) {
        storage.put(transferDto.getProductName(),
                    storage.get(transferDto.getProductName()) + transferDto.getAmount());
    }
}
