package core.basesyntax.service.impl;

import core.basesyntax.model.LineInformation;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    @Override
    public List<LineInformation> parse(List<String> list) {
        List<LineInformation> lineInformation = new ArrayList<>();
        list.remove(0);

        for (String part: list) {
            new DataValidatorImpl().validate(part.trim());
            String[] splittedLine = part.split(",");
            lineInformation.add(new LineInformation(splittedLine[0],
                    splittedLine[1], Integer.parseInt(splittedLine[2])));
        }
        return lineInformation;
    }
}
