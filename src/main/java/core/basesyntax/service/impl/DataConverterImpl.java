package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> converteData(List<String> dataFromFile) {
        List<FruitTransaction> convertedData = new ArrayList<>();
        for (String data : dataFromFile) {
            if (data != null && !data.trim().isEmpty()) {
                String[] eachLineElement = data.split(",");
                if (eachLineElement.length == 3) {
                    convertedData.add(new FruitTransaction(eachLineElement[0], eachLineElement[1],
                            Integer.parseInt(eachLineElement[2])));
                } else {
                    throw new IllegalArgumentException("Invalid data format: " + data);
                }
            }
        }
        return convertedData;
    }
}

