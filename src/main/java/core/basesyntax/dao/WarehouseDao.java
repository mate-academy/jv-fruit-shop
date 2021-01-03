package core.basesyntax.dao;

public interface WarehouseDao {
    void readFromReport(String filName, Warehouse warehouse);

    void writeToReport(Warehouse warehouse);
}
