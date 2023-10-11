package core.basesyntax.db.dao;

import core.basesyntax.db.dto.GoodsDTO;
import core.basesyntax.db.dto.GoodsOperationDTO;

import java.util.List;

public interface StorageDAO {
    void update(GoodsOperationDTO operation);
    void update(List<GoodsOperationDTO> operationList);
    GoodsDTO getRemainder(String goodsName);
    List<GoodsDTO> getRemainders();
}
