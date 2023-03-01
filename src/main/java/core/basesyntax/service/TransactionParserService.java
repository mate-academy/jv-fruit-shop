package core.basesyntax.service;

import core.basesyntax.exeption.FruitShopExeption;
import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserService {

    private static final String CSV_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int WORDS_IN_LINE = 3;

    public List<FruitTransaction> parseFruitTransaction(List<String> line) {
        if (line == null) {
            throw new FruitShopExeption("List must contain rows from file, but was null");
        }
        return line.stream()
                .map(this::lineProcessing)
                .collect(Collectors.toList());
    }

    private FruitTransaction lineProcessing(String line) {
        String[] separateLine;
        separateLine = line.split(CSV_SEPARATOR);
        checkData(separateLine);
        return new FruitTransaction(FruitTransaction.Operation
                .getByCode(separateLine[OPERATION_INDEX]),
                separateLine[FRUIT_INDEX],
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

}
