package core.basesyntax.processhandler;

public class ProcessHandler {
    public String fruitTypeHandler(String fruit) {
        if (fruit == null || fruit.isEmpty()) {
            throw new RuntimeException("Field 'Fruit' can't be empty");
        }
        return fruit;
    }

    public int quantityHandler(String quantity) {
        if (quantity == null || quantity.isEmpty()) {
            throw new RuntimeException("Field 'Quantity' can't be empty");
        }
        return Integer.parseInt(quantity);
    }
}
