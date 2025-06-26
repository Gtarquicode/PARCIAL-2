# 🏥 Simulador de Gestión de Consultorio (Consultas médicas)

Proyecto de Programación Orientada a Objetos — Universidad Nacional de Colombia  
Desarrollado en Java con Apache NetBeans usando JSwing y el patrón MVVM.

---

## 🎯 Objetivo

Este sistema permite registrar pacientes y médicos, asignar consultas médicas con diagnóstico y tratamiento, y consultar el historial por paciente o médico.

---

## 🧱 Estructura del proyecto

```plaintext
Clinica/
├── model/              # Clases base del modelo (Paciente, Medico, etc.)
├── view/               # Interfaz gráfica Swing (VentanaPrincipal y paneles)
├── viewmodel/          # Conector entre la lógica y la vista (MVVM)
├── excepciones/        # Excepciones personalizadas
├── persistencia/       # Guardado/carga de datos usando archivos
└── app/                # Punto de entrada (Main.java)
```

---

## 📦 Explicación de clases principales

### `Persona` (abstracta)
Clase base que contiene atributos comunes como `nombre` e `id`. Es heredada por `Paciente` y `Medico`.

### `Paciente`
Representa un paciente registrado. Hereda de `Persona`.

### `Medico`
Representa a un médico con especialidad. Hereda de `Persona` e implementa la interfaz `Agendable`, ya que puede agendar consultas.

### `Consulta`
Contiene toda la información de una consulta médica: paciente, médico, síntomas, diagnóstico, tratamiento y fecha.

### `Clinica`
Contiene listas (`List`) de pacientes, médicos y consultas. Tiene métodos para registrar, buscar y almacenar información.

### `ClinicaViewModel`
Conecta la interfaz gráfica con el modelo. Valida datos, centraliza la lógica y lanza excepciones personalizadas si hay errores.

### `VentanaPrincipal`
Interfaz gráfica principal con navegación a cada funcionalidad mediante botones (Registrar, Asignar Consulta, Ver Historial).

### `PanelRegistro`, `PanelConsulta`, `PanelHistorial`
Paneles de Swing para registrar personas, asignar consultas y consultar el historial.

### `PersistenciaArchivo`
Guarda y carga todos los datos en un archivo `clinica.ser` usando serialización con `ObjectOutputStream` y `ObjectInputStream`.

---

## 💾 Manejo de archivos y persistencia

La clase `PersistenciaArchivo` implementa dos operaciones principales:

### 🗃️ Serialización de Objetos
- Convierte el objeto `Clinica` a un formato binario.
- Guarda los datos en un archivo `.ser`.
- Utiliza `ObjectOutputStream` para la escritura.

### 📥 Deserialización de Objetos
- Lee el archivo `.ser` y convierte los datos binarios en objetos Java (`Clinica`, `Paciente`, etc.).
- Utiliza `ObjectInputStream`.

> Esto permite que toda la información (pacientes, médicos, consultas) se mantenga guardada entre sesiones.

---

## ⚠️ Manejo de Errores

El sistema usa excepciones personalizadas para mejorar la experiencia del usuario:

- `CampoVacioException` → cuando hay campos obligatorios vacíos.
- `UsuarioNoEncontradoException` → cuando no se encuentra un paciente o médico por ID.

También se manejan:
- `IOException` → errores al leer o escribir archivos.
- `ClassNotFoundException` → errores al cargar los objetos serializados.

---

## 🧠 Notas importantes

1. **`Serializable`** no necesita métodos; solo se implementa en las clases que serán guardadas.
2. **`serialVersionUID`** se recomienda para mantener compatibilidad al guardar/cargar objetos.
3. Se usa `try-with-resources` para asegurar el cierre correcto de archivos.
4. El código sigue buenas prácticas:
   - Organización por paquetes
   - Separación de lógica y vista (MVVM)
   - Código claro, limpio y comentado
   - Buen manejo de errores y mensajes de usuario

---

## ✅ Funcionalidades implementadas

- [x] Registro de pacientes
- [x] Registro de médicos
- [x] Asignación de consultas
- [x] Consulta de historial por paciente
- [x] Consulta de historial por médico
- [x] Persistencia en archivo `.ser`
- [x] Interfaz gráfica clara y funcional

---

## 📸 Capturas de pantalla (Ejemplo de uso)

**Registro médico

![registro medico](https://github.com/user-attachments/assets/731c62ee-9841-4752-9d4e-ec32cef1c21f)

**Registro paciente**

![Nuevo paciente](https://github.com/user-attachments/assets/27f1ba34-061d-4073-9f2a-8da8f85ca7b2)

**Consulta 1**

![consulta 1](https://github.com/user-attachments/assets/d86cbbc7-a82a-4a9b-944f-951883b856fb)

**Consulta 2**

![consulta 2](https://github.com/user-attachments/assets/64f543f3-3f3a-4bfd-8119-14422489f2a9)

**Historial del medico**

![historial del medico](https://github.com/user-attachments/assets/b28525c9-81ae-4f6a-a9fd-dd5bc21e6ee1)

**Historial de los pacientes**

![historial de los pacientes](https://github.com/user-attachments/assets/8849627e-73c8-4713-aba5-253488b7babd)

**Error**

![image](https://github.com/user-attachments/assets/55b7455f-00a8-4c2c-a549-b320307356cc)

---

## 🚀 Cómo ejecutar

1. Abre el proyecto en **NetBeans**.
2. Asegúrate de tener `Main.java` como clase principal (`Run > Set Main Project`).
3. Ejecuta el proyecto (`▶️`).
4. Usa la interfaz para registrar, asignar y consultar datos.

---

## 📂 Persistencia

El archivo `clinica.ser` se genera en el directorio raíz del proyecto al guardar información. Puedes cargarlo en ejecuciones futuras.

---

## 🧪 Casos de prueba sugeridos

- Registrar paciente y médico (verifica campos vacíos).
- Asignar consulta entre ellos.
- Buscar historial del paciente o del médico por su ID.
- Cerrar el programa y volver a cargar los datos guardados.

---

## 🏁 Requisitos cumplidos del parcial

✔️ Patrón MVVM  
✔️ Clases abstractas, interfaces y herencia  
✔️ Excepciones personalizadas  
✔️ Persistencia con archivos planos (`.ser`)  
✔️ Interfaz gráfica en JSwing  
✔️ Organización en paquetes  
✔️ Código comentado y entendible
