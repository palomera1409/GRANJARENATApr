package isic.tala.tec.granjarenata;

/**
 * Created by Palomera on 13/09/2018.
 */
public class Parametros {

    private int Id_Cerdos;
    private String Raza;
    private String Linea;
    private String Nombre;
    private String Edad;
    private String imagen;
    private String existencia_de_dosis;
    private String descripcion;



    public int getId_Cerdos() {
        return Id_Cerdos;
    }

    public void setId_Cerdos(int id_Cerdos) {
        Id_Cerdos = id_Cerdos;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String raza) {
        Raza = raza;
    }

    public String getLinea() {
        return Linea;
    }



    public void setLinea(String linea) {
        Linea = linea;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getExistencia_de_dosis() {
        return existencia_de_dosis;
    }

    public void setExistencia_de_dosis(String existencia_de_dosis) {
        this.existencia_de_dosis = existencia_de_dosis;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Parametros{" +
                "Id_Cerdos=" + Id_Cerdos +
                ", Raza='" + Raza + '\'' +
                ", Linea='" + Linea + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Edad='" + Edad + '\'' +
                ", imagen='" + imagen + '\'' +
                ", existencia_de_dosis='" + existencia_de_dosis + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}


