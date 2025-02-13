package core.basesyntax.data;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> readReport) {
        List<FruitTransaction> fruitReport = new ArrayList<>();
        for (String line : readReport) {
            String[] partOfOperation = line.split(",");
            fruitReport.add(new FruitTransaction(
                    FruitTransaction.Operation.fromCode(partOfOperation[0]),
                    partOfOperation[1],
                    Integer.parseInt(partOfOperation[2])));
        }
        return fruitReport;
    }
}
