/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;
/**
 *
 * @author juane
 */
import model.Clinica;
import java.io.IOException;

// Interfaz para manejar la persistencia de datos
public interface IPersistencia {
    void guardar(Clinica clinica) throws IOException;
    Clinica cargar() throws IOException, ClassNotFoundException;
}