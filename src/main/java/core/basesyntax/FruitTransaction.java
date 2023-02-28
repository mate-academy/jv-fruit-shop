package core.basesyntax;

import core.basesyntax.exeption.FruitShopExeption;
import core.basesyntax.service.FruitService;
import core.basesyntax.stragegyfactory.StrategyFactory;
import java.util.List;

public class FruitTransaction {
    private static final String CSV_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int WORDS_IN_LINE = 3;

    public void chooseStrategy(List<String> line) {
        if (line == null) {
            throw new FruitShopExeption("List must contain rows from file, but was null");
        }
        line.stream().forEach(this::lineProcessing);
    }

    private void lineProcessing(String line) {
        String[] separateLine;
        separateLine = line.split(CSV_SEPARATOR);
        StrategyFactory strategyFactory = new StrategyFactory();
        checkData(separateLine);
        FruitService fruitService = strategyFactory
                .getFruitService(Operation.getByCode(separateLine[OPERATION_INDEX]));
        fruitService.moveFruit(separateLine[FRUIT_INDEX],
                Integer.parseInt(separateLine[AMOUNT_INDEX]));
    }

    private void checkData(String[] separateLine) {
        if (separateLine.length != WORDS_IN_LINE) {
            throw new FruitShopExeption("In csv file line mast contain 3 words, but was: "
                    + separateLine.length);
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

        public static Operation getByCode(String code) {
            for (Operation operation : Operation.values()) {
                if (operation.getCode().equals(code)) {
                    return operation;
                }
            }
            throw new IllegalArgumentException("No operation with code " + code + " found");
        }
    }
}
