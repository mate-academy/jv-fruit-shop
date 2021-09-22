package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.data.Validator;
import core.basesyntax.service.data.ValidatorImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FruitParserImpl implements Function<List<String>, List<FruitRecordDto>> {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLIT_SYMBOL = ",";

    @Override
    public List<FruitRecordDto> apply(List<String> records) {
        Validator validator = new ValidatorImpl();
        List<FruitRecordDto> fruitRecordList = new ArrayList<>();
        for (String splitArray : records) {
            String[] result = splitArray.split(SPLIT_SYMBOL);
            validator.validator(result);
            fruitRecordList.add(new FruitRecordDto(result[TYPE_INDEX],
                    new Fruit(result[FRUIT_INDEX]),
                    Integer.parseInt(result[QUANTITY_INDEX])));
        }
        return fruitRecordList;
    }
}
