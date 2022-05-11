package service;

import model.FruitTransaction;

public class FruitParserImpl implements FruitParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public FruitTransaction parseFruitTransaction(String line) {
        String[] fields = line.split(" ");
        FruitTransaction fruitTransaction = new FruitTransaction();
        for (String field : fields) {
            if (field.isEmpty()) {
                continue;
            }
            String[] split = field.split(",");
            if (split[OPERATION_INDEX] == null
                    || split[OPERATION_INDEX].isEmpty()
                    || split[FRUIT_INDEX] == null
                    || split[FRUIT_INDEX].isEmpty()
                    || split[QUANTITY_INDEX] == null
                    || split[QUANTITY_INDEX].isEmpty()) {
                throw new NullPointerException("This line cannot be empty");
            }
            fruitTransaction.setOperation(
                    FruitTransaction.Operation.findByAbbreviation(split[OPERATION_INDEX]));
            fruitTransaction.setFruit(split[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(split[QUANTITY_INDEX]));
        }
        return fruitTransaction;
    }
}
