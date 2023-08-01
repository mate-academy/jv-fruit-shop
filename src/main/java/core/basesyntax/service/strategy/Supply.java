package core.basesyntax.service.strategy;

import core.basesyntax.service.ActivitiesService;

public class Supply implements ActivitiesService {
    @Override
    public int quantityModify(int adderBefore) {
        return adderBefore;
    }
}
