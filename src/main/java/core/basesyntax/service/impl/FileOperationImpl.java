package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;
import core.basesyntax.service.FruitRecordDtoParser;
import core.basesyntax.service.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FileOperationImpl implements OperationStrategy {
    private static final String LINE_SEPARATOR = ",";
    private Map<String, FruitOperationHandler> mapStrategy;

    public FileOperationImpl(Map<String, FruitOperationHandler> mapStrategy) {
        this.mapStrategy = mapStrategy;
    }

    @Override
    public void doOperation() {
        FileReaderImpl fileReader = new FileReaderImpl();
        FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
        List<FruitRecordDto> dtos = parser.parse(fileReader.readFromFile("fruitStorageInfo.csv"));
        for (FruitRecordDto dto : dtos) {
            mapStrategy.get(dto.getOperationType()).apply(dto);
        }
    }

    @Override
    public Map<Fruit, Integer> getAllData() {
        return Storage.fruits;
    }

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fruit, Quantity\n");
        for (Map.Entry<Fruit,Integer> entry : getAllData().entrySet()) {
            stringBuilder.append(entry.getKey().getName())
                    .append(LINE_SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
