package core.basesyntax.service.impl;

import core.basesyntax.model.FruitsTranslation;
import core.basesyntax.service.TransactionService;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionServiseImpl implements TransactionService {
    @Override
    public List<FruitsTranslation> transactionProcess(List<String> transactionData) {
        return transactionData.stream()
                .skip(1)
                .map(s -> processes(s))
                .collect(Collectors.toList());
    }

    private FruitsTranslation processes(String data) {
        String[] strings = data.split(",");
        return new FruitsTranslation(
                FruitsTranslation.Operation.getByCode(strings[0]), strings[1],
                Integer.parseInt(strings[2]));
    }
}
