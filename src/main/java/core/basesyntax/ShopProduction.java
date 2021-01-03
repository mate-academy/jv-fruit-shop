package core.basesyntax;

import core.basesyntax.dao.ReportWorker;
import core.basesyntax.dao.Warehouse;
import core.basesyntax.dao.WarehouseImpl;
import java.util.LinkedList;
import java.util.List;

public class ShopProduction {
    private static List<Warehouse> warehouseList = new LinkedList();
    private static Warehouse warehouse = new WarehouseImpl();

    public static void main(String[] args) {
        warehouseList.add(warehouse);
        ReportWorker reportWorker = new ReportWorker();
        reportWorker.readFromReport("reportIn", warehouse);
        reportWorker.writeToReport(warehouse);
    }
}
