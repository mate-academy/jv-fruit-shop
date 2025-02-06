package core.basesyntax.service.usecases;
import core.basesyntax.infratructure.persistence.FruitRepository;

public interface FruitUseService {

    void run(String fruitNam, int amount);

}
