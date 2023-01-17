import java.util.Scanner;
    public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {     // Обработка команд
                monthlyReport.getReport();
                System.out.println("Все месячные отчёты считаны\n");

            } else if ((command == 2)) {
                yearlyReport.getReport();
                System.out.println("Годовой отчёт считан\n");

            } else if ((command == 3)) {
                if (monthlyReport.isReport && yearlyReport.isReport) {
                    GeneralReport generalReport = new GeneralReport(monthlyReport.monthsStat, yearlyReport.yearStat);
                    generalReport.getGeneralReport();
                } else {
                    System.out.println("Сначала необходимо считать месячные и годовой отчёты\n");
                }

            } else if ((command == 4)) {
                if (monthlyReport.isReport) {
                    monthlyReport.genMonthsInfo();
                } else {
                    System.out.println("Сначала необходимо считать месячные отчёты\n");
                }

            } else if ((command == 5)) {
                if (yearlyReport.isReport) {
                    yearlyReport.getYearInfo();
                } else {
                    System.out.println("Сначала необходимо считать годовой отчёт\n");
                }

            } else if (command == 0) {
                System.out.println("Выход\n");
                break;

            } else {
                System.out.println("Такой команды нет, пупсик.\n");
            }
        }
    }

    public static void printMenu() {        // Вывод команд
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить месячные и годовой отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
}
