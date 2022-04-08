import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.impl.FruitShopServiceImpl;

public class Main {
    private static final FruitShopService service = new FruitShopServiceImpl();
    private static final String INPUT_FILE = "src/main/resources/InputData.csv";
    private static final String OUTPUT_FILE = "src/main/resources/OutputData.csv";

    public static void main(String[] args) {
        service.update(INPUT_FILE, OUTPUT_FILE);
    }
}
