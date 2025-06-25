/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;
/**
 *
 * @author juane
 */
import model.*;
import excepciones.*;
import java.util.List;

// Esta es la clase que conecta la interfaz gráfica con la lógica
public class ClinicaViewModel {
    private Clinica clinica; // Composición: tiene una clínica

    public ClinicaViewModel() {
        this.clinica = new Clinica(); // Se crea la clínica al iniciar
    }

    // Registra un paciente, lanza excepción si falta algún campo
    public void registrarPaciente(String nombre, String id) throws CampoVacioException {
        if (nombre.isBlank() || id.isBlank()) {
            throw new CampoVacioException("Nombre o ID del paciente vacío.");
        }
        Paciente p = new Paciente(nombre, id);
        clinica.agregarPaciente(p);
    }

    // Registra un médico
    public void registrarMedico(String nombre, String id, String especialidad) throws CampoVacioException {
        if (nombre.isBlank() || id.isBlank() || especialidad.isBlank()) {
            throw new CampoVacioException("Faltan datos del médico.");
        }
        Medico m = new Medico(nombre, id, especialidad);
        clinica.agregarMedico(m);
    }

    // Crea una consulta médica
    public void asignarConsulta(String idPaciente, String idMedico, String sintomas, String diagnostico, String tratamiento)
            throws UsuarioNoEncontradoException, CampoVacioException {
        if (idPaciente.isBlank() || idMedico.isBlank() || sintomas.isBlank() || diagnostico.isBlank() || tratamiento.isBlank()) {
            throw new CampoVacioException("Faltan datos en la consulta.");
        }

        Paciente paciente = clinica.buscarPacientePorId(idPaciente);
        if (paciente == null) throw new UsuarioNoEncontradoException("Paciente no encontrado.");

        Medico medico = clinica.buscarMedicoPorId(idMedico);
        if (medico == null) throw new UsuarioNoEncontradoException("Médico no encontrado.");

        Consulta c = new Consulta(paciente, medico, sintomas, diagnostico, tratamiento);
        clinica.agregarConsulta(c);
    }

    // Obtener historial de un paciente
    public List<Consulta> obtenerHistorialPaciente(String idPaciente) throws UsuarioNoEncontradoException {
        Paciente paciente = clinica.buscarPacientePorId(idPaciente);
        if (paciente == null) throw new UsuarioNoEncontradoException("Paciente no encontrado.");
        return clinica.getConsultas().stream()
                .filter(c -> c.getPaciente().getId().equals(idPaciente))
                .toList();
    }

    // Obtener consultas de un médico
    public List<Consulta> obtenerConsultasMedico(String idMedico) throws UsuarioNoEncontradoException {
        Medico medico = clinica.buscarMedicoPorId(idMedico);
        if (medico == null) throw new UsuarioNoEncontradoException("Médico no encontrado.");
        return medico.getConsultas();
    }

    // Obtener listas de pacientes y médicos (para mostrar en tablas, combo box, etc.)
    public List<Paciente> getPacientes() {
        return clinica.getPacientes();
    }

    public List<Medico> getMedicos() {
        return clinica.getMedicos();
    }

    public List<Consulta> getConsultas() {
        return clinica.getConsultas();
    }
}
