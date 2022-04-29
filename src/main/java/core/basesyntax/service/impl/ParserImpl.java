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

    @Override
    public List<LineData> parse(List<String> list) {
        List<LineData> lineData = new ArrayList<>();
        list.remove(0);

        for (String line: list) {
            new ValidatorImpl().validate(line.trim());
            String[] splitLine = line.split(",");
            lineData.add(new LineData(splitLine[OPERATION_INDEX],
                    new Fruit(splitLine[FRUIT_INDEX]),
                               Integer.parseInt(splitLine[QUANTITY_INDEX])));
        }
        return lineData;
    }
}
