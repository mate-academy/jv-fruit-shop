package main.service.impl;

import main.dao.ReportDao;
import main.model.Product;
import main.model.Transaction;
import main.service.BalanceSetter;

import java.util.List;

public class BalanceSetterImpl implements BalanceSetter {
    private ReportDao reportDao;

    public BalanceSetterImpl(ReportDao reportDao) {
        this.reportDao = reportDao;
    }

    @Override
    public void setBalance(List<Product> products) {
        products.stream()
            .filter(product -> product.getTransaction() == Transaction.BALANCE)
            .forEach(product -> reportDao.update(product));
    }
}
