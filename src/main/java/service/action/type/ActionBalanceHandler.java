package service.action.type;

import dao.ReportLocalDaoImpl;
import model.Fruit;

public class ActionBalanceHandler extends ActionStrategyHandler {
    private final ReportLocalDaoImpl reportLocalDao = new ReportLocalDaoImpl();

    @Override
    public void doing(String[] data) {
        Fruit fruit = new Fruit(data[1], Integer.parseInt(data[2]));
        reportLocalDao.setFruit(fruit);
    }
}
