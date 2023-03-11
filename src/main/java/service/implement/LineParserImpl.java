package service.implement;

import core.basesyntax.model.ParseLine;
import java.util.List;
import service.LineParser;

public class LineParserImpl implements LineParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<ParseLine> lineParcer(List<String> input) {
        inputValidator.validate(input);
        for (String string: input) {
            String[] values = string.split(",");
            parseLineList.add(new ParseLine(values[OPERATION_INDEX],
                    values[FRUIT_INDEX], Integer.parseInt(values[QUANTITY_INDEX])));
        }
        return parseLineList;
    }
}
