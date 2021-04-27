package core.basesyntax;

import core.basesyntax.activity.Activities;
import core.basesyntax.activity.PickActivityStrategy;
import core.basesyntax.activity.ActivityStrategyImpl;
import core.basesyntax.managing.storage.AddToStorageImp;
import core.basesyntax.managing.storage.HandleGoods;
import core.basesyntax.managing.storage.TakeFromStorageImpl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FruitShop {
    public Map<String, Integer> taskReader(String fromFile) {
        String line;
        String[] inputData;
        String activity;
        String fruitType;
        int amount;
        Map<String, Integer> fruitStorage = new HashMap<>();

        Map<Activities, HandleGoods> handleGoodsMap = new HashMap<>();
        handleGoodsMap.put(Activities.B, new AddToStorageImp());
        handleGoodsMap.put(Activities.S, new AddToStorageImp());
        handleGoodsMap.put(Activities.P, new TakeFromStorageImpl());
        handleGoodsMap.put(Activities.R, new AddToStorageImp());
        PickActivityStrategy activityStrategy = new ActivityStrategyImpl(handleGoodsMap);

        try (BufferedReader reader = new BufferedReader(new FileReader(fromFile))) {
            line = reader.readLine();
            while (line != null) {
                inputData = line.trim().split(",");
                if (!inputData[2].matches("[0-9]+")) {
                    line = reader.readLine();
                    continue;
                }
                activity = inputData[0];
                fruitType = inputData[1];
                amount = Integer.parseInt(inputData[2]);
                activityStrategy.get(Activities.valueOf(activity.toUpperCase()))
                        .handleGoods(fruitStorage, fruitType, amount);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find the file", e);
        }
        return fruitStorage;
    }

    public void createReport(String toFile, Map<String, Integer> storage) {
        File file = new File(String.valueOf(toFile));
        String title = "fruit,quantity\n";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(title);
            for (Map.Entry<String, Integer> map : storage.entrySet()) {
                bufferedWriter.write(map.getKey() + ",");
                bufferedWriter.write(map.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find the file", e);
        }

    }
}
