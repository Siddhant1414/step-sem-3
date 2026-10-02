package main.java.week6.assignment_problems;

public class Assignment2 {

    static class Payroll {

        private double basicSalary;
        private double bonus;

        Payroll(double basicSalary) {

            if (basicSalary < 0) {
                this.basicSalary = 0;
            } else {
                this.basicSalary = basicSalary;
            }

            this.bonus = 0;
        }

        public void creditBonus(double amount) {

            if (amount > 0) {
                bonus += amount;
            }
        }

        public void deductTax(double percent) {

            if (percent > 0 && percent <= 100) {

                double tax = getNetSalary() * percent / 100;

                basicSalary -= tax;

                if (basicSalary < 0) {
                    basicSalary = 0;
                }
            }
        }

        public double getNetSalary() {
            return basicSalary + bonus;
        }
    }

    public static void main(String[] args) {

        Payroll payroll = new Payroll(50000);

        System.out.println("Initial Net Salary: "
                + payroll.getNetSalary());

        payroll.creditBonus(5000);

        System.out.println("After Bonus: "
                + payroll.getNetSalary());

        payroll.deductTax(10);

        System.out.println("After 10% Tax: "
                + payroll.getNetSalary());
    }
}