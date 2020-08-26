package core.basesyntax.service.operations;

import core.basesyntax.controller.ControllerDao;
import core.basesyntax.controller.ControllerDaoImpl;
import core.basesyntax.model.Product;
import java.util.List;

public interface Operation {
    ControllerDao<Product> controllerDao = new ControllerDaoImpl();

    boolean updateStorage(List<Product> product);
}
