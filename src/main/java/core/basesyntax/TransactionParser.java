package core.basesyntax;

public class TransactionParser {

    public FruitTransaction parse(String string) {
        String[] split = string.split(",");
        String operation = split[0];
        String fruitType = split[1];
        String quantity = split[2];
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.convertToOperationEnum(operation));
        fruitTransaction.setFruit(fruitType);
        fruitTransaction.setQuantity(Integer.valueOf(quantity));
        return fruitTransaction;
    }
}