package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ParseService;

public class ParseServiceImplementation implements ParseService {
    @Override
    public List<FruitTransaction> parse(List<String[]> transactions) {
        return transactions.stream()
                .skip(1)
                .map(i -> new FruitTransaction(i[0], i[1], Integer.parseInt(i[2])))
                .collect(Collectors.toList());
    }
}
