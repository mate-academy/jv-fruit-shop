package core.basesyntax.service.strategy;

import core.basesyntax.service.ActivitiesService;

public class Purchase implements ActivitiesService {
    @Override
    public int quantityModify(int adderBefore) {
        return Math.negateExact(adderBefore);
    }
}
