package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;

public class ReportService {
    public String createReport() {
        return "fruit," + "quantity" + System.lineSeparator()
                + Storage.banana.getFruit() + "," + Storage.banana.getQuantity()
                + System.lineSeparator()
                + Storage.apple.getFruit() + "," + Storage.apple.getQuantity();
    }
}
