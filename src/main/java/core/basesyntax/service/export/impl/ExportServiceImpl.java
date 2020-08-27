package core.basesyntax.service.export.impl;

import core.basesyntax.ExportData;
import core.basesyntax.Fruit;
import core.basesyntax.Storage;
import core.basesyntax.service.export.ExportService;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ExportServiceImpl implements ExportService {

    @Override
    public List<ExportData> prepareData() {
        return Storage.fruits.stream()
                .map(Fruit::getName)
                .collect(Collectors.toSet())
                .stream()
                .map(name -> {
                    Integer total = Storage.fruits.stream()
                            .filter(fruit -> Objects.equals(fruit.getName(), name))
                            .map(Fruit::getQuantity)
                            .reduce(Integer::sum)
                            .orElse(0);
                    return new ExportData(total, name);
                })
                .collect(Collectors.toList());
    }
}
