package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ConverterService;

import java.util.List;
import java.util.stream.Collectors;

public class ConverterTransactionServiceImp implements ConverterService {
    @Override
    public List<Transaction> convertFromStringToFunction(List<String> transactions) {
        return transactions.stream()
                .map(s -> s.split(","))
                .map(t -> {
                    String operation = t[0];
                    String fruit = t[1];
                    int quantity = Integer.parseInt(t[2]);
                    return new Transaction(operation, fruit, quantity);
                }).collect(Collectors.toList());
    }
}
