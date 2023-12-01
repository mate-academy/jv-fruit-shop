package dao;

import db.Storage;
import model.Fruit;

import java.util.Map;

public class ReportDaoImpl implements ReportDao {
    private Storage storage = new Storage();

    @Override
    public Map<String, Integer> getReport() {
        return storage.getReportData();
    }

    @Override
    public void updateReport(Fruit fruit) {
        storage.addDataToReport(fruit);
    }

    @Override
    public int getBalanceFruit(Fruit fruit) {
        return getReport().get(fruit.getFruit());
    }
}
