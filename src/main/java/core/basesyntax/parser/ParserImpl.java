package core.basesyntax.parser;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.model.OperationType;
import core.basesyntax.validator.Validator;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final String CSV_SEPARATOR = ",";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public List<FruitRecord> parseLines(List<String> lines) {
        List<FruitRecord> fruitRecords = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++){
            String[] splitedLine = lines.get(i).split(CSV_SEPARATOR);
            validator.validateLine(splitedLine, i);
            fruitRecords.add(new FruitRecord(
                    new Fruit(splitedLine[FRUIT_INDEX],
                            Long.parseLong(splitedLine[QUANTITY_INDEX])),
                    OperationType.valueOf(splitedLine[TYPE_INDEX].toUpperCase())));
        }
        return fruitRecords;
    }
}
