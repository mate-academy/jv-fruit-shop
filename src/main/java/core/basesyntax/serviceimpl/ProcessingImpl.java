package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Processing;
import java.util.List;

public class ProcessingImpl implements Processing {
    @Override
    public List<FruitTransaction> getProcessedData(List<String> textReport) {
        return textReport.stream()
                .skip(1)
                .map(str -> str.split(","))
                .map(strArr -> new FruitTransaction(FruitTransaction.getOperationType(strArr[0]),
                        strArr[1], Integer.parseInt(strArr[2])))
                .toList();
    }
}
