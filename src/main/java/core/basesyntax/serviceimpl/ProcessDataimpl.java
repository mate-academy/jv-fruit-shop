package core.basesyntax.serviceimpl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.ProcessData;

import java.util.List;

public class ProcessDataimpl implements ProcessData {

    private static final FruitStrategy fruitStrategy = new FruitStrategy();

    @Override
    public void processData(List<Fruit> data) {
        for (Fruit entry : data) {
            OperationService service = fruitStrategy.getOperationService(entry.getType());
            service.calculateQuantity(entry);
        }
    }
}
