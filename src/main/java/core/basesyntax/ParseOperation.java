package core.basesyntax;

import java.time.LocalDate;

public class ParseOperation {
    public FruitOperation getFruitOperation(String[] parts) {
        String fruitName = parts[1];
        int quantity = Integer.parseInt(parts[2]);
        LocalDate date = LocalDate.parse(parts[3]);
        Transaction transaction = new Transaction(fruitName, quantity, date, false);
        FruitOperation operation;
        switch (parts[0]) {
            case "s":
                operation = new SupplyFruitOperation(OperationType.SUPPLY, transaction);
                break;
            case "r":
                operation = new ReturnFruitOperation(OperationType.RETURN, transaction);
                break;
            case "b":
                operation = new BuyFruitOperation(OperationType.BUY, transaction);
                break;
            default:
                throw new RuntimeException("Unsuspected type of operation");
        }
        return operation;
    }
}
