package core.service;

import core.model.Operations;
import core.strategy.AmountHandler;

public interface ActivitiesStrategy {
    AmountHandler get(Operations typeOfActivity);
}
