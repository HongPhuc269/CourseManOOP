package model;

public class Module {
    private String code;
    private String name;
    private int semester;
    private int credits;
    private static int id = 1;

    public Module(String name, int semester, int credits) {
        generateModuleCode(semester);
        this.name = name;
        this.semester = semester;
        this.credits = credits;
    }

    public void generateModuleCode(int s) {
        if (id > 9) {
            this.code = "m" + s + id;
        } else if (1 <= id && id <= 9) {
            this.code = "m" + s + "0" + id;
        } else {
            System.out.println("Invalid number code");
        }
        id++;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Module{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", semester=" + semester +
                ", credits=" + credits +
                '}';
    }

}
