package core.basesyntax.service.repot;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ReportGenerationImpl implements ReportGeneration {
    private static final String DATA_SEPARATOR = ",";

    @Override
    public String report(Storage storage) {
        StringBuilder report = new StringBuilder();

        List<String> products = storage.get().stream()
                .map(FruitTransaction::getFruit)
                .distinct()
                .collect(Collectors.toList());

        for (String product : products) {
            report.append(product).append(DATA_SEPARATOR)
                    .append(getProductOperationsSum(storage, product))
                    .append(System.lineSeparator());
        }
        return report.toString();
    }

    private int getProductOperationsSum(Storage storage, String product) {
        return storage.get().stream()
                .filter(e -> e.getFruit().equals(product))
                .map(e -> e.getOperation().getOperationIndex()
                        .equals(FruitTransaction.Operation.PURCHASE.getOperationIndex())
                        ? e.getQuantity() * -1 : e.getQuantity())
                .mapToInt(e -> e)
                .sum();
    }
}
