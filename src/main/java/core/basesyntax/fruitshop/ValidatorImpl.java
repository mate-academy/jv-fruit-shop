package core.basesyntax.fruitshop;

public class ValidatorImpl implements Validator {
    private static final String IS_NUMERIC = "[0-9]+";
    private static final String VALID_ACTION = "[bspr]";
    private final FruitChecker fruitChecker = new FruitCheckerImpl();

    @Override
    public void validate(String[] strings) {
        String action = strings[0];
        String fruit = strings[1];
        int amount = Integer.parseInt(strings[2]);
        if (amount < 0) {
            throw new RuntimeException("Buyers will not be able to buy "
                    + amount + " " + fruit + ". "
                    + amount + " is incorrect input.");
        }
        if (!action.matches(VALID_ACTION) || !strings[2].matches(IS_NUMERIC)) {
            throw new RuntimeException("Invalid input");
        }
        if (!fruitChecker.checkFruits(strings)) {
            throw new RuntimeException("There is no " + fruit + " in stock");
        }
    }
}
