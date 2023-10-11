package core.basesyntax.db.dto;

public class GoodsOperationDTO {
    private final String type;
    private final GoodsDTO goods;

    public GoodsOperationDTO(String type, GoodsDTO goods) {
        this.type = type;
        this.goods = goods;
    }

    public String getType() {
        return type;
    }

    public GoodsDTO getGoods() {
        return goods;
    }
}
