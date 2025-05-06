public class PartTimeStaffHire extends StaffHire {
    // Additional attributes
    private int workingHours;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;

    // Constructor
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName,String joiningDate, String qualifications, String appointedBy, boolean joined,
                             int workingHours, double wagesPerHour, String shifts) 
    {
        // Call to superclass constructor
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualifications, appointedBy, joined);
        this.workingHours = workingHours;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;
    }

    // Getters
    public int getWorkingHour() {
        return workingHours;
    }

    public double getWagesPerHour() {
        return wagesPerHour;
    }

    public String getShifts() {
        return shifts;
    }

    public boolean isTerminated() {
        return terminated;
    }

    // Setters
    public void setWorkingHours(int workingHours) {
        this.workingHours= workingHours;
    }

    public void setWagesPerHour(double wagesPerHour) {
        this.wagesPerHour = wagesPerHour;
    }
    
    
    // Set shifts if not joined
    public void setShifts(String newShifts) {
        if (!getJoined()) {
            this.shifts = newShifts;
            System.out.println("Shifts updated to: " + newShifts);
        } else {
            System.out.println("Cannot change shifts after the staff has joined.");
        }
    }

    // Terminate method
    public void terminateStaff() {
        if (terminated) {
            System.out.println("Staff already terminated.");
        } else {
            setStaffName("");
            setJoiningDate("");
            setQualifications("");
            setAppointedBy("");
            setJoined(false);
            terminated = true;
            System.out.println("Part-time staff has been terminated.");
        }
    }

    // Override display
    @Override
    public void display() {
        super.display();
        if (!getStaffName().equals("")) {
            System.out.println("Working Hour per day: " + workingHours);
            System.out.println("Wages Per Hour: " + wagesPerHour);
            System.out.println("Shifts: " + shifts);
            System.out.println("Terminated: " + terminated);
            System.out.println("Income Per Day: " + (workingHours * wagesPerHour));
        }
    }
}
