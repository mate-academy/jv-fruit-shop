package core.basesyntax.service.exeptions;

public class NegativeNumberExeption extends RuntimeException {
    public NegativeNumberExeption(String message) {
        super(message);
    }
}
