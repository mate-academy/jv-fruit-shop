package fruit.shop.service;

import fruit.shop.model.Fruit;
import fruit.shop.model.FruitTransaction;
import fruit.shop.model.Transaction;
import java.util.List;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final int TRANSACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final InputDataValidator INPUT_DATA_VALIDATOR = new InputDataValidator();

    @Override
    public List<FruitTransaction> parse(List<String> transactionInput) {
        return transactionInput.stream()
                .map(input -> input.split(","))
                .map(INPUT_DATA_VALIDATOR::test)
                .map(input -> new FruitTransaction(
                                Fruit.valueOf(input[FRUIT_INDEX].toUpperCase()),
                                transactionShort(input[TRANSACTION_INDEX]),
                                Integer.parseInt(input[QUANTITY_INDEX])
                        )
                )
                .toList();
    }

    private Transaction transactionShort(String transaction) {
        return switch (transaction) {
            case "b" -> Transaction.BALANCE;
            case "s" -> Transaction.SUPPLY;
            case "p" -> Transaction.PURCHASE;
            case "r" -> Transaction.RETURN;
            default -> throw new RuntimeException("Input csv is invalid. Transaction: "
                    + transaction
                    + " is not defined in shop");
        };
    }
}
