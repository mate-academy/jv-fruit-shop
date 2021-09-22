package core.basesyntax.servises;

public class SupplayHandler implements OperationHandler {
    @Override
    public void apply(TransferDto transferDto, Storage<String, Integer> storage) {
        storage.put(transferDto.getProductName(),
                    (Integer) storage.get(transferDto.getProductName()) + transferDto.getAmount());
    }
}
