public class FullTimeStaffHire extends StaffHire {
    // Adding more attributes
    private double salary;
    private int weeklyFractionalHours;

    // Constructors
    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType,String staffName, String joiningDate, String qualifications,
                         String appointedBy, boolean joined, double salary, int weeklyFractionalHours) {
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualifications, appointedBy, joined);  // Call to StaffHire constructor
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    // Getter methods
    public double getSalary() {
        return salary;
    }

    public int getWeeklyFractionalHours() {
        return weeklyFractionalHours;
    }

    // Setter methods
    public void setSalary(double newSalary) {
        this.salary = newSalary;
        System.out.println("Salary updated to: " + newSalary);
    }

    public void setWeeklyFractionalHours(int newWeeklyHours) {
        this.weeklyFractionalHours = newWeeklyHours;
        System.out.println("Weekly fractional hours updated to: " + newWeeklyHours);
    }

    // Display method
    @Override
    public void display() {
        super.display();  // Calls display from StaffHire
        System.out.println("Salary: " + salary);
        System.out.println("Weekly Fractional Hours: " + weeklyFractionalHours);
    }
}
