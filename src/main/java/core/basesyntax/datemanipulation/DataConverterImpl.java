package core.basesyntax.datemanipulation;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> list) {
        List<FruitTransaction> result = new ArrayList<>();
        if (list == null || list.size() <= 1) {
            return result;
        }
        for (int i = 1; i < list.size(); i++) {
            String[] split = list.get(i).split(",");
            if (split.length == 3) {
                result.add(new FruitTransaction(split[0], split[1], Integer.parseInt(split[2])));
            } else {
                throw new NumberFormatException("Wrong format date at input file");
            }
        }
        return result;
    }
}
