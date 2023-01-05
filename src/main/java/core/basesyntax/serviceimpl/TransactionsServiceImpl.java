package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionsServiceImpl implements TransactionService {
    @Override
    public List<FruitTransaction> getlistOfFruitTransaction(List<String> dataFromFile) {
        return dataFromFile.stream()
                .skip(1)
                .map(s -> getFruitTransaction(s))
                .collect(Collectors.toList());
    }

    private FruitTransaction getFruitTransaction(String data) {
        String[] strings = data.split(",");
        return new FruitTransaction(
                FruitTransaction.Operation.getOperationByActivity(strings[0]), strings[1],
                Integer.parseInt(strings[2]));
    }
}

