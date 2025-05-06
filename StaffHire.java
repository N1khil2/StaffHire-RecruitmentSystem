//Supercalss StaffHire holds all the common attributes for all hired staff
public class StaffHire {
    // Protected Attributes that only subclasses have access to
    protected int vacancyNumber;
    protected String designation;
    protected String jobType;
    protected String staffName;
    protected String joiningDate;
    protected String qualifications;
    protected String appointedBy;
    protected boolean joined;

    // Constructor
    public StaffHire(int vacancyNumber, String designation, String jobType, String staffName,
                     String joiningDate, String qualifications, String appointedBy, boolean joined) {
        this.vacancyNumber = vacancyNumber;
        this.designation = designation;
        this.jobType = jobType;
        this.staffName = staffName;
        this.joiningDate = joiningDate;
        this.qualifications = qualifications;
        this.appointedBy = appointedBy;
        this.joined = joined;
    }
    
    // Getters
    public int getVacancyNumber() {
        return vacancyNumber;
    }

    public String getDesignation() {
        return designation;
    }

    public String getJobType() {
        return jobType;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public String getQualification() {
        return qualifications;
    }

    public String getAppointedBy() {
        return appointedBy;
    }

    public boolean getJoined() {
        return joined;
    }

    // Setters
    public void setVacancyNumber(int vacancyNumber) {
        this.vacancyNumber = vacancyNumber;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public void setAppointedBy(String appointedBy) {
        this.appointedBy = appointedBy;
    }

    public void setJoined(boolean joined) {
        this.joined = joined;
    }

    // Display Method
    public void display() {
        System.out.println("Vacancy Number: " + vacancyNumber);
        System.out.println("Designation: " + designation);
        System.out.println("Job Type: " + jobType);
        System.out.println("Staff Name: " + staffName);
        System.out.println("Joining Date: " + joiningDate);
        System.out.println("Qualifications: " + qualifications);
        System.out.println("Appointed By: " + appointedBy);
        System.out.println("Joined: " + joined);
    }
}
