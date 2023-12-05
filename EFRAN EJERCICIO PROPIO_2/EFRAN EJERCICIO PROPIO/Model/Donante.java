package Model;


import java.util.Date;

public class Donante extends Persona{
    private double amountDonation; //Nuevo atributo

    public Donante(String name, String lastName, Long DNI, Date birthdate, String location, int age, String profession, String status, double amountDonation) {
        super(name, lastName, DNI, birthdate, location, age, profession, status);
        this.amountDonation = amountDonation;
    }

    public double getAmountDonation() {
        return amountDonation;
    }

    public void setAmountDonation(double amountDonation) {
        this.amountDonation = amountDonation;
    }

    public void doDonation(double amount){
        amountDonation+=amount;//amountDonation=amountDonation+amount;
        System.out.println("Donation done by "+getName() + ": $"+amount);
        //Donation done by Chris: $100
    }
}
