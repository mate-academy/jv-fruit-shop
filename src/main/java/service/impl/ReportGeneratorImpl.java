package service.impl;

import db.WareHouse;
import java.util.List;
import java.util.stream.Collectors;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public List<String> getReport() {
        return WareHouse.STORED_FRUITS
                .stream()
                .map(lot -> String.join(",", lot))
                .collect(Collectors.toList());
    }
}
