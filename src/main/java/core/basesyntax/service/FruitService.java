package core.basesyntax.service;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.AbstractOperation;
import core.basesyntax.model.Operation;
import core.basesyntax.model.OperationFactory;
import core.basesyntax.model.entities.Fruit;
import java.util.ArrayList;
import java.util.List;

public class FruitService implements ProductService<Fruit> {
    private final OperationFactory<Fruit> operationFactory;

    public FruitService(OperationFactory<Fruit> operationFactory) {
        this.operationFactory = operationFactory;
    }

    public void importData(List<String[]> data) {
        for (String[] row : data) {
            AbstractOperation<Fruit> operation =
                    operationFactory.get(Operation.valueOf(row[0].toUpperCase()));
            Fruit fruit = new Fruit(row[1]);
            Integer amount = Integer.valueOf(row[2]);
            operation.execute(fruit, amount);
        }
    }

    public List<String[]> generateReport() {
        ArrayList<String[]> report = new ArrayList<>();
        Warehouse.getFruitStorage().forEach((fruit, amount) ->
                report.add(new String[]{fruit.getName(), String.valueOf(amount)}));
        return report;
    }
}
