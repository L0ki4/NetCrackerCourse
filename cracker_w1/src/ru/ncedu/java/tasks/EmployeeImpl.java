package ru.ncedu.java.tasks;

public class EmployeeImpl implements Employee {

    private int salary = 1000;
    private String firstName = "a";
    private String lastName = "a";
    private Employee manager = this;

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void increaseSalary(int value) {
        salary += value;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
     }

    @Override
    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public String getManagerName() {
        if(manager == this){
            return "No manager";
        }
        return manager.getFullName();
    }

    @Override
    public Employee getTopManager() {
        if (manager != this){
            return manager.getTopManager();
        }
        return this;
    }
}
