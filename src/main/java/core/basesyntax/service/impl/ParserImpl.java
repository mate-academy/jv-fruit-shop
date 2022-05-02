package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.LineInformation;
import core.basesyntax.service.DataValidator;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private DataValidator dataValidator;

    public ParserImpl(DataValidator dataValidator) {
        this.dataValidator = dataValidator;
    }

    @Override
    public List<LineInformation> parse(List<String> sourceData) {
        List<LineInformation> lineInformation = new ArrayList<>();
        sourceData.remove(0);
        for (String part : sourceData) {
            dataValidator.validate(part.trim());
            String[] splittedLine = part.split(",");
            lineInformation.add(new LineInformation(splittedLine[OPERATION_INDEX],
                    new Fruit(splittedLine[FRUIT_INDEX]),
                    Integer.parseInt(splittedLine[AMOUNT_INDEX])));
        }
        return lineInformation;
    }
}
