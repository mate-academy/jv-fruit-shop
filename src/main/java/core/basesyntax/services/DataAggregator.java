package core.basesyntax.services;

import core.basesyntax.items.Product;
import core.basesyntax.items.Storage;
import core.basesyntax.operations.Buy;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.Supply;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DataAggregator {
    private final LineParser parser = new LineParser();
    private final Map<String, Operation> operationsDecoder = new TreeMap<>();

    public DataAggregator() {
        operationsDecoder.put("s", new Supply());
        operationsDecoder.put("b", new Buy());
        operationsDecoder.put("r", new Supply());
    }

    public Storage aggregate(List<String> list, Storage storage) {
        for (String line : list) {
            String[] operationData = parser.parse(line);
            Product product = new Product(operationData[1],
                    Integer.parseInt(operationData[2]), LocalDate.parse(operationData[3]));
            operationsDecoder.get(operationData[0])
                    .doAction(product, storage);
        }
        return storage;
    }
}
