package core.basesyntax.service.impl;

import core.basesyntax.model.FruitOperationDto;
import core.basesyntax.service.Transformation;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FruitDtoTransformation implements Transformation<String, FruitOperationDto> {
    private Function<String, FruitOperationDto> mapper;

    @Override
    public List<FruitOperationDto> transformationToObj(List<String> dataFromFile) {
        mapper = new FruitOperationDtoMapper();
        return dataFromFile.stream()
                .map(mapper::apply)
                .collect(Collectors.toList());
    }
}
