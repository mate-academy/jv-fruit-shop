package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.TransactionHandlerService;

import java.util.ArrayList;
import java.util.List;

public class TransactionHandlerServiceImpl implements TransactionHandlerService {
    private List<FruitTransaction> fruitTransactions;

    public static void main(String[] args) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation("b");

        System.out.println(fruitTransaction.getOperation());
    }

    @Override
    public List<String> getReport(List<String> listInputData) {
        ParserService parse = new ParserServiceImpl();
        fruitTransactions = new ArrayList<>();

        for (String text : listInputData) {
            fruitTransactions.add(parse.getDataFromLine(text));
        }
        return null;
    }
}
