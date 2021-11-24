package service.implement;

import core.basesyntax.model.ParseLine;
import service.InputDataValidator;
import service.LineParser;

import javax.xml.validation.Validator;
import java.util.List;

public class LineParserImp implements LineParser {

    @Override
    public List<ParseLine> lineParcer(List<String> input) {
        inputValidator.validate(input);
        for (String string: input) {
            String[] values = string.split(",");
            parseLineList.add(new ParseLine(values[0], values[1], Integer.parseInt(values[2])));
        }
        return parseLineList;
    }
}
