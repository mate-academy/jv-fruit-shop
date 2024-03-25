package mate.fruitshop;

import mate.fruitshop.dao.FruitTransactionDaoCsv;
import mate.fruitshop.service.FruitService;

public class Main {
    private static final FruitService service = new FruitService(new FruitTransactionDaoCsv());

    public static void main(String[] args) {
        service.saveReport(service.createReport(service.calculateFruitsLeft()));
    }
}
