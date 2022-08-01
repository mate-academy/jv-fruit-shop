package serviceimpl;

import dao.StorageDao;
import java.util.List;
import model.FruitTransaction;

public class ReportCreatorImpl implements service.ReportCreator {
    private static final String HEAD = "fruits, quantity";
    private final StorageDao storageDao;

    public ReportCreatorImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String create() {
        List<FruitTransaction> fruits = storageDao.getAll();
        StringBuilder reportBuilder = new StringBuilder();
        for (FruitTransaction fruit : fruits) {
            reportBuilder.append(System.lineSeparator()).append(fruit.getFruit())
                    .append(",").append(fruit.getQuantity());
        }
        return HEAD + reportBuilder.toString();
    }
}
