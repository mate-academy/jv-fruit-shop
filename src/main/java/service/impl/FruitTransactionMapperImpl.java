package service.impl;

import static model.FruitTransaction.valueOfLabel;

import model.FruitTransaction;
import service.FruitTransactionMapper;

public class FruitTransactionMapperImpl implements FruitTransactionMapper {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public FruitTransaction[] buildFruitTransactions(String fileData) {
        String[] activitiesList = fileData.split(" ");
        FruitTransaction[] transactions = new FruitTransaction[activitiesList.length];
        String[] transactionParts;

        for (int i = 0; i < activitiesList.length; i++) {
            transactionParts = activitiesList[i].split(",");
            transactions[i] = new FruitTransaction(
                    valueOfLabel(transactionParts[INDEX_OF_OPERATION]),
                    transactionParts[INDEX_OF_FRUIT],
                    Integer.parseInt(transactionParts[INDEX_OF_QUANTITY]));
        }

        return transactions;
    }
}
