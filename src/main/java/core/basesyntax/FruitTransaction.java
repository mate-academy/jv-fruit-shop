package core.basesyntax;

import core.basesyntax.exeption.FruitShopExeption;
import core.basesyntax.service.FruitService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitTransaction {
    private static final String CSV_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int WORDS_IN_LINE = 3;
    private final Map<String, FruitService> strategy = new HashMap<>();
    private FruitService fruitService;

    public void chooseStrategy(List<String> line) {
        if (line == null) {
            throw new FruitShopExeption("List must contain rows from file, but was null");
        }
        String[] separateLine;
        for (String s : line) {
            separateLine = s.split(CSV_SEPARATOR);
            checkData(separateLine);
            fruitService.moveFruit(separateLine[FRUIT_INDEX],
                    Integer.parseInt(separateLine[AMOUNT_INDEX]));
        }
    }

    private void checkData(String[] separateLine) {
        fruitService = strategy.get(separateLine[OPERATION_INDEX]);
        if (separateLine.length != WORDS_IN_LINE) {
            throw new FruitShopExeption("In csv file line mast contain 3 words, but was: "
                    + separateLine.length);
        }
        if (fruitService == null) {
            throw new FruitShopExeption("Inexplicable operation with fruit: "
                    + separateLine[OPERATION_INDEX]);
        }
        if (separateLine[FRUIT_INDEX].length() == 0) {
            throw new FruitShopExeption("In csv file all line mast contain fruit value");
        }
        try {
            Integer amount = Integer.valueOf(separateLine[AMOUNT_INDEX]);
        } catch (NumberFormatException e) {
            throw new FruitShopExeption("In csv file all line mast contain positive value"
                    + "on amount position, but was " + separateLine[AMOUNT_INDEX]);
        }
        if (separateLine[AMOUNT_INDEX].length() <= 0) {
            throw new FruitShopExeption("In csv file all line mast contain positive value"
                    + "on amount position, but was " + separateLine[AMOUNT_INDEX]);
        }
    }

    public Map<String, FruitService> getStrategy() {
        return strategy;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
