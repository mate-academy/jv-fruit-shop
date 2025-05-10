package core.basesyntax;

import core.basesyntax.service.Inventory;
import core.basesyntax.service.InventoryFromCsv;
import core.basesyntax.service.Report;
import core.basesyntax.service.ReportToCsv;
import core.basesyntax.storage.Storage;

public class Mail {
    public static void main(String[] args) {
        Storage storage = new Storage();

        Inventory inventory = new InventoryFromCsv();
        inventory.synchronizeWithTheStorage();

        Report report = new ReportToCsv();
        report.prepare();
    }
}
