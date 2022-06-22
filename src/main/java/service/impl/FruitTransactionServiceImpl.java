package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.FruitTransactionService;
import service.SplitInformation;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private SplitInformation splitInformation;

    public FruitTransactionServiceImpl(SplitInformation splitInformation) {
        this.splitInformation = splitInformation;
    }

    @Override
    public List<FruitTransaction> createListOfTransactions(List<String> info) {
        info.remove(0);
        return info.stream()
               .map(s -> splitInformation.addToTransactionList(s))
               .collect(Collectors.toList());
    }
}
