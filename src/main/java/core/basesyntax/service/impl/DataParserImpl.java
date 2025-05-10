package core.basesyntax.service.impl;

import core.basesyntax.exception.InvalidFruitDataException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserImpl implements DataParser<FruitTransaction> {
    private static final String REGEX = ",";
    private static final int NUMBER_OF_MISSING_LINES = 1;
    private static final int FIRST_ELEMENT_INDEX = 0;
    private static final int SECOND_ELEMENT_INDEX = 1;
    private static final int THIRD_ELEMENT_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> fileData) {
        try {
            return fileData.stream()
                    .skip(NUMBER_OF_MISSING_LINES)
                    .map(d -> d.split(REGEX))
                    .map(s -> new FruitTransaction(s[FIRST_ELEMENT_INDEX], s[SECOND_ELEMENT_INDEX],
                            Integer.parseInt(s[THIRD_ELEMENT_INDEX])))
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new InvalidFruitDataException("The input file has an incorrect format"
                    + " or contains invalid characters");
        }
    }
}
