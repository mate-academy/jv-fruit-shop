package core.basesyntax.service;

import core.basesyntax.dao.FruitRecordDto;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.db.SaveData;
import core.basesyntax.filework.FileReader;
import core.basesyntax.filework.FileWriter;
import core.basesyntax.model.Type;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String FROM_FILE_NAME = "src/main/resources/fruit_shop.csv";
    private static final String TO_FILE_NAME = "src/main/resources/result.csv";
    private static final String SEPARATOR = System.getProperty("line.separator");
    private static final String COMA = ",";
    private final FileReader reader;
    private final FileWriter writer;

    public FruitServiceImpl(FileReader reader, FileWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void createReport(Map<Type, OperationHandler> operationHandlerMap) {
        reader.read(FROM_FILE_NAME);
        updateInfo(operationHandlerMap);
        writer.write(TO_FILE_NAME, makeContent(FruitStorage.storage));
    }

    private void updateInfo(Map<Type, OperationHandler> operationHandlerMap) {
        for (FruitRecordDto fruit : SaveData.fruitStore) {
            operationHandlerMap.get(fruit.getType())
                    .apply(fruit);
        }
    }

    public String makeContent(Map<String, Integer> storage) {
        StringBuilder content = new StringBuilder();
        content.append("fruit").append(COMA).append("quantity").append(SEPARATOR);
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            content.append(entry.getKey())
                    .append(COMA)
                    .append(entry.getValue())
                    .append(SEPARATOR);
        }
        return content.toString();
    }
}
