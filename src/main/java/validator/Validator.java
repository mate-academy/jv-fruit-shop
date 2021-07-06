package validator;

@FunctionalInterface
public interface Validator<J> {
    boolean validate(J value);
}
