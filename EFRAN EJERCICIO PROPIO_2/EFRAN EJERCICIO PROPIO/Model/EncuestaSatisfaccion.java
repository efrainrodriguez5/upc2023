package Model;

public class EncuestaSatisfaccion implements Evaluable{
    private int Satisfactionpercentage;
    private String comment; // Nuevo atributo

    public EncuestaSatisfaccion(int Satisfactionpercentage, String commment){
        this.Satisfactionpercentage=Satisfactionpercentage;
        this.comment=commment;
    }

    public int getSatisfactionpercentage() {
        return Satisfactionpercentage;
    }

    public void setSatisfactionpercentage(int satisfactionpercentage) {
        Satisfactionpercentage = satisfactionpercentage;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public void evaluar() {
        System.out.println("Encuesta evaluada con un porcentaje de satisfacción del " + Satisfactionpercentage + "%");
    }
}
