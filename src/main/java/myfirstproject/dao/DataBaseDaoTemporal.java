package myfirstproject.dao;

import myfirstproject.strategy.Operation;

public interface DataBaseDaoTemporal {
    void saveDataToTemporalDB(Operation operation);
}
