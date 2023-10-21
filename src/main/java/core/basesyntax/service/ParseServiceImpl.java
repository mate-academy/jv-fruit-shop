package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ParseServiceImpl implements ParseService {
    private static final String SEPARATOR = ",";
    private static final int HEADER_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> fruits) {
        ArrayList<FruitTransaction> fruitTransactions = new ArrayList<>();
        fruits.remove(HEADER_INDEX);
        for (String fruit : fruits) {
            String[] parsedFruit = fruit.split(SEPARATOR);
            try {
                int amount = Integer.parseInt(parsedFruit[AMOUNT_INDEX]);
                if (amount < 0) {
                    throw new NumberFormatException();
                }
                FruitTransaction.Operation operation
                        = FruitTransaction.Operation.getByCode(parsedFruit[OPERATION_INDEX]);
                fruitTransactions.add(new FruitTransaction(parsedFruit[FRUIT_INDEX],
                        amount, operation));
            } catch (NumberFormatException numberFormatException) {
                throw new RuntimeException("Invalid amount: " + parsedFruit[AMOUNT_INDEX],
                        numberFormatException);
            } catch (NoSuchElementException noSuchElementException) {
                throw new RuntimeException("No such operation code: "
                        + parsedFruit[OPERATION_INDEX],
                        noSuchElementException);
            }
        }
        return fruitTransactions;
    }
}
