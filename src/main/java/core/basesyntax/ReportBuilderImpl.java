package core.basesyntax;

import java.util.List;

public class ReportBuilderImpl implements ReportBuilder {

    @Override
    public String buildReport(List<String> list) {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity\n");
        int totalBananaQuantity = 0;
        int totalAppleQuantity = 0;

        for (String record : list) {
            String[] words = record.split(",");
            String activity = words[0];
            String kindOfFruit = words[1];
            int amountOfFruit = Integer.parseInt(words[2]);

            if (activity.equals("b")) {
                if (kindOfFruit.equals("banana")) {
                    totalBananaQuantity = amountOfFruit;
                } else {
                    totalAppleQuantity = amountOfFruit;
                }
            }
            if (activity.equals("s")) {
                if (kindOfFruit.equals("banana")) {
                    totalBananaQuantity += amountOfFruit;
                } else {
                    totalAppleQuantity += amountOfFruit;
                }
            }
            if (activity.equals("p")) {
                if (kindOfFruit.equals("banana")) {
                    totalBananaQuantity -= amountOfFruit;
                } else {
                    totalAppleQuantity -= amountOfFruit;
                }
            }
            if (activity.equals("r")) {
                if (kindOfFruit.equals("banana")) {
                    totalBananaQuantity += amountOfFruit;
                } else {
                    totalAppleQuantity += amountOfFruit;
                }
            }
        }
        builder.append("banana,").append(totalBananaQuantity)
                .append("\n")
                .append("apple,").append(totalAppleQuantity);
        return builder.toString();

    }
}
