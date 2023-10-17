package core.basesyntax.db;

import core.basesyntax.db.dto.StorageItemDTO;
import java.util.List;

public interface Storage {
    StorageItemDTO receipt(StorageItemDTO goods);
    List<StorageItemDTO> receipt(List<StorageItemDTO> goodsList);
    StorageItemDTO outgo(StorageItemDTO goods);
    List<StorageItemDTO> outgo (List<StorageItemDTO> goodsList);
    StorageItemDTO setRemainder(StorageItemDTO goods);
    List<StorageItemDTO> setRemainder(List<StorageItemDTO> goodsList);
    StorageItemDTO getRemainder(String goodsName);
    List<StorageItemDTO> getRemainders();
}
