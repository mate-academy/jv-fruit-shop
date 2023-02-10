package core.basesyntax.service.impl;

import core.basesyntax.dao.WarehouseDao;
import core.basesyntax.service.ReportCreator;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private static final String REPORT_HEADER = "fruit,quantity" + System.lineSeparator();
    private WarehouseDao warehouseDao;

    public ReportCreatorImpl(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
    }

    @Override
    public String getReport(Map<String, Integer> leftovers) {
        return REPORT_HEADER + leftovers.entrySet().stream()
                .map(f -> f.getKey() + "," + f.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
