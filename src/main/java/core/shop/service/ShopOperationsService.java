package core.shop.service;

import core.shop.model.ActivityType;

public interface ShopOperationsService {
    void addOperationToCsv(ActivityType activityType, String fruitName, int quantity);
}
