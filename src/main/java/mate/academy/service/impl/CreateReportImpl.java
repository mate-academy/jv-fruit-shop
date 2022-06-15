package mate.academy.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import mate.academy.dao.ShopDao;
import mate.academy.dao.ShopDaoImpl;
import mate.academy.service.CreateReport;

public class CreateReportImpl implements CreateReport {
    private final ShopDao shopDao = new ShopDaoImpl();

    public void createReport(String pathNameReport) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathNameReport))) {
            writer.write("fruit, quantity");
            writer.newLine();
            writer.write(shopDao.getAll());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + pathNameReport, e);
        }
    }
}
