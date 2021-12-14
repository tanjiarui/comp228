import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javax.swing.*;
import java.sql.*;

public class Main extends Application
{
    /**
     * Database variables
     * */
    static final String driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/db";
    static final String user = "root";
    static final String password = "";

    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("employee");
        //GUI JavaFX variables
        Label label_id = new Label("employee’s id");
        TextField input_text = new TextField();
        Label label_name = new Label("employee’s name");
        TextField name_text = new TextField();
        name_text.setEditable(false);
        Label label_gross = new Label("employee’s gross income");
        TextField gross_text = new TextField();
        gross_text.setEditable(false);
        Label label_net = new Label("employee’s net income");
        TextField net_text = new TextField();
        net_text.setEditable(false);
        Button display = new Button("Display");
        Button reset = new Button("Reset");
        Button delete = new Button("Delete");
        Button quit = new Button("Quit");
        GridPane layout = new GridPane();
        //Add event listener on Button
        display.setOnAction(event ->
        {
            try {
                String input = input_text.getText();
                //connect to database
                Class.forName(driver);
                System.out.println("connecting to database...");
                Connection connect = DriverManager.getConnection(url,user,password);
                System.out.println("statement created...");
                Statement state = connect.createStatement();
                String sql = "select * from employee where id = "+input;
                ResultSet result = state.executeQuery(sql);
                if(result.next())
                {
                    result = state.executeQuery(sql);
                    //parse the query
                    while(result.next())
                    {
                        String name = result.getString("name");
                        float monthly_salary = result.getFloat("monthly_salary");
                        float net_salary=monthly_salary-monthly_salary*(float).3;
                        name_text.setText(name);
                        gross_text.setText(Float.toString(monthly_salary));
                        net_text.setText(Float.toString(net_salary));
                    }
                }
                else JOptionPane.showMessageDialog(null,"no such record");
                //free connection
                result.close();
                state.close();
                connect.close();
            }catch(SQLException | ClassNotFoundException exception){
                JOptionPane.showMessageDialog(null, "look at console for error details...");
                System.out.println(exception.getMessage());
            }
        });
        reset.setOnAction(event ->
        {
            input_text.clear();
            name_text.clear();
            gross_text.clear();
            net_text.clear();
        });
        delete.setOnAction(event ->
        {
            try {
                String input = input_text.getText();
                //connect to database
                Class.forName(driver);
                System.out.println("connecting to database...");
                Connection connect = DriverManager.getConnection(url,user,password);
                System.out.println("statement created...");
                Statement state = connect.createStatement();
                String sql = "select * from employee where id = "+input;
                ResultSet result = state.executeQuery(sql);
                if(result.next())
                {
                    sql = "delete from employee where id = " + input;
                    state.execute(sql);
                }
                else JOptionPane.showMessageDialog(null,"no such record");
                //free connection
                result.close();
                state.close();
                connect.close();
            }catch(SQLException | ClassNotFoundException exception){
                JOptionPane.showMessageDialog(null, "look at console for error details...");
                System.out.println(exception.getMessage());
            }
        });
        quit.setOnAction(event->Platform.exit());
        //Add components to the gridPaneLayout
        layout.add(label_id, 0, 0);
        GridPane.setHalignment(label_id, HPos.LEFT);
        layout.add(input_text,1,0);
        GridPane.setHalignment(input_text, HPos.RIGHT);
        layout.add(display,1,1);
        GridPane.setHalignment(display, HPos.RIGHT);
        layout.add(label_name, 0, 2);
        GridPane.setHalignment(label_name, HPos.LEFT);
        layout.add(name_text,1,2);
        GridPane.setHalignment(name_text, HPos.RIGHT);
        layout.add(label_gross,0,3);
        GridPane.setHalignment(label_gross, HPos.LEFT);
        layout.add(gross_text,1,3);
        GridPane.setHalignment(gross_text, HPos.RIGHT);
        layout.add(label_net,0,4);
        GridPane.setHalignment(label_net, HPos.LEFT);
        layout.add(net_text,1,4);
        GridPane.setHalignment(net_text, HPos.RIGHT);
        layout.add(reset,0,5);
        GridPane.setHalignment(reset, HPos.LEFT);
        layout.add(delete,1,5);
        GridPane.setHalignment(delete, HPos.CENTER);
        layout.add(quit,2,5);
        GridPane.setHalignment(quit, HPos.RIGHT);
        //Set the gridPaneLayout properly
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(14, 14, 14, 14));
        layout.setHgap(6.0);
        layout.setVgap(6.0);
        //Setting the primaryStage and show it
        primaryStage.setScene(new Scene(layout, 400, 350));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
