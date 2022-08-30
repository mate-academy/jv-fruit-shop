package core.basesyntax.service.impl;

import core.basesyntax.service.ParseService;
import model.Fruit;
import model.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {

    @Override
    public List<Transaction> transactionsParser(List<String> transactions) {
        transactions.remove(0);
        return transactions.stream()
                .map(this::getTransaction)
                .collect(Collectors.toList());
    }

    private Transaction getTransaction(String string) {
        String[] splitted = string.split(",");
        return new Transaction(splitted[0].trim(), new Fruit(splitted[1].trim()), Integer.parseInt(splitted[2].trim()));
    }
}
