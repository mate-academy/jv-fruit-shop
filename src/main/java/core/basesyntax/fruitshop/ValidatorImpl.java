package core.basesyntax.fruitshop;

public class ValidatorImpl implements Validator {

    @Override
    public void validate(String inputLine) {
        String[] strings = inputLine.split(",");
        String fruit = strings[1];
        int amount = Integer.parseInt(strings[2]);
        if (amount < 0) {
            throw new RuntimeException("Buyers will not be able to buy "
                    + amount + " " + fruit + ". "
                    + amount + " is incorrect input.");
        }
        if (!strings[2].matches("[0-9]+") || !strings[0].matches("[bspr]")) {
            throw new RuntimeException("Invalid input");
        }
    }
}
