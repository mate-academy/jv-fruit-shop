package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransfer;
import core.basesyntax.servise.ParseService;
import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int REMAINDER_INDEX = 2;

    @Override
    public List<FruitTransfer> getParse(List<String> list) {
        return list.stream()
                .skip(1)
                .map(this::getFruitTransfer)
                .collect(Collectors.toList());
    }

    FruitTransfer getFruitTransfer(String line) {
        String [] arrays = line.split(",");
        return new FruitTransfer(FruitTransfer.Operation.valueOf(arrays[OPERATION_INDEX]),
                new Fruit(arrays[FRUIT_INDEX]),Integer.parseInt(arrays[REMAINDER_INDEX]));
    }
}
