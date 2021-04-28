package service.validator;

import java.util.function.Predicate;

public class DataValidator implements Predicate<String> {
    public static final int DATA_ELEMENTS = 3;

    @Override
    public boolean test(String data) {
        String[] dataArr = data.split(",");
        if (dataArr.length != DATA_ELEMENTS) {
            return false;
        }
        try {
            if (Integer.parseInt(dataArr[2]) < 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        String activity = dataArr[0];
        return "b".equals(activity)
                || "p".equals(activity)
                || "s".equals(activity)
                || "r".equals(activity);
    }
}
