
package acuarela.modelo;

import java.io.InputStream;

public class Obra {
   int id_obra;
   String titulo;
   String descripcion;
   InputStream imagen;
   Double precio;
    public Obra (){
        
    }
    public Obra(int id_obra, String titulo, String descripcion, InputStream imagen, Double precio) {
        this.id_obra = id_obra;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
    }

    public int getId_obra() {
        return id_obra;
    }

    public void setId_obra(int id_obra) {
        this.id_obra = id_obra;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public InputStream getImagen() {
        return imagen;
    }

    public void setImagen(InputStream imagen) {
        this.imagen = imagen;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
