package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.*;
import java.util.List;
import java.util.Map;

public class FileOperationImpl implements OperationStrategy {
    private static final String CSV_SEPARATOR = ",";
    private Map<String, FruitOperationHandler> mapStrategy;
    private FileReaderService fileReader = new FileReaderImpl();
    private FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
    private StorageService storageService = new StorageServiceImpl();
    private static final String INPUT_FILE_PATH = "src/main/resources/fruitStorageInfo.csv";

    public FileOperationImpl(Map<String, FruitOperationHandler> mapStrategy) {
        this.mapStrategy = mapStrategy;
    }

    @Override
    public void doOperation() {
        List<FruitRecordDto> dtos = parser.parse(fileReader.readFromFile(INPUT_FILE_PATH));
        for (FruitRecordDto dto : dtos) {
            mapStrategy.get(dto.getOperationType()).apply(dto);
        }
    }

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fruit, Quantity\n");
        for (Map.Entry<Fruit,Integer> entry : storageService.getAllData().entrySet()) {
            stringBuilder.append(entry.getKey().getName())
                    .append(CSV_SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
