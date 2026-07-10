package core.basesyntax;

import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .skip(1)
                .map(this::toFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction toFruitTransaction(String s) {
        String[] columns = s.split(",");
        return new FruitTransaction(FruitTransaction.Operation.fromCode(columns[0]),
                columns[1],
                Integer.parseInt(columns[2]));
    }
}