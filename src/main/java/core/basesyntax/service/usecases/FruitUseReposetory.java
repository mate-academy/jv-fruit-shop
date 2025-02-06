package core.basesyntax.service.usecases;

import core.basesyntax.infratructure.db.InsertListDao;
import core.basesyntax.infratructure.db.InsertListImpl;
import core.basesyntax.infratructure.persistence.FruitRepository;

public class FruitUseReposetory {
    private FruitRepository fruitRepository;
    private InsertListDao insertListDao;

    public FruitUseReposetory(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
        insertListDao = new InsertListImpl();
    }

    public FruitRepository getFruitRepository() {
        return fruitRepository;
    }

    public void setFruitRepository(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public InsertListDao getInsertListDao() {
        return insertListDao;
    }

    public void setInsertListDao(InsertListDao insertListDao) {
        this.insertListDao = insertListDao;
    }
}
