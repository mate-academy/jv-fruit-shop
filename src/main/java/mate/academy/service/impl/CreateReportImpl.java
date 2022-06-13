package mate.academy.service.impl;

import mate.academy.dao.ShopDao;
import mate.academy.dao.ShopDaoImpl;
import mate.academy.service.CreateReport;
import mate.academy.storage.Storage;

import java.io.*;
import java.util.stream.Collectors;

public class CreateReportImpl implements CreateReport {
    private static final String PATH_NAME = "src/main/java/mate/academy/report/report.csv";
    private final ShopDao shopDao = new ShopDaoImpl();

    public void createReport() {
        shopDao.createFileForReport();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_NAME));
            writer.write("fruit, quantity");
            writer.newLine();
            writer.write(Storage.storage.entrySet().stream()
                    .map(key -> key.getKey() + "," + key.getValue() )
                    .collect(Collectors.joining("\n")));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file");
        }
    }
}