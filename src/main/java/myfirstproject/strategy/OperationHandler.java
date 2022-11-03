package myfirstproject.strategy;

import myfirstproject.dao.DataBaseDao;
import myfirstproject.dao.impl.DataBaseDaoImpl;
import myfirstproject.model.Fruit;

public interface OperationHandler {
    DataBaseDao dataBaseDao = new DataBaseDaoImpl();

    void changeValue(Fruit fruit, int value);
}
