package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

public class DisplayControl implements Initializable {
    public TextField nameTextField;
    public TextField addressField;
    public TextField provinceTextField;
    public TextField cityTextField;
    public TextField postCodeTextField;
    public TextField phoneNumberTextField;
    public TextField emailTextField;
    public RadioButton studentCouncil;
    public RadioButton volunteerWork;
    public ComboBox classComb;
    public ScrollPane content;
    public Button display;
    public RadioButton computerScience;
    public RadioButton business;
    public ListView<String> classList;
    public TextArea contentText;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup subjectGroup = new ToggleGroup();
        computerScience.setToggleGroup(subjectGroup);
        business.setToggleGroup(subjectGroup);
    }
    public Student getAllInformation(){
        Student student = new Student();
        student.setName(nameTextField.getText());
        student.setAddress(addressField.getText());
        student.setProvince(provinceTextField.getText());
        student.setCity(cityTextField.getText());
        student.setPostCode(postCodeTextField.getText());
        student.setPhoneNum(phoneNumberTextField.getText());
        student.setEmail(emailTextField.getText());
        if(studentCouncil.isSelected()){
            student.setStuCouncil(true);
        }else {
            student.setStuCouncil(false);
        }
        if(volunteerWork.isSelected()){
            student.setVolunteer(true);
        }else {
            student.setVolunteer(false);
        }
        if (computerScience.isSelected()){
            student.setSubject("Computer Science");
        }else {
            student.setSubject("Business");
        }
        int claassSize = classList.getItems().size();
        for (int i=0;i<claassSize;i++){
            String classitem = classList.getItems().get(i);
            student.getStuClasses().add(classitem);
        }
        return student;
    }
    public void handleSubmitButtonAction(javafx.event.ActionEvent actionEvent) {
//        System.out.println("123");
        Student student = getAllInformation();
//        System.out.println(student.stuToString());
        contentText.setText(student.stuToString());
    }
    public void clssCombChanged(ActionEvent actionEvent) {
        HashSet<String> classes = new HashSet<>();
        if(!classList.getItems().contains(classComb.getValue().toString())){
            classList.getItems().add(classComb.getValue().toString());
        }
//        System.out.println(classComb.getValue().toString());
//        System.out.println(classList.getItems());
    }
}