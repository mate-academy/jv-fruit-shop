package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitStoreService;
import core.basesyntax.startegy.ActivityHandler;
import core.basesyntax.startegy.ActivityStrategy;
import core.basesyntax.startegy.ActivityType;
import java.util.List;

public class FruitStoreServiceImpl implements FruitStoreService {
    private FruitDao fruitsDao;
    private ActivityStrategy activitiesStrategy;

    public FruitStoreServiceImpl(FruitDao fruitsDao, ActivityStrategy activitiesStrategy) {
        this.fruitsDao = fruitsDao;
        this.activitiesStrategy = activitiesStrategy;
    }

    public List<Fruit> changeBalance(List<TransactionDto> transactions) {
        for (TransactionDto transactionDto: transactions) {
            ActivityHandler activitiesService = activitiesStrategy.get(ActivityType
                    .getActivityType(transactionDto.getActivity()));
            activitiesService.doActivity(transactionDto.getFruitName(),
                    transactionDto.getQuantity());
        }
        return fruitsDao.getAll();
    }
}
