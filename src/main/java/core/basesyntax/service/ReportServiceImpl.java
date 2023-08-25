package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitItem;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private FruitDao fruitDao = new FruitDaoImpl();

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public List<FruitItem> create() {
        return new ArrayList<>(fruitDao.getAll())
                .stream()
                .filter(fruitItem -> fruitItem.getQuantity() != 0)
                .collect(Collectors.toList());
    }
}
