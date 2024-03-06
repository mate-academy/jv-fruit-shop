package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.Operation;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int LENGTH_OF_COMMAND_PATTERN = 3;

    @Override
    public List<FruitTransaction> parse(List<String> commands) {
        List<FruitTransaction> listOfFruitTransactions = new ArrayList<>();
        String[] fruitTransactionPattern;
        FruitTransaction fruitTransaction;
        for (String command : commands) {
            fruitTransactionPattern = command.trim().split(",");
            if (fruitTransactionPattern.length != LENGTH_OF_COMMAND_PATTERN) {
                throw new RuntimeException("Invalid data in file");
            }
            Operation operation = Operation.fromCode(fruitTransactionPattern[OPERATION_INDEX]);
            String fruitName = fruitTransactionPattern[FRUIT_NAME_INDEX];
            int quantity;
            try {
                quantity = Integer.parseInt(fruitTransactionPattern[QUANTITY_INDEX]);
                if (quantity < 0) {
                    throw new NumberFormatException("Quantity can`t be less than 0");
                }
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid type of number");
            }
            fruitTransaction = new FruitTransaction(operation, fruitName, quantity);
            listOfFruitTransactions.add(fruitTransaction);
        }
        return listOfFruitTransactions;
    }
}
