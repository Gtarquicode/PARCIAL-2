/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;
/**
 *
 * @author juane
 */
// Excepción personalizada para campos vacíos
public class CampoVacioException extends Exception {
    public CampoVacioException(String mensaje) {
        super(mensaje); // Llama al constructor de Exception con el mensaje
    }
}
