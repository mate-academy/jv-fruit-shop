package core.basesyntax.serviceimpl;

import core.basesyntax.service.OperationService;
import core.basesyntax.service.ProcessData;
import java.util.List;

public class ProcessDataimpl implements ProcessData {
    private static final FruitStrategy fruitStrategy = new FruitStrategy();

    @Override
    public void processData(List<FruitTransaction> data) {
        for (FruitTransaction entry : data) {
            OperationService service = fruitStrategy.getOperationService(entry.getOperation());
            service.calculateQuantity(entry);
        }
    }
}
