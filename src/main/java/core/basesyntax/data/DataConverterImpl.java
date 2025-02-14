package core.basesyntax.data;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> readReport) {
        List<FruitTransaction> fruitReport = new ArrayList<>();
        for (String line : readReport) {
            String[] partOfOperation = line.split(SEPARATOR);
            try {
                fruitReport.add(new FruitTransaction(
                        FruitTransaction.Operation.fromCode(partOfOperation[0]),
                        partOfOperation[1],
                        Integer.parseInt(partOfOperation[2])));
            } catch (RuntimeException e) {
                throw new IllegalArgumentException(
                        "Line should be in pattern: \"type,fruit,quantity\" ");
            }

        }
        return fruitReport;
    }
}
