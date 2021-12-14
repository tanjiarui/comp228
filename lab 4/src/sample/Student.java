package sample;

import java.util.ArrayList;
import java.util.HashSet;

public class Student {
    String name;
    String address;
    String province;
    String city;
    String postCode;
    String phoneNum;
    String email;
    boolean stuCouncil = false;
    boolean volunteer = false;
    String subject;
    ArrayList<String> stuClasses = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStuCouncil() {
        return stuCouncil;
    }

    public void setStuCouncil(boolean stuCouncil) {
        this.stuCouncil = stuCouncil;
    }

    public boolean isVolunteer() {
        return volunteer;
    }

    public void setVolunteer(boolean volunteer) {
        this.volunteer = volunteer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ArrayList<String> getStuClasses() {
        return stuClasses;
    }

    public void setStuClasses(ArrayList<String> stuClasses) {
        this.stuClasses = stuClasses;
    }

    public String stuToString(){
        StringBuffer stuToString = new StringBuffer();
        stuToString=stuToString.append(this.name+","+this.address+","+this.province+","+this.city+","+this.postCode+","+this.phoneNum+","
                +this.email+"\n"+"course:");
        for (String s: this.stuClasses){
            stuToString.append(s);
            stuToString.append("\n");
        }
        stuToString.append("Major:"+this.subject+"/n");
        if (stuCouncil){
            stuToString.append("Student council \n");
        }
        if(volunteer){
            stuToString.append("Volunteer");
        }
        return stuToString.toString();
    }


}
