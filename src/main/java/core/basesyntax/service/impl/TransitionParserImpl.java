package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransition;
import core.basesyntax.service.OperationValidator;
import core.basesyntax.service.TransitionParser;
import java.util.ArrayList;
import java.util.List;

public class TransitionParserImpl implements TransitionParser {
    private static final int INDEX_OPERATION_TYPE = 0;
    private static final int INDEX_FRUIT_TYPE = 1;
    private static final int INDEX_COUNT = 2;
    private static final String SPLITTER = ",";
    private final OperationValidator validator;

    public TransitionParserImpl(OperationValidator validator) {
        this.validator = validator;
    }

    @Override
    public List<FruitTransition> parseTransition(List<String> dataFromFile) {
        String[] data;
        List<FruitTransition> fruitTransitionList = new ArrayList<>();
        for (int i = 1; i < dataFromFile.size(); i++) {
            data = dataFromFile.get(i).split(SPLITTER);
            fruitTransitionList
                    .add(new FruitTransition(validator.validate(data[INDEX_OPERATION_TYPE]),
                    new Fruit(data[INDEX_FRUIT_TYPE]),
                    Integer.parseInt(data[INDEX_COUNT])));
        }
        return fruitTransitionList;
    }
}
