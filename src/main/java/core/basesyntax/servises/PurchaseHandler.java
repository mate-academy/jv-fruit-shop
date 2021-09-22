package core.basesyntax.servises;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void apply(TransferDto transferDto, Storage<String, Integer> storage) {
        if (transferDto.getAmount() > (Integer) storage.get(transferDto.getProductName())) {
            throw new RuntimeException("purchase can't be < balance");
        }
        storage.put(transferDto.getProductName(),
                    (Integer) storage.get(transferDto.getProductName()) - transferDto.getAmount());
    }
}
