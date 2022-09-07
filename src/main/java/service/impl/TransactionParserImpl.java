package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.Transaction;
import service.TransactionParser;

public class TransactionParserImpl implements TransactionParser {
    private static final int INFO_INPUT_LINE_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<Transaction> parse(List<String> inputList) {
        inputList.remove(INFO_INPUT_LINE_INDEX);
        List<Transaction> transactions = new ArrayList<>();
        for (String input : inputList) {
            transactions.add(createNewTransaction(input.split(",")));
        }
        return transactions;
    }

    private Transaction createNewTransaction(String[] inputSplited) {
        return new Transaction(
                Transaction.Operation.getByLabel(inputSplited[OPERATION_INDEX]),
                new Fruit(inputSplited[FRUIT_INDEX]),
                Integer.parseInt(inputSplited[QUANTITY_INDEX])
        );
    }
}
