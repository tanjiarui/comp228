package exe2;

public class PartTimeGameTester extends GameTester{
    public float time;

    public PartTimeGameTester() {
        this.name = "PartTimeGameTester";
        this.isFullTime = false;
        this.time = 0;
    }

    public void setTime(float time) {
        this.time = time;
    }

    @Override
    public float getSalary() {
        return 20*time;
    }
}