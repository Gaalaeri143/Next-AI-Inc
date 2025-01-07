public class NextAIInc {

    // Method to calculate total weekly pay
    public void calculatePay(double basePay, int hoursWorked) {
        final double OVERTIME_RATE = 2.0; // Overtime rate multiplier
        final int MAX_REGULAR_HOURS = 48; // Max regular hours
        final int MAX_HOURS = 72; // Max total hours
        final double MIN_BASE_PAY = 30000; // Minimum base pay

        // Check if the base pay is below the minimum
        if (basePay < MIN_BASE_PAY) {
            System.out.println("Error: Base pay must not fall below UGX 30,000.");
            return;
        }

        // Check if hours worked exceed the maximum limit
        if (hoursWorked > MAX_HOURS) {
            System.out.println("Error: Contractors cannot work more than 72 hours per week.");
            return;
        }

        // Calculate total pay
        double totalPay;
        if (hoursWorked <= MAX_REGULAR_HOURS) {
            totalPay = basePay * hoursWorked; // No overtime
        } else {
            int overtimeHours = hoursWorked - MAX_REGULAR_HOURS; // Calculate overtime hours
            totalPay = (basePay * MAX_REGULAR_HOURS) + (basePay * OVERTIME_RATE * overtimeHours); // Regular + Overtime pay
        }

        // Print the total weekly pay
        System.out.println("Total weekly pay for the contractor: UGX " + totalPay);
    }

    public static void main(String[] args) {
        NextAIInc company = new NextAIInc();

        // Test case for Contractor A
        System.out.println("Contractor A:");
        company.calculatePay(30000, 51); // Expected Outcome: UGX 1,530,000

        // Test case for Contractor B
        System.out.println("\nContractor B:");
        company.calculatePay(20000, 40); // Expected Outcome: Error message for base pay

        // Test case for Contractor C
        System.out.println("\nContractor C:");
        company.calculatePay(35000, 96); // Expected Outcome: Error message for hours worked
    }
}