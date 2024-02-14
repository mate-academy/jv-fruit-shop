package service.impl;

import dao.ActionDao;
import dao.ActionDaoImpl;
import java.util.List;
import model.FruitTransaction;
import model.Operation;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final String SEPARATOR = ",";
    private static final int START_DATA_LINE = 1;
    private static final int INDEX_TYPE = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;
    private final ActionDao actionDao = new ActionDaoImpl();

    @Override
    public List<FruitTransaction> parseTransactions(List<String> stringList) {
        if (stringList == null) {
            throw new RuntimeException("There isn't any information for parsing");
        }
        for (int i = START_DATA_LINE; i < stringList.size(); i++) {
            actionDao.addFruitTransaction(createAction(stringList.get(i)));
        }
        return actionDao.getListTransactions();
    }

    private FruitTransaction createAction(String line) {
        String[] dataMassive = line.split(SEPARATOR);
        return new FruitTransaction(Operation.getByType(dataMassive[INDEX_TYPE]),
                dataMassive[INDEX_FRUIT], Integer.parseInt(dataMassive[INDEX_QUANTITY]));
    }
}
