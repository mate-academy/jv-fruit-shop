package core.basesyntax.storeservice;

import core.basesyntax.dao.FruitStorage;
import core.basesyntax.dao.Storage;
import core.basesyntax.fileservice.ProductDto;
import core.basesyntax.goods.FruitPack;
import java.util.List;

public class Updater {
    private final FruitStorage storage;

    public Updater() {
        this.storage = Storage.MAIN_STORAGE;
    }

    public FruitStorage updateData(List<ProductDto> inputData) {
        if (inputData == null || inputData.size() == 0) {
            throw new IllegalArgumentException("No operation data found");
        }
        for (ProductDto element : inputData) {
            FruitPack product = new FruitPack(element.getType(),
                    element.getExpDate(),
                    element.getQuantity());
            element.getOperation()
                    .updateStorage(product);
        }
        return storage;
    }
}
