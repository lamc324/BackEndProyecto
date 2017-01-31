/*
 * Copyright (C) 2016 Grupo Tango
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Universidad Nacional de Costa Rica, Estudiantes: Luis Alonso Morgan Campos,
 * John Herrera Jimenez, Kevin Venegas Loria, Caleb Villalta Quesada, Josue David Matamorros.
 */
package una.cr.design.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Grupo Tango
 */
@Entity
@Table(name = "paciente", catalog = "proyecto", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id_paciente")})
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_paciente", unique = true, nullable = false)
    private int idPaciente;

    @Column(name = "nombre", unique = false, nullable = false)
    private String nombre;

    @Column(name = "telefono", unique = false, nullable = false)
    private String telefono;

    @Column(name = "direccion", unique = false, nullable = false)
    private String direccion;

    @Column(name = "fecha_nacimiento", unique = false, nullable = false)
    private String fechaNacimiento;

    @Column(name = "enfermedades", unique = false, nullable = true)
    private String enfermedades;

    @Column(name = "observaciones", unique = false, nullable = true)
    private String observaciones;

    /**
     * Constructor sin parametros
     */
    public Paciente() {
    }

    /**
     * Constructor con parametros
     *
     * @param id
     * @param nombre
     * @param telefono
     * @param direccion
     * @param fechaNacimiento
     * @param enfermedades
     * @param observaciones
     */
    public Paciente(int id, String nombre, String telefono, String direccion,
            String fechaNacimiento, String enfermedades, String observaciones) {
        this.idPaciente = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.enfermedades = enfermedades;
        this.observaciones = observaciones;
    }

    /**
     *
     * @param nombre
     * @param telefono
     * @param direccion
     * @param fechaNacimiento
     * @param enfermedades
     * @param observaciones
     */
    public Paciente(String nombre, String telefono, String direccion,
            String fechaNacimiento, String enfermedades, String observaciones) {

        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.enfermedades = enfermedades;
        this.observaciones = observaciones;
    }

    /**
     *
     * @return
     */
    public int getIdPaciente() {
        return idPaciente;
    }

    /**
     *
     * @param idPaciente
     */
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * @return getEnfermedades
     */
    public String getEnfermedades() {
        return enfermedades;
    }

    /**
     *
     * @param enfermedadesAsociadas
     */
    public void setEnfermedades(String enfermedadesAsociadas) {
        this.enfermedades = enfermedadesAsociadas;
    }

    /**
     *
     * @return observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     *
     * @param observaciones
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Retorna solo un elemento del array de enfermedades
     *
     * @return enfermedad
     */
//    public String getEnfermedad() {
//        String enfermedad = "";
//        for (String enf : enfermedades) {
//            enfermedad += enf + ", ";
//        }
//        return enfermedad;
//    }
    /**
     *
     * @return toString
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idPaciente;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.telefono);
        hash = 89 * hash + Objects.hashCode(this.direccion);
        hash = 89 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 89 * hash + Objects.hashCode(this.enfermedades);
        hash = 89 * hash + Objects.hashCode(this.observaciones);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paciente other = (Paciente) obj;
        if (this.idPaciente != other.idPaciente) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        if (!Objects.equals(this.enfermedades, other.enfermedades)) {
            return false;
        }
        if (!Objects.equals(this.observaciones, other.observaciones)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Paciente{" + "idPaciente=" + idPaciente + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento + ", enfermedades=" + enfermedades + ", observaciones=" + observaciones + '}';
    }

}
