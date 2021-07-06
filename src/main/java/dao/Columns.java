package dao;

import java.util.Map;

public class Columns {
    private static final Map<String, String> columns = Map.of("type", "type",
            "fruit", "fruit", "quantity", "quantity");

    public static boolean inColumns(String column) {
        return columns.containsKey(column);
    }

    public static String getAllColumns() {
        StringBuilder builder = new StringBuilder();
        for (String string : columns.values().toArray(new String[0])) {
            builder.append(string);
            builder.append(",");
        }
        String result = builder.toString();
        return result.substring(0, result.length() - 1);
    }

    public static boolean addColumn(String column) {
        columns.put(column, column);
        return columns.containsKey(column);
    }
}
