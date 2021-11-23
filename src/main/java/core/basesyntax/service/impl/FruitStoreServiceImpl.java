package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitStoreService;
import core.basesyntax.strategy.GetManipulationType;
import core.basesyntax.strategy.Manipulation;
import core.basesyntax.strategy.ManipulationService;
import java.util.List;

public class FruitStoreServiceImpl implements FruitStoreService {
    private FruitStorageDao fruitStorageDao;
    private GetManipulationType getManipulationType;

    public FruitStoreServiceImpl(FruitStorageDao fruitStorageDao,
                                 GetManipulationType getManipulationType) {
        this.fruitStorageDao = fruitStorageDao;
        this.getManipulationType = getManipulationType;
    }

    public List<Fruit> changeBalance(List<TransactionDto> data) {
        for (TransactionDto datum : data) {
            ManipulationService manipulationService =
                    getManipulationType.get(Manipulation
                            .getManipulation(datum.getManipulation()));
            manipulationService.manipulate(datum.getFruitName(), datum.getQuantity());
        }
        return fruitStorageDao.getAll();
    }
}
