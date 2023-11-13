package exception;

public class NegativeBalanceException extends RuntimeException {
    public NegativeBalanceException(String massage) {
        super(massage);
    }
}
