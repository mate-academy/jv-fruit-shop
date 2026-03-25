package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        data.remove(0);

        return data.stream()
                .skip(1)
                .map(d -> d.split(","))
                .map(part -> new FruitTransaction(part[0], part[1], Integer.parseInt(part[2])))
                .toList();
    }
}
