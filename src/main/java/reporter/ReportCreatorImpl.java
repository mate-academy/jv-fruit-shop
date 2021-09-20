package reporter;

import dao.FruitShopDao;
import dao.FruitShopDaoImpl;
import operations.OperationStrategy;
import readerService.Reader;
import readerService.ReaderImpl;
import validator.Validator;
import validator.ValidatorImpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private static final int FRUIT_COLUMN = 1;
    private static final int QUANTITY_COLUMN = 2;
    private static final int TYPE_COLUMN = 0;
    private Reader reader = new ReaderImpl();
    private Validator validator = new ValidatorImpl();
    private OperationStrategy strategy;
    private FruitShopDao fruitShopDao = new FruitShopDaoImpl();

    public ReportCreatorImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }


    @Override
    public Map<String, Integer> createPreReport(String filepath) {
       List<String> lines =  reader.read(filepath);
        Map<String, Integer> collect = lines.stream()
                .skip(1)
                .filter(validator::isValidLine)
                .map(n -> n.split(",")).map(n -> n[1])
                .distinct()
                .collect(Collectors.toMap(n -> n, n -> 0));
        for (int i = 1; i < lines.size(); i++) {
            String[] splittedLine = lines.get(i).split(",");
            collect.put(splittedLine[FRUIT_COLUMN], strategy.get(splittedLine[TYPE_COLUMN].trim())
                    .calculate(collect.get(splittedLine[FRUIT_COLUMN]),
                            Integer.parseInt(splittedLine[QUANTITY_COLUMN])));
        }
        return collect;
    }

    @Override
    public void createReport(String filepath, String toFilepath) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("\nfruit")
                .append(",")
                .append("quantity\n");
      Map<String, Integer> tempMap = createPreReport(filepath);
      for (Map.Entry<String, Integer> entry: tempMap.entrySet()) {
          reportBuilder.append(entry.getKey())
                  .append(",")
                  .append(entry.getValue())
                  .append("\n");
      }
      fruitShopDao.add(reportBuilder.toString());
      try(BufferedWriter writer = new BufferedWriter(new FileWriter(toFilepath))) {
          writer.write(reportBuilder.toString());
      } catch (IOException e) {
          throw new RuntimeException("Cant write to file " + filepath);
      }
    }
}
