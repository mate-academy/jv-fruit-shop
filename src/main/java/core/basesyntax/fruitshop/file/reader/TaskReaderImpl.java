package core.basesyntax.fruitshop.file.reader;

import core.basesyntax.activity.Activities;
import core.basesyntax.activity.ActivityStrategyImpl;
import core.basesyntax.activity.PickActivityStrategy;
import core.basesyntax.db.Storage;
import core.basesyntax.fruit.dto.FruitDto;
import core.basesyntax.fruitshop.ValidatorImpl;
import core.basesyntax.storage.dao.AddToStorageImpl;
import core.basesyntax.storage.dao.HandleGoods;
import core.basesyntax.storage.dao.TakeFromStorageImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

public class TaskReaderImpl implements TaskReader {

    @Override
    public Map<String, Integer> readFile(String fromFile) {
        String line;
        String[] inputData;
        ValidatorImpl validator = new ValidatorImpl();

        Map<Activities, HandleGoods> handleGoodsMap = Map.of(Activities.B, new AddToStorageImpl(),
                Activities.S, new AddToStorageImpl(),
                Activities.P, new TakeFromStorageImpl(),
                Activities.R, new AddToStorageImpl());
        PickActivityStrategy activityStrategy = new ActivityStrategyImpl(handleGoodsMap);

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fromFile))) {
            line = reader.readLine();
            while (line != null) {
                inputData = line.trim().split(",");
                if (inputData[0].equals("type")) {
                    line = reader.readLine();
                    continue;
                }
                validator.validate(line);
                FruitDto fruitsToHandle = new FruitDto(inputData[1],
                        Integer.parseInt(inputData[2]));
                activityStrategy.get(Activities.valueOf(inputData[0].toUpperCase()))
                        .handleGoods(fruitsToHandle);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find the file", e);
        }
        return Storage.getFruitStorage();
    }
}

