package core.basesyntax.db;

import core.basesyntax.dto.BalanceDto;
import core.basesyntax.model.Product;
import java.util.List;

public interface BalanceStorage {
    void save(Product product, int quantity);

    int getQuantity(Product product);

    List<BalanceDto> getAll();

    int remove(Product product);

    void clear();
}
