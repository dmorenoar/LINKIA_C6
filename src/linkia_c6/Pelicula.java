/*
 * Clase Pelicula utilizada para guardar información en un fichero XML.
 */
package linkia_c6;

import java.io.Serializable;

/**
 *
 * @author Daniel Moreno
 */
public class Pelicula implements Serializable{
    private String titulo;
    private String director;
    private int anyo;
    private String genero;

    public Pelicula() {
    }

    public Pelicula(String titulo, String director, int anyo, String genero) {
        this.titulo = titulo;
        this.director = director;
        this.anyo = anyo;
        this.genero = genero;
    }

    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", director=" + director + ", anyo=" + anyo + ", genero=" + genero + '}';
    }
}
