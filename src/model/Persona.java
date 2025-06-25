/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author juane
 */
import java.io.Serializable;
// Clase abstracta que representa una persona general (médico o paciente)
public abstract class Persona implements Serializable {
    protected String nombre;
    protected String id;

    // Constructor
    public Persona(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    // Métodos comunes
    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    // Método abstracto para mostrar información (se implementa en las subclases)
    public abstract String getInfo();
}
