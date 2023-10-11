package core.basesyntax.db.dto;

public class GoodsDTO {
    private final String goodsCategory;
    private final String goodsName;
    private final double qty;

    public GoodsDTO(String goodsCategory, String goodsName, double qty) {
        this.goodsCategory = goodsCategory;
        this.goodsName = goodsName;
        this.qty = qty;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public double getQty() {
        return qty;
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }
}
