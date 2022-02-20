import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.initializer.Initializer;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;

public class Main {
    public static void main(String[] args) {
        String reportPath
                = "C:\\Users\\Igor\\IdeaProjects\\jv-fruit-shop\\src\\main\\resources\\report.csv";
        FruitService fruitService
                = new FruitServiceImpl(new FruitDaoImpl(new Storage()), reportPath);
        Initializer initializer = new Initializer(fruitService);
        initializer.initStorage();
        fruitService.createReport();
    }
}
