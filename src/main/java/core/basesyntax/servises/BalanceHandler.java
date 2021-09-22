package core.basesyntax.servises;

public class BalanceHandler implements OperationHandler {
    @Override
    public void apply(TransferDto transferDto, Storage<String, Integer> storage) {
        storage.put(transferDto.getProductName(), transferDto.getAmount());
    }
}
