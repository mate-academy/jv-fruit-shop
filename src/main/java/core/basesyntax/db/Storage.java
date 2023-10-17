package core.basesyntax.db;

import core.basesyntax.db.dto.StorageItemDto;
import java.util.List;

public interface Storage {
    void clear();

    void income(StorageItemDto goods);

    void outcome(StorageItemDto goods);

    void setRemainder(StorageItemDto goods);

    StorageItemDto getRemainder(String goodsName);

    List<StorageItemDto> getRemainders();
}
