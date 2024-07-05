package core.basesyntax.checker;

public class Validator {
    public static void checkQuantity(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Quantity can't be less than 0.");
        }
    }
}
