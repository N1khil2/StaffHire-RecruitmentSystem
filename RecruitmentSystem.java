import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RecruitmentSystem implements ActionListener {
    private JFrame frame;
    private JTextField vacancyField, designationField, jobTypeField, staffNameField, joiningDateField,
            qualificationField, appointedByField, salaryField, weeklyHoursField,
            workingHoursField, wagesPerHourField, shiftsField, displayNumberField;
    private JButton addFullTimeBtn, addPartTimeBtn, setSalaryBtn, setShiftsBtn,
            terminateBtn, displayBtn, clearBtn;

    private ArrayList<StaffHire> staffList = new ArrayList<>();

    public RecruitmentSystem() {
        frame = new JFrame("Recruitment System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLayout(new BorderLayout(10, 10));
        
        // Creates and adds inputs
        JPanel formPanel = new JPanel(new GridLayout(13, 2, 5, 5));
        vacancyField = addLabeledField("Vacancy Number:", formPanel);
        designationField = addLabeledField("Designation:", formPanel);
        jobTypeField = addLabeledField("Job Type:", formPanel);
        staffNameField = addLabeledField("Staff Name:", formPanel);
        joiningDateField = addLabeledField("Joining Date:", formPanel);
        qualificationField = addLabeledField("Qualification:", formPanel);
        appointedByField = addLabeledField("Appointed By:", formPanel);
        salaryField = addLabeledField("Salary:", formPanel);
        weeklyHoursField = addLabeledField("Weekly Hours:", formPanel);
        workingHoursField = addLabeledField("Working Hours:", formPanel);
        wagesPerHourField = addLabeledField("Wages Per Hour:", formPanel);
        shiftsField = addLabeledField("Shifts:", formPanel);
        displayNumberField = addLabeledField("Display Number:", formPanel);
        
        // Centers the form pannel
        frame.add(formPanel, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        addFullTimeBtn = addButton("Add Full Time Staff", buttonPanel);
        addPartTimeBtn = addButton("Add Part Time Staff", buttonPanel);
        setSalaryBtn = addButton("Set Salary", buttonPanel);
        setShiftsBtn = addButton("Set Working Shifts", buttonPanel);
        terminateBtn = addButton("Terminate Part Time Staff", buttonPanel);
        displayBtn = addButton("Display Number", buttonPanel);
        JButton displayAllBtn = addButton("Display All Staff", buttonPanel);
        clearBtn = addButton("Clear", buttonPanel);
        
        // Add the button panel to the bottom
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
    
    private JTextField addLabeledField(String label, JPanel panel) {
    JLabel jLabel = new JLabel(label);
    JTextField textField = new JTextField();
    panel.add(jLabel);
    panel.add(textField);
    return textField;
    }    

    private JButton addButton(String text, JPanel panel) {
    JButton button = new JButton(text);
    button.addActionListener(this);
    panel.add(button);
    return button;
    }
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Clear")) {
            clearFields();
        } else if (command.equals("Display Number")) {
            int index = getDisplayIndex();
            if (index != -1 && index < staffList.size()) {
                staffList.get(index).display();
            }
        } else if (command.equals("Add Full Time Staff")) {
            try {
                int vacancyNumber = Integer.parseInt(vacancyField.getText());
                String designation = designationField.getText();
                String jobType = jobTypeField.getText();
                String staffName = staffNameField.getText();
                String joiningDate = joiningDateField.getText();
                String qualification = qualificationField.getText();
                String appointedBy = appointedByField.getText();
                double salary = Double.parseDouble(salaryField.getText());
                int weeklyHours = Integer.parseInt(weeklyHoursField.getText());

                FullTimeStaffHire fullTime = new FullTimeStaffHire(
                        vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, true, salary, weeklyHours
                );
                staffList.add(fullTime);
                JOptionPane.showMessageDialog(frame, "Full-time staff added successfully.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numeric values.");
            }
        } else if (command.equals("Add Part Time Staff")) {
            try {
                int vacancyNumber = Integer.parseInt(vacancyField.getText());
                String designation = designationField.getText();
                String jobType = jobTypeField.getText();
                String staffName = staffNameField.getText();
                String joiningDate = joiningDateField.getText();
                String qualification = qualificationField.getText();
                String appointedBy = appointedByField.getText();
                int workingHours = Integer.parseInt(workingHoursField.getText());
                double wagesPerHour = Double.parseDouble(wagesPerHourField.getText());
                String shifts = shiftsField.getText();

                PartTimeStaffHire partTime = new PartTimeStaffHire(
                        vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, true, workingHours, wagesPerHour, shifts
                );
                staffList.add(partTime);
                JOptionPane.showMessageDialog(frame, "Part-time staff added successfully.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numeric values.");
            }
        } else if (command.equals("Set Salary")) {
            try {
                int index = getDisplayIndex();
                if (index != -1 && staffList.get(index) instanceof FullTimeStaffHire) {
                    double newSalary = Double.parseDouble(salaryField.getText());
                    ((FullTimeStaffHire) staffList.get(index)).setSalary(newSalary);
                    JOptionPane.showMessageDialog(frame, "Salary updated successfully.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Enter a valid number for salary.");
            }
        } else if (command.equals("Set Working Shifts")) {
            try {
                int index = getDisplayIndex();
                if (index != -1 && staffList.get(index) instanceof PartTimeStaffHire) {
                    String newShift = shiftsField.getText();
                    ((PartTimeStaffHire) staffList.get(index)).setShifts(newShift);
                    JOptionPane.showMessageDialog(frame, "Shift updated successfully.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Unable to set shift.");
            }
        } else if (command.equals("Terminate Part Time Staff")) {
            int index = getDisplayIndex();
            if (index != -1 && staffList.get(index) instanceof PartTimeStaffHire) {
                ((PartTimeStaffHire) staffList.get(index)).terminateStaff();
                JOptionPane.showMessageDialog(frame, "Part-time staff terminated.");
            }
        } else if (command.equals("Display All Staff")) {
            if (staffList.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No staff to display.");
            } else {
        StringBuilder allStaffInfo = new StringBuilder();
        for (int i = 0; i < staffList.size(); i++) {
            StaffHire staff = staffList.get(i);
            allStaffInfo.append("Staff #").append(i).append(":\n");

            // Collect basic info
            allStaffInfo.append("Vacancy Number: ").append(staff.getVacancyNumber()).append("\n");
            allStaffInfo.append("Designation: ").append(staff.getDesignation()).append("\n");
            allStaffInfo.append("Job Type: ").append(staff.getJobType()).append("\n");
            allStaffInfo.append("Staff Name: ").append(staff.getStaffName()).append("\n");
            allStaffInfo.append("Joining Date: ").append(staff.getJoiningDate()).append("\n");
            allStaffInfo.append("Qualifications: ").append(staff.getQualification()).append("\n");
            allStaffInfo.append("Appointed By: ").append(staff.getAppointedBy()).append("\n");
            allStaffInfo.append("Joined: ").append(staff.getJoined()).append("\n");

            // Extra info based on type
            if (staff instanceof FullTimeStaffHire) {
                FullTimeStaffHire fullTime = (FullTimeStaffHire) staff;
                allStaffInfo.append("Salary: ").append(fullTime.getSalary()).append("\n");
                allStaffInfo.append("Weekly Hours: ").append(fullTime.getWeeklyFractionalHours()).append("\n");
            } else if (staff instanceof PartTimeStaffHire) {
                PartTimeStaffHire partTime = (PartTimeStaffHire) staff;
                allStaffInfo.append("Working Hours: ").append(partTime.getWorkingHour()).append("\n");
                allStaffInfo.append("Wages Per Hour: ").append(partTime.getWagesPerHour()).append("\n");
                allStaffInfo.append("Shifts: ").append(partTime.getShifts()).append("\n");
                allStaffInfo.append("Terminated: ").append(partTime.isTerminated()).append("\n");
                allStaffInfo.append("Income Per Day: ").append(partTime.getWorkingHour() * partTime.getWagesPerHour()).append("\n");
            }

            allStaffInfo.append("----------------------------------------\n");
        }

        JTextArea textArea = new JTextArea(allStaffInfo.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));
        JOptionPane.showMessageDialog(frame, scrollPane, "All Staff Details", JOptionPane.INFORMATION_MESSAGE);
    }
    }
    }

    private void clearFields() {
        vacancyField.setText("");
        designationField.setText("");
        jobTypeField.setText("");
        staffNameField.setText("");
        joiningDateField.setText("");
        qualificationField.setText("");
        appointedByField.setText("");
        salaryField.setText("");
        weeklyHoursField.setText("");
        workingHoursField.setText("");
        wagesPerHourField.setText("");
        shiftsField.setText("");
        displayNumberField.setText("");
    }

    private int getDisplayIndex() {
        try {
            int index = Integer.parseInt(displayNumberField.getText());
            if (index >= 0 && index < staffList.size()) {
                return index;
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid index range.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid integer index.");
        }
        return -1;
    }

    public static void main(String[] args) {
        new RecruitmentSystem();
    }
}
