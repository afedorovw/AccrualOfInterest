import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    static final int MONTHS_OF_YEAR = 12;
    static final int DAYS_YEAR = 365;

    public static void main(String[] args) {
        int startMonth; // номер месяца открытия вклада
        int startYear; // год открытия вклада
        int depositTerm; // срок вклада в месяцах
        double rate; // процентная ставка (% годовых)
        double depositAmount; // сумма вклада
        double accruedInterestPerMonth; // доход по вкладу в текущем месяце
        double accruedInterestTotal = 0; // суммарный доход по вкладу

        Scanner input = new Scanner(System.in);

        System.out.print("Введите номер месяца открытия вклада: ");
        startMonth = input.nextInt();

        System.out.print("Введите год открытия вклада: ");
        startYear = input.nextInt();

        System.out.print("Введите срок вклада в месяцах: ");
        depositTerm = input.nextInt();

        System.out.print("Введите сумму вклада: ");
        depositAmount = input.nextDouble();

        System.out.print("Введите годовую процентную ставку: ");
        rate = input.nextDouble();

        int monthsCount = 0;

        int i = startYear;
        while (monthsCount < depositTerm) {

            for (int j = 1; j <= MONTHS_OF_YEAR; j++) { // итерация по месяцам с 1 до 12

                if (i == startYear && j <= startMonth) continue;

                if (monthsCount == depositTerm) break;

                // Получаем количество дней в текущем месяце
                int lengthOfMonth = LocalDate.of(i, j, 1).lengthOfMonth();

                // Рассчитаем доход по вкладу в текущем месяце
                accruedInterestPerMonth = depositAmount * rate / 100 / DAYS_YEAR * lengthOfMonth;

                accruedInterestPerMonth = Math.round(accruedInterestPerMonth * 100) / 100.0;

                System.out.println("Начислено процентов в " + i + " году " + j + " месяца = " + accruedInterestPerMonth);

                // Добавим процент по вкладам текущего месяца к суммарной выплате
                accruedInterestTotal = accruedInterestTotal + accruedInterestPerMonth;

                monthsCount++;
            }

            i++;
        }

        System.out.println("Всего начислено процентов = " + accruedInterestTotal);

    }
}
