package com.mate.fruitshop.service.impl;

import com.mate.fruitshop.dao.FruitStorageDao;
import com.mate.fruitshop.dao.impl.FruitStorageDaoImpl;
import com.mate.fruitshop.model.FruitEntry;
import com.mate.fruitshop.service.ReportCreatorService;
import java.util.List;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    @Override
    public String createReport() {
        FruitStorageDao dao = new FruitStorageDaoImpl();
        List<FruitEntry> entries = dao.getAllFruitEntries();
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("fruit,quantity").append(System.lineSeparator());
        for (FruitEntry entry : entries) {
            strBuilder.append(entry.getFruitName())
                    .append(",")
                    .append(entry.getQuantity())
                    .append(System.lineSeparator());
        }
        return strBuilder.toString();
    }
}
