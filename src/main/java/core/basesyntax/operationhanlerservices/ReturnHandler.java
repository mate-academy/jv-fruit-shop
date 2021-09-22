package core.basesyntax.operationhanlerservices;

import core.basesyntax.model.TransferDto;
import java.util.Map;

public class ReturnHandler implements OperationHandler {
    @Override
    public void apply(TransferDto transferDto, Map<String, Integer> storage) {
        if (transferDto.getAmount() < 0) {
            throw new RuntimeException("Return can't be negative");
        }
        storage.put(transferDto.getProductName(),
                    (Integer) storage.get(transferDto.getProductName()) + transferDto.getAmount());
    }
}
