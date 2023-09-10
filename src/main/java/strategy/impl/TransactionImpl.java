package strategy.impl;

import strategy.Transaction;

public class TransactionImpl implements Transaction {
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";
    private static final String SPLIT_INDEX = ",";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_TYP_OF_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public void operate(String lineFile) {
        String[] partsLine = lineFile.split(SPLIT_INDEX);
        if (partsLine[INDEX_OF_OPERATION].equals(BALANCE)) {
            new BalanceImpl().getBalance(partsLine[INDEX_TYP_OF_FRUIT],
                    Integer.parseInt(partsLine[INDEX_QUANTITY]));
        }
        if (partsLine[INDEX_OF_OPERATION].equals(SUPPLY)) {
            new SupplyImpl().addSupply(partsLine[INDEX_TYP_OF_FRUIT],
                    Integer.parseInt(partsLine[INDEX_QUANTITY]));
        }
        if (partsLine[INDEX_OF_OPERATION].equals(PURCHASE)) {
            new PurchaseImpl().subtract(partsLine[INDEX_TYP_OF_FRUIT],
                    Integer.parseInt(partsLine[INDEX_QUANTITY]));
        }
        if (partsLine[INDEX_OF_OPERATION].equals(RETURN)) {
            new ReturnImpl().addReturn(partsLine[INDEX_TYP_OF_FRUIT],
                    Integer.parseInt(partsLine[INDEX_QUANTITY]));
        }
    }
}
