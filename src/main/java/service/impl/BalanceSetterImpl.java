package service.impl;

import dao.ReportDao;
import model.Fruit;
import model.Transaction;
import service.BalanceSetter;

import java.util.List;

public class BalanceSetterImpl implements BalanceSetter {
    private ReportDao reportDao;

    public BalanceSetterImpl(ReportDao reportDao) {
        this.reportDao = reportDao;
    }

    @Override
    public void setBalance(List<Fruit> fruitList) {
        fruitList.stream()
                .filter(fruit -> fruit.getTransaction() == Transaction.BALANCE)
                .forEach(fruit -> reportDao.updateReport(fruit));
    }
}
