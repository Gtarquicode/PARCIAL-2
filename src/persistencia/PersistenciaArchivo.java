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
import java.io.*;

// Clase que guarda y carga datos de la clínica usando archivos .ser
public class PersistenciaArchivo implements IPersistencia {
    private final String archivo = "clinica.ser"; // Nombre del archivo

    @Override
    public void guardar(Clinica clinica) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(clinica); // Guarda todo el objeto
        }
    }

    @Override
    public Clinica cargar() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Clinica) ois.readObject(); // Carga el objeto
        }
    }
}