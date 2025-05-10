package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.Parser;

public class FruitTransactionParser implements Parser<FruitTransaction> {
    private static final String FIRST_LINE_FROM_FILE = "type,fruit,quantity";
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_FRUIT_INDEX = 1;
    private static final int QUANTITY_OPERATION_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> input) {
        if (input.get(0).equals(FIRST_LINE_FROM_FILE)) {
            List<FruitTransaction> transactions = new ArrayList<>();
            input.remove(0);
            for (String transaction : input) {
                String clearTransaction = transaction.replaceAll(" ", "");
                String[] forMakeTransaction = clearTransaction.split(",");

                FruitTransaction.Operation newOperation
                        = FruitTransaction
                            .Operation.validation(forMakeTransaction[OPERATION_INDEX]);
                String nameOfFruit
                        = forMakeTransaction[NAME_FRUIT_INDEX];
                int quantityOfOperation
                        = Integer.parseInt(forMakeTransaction[QUANTITY_OPERATION_INDEX]);

                transactions.add(new FruitTransaction(newOperation,
                        nameOfFruit,
                        quantityOfOperation));
            }
            return transactions;
        }
        throw new RuntimeException("Can't parse this List" + input);
    }
}
