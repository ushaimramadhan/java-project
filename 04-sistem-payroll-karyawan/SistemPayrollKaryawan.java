interface Taxable {
    double getTaxRate();
    double calculateTax(double grossSalary);
}

abstract class Employee {
    private String id;
    private String name;

    public Employee (String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public abstract double calculateSalary();

    public void printSlipHeader() {
        System.out.println("Slip Gaji " + name + " (" + id + ")");
    }
}

class FullTimeEmployee extends Employee implements Taxable {
    private double baseSalary;
    private double bonus;
    
    public FullTimeEmployee(String id, String name, double baseSalary, double bonus) {
        super(id, name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    @Override
    public double getTaxRate() {
        return 0.10;
    }

    @Override
    public double calculateTax(double grossSalary) {
        return grossSalary * getTaxRate();
    }
}

class Intern extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public Intern(String id, String name, int hoursWorked, double hourlyRate){
        super(id, name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}