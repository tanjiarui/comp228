package exe2;

public abstract class GameTester {
    public String name;
    public boolean isFullTime;

    public String getName() {
        return name;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public abstract float getSalary();
}
