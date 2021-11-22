package service.action.type;

import dao.ReportLocalDaoImpl;
import java.util.List;
import model.Fruit;

public class ActionPurchaseHandler extends ActionStrategyHandler {
    private final ReportLocalDaoImpl reportLocalDao = new ReportLocalDaoImpl();

    @Override
    public void doing(String[] data) {
        List<Fruit> fruits = reportLocalDao.getListRemainder();
        for (Fruit fruit1 : fruits) {
            if (fruit1.getName().equals(data[1])) {
                fruit1.setCount(fruit1.getCount() - Integer.parseInt(data[2]));
                return;
            }
        }
        throw new RuntimeException("such fruit does not exist");
    }
}
