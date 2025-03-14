package core.basesyntax.service;

import java.util.List;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public List<String> report(List<FruitStorage> fruitStorageList) {

        List<String> list = fruitStorageList.stream()
                .map(f -> f.getFruit() + "," + f.getQuantity())
                .collect(Collectors.toList());

        String heading = "fruit,quantity";
        list.add(0, heading);

        return list;
    }
}
