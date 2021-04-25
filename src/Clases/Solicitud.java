package Clases;

public class Solicitud {

    private Empresa empresa;
    private static int numeroSolicitud = 0;
    private String informaccionAdicional;
    private Profesional profesional;

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Solicitud(Profesional profesional, Empresa empresa, String informaccionAdicional) {
        numeroSolicitud++;
        this.profesional = profesional;
        this.empresa = empresa;
        this.informaccionAdicional = informaccionAdicional;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getInformaccionAdicional() {
        return informaccionAdicional;
    }

    public void setInformaccionAdicional(String informaccionAdicional) {
        this.informaccionAdicional = informaccionAdicional;
    }

    @Override
    public String toString() {
        return "\nSolicitud número: " + this.numeroSolicitud +
                "\n***********************************************************" +
                "\nEmpresa: " + empresa +
                "\nInformaccion Adicional del solicitante: \n" + informaccionAdicional +
                "\nProfesional solicitante: \n" + profesional +
                "\n***********************************************************";
    }
}
