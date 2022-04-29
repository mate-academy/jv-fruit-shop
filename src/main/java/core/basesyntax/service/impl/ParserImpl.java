package core.basesyntax.service.impl;

import core.basesyntax.model.LineData;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    @Override
    public List<LineData> parse(List<String> list) {
        List<LineData> lineData = new ArrayList<>();
        list.remove(0);

        for (String line: list) {
            new ValidatorImpl().validate(line.trim());
            String[] splitLine = line.split(",");
            lineData.add(new LineData(splitLine[0],
                    splitLine[1], Integer.parseInt(splitLine[2])));
        }
        return lineData;
    }
}
