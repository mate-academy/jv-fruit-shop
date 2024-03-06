package service.impl;

import java.util.ArrayList;
import java.util.List;
import dao.FruitDao;
import service.ParserService;
import model.Fruit;
import model.FruitTransaction;
import model.Operation;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> commands) {
        List<FruitTransaction> listOfFruitTransactions = new ArrayList<>();
        String[] fruitTransactionPattern;
        FruitTransaction fruitTransaction;
        for (String command : commands) {
            fruitTransactionPattern = command.trim().split(",");
            Operation operation = Operation.fromCode(fruitTransactionPattern[OPERATION_INDEX]);
            String fruitName = fruitTransactionPattern[FRUIT_NAME_INDEX];
            int quantity = Integer.parseInt(fruitTransactionPattern[QUANTITY_INDEX]);
            fruitTransaction = new FruitTransaction(operation, fruitName, quantity);
            listOfFruitTransactions.add(fruitTransaction);
        }
        return listOfFruitTransactions;
    }
}
