package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.LineData;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final ValidatorImpl validator;

    public ParserImpl(ValidatorImpl validatorImpl) {
        this.validator = validatorImpl;
    }

    @Override
    public List<LineData> parse(List<String> sourceData) {
        List<LineData> lineData = new ArrayList<>();
        sourceData.remove(0);

        for (String line: sourceData) {
            validator.validate(line.trim());
            String[] splittedLine = line.split(",");
            lineData.add(new LineData(splittedLine[OPERATION_INDEX],
                    new Fruit(splittedLine[FRUIT_INDEX]),
                    Integer.parseInt(splittedLine[QUANTITY_INDEX])));
        }
        return lineData;
    }
}
