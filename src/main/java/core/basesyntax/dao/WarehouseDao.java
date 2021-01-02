package core.basesyntax.dao;

public interface WarehouseDao {
    public void readFromReport(String filName, WarehouseImpl warehouse);

    public void writeToReport(WarehouseImpl warehouse);
}
