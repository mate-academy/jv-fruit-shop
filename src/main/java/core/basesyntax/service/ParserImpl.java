package core.basesyntax.service;

import core.basesyntax.dto.FruitDto;

public class ParserImpl implements Parser {
    public static final int INDEX_OPERATION = 0;
    public static final int INDEX_NAME = 1;
    public static final int INDEX_COUNT = 2;
    public static final String WORDS_SEPARATOR = ",";
    private Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public FruitDto parseToFruitDto(String line) {
        if (!validator.test(line)) {
            throw new RuntimeException("Exception: wrong line");
        }
        String[] partsOfElement = line.split(WORDS_SEPARATOR);
        return new FruitDto(partsOfElement[INDEX_OPERATION],
                partsOfElement[INDEX_NAME],
                Integer.parseInt(partsOfElement[INDEX_COUNT]));
    }
}
