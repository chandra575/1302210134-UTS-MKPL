package lib;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import lib.children.Child;

public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private int yearJoined;
    private int monthJoined;
    private boolean isForeigner;
    private boolean isMale;
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;
    private String spouseIdNumber;
    private List<Child> children;

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, int yearJoined, int monthJoined, boolean isForeigner, boolean isMale) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.yearJoined = yearJoined;
        this.monthJoined = monthJoined;
        this.isForeigner = isForeigner;
        this.isMale = isMale;
        this.children = new LinkedList<>();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYearJoined() {
        return yearJoined;
    }

    public void setYearJoined(int yearJoined) {
        this.yearJoined = yearJoined;
    }

    public int getMonthJoined() {
        return monthJoined;
    }

    public void setMonthJoined(int monthJoined) {
        this.monthJoined = monthJoined;
    }

    public boolean isForeigner() {
        return isForeigner;
    }

    public void setForeigner(boolean foreigner) {
        isForeigner = foreigner;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
	
	public void setMonthlySalary(int grade) {    
        switch (grade) {
            case 1:
                monthlySalary = isForeigner ? 4500000 : 3000000;
                break;
            case 2:
                monthlySalary = isForeigner ? 7500000 : 5000000;
                break;
            case 3:
                monthlySalary = isForeigner ? 10500000 : 7000000;
                break;
            default:
                break;
        }
    }

    public void setAnnualDeductible(int deductible) {    
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {    
        this.otherMonthlyIncome = income;
    }

    public int getAnnualIncomeTax() {
        LocalDate date = LocalDate.now();
        
        int monthWorkingInYear;
        if (date.getYear() == yearJoined) {
            monthWorkingInYear = date.getMonthValue() - monthJoined;
        } else {
            monthWorkingInYear = 12;
        }

        return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, !spouseIdNumber.isEmpty(), children.size());
    }
}