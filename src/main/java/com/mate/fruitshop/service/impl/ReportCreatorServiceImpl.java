package com.mate.fruitshop.service.impl;

import com.mate.fruitshop.dao.FruitStorageDao;
import com.mate.fruitshop.dao.impl.FruitStorageDaoImpl;
import com.mate.fruitshop.model.FruitEntry;
import com.mate.fruitshop.service.ReportCreatorService;
import java.util.List;

public class ReportCreatorServiceImpl implements ReportCreatorService {

    public static final String REPORT_HEADER = "fruit,quantity";
    public static final String DELIMITER = ",";

    @Override
    public String createReport() {
        FruitStorageDao dao = new FruitStorageDaoImpl();
        List<FruitEntry> entries = dao.getAllFruitEntries();
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(REPORT_HEADER).append(System.lineSeparator());
        for (FruitEntry entry : entries) {
            strBuilder.append(entry.getFruitName())
                    .append(DELIMITER)
                    .append(entry.getQuantity())
                    .append(System.lineSeparator());
        }
        return strBuilder.toString();
    }
}
