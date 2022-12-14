package model;

public class ElectiveModule extends Module{
    private String departmentName;

    public ElectiveModule(String name, int semester, int credits, String departmentName) {
        super(name, semester, credits);
        this.departmentName = departmentName;
    }
}
