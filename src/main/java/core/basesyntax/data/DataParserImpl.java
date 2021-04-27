package core.basesyntax.data;

import core.basesyntax.handlers.Operations;
import core.basesyntax.services.FruitsService;
import core.basesyntax.storage.FruitDataBase;
import java.util.List;
import java.util.Map;

public class DataParserImpl implements DataParser {
    private static final String SPLIT_REGEX = ",";
    private static final int REQUIRED_LENGTH = 1;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    @Override
    public void convert(List<String> listWithRawData,
                        Map<Operations, FruitsService> fruitStrategies,
                        FruitDataBase fruitDataBase) {
        for (String line : listWithRawData) {
            String[] elements = line.trim().split(SPLIT_REGEX);
            if (elements[ZERO].length() == REQUIRED_LENGTH) {
                fruitStrategies.get(Operations.getEnum(elements[ZERO]))
                        .change(elements[ONE], Integer.parseInt(elements[TWO]), fruitDataBase);
            }
        }
    }
}
