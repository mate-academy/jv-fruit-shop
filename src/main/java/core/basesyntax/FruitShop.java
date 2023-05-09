package core.basesyntax;

import core.basesyntax.dao.WarehouseDaoRead;
import core.basesyntax.dao.WarehouseDaoWrite;
import core.basesyntax.service.Warehouse;
import core.basesyntax.service.WarehouseImpl;

public class FruitShop {
    private static final String INPUT_FILE = "input.csv";
    private static final String OUTPUT_FILE = "output.csv";

    public static void main(String[] args) {
        Warehouse warehouse = new WarehouseImpl(WarehouseDaoRead.readData(INPUT_FILE));
        WarehouseDaoWrite.writeData(OUTPUT_FILE, warehouse.getRemains());
    }

}
