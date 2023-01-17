import java.util.ArrayList;
import java.util.List;

public class MonthlyReader {
    FileReader fileReader = new FileReader();   // Читатель csv
    ArrayList<MonthLine> month = new ArrayList<>();
    public MonthlyReader(String path) {
        List<String> lines = fileReader.readFileContents(path); // Читаем csv, разделяет на строки
        for (int i = 1; i < lines.size(); i++) {   // Перебираем каждую строку
            String line = lines.get(i);
            String[] parts = line.split(",");   // Каждую строку csv добавляет в объект
            String itemName = parts[0];
            Boolean isExpense = Boolean.parseBoolean(parts[1]);
            Integer quantity = Integer.parseInt(parts[2]);
            Double SumOfOne = Double.parseDouble(parts[3]);
            MonthLine monthLine = new MonthLine(itemName, isExpense, quantity, SumOfOne);
            month.add(monthLine);
        }
    }
}