package core.basesyntax.fruit.dto;

public class FruitDtoParserImpl implements FruitDtoParser {
    private static final String IS_NUMERIC = "[0-9]+";
    private static final String LINE_SPLITERATOR = ",";
    private static final String FRUITS = "banana,apple";

    @Override
    public FruitDto parseFruitDto(String line) {
        String fruit = line.substring(line.indexOf(LINE_SPLITERATOR) + 1, line.lastIndexOf(LINE_SPLITERATOR)).trim();
        String amount = line.substring(line.lastIndexOf(LINE_SPLITERATOR) + 1);
        if (Integer.parseInt(amount) < 0) {
            throw new RuntimeException("Buyers will not be able to buy "
                    + amount + " " + fruit + ". "
                    + amount + " is incorrect input.");
        }
        if (!amount.matches(IS_NUMERIC)) {
            throw new RuntimeException("Invalid input");
        }
        if (!FRUITS.contains(fruit)) {
            throw new RuntimeException("There is no " + fruit + " in stock");
        }
        return new FruitDto(fruit, Integer.parseInt(amount));
    }
}
