package parser;

import fruittransaction.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int INDEX_FOR_OPERATION = 0;
    private static final int INDEX_FOR_FRUITS = 1;
    private static final int INDEX_FOR_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> completeParseList = new ArrayList<>();
        for (String line : lines) {
            String[] splitLineFromLines = line.split(",");
            FruitTransaction fruitsObjectForCompleteList = new FruitTransaction();

            if (splitLineFromLines[INDEX_FOR_OPERATION].equals("b")) {
                fruitsObjectForCompleteList
                        .setOperation(FruitTransaction.Operation.BALANCE);
            } else if (splitLineFromLines[INDEX_FOR_OPERATION].equals("s")) {
                fruitsObjectForCompleteList
                        .setOperation(FruitTransaction.Operation.SUPPLY);
            } else if (splitLineFromLines[INDEX_FOR_OPERATION].equals("p")) {
                fruitsObjectForCompleteList
                        .setOperation(FruitTransaction.Operation.PURCHASE);
            } else {
                fruitsObjectForCompleteList
                        .setOperation(FruitTransaction.Operation.RETURN);
            }
            fruitsObjectForCompleteList
                    .setFruit(splitLineFromLines[INDEX_FOR_FRUITS]);
            fruitsObjectForCompleteList
                    .setQuantity(Integer.parseInt(splitLineFromLines[INDEX_FOR_QUANTITY]));
            completeParseList.add(fruitsObjectForCompleteList);
        }
        return completeParseList;
    }
}

