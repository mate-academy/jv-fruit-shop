package core.basesyntax.service;

import core.basesyntax.dao.OperationDao;
import core.basesyntax.dao.OperationDaoImpl;
import java.util.List;

public class DataFormatterImpl implements DataFormatter {
    @Override
    public void formatData(List<String> data) {
        OperationDao operationDao = new OperationDaoImpl();
        for (String datum : data) {
            String[] datumArray = datum.split(",");
            String type = datumArray[0];
            String fruit = datumArray[1];
            int amount = Integer.parseInt(datumArray[2]);
            operationDao.put(type, fruit, amount);
        }
    }
}
