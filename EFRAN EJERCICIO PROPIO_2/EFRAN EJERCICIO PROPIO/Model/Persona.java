package Model;

import java.util.Date;

public class Persona {
    private String name;
    private String lastName;

    private Long DNI;
    private Date birthdate;
    private String location;
    private int age;
    private String profession;
    private String status;

    public Long getDNI() {
        return DNI;
    }

    public void setDNI(Long DNI) {
        this.DNI = DNI;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Persona(String name, String lastName, Long DNI, Date birthdate, String location, int age, String profession, String status) {
        this.name = name;
        this.lastName = lastName;
        this.DNI = DNI;
        this.birthdate = birthdate;
        this.location = location;
        this.age = age;
        this.profession = profession;
        this.status = status;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public Date getBirthdate(){
        return birthdate;
    }

    public void setBirthdate(Date birthdate){
        this.birthdate=birthdate;
        this.age=calcularEdad(birthdate);
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location=location;
    }

    public int getAge(){
        return age;
    }

    public String getProfession(){
        return profession;
    }

    public void setProfession(String profession){
        this.profession=profession;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status=status;
    }

    private int calcularEdad(Date birthdate){
        Date currentDate=new Date();
        int edad=currentDate.getYear()-birthdate.getYear();
        return edad;
    }

}
