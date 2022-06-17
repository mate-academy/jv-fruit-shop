package mate.academy.service.impl;

import mate.academy.dao.ShopDao;
import mate.academy.dao.ShopDaoImpl;
import mate.academy.service.CreateReport;

public class CreateReportImpl implements CreateReport {
    private final ShopDao shopDao = new ShopDaoImpl();

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit, quantity");
        report.append(System.lineSeparator());
        report.append(shopDao.getAll());
        return report.toString();
    }
}
