package service;

import java.util.List;
import model.FruitDataDto;

public class ShopServiceImpl implements ShopService {
    private ActivityStrategy activityStrategy;

    public ShopServiceImpl(ActivityStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
    }

    public void doAction(List<FruitDataDto> data) {
        for (FruitDataDto record : data) {
            activityStrategy.get(record.getOperation()).apply(record);
        }
    }
}
