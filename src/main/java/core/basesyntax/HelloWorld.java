package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    private FruitDao fruitDao = new FruitDaoImpl();
    private FruitService fruitService = new FruitServiceImpl(fruitDao);


    public static void main(String[] args) {

    }

}
