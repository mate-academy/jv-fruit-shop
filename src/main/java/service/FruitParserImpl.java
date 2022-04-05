package service;

import model.FruitTransaction;

public class FruitParserImpl implements FruitParser {
    @Override
    public FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(" ");
        FruitTransaction fruitTransaction = new FruitTransaction();
        for (String field : fields) {
            if (field.isEmpty()) {
                continue;
            }
            String[] split = field.split(",");
            if (split[0] == null
                    || split[0].isEmpty()
                    || split[1] == null
                    || split[1].isEmpty()
                    || split[2] == null
                    || split[2].isEmpty()) {
                throw new NullPointerException("This line cannot be empty");
            }
            fruitTransaction.setOperation(FruitTransaction.Operation.findByAbbr(split[0]));
            fruitTransaction.setFruit(split[1]);
            fruitTransaction.setQuantity(Integer.parseInt(split[2]));
        }
        return fruitTransaction;
    }
}
