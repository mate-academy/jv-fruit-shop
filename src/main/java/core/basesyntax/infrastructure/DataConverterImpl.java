package core.basesyntax.infrastructure;

import core.basesyntax.service.FruitTransaction;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .map(s -> s.split(","))
                .map(s -> new FruitTransaction(
                        FruitTransaction.getOperation(s[0]), s[1], Integer.parseInt(s[2])))
                .toList();
    }
}
