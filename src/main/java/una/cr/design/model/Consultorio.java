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

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "consultorio", catalog = "proyecto", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id_consultorio")})
public class Consultorio {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_consultorio", unique = true, nullable = false)
    private int idConsultorio;
    
    @Column(name = "nombre", unique = false, nullable = false)
    private String nombre;
    
    @Column(name = "dias", unique = false, nullable = false)
    private String diasConsulta;
    
    @Column(name = "horario", unique = false, nullable = false)
    private String horarioAtencion;
    
    @Column(name = "telefono", unique = false, nullable = false)
    private String telefono;

    /**
     * Constructor sin parametros
     */
    public Consultorio() {
    }



    /**
     * Constructor con parametros
     *
     * @param nombre
     * @param diasConsulta
     * @param horarioAtencion
     * @param telefono
     */
    public Consultorio(int idConsultorio, String nombre, String diasConsulta, String horarioAtencion, String telefono) {
        this.idConsultorio = idConsultorio;
        this.nombre = nombre;
        this.diasConsulta = diasConsulta;
        this.horarioAtencion = horarioAtencion;
        this.telefono = telefono;
    }
    
        public Consultorio( String nombre, String diasConsulta, String horarioAtencion, String telefono) {
        this.nombre = nombre;
        this.diasConsulta = diasConsulta;
        this.horarioAtencion = horarioAtencion;
        this.telefono = telefono;
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
     * @return diaConsulta
     */
    public String getDiasConsulta() {
        return diasConsulta;
    }

    /**
     *
     * @param diasConsulta
     */
    public void setDiasConsulta(String diasConsulta) {
        this.diasConsulta = diasConsulta;
    }

    /**
     *
     * @return horarioAtencion
     */
    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    /**
     *
     * @param horarioAtencion
     */
    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
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

    public int getIdConsultorio() {
        return idConsultorio;
    }

    
    public void setIdConsultorio(int idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    @Override
    public String toString() {
        return "Consultorio{" + "idConsultorio=" + idConsultorio + ", nombre=" + nombre + ", diasConsulta=" + diasConsulta + ", horarioAtencion=" + horarioAtencion + ", telefono=" + telefono + '}';
    }

    /**
     *
     * @return
     */
    
    

}
