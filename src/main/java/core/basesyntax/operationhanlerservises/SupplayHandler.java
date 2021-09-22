package core.basesyntax.operationhanlerservises;

import core.basesyntax.model.TransferDto;
import java.util.Map;

public class SupplayHandler implements OperationHandler {
    @Override
    public void apply(TransferDto transferDto, Map<String, Integer> storage) {
        storage.put(transferDto.getProductName(),
                    storage.get(transferDto.getProductName()) + transferDto.getAmount());
    }
}
