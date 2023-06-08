package org.example.Modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Princesas {
    private int id;
    private String nombre;
    private String edad;
    private String principe;
    private String lugar;
    private String url;

    public Princesas() {
    }

    public Princesas(int id, String nombre, String edad, String principe, String lugar, String url) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.principe = principe;
        this.lugar = lugar;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPrincipe() {
        return principe;
    }

    public void setPrincipe(String principe) {
        this.principe = principe;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Princesas{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", principe='" + principe + '\'' +
                ", lugar='" + lugar + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public ImageIcon getImagenPrincesa() throws MalformedURLException {
        URL urlPrincesa = new URL(this.url);
        return new ImageIcon(urlPrincesa);
    }
}
