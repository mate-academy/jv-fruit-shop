import dao.Writer;
import dao.WriterImpl;

public class Main {
    public static void main(String[] args) {
        Writer writer = new WriterImpl();
        writer.reportWriter();
    }
}
