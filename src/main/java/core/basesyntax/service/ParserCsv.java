package core.basesyntax.service;

import core.basesyntax.dto.FruitDto;

public class ParserCsv implements Parser {
    public static final int INDEX_OPERATION = 0;
    public static final int INDEX_NAME = 1;
    public static final int INDEX_COUNT = 2;
    private Validator validator;

    public ParserCsv(Validator validator) {
        this.validator = validator;
    }

    @Override
    public FruitDto parse(String element) {
        if (!validator.test(element)) {
            throw new RuntimeException("Exception: wrong line");
        }
        String[] partsOfElement = element.split(",");
        return new FruitDto(partsOfElement[INDEX_OPERATION],
                partsOfElement[INDEX_NAME],
                Integer.parseInt(partsOfElement[INDEX_COUNT]));
    }
}
