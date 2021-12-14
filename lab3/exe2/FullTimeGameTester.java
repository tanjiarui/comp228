package exe2;

public class FullTimeGameTester extends GameTester {
    public FullTimeGameTester() {
        this.name = "FullTImeGameTester";
        this.isFullTime = true;
    }

    @Override
    public float getSalary() {
        return 3000;
    }
}