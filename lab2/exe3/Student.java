package exe3;

public class Student extends Human{
    private static void information(int age){
        System.out.println("The student is "+age+" years old.");
    }
    private static void information(int age,String name){
        System.out.println("The student is "+age+" years old. His name is "+name+".");
    }
    private static void information(int age,String name,String hometown){
        System.out.println("The student is "+age+" years old. His name is "+name+". His hometown is "+hometown+".");
    }

    public static void main(String[] args) {
        Student.information(12);
        Student.information(13);
        Student.information(12,"Jack");
        Student.information(13,"Mike");
        Student.information(14,"Jack","NY");
        Student.information(13,"Mike","LA");
    }
}