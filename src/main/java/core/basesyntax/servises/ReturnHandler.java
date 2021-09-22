package core.basesyntax.servises;

public class ReturnHandler implements OperationHandler {
    @Override
    public void apply(TransferDto transferDto, Storage<String, Integer> storage) {
        if (transferDto.getAmount() < 0) {
            throw new RuntimeException("Return can't be negative");
        }
        storage.put(transferDto.getProductName(),
                    (Integer) storage.get(transferDto.getProductName()) + transferDto.getAmount());
    }
}
