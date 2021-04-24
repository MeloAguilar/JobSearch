package Clases;

public class Solicitud {

    private Empresa empresa;
    private String informaccionAdicional;
    private Profesional profesional;

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Solicitud(Profesional profesional, Empresa empresa, String informaccionAdicional) {
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
}
