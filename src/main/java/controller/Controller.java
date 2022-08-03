package controller;

import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.List;

public class Controller {
    private StorageDao storageDao = new StorageDaoImpl();

    public String getReport() {
        return storageDao.getFruitReport();
    }

    private void balance(String name, int amount) {
        storageDao.put(name, amount);
    }

    private void supply(String name, int amount) {
        int add = storageDao.get(name);
        storageDao.put(name, add + amount);
    }

    private void purchase(String name, int amount) {
        int bought = storageDao.get(name);
        storageDao.put(name, bought - amount);
    }

    public void operation(List<String> lines) {
        for (String line : lines) {
            String[] data = line.split(",");
            switch (data[0].trim()) {
                case "b":
                    balance(data[1], Integer.parseInt(data[2]));
                    break;
                case "s":
                    supply(data[1], Integer.parseInt(data[2]));
                    break;
                case "p":
                    purchase(data[1], Integer.parseInt(data[2]));
                    break;
                case "r":
                    supply(data[1], Integer.parseInt(data[2]));
                    break;
                default:
                    break;
            }
        }
    }
}
