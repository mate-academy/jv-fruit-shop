package core.basesyntax.services.implementation;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.TypeOfOperation;
import core.basesyntax.services.FruitService;
import core.basesyntax.services.operations.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String TITLE_ROW = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private final Map<TypeOfOperation, OperationHandler> handlerMap;

    public FruitServiceImpl(Map<TypeOfOperation, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public String makeReport() {
        StringBuilder builder = new StringBuilder(TITLE_ROW).append(System.lineSeparator());
        Storage.fruitStorage.forEach((key, value) -> builder.append(key.getName())
                .append(SEPARATOR)
                .append(value).append(System.lineSeparator()));
        return builder.toString();
    }

    @Override
    public void applyOperationsOnFruitsDto(List<FruitDto> fruitDtos) {
        for (FruitDto fruitDto : fruitDtos) {
            OperationHandler operationHandler = handlerMap
                    .get(fruitDto.getType());
            operationHandler.apply(fruitDto);
        }
    }
}
