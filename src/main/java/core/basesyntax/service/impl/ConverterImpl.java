package core.basesyntax.service.impl;

import core.basesyntax.model.ProductDaoCsvImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Converter;

import java.util.ArrayList;
import java.util.List;

public class ConverterImpl implements Converter {
    public static ProductDaoCsvImpl dao;

    public ConverterImpl(ProductDaoCsvImpl daoImpl) {
        dao = daoImpl;
    }

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> transactions) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String transaction : transactions) {
            String[] elements = transaction.split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(elements[0].trim()));
            fruitTransaction.setFruitName(elements[1].trim());
            fruitTransaction.setQuantity(Integer.parseInt(elements[2].trim()));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
