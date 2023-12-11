package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class CsvTransactionParser implements TransactionParser {

    @Override
    public List<FruitTransaction> parseTransactions(List<String> transactionLines) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String transactionLine : transactionLines) {
            String[] transactionData = transactionLine.split(",");
            Operation operation = getOperationByCode(transactionData[0]);
            String fruitName = transactionData[1];
            int quantity = Integer.parseInt(transactionData[2]);
            transactions.add(new FruitTransaction(fruitName, quantity, operation));
        }

        return transactions;
    }


    private Operation getOperationByCode(String operationCode) {
        switch (operationCode) {
            case "b":
                return Operation.BALANCE;
            case "s":
                return Operation.SUPPLY;
            case "p":
                return Operation.PURCHASE;
            case "r":
                return Operation.RETURN;
            default:
                throw new RuntimeException("Unknown operation code: " + operationCode);
        }
    }
}
