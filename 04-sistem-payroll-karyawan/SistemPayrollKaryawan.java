import java.util.ArrayList;
import java.util.List;

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
 
public class SistemPayrollKaryawan {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new FullTimeEmployee("FT-01",  "budi", 10_000_000, 2_000_000));
        employeeList.add(new Intern("INT-01", "adan", 40, 50_000));

        System.out.println("GENERATING PAYROLL...\n");

        for (Employee emp : employeeList) {
            emp.printSlipHeader();

            double grossSalary = emp.calculateSalary();
            double tax = 0;

            if (emp instanceof Taxable) {
                Taxable taxableEmp = (Taxable) emp; //casting
                tax = taxableEmp.calculateTax(grossSalary);
                System.out.println("Tipe: karyawan kena pajak");
            } else {
                System.out.println("Tipe: Bebas pajak");
            }

            double netSalary = grossSalary - tax;

            System.out.println("Gaji Kotor: Rp " + (long) grossSalary);
            System.out.println("Potongan: Rp " + (long) tax);
            System.out.println("Gaji Bersih: Rp " + (long) netSalary);
            System.out.println();
        }
    }
}