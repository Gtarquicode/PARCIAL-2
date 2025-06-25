/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author juane
 */
// Clase Paciente que hereda de Persona
public class Paciente extends Persona {

    public Paciente(String nombre, String id) {
        super(nombre, id); // Llama al constructor de Persona
    }

    // Implementación del método abstracto
    @Override
    public String getInfo() {
        return "Paciente: " + nombre + " (ID: " + id + ")";
    }
}
