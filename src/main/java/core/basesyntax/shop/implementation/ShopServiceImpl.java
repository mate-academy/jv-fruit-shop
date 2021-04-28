package core.basesyntax.shop.implementation;

import core.basesyntax.shop.ShopService;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private StringSplitter splitter;
    private Operation operation;

    public ShopServiceImpl() {
        operation = new Operation();
    }

    @Override
    public boolean pushDataToStorage(List<String> stringList) {
        for (int i = 1; i < stringList.size(); i++) {
            splitter = new StringSplitter(stringList.get(i).trim());
            operation.operateData(splitter);
        }
        return true;
    }
}
