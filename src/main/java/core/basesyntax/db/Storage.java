package core.basesyntax.db;

import core.basesyntax.db.dto.GoodsDTO;
import java.util.List;

public interface Storage {
    GoodsDTO receipt(GoodsDTO goods);
    List<GoodsDTO> receipt(List<GoodsDTO> goodsList);
    GoodsDTO outgo(GoodsDTO goods);
    List<GoodsDTO> outgo (List<GoodsDTO> goodsList);
    GoodsDTO setRemainder(GoodsDTO goods);
    List<GoodsDTO> setRemainder(List<GoodsDTO> goodsList);
    GoodsDTO getRemainder(String goodsName);
    List<GoodsDTO> getRemainders();
}
