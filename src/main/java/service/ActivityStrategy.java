package service;

import model.FruitTransaction;
import service.activity.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler getHandler(FruitTransaction.Operation operation);
}
