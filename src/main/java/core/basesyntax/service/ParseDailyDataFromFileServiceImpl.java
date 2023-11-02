package core.basesyntax.service;

public class ParseDailyDataFromFileServiceImpl implements ParseDailyDataFromFileService {
    public static final int TYPE_POSITION_AFTER_SPLIT = 0;
    public static final int FRUIT_NAME_POSITION_AFTER_SPLIT = 1;
    public static final int QUANTITY_POSITION_AFTER_SPLIT = 2;

    @Override
    public char getType(String line) {
        String type = parseValue(line)[TYPE_POSITION_AFTER_SPLIT];
        if (type.length() != 1) {
            throw new IllegalArgumentException(
                    "Invalid type: the type should be a single character");
        }
        return type.charAt(TYPE_POSITION_AFTER_SPLIT);
    }

    @Override
    public String getFruitName(String line) {
        return parseValue(line)[FRUIT_NAME_POSITION_AFTER_SPLIT];
    }

    @Override
    public int getQuantity(String line) {
        return Integer.parseInt(parseValue(line)[QUANTITY_POSITION_AFTER_SPLIT]);
    }

    private String[] parseValue(String line) {
        String[] split = line.split(",");
        if (split.length != 3) {
            throw new IllegalArgumentException("Invalid input data: expected format "
                    + "'<type>,<fruit_name>,<quantity>'");
        }
        return split;
    }
}
