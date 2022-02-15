package core.service;

import core.dao.FruitsDao;
import core.dao.FruitsDaoImpl;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private final FruitsDao fruitsDao = new FruitsDaoImpl();

    @Override
    public String generateFruitReport() {
        return fruitsDao.getAll().entrySet().stream()
                .map(s -> s.getKey() + "," + s.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
