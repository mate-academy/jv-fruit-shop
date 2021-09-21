package core.basesyntax.service.activityhandler;

import static core.basesyntax.db.Storage.storage;

import core.basesyntax.service.validators.ExperssionValidatorImpl;
import core.basesyntax.service.validators.ExpessionValidator;

public class PurchaseActivityHandler implements ActivityTypeHandler {
    @Override
    public void processActivity(String fruit, Integer amount) {
        ExpessionValidator validator = new ExperssionValidatorImpl();
        // check if there are enough fruits in storage
        validator.validateExpression(storage.get(fruit), amount);
        storage.put(fruit, storage.get(fruit) - amount);
    }
}
