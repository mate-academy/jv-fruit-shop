package myfirstproject.dao.impl;

import myfirstproject.dao.DataBaseDaoTemporal;
import myfirstproject.db.TemporalListOfOperations;
import myfirstproject.model.Fruit;
import myfirstproject.strategy.Operation;

public class DataBaseDaoTemporalImpl implements DataBaseDaoTemporal {
    @Override
    public void saveDataToTemporalDB(Operation operation) {
        for (int i = 1; i < TemporalListOfOperations.temporalData.size(); i++) {
            String type = TemporalListOfOperations.temporalData.get(i)[0];
            Fruit fruit = new Fruit(TemporalListOfOperations.temporalData.get(i)[1]);
            int value = Integer.parseInt(TemporalListOfOperations.temporalData.get(i)[2]);
            operation.changeValue(type, fruit, value);
        }
    }
}
