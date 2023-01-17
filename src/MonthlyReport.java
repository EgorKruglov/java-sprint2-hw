import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    boolean isReport = false;   // Флаг о проверке отчётов
    HashMap<String,ArrayList<MonthLine>> monthsStat = new HashMap<>();

    void getReport() {      // Прочитать все отчёты и занести в список months
        for (int i = 1; i <= 3; i++) {
            String link = "resources/m.20210" + i + ".csv";
            MonthlyReader monthlyReader = new MonthlyReader(link);
            String monthName = getMonthName(i);
            monthsStat.put(monthName, monthlyReader.month);
        }
        isReport = true;
    }
    String getMonthName (int i) {       // Получить имя месяца
        String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        return months[i - 1];
    }

    void genMonthsInfo() {      // Вывод информации о месячных отчётах

        for (String monthName : monthsStat.keySet()) {
            double maxProfit = 0.0;
            String bestGood = "";
            double bestGoodSum = 0.0;
            double maxExpense = 0.0;
            String maxExpenseGood = "";
            double maxExpenseSum = 0.0;
            System.out.println(monthName);          // Вывели имя месяца
            for (MonthLine line : monthsStat.get(monthName)) {      // Перебор строк отчёта месяца
                if (!(line.isExpense)) {           // Находим самый прибыльный товар
                    if (maxProfit < line.quantity * line.sumOfOne) {
                        maxProfit = line.quantity * line.sumOfOne;
                        bestGood = line.itemName;
                        bestGoodSum = line.sumOfOne;
                    }
                } else {                        // Находим самую большую трату
                    if (maxExpense < line.quantity * line.sumOfOne) {
                        maxExpense = line.quantity * line.sumOfOne;
                        maxExpenseGood = line.itemName;
                        maxExpenseSum = line.sumOfOne;
                    }
                }
            }
            System.out.println("Самый прибыльный товар месяца " + bestGood + " по " + bestGoodSum);
            System.out.println("Самая большая трата месяца " + maxExpenseGood + " по " + maxExpenseSum + "\n");
        }
    }
}
