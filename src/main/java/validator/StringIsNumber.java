package validator;

public class StringIsNumber implements Validator<String> {
    @Override
    public boolean validate(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
