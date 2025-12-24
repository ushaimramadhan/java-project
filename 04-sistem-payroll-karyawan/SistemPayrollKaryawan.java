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