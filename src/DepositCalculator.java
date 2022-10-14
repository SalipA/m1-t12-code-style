import java.util.Scanner;
public class DepositCalculator {
    double calculateComplexPercent(double depositAmount, double yearRate, int depositPeriod) {
        double depositValue = depositAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundValue(depositValue, 2);
    }
    double calculateSimplePercent(double depositAmount,double yearRate, int depositPeriod) {
        return roundValue(depositAmount + depositAmount * yearRate * depositPeriod, 2);
    }
    double roundValue(double value,int degree) {
        double scale = Math.pow(10, degree);
        return Math.round(value * scale) / scale;
    }
    void printDepositValue() {
        int depositPeriod;
        int typeOfPercentChoice;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        typeOfPercentChoice = scanner.nextInt();
        double depositValue = 0;
        if (typeOfPercentChoice == 1)
            depositValue = calculateSimplePercent(depositAmount, 0.06, depositPeriod);
        else if (typeOfPercentChoice == 2) {
            depositValue = calculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в "
                + depositValue);
    }

public static void main(String[] args) {
        new DepositCalculator().printDepositValue();
}

}
