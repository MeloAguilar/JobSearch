package Clases;

import java.util.Objects;

public class Solicitud {

    /**
     * todo En realidad se podría poner en Profesional ya que realmente es ekl Profesional quien envia
     */
    private Empresa empresa;
    private static int numeroSolicitud = 0;
    private String informaccionAdicional;
    private String puestoSolicitado;
    private Profesional profesional;

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Solicitud(Profesional profesional, Empresa empresa, String informaccionAdicional, String puestoSolicitado) {
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
    public int getNumeroSolicitud() {
        return numeroSolicitud;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solicitud)) return false;
        Solicitud solicitud = (Solicitud) o;
        return Objects.equals (getNumeroSolicitud ( ), solicitud.getNumeroSolicitud ( ));
    }

    @Override
    public int hashCode() {
        return Objects.hash (getProfesional ( ));
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
