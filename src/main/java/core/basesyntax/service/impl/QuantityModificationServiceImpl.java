package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ActivitiesService;
import core.basesyntax.service.QuantityModificationService;
import core.basesyntax.service.strategy.ActivityStrategy;
import java.util.List;
import java.util.stream.Collectors;

public class QuantityModificationServiceImpl implements QuantityModificationService {
    private final ActivityStrategy activityStrategy;
    private final FruitDao fruitDao;

    public QuantityModificationServiceImpl(ActivityStrategy activityStrategy, FruitDao fruitDao) {
        this.activityStrategy = activityStrategy;
        this.fruitDao = fruitDao;
    }

    public List<Fruit> modifyQuantity() {
        return fruitDao.getAll()
                .stream()
                .map(this::fruitModify).collect(Collectors.toList());
    }

    private Fruit fruitModify(Fruit toModify) {
        ActivitiesService activityService = activityStrategy
                .getQuantityModifier(toModify.getOperation());
        int quantityModify = activityService.quantityModify(toModify.getQuantity());
        toModify.setQuantity(quantityModify);
        return toModify;

    }
}
