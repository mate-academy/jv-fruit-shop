package core.shop.service.impl;

import core.shop.model.ActivityType;
import core.shop.model.FruitRecord;
import core.shop.service.ParseListService;
import java.util.List;
import java.util.stream.Collectors;

public class ParseListServiceImpl implements ParseListService {
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COMA_SPLITERATOR = ",";

    @Override
    public List<FruitRecord> getFruitRecords(List<String> list) {
        List<String> withoutFirstLine = list.subList(1, list.size());
        return withoutFirstLine.stream()
                .map(fruit -> {
                    String[] splittedString = fruit.split(COMA_SPLITERATOR);
                    FruitRecord fruitRecord = new FruitRecord();
                    fruitRecord.setActivityType(ActivityType.fromValue(
                            splittedString[ACTIVITY_TYPE_INDEX]));
                    fruitRecord.setFruitName(splittedString[FRUIT_NAME_INDEX]);
                    fruitRecord.setQuantity(Integer.parseInt(splittedString[QUANTITY_INDEX]));
                    return fruitRecord;
                })
                .collect(Collectors.toList());
    }

}
