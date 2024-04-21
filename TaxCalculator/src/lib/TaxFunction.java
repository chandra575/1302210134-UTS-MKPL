package lib;

public class TaxFunction {

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        int tax = 0;

        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }

        numberOfChildren = Math.min(numberOfChildren, 3);

        int nonTaxableIncome = calculateNonTaxableIncome(isMarried, numberOfChildren);
        int taxableIncome = calculateTaxableIncome(monthlySalary, otherMonthlyIncome, numberOfMonthWorking, deductible, nonTaxableIncome);

        tax = (int) Math.round(0.05 * taxableIncome);

        return Math.max(tax, 0); // Pajak tidak boleh negatif
    }

    private static int calculateNonTaxableIncome(boolean isMarried, int numberOfChildren) {
        int nonTaxableIncome = 54000000; // Untuk yang belum menikah dan belum punya anak

        switch (numberOfChildren) {
            case 3:
                nonTaxableIncome += 1500000; // Fallthrough
            case 2:
                nonTaxableIncome += 1500000; // Fallthrough
            case 1:
                nonTaxableIncome += 1500000; // Untuk anak-anak
                break;
            default:
                break;
        }

        if (isMarried) {
            nonTaxableIncome += 4500000; // Untuk yang sudah menikah
        }

        return nonTaxableIncome;
    }

    private static int calculateTaxableIncome(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, int nonTaxableIncome) {
        int totalIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
        return totalIncome - deductible - nonTaxableIncome;
    }
}
