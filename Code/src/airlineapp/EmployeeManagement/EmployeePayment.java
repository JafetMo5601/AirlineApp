package airlineapp.EmployeeManagement;

import javax.swing.JOptionPane;

final class EmployeePayment {
    private double salary;
    private double taxes;
    private double comision;
    private double salPerHour;
    private int workHours;
    private double total;

    public void calculateSalary() {
        workHours = 8;
        salPerHour = 2.000;
        salPerHour = 1.608;
        salary = (salPerHour * (workHours * 2));
        taxes = (10.5 * salary) / 100;
        comision = (10 * salary) / 100;
        total = (salary - taxes - comision);

        JOptionPane.showMessageDialog(null,
                "\nSalary per hour " + salPerHour
                + "\nWork hours: " + workHours
                + "\nTaxes to pay: " + taxes + "%"
                + "\nComision to pay: " + comision + "%"
                + "\nNet salary to pay: " + salary
                + "\nSalary to pay: " + total
                + -1);
    }

    public void showSalary() {
        System.out.println("\nPlease, choose your work position");
        Object[] options = {"Administradors", "Vendors"};
        Object optionChoose = JOptionPane.showInputDialog(null, "Employ Payment Management", "Please, choose an option",
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (optionChoose.equals("Administradors")) {
            EmployeePayment em = new EmployeePayment();
            em.calculateSalary();
        } else if (optionChoose.equals("Vendors")) {
            EmployeePayment em = new EmployeePayment();
            em.calculateSalary();
        } else {
            System.out.println("Option not valid");
        }
    }

    public void paySalary() {
    }

}
