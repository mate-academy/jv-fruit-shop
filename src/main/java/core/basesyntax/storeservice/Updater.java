package core.basesyntax.storeservice;

import core.basesyntax.dao.FruitStorage;
import core.basesyntax.fileservice.ProductDto;
import core.basesyntax.goods.FruitPack;
import java.util.List;


public class Updater {
    private FruitStorage storage;

    public Updater(FruitStorage storage) {
        this.storage = storage;
    }

    public FruitStorage updateData(List<ProductDto> inputData) {
        if (inputData.size() == 0) {
            throw new RuntimeException("No operation data found");
        }
        for (ProductDto element : inputData) {
            FruitPack product = new FruitPack(element.getType(), element.getExpDate(), element.getQuantity());
            element.getOperation()
                    .updateStorage(product, storage);
        }
        return storage;
    }
}
