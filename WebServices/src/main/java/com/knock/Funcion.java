package com.knock;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;


/**
 * Created by victordespinosavazquez on 13/06/13.
 */
public class Funcion implements KvmSerializable {

    private String sede, titulo,horario;
    private int countProperty=3;


    public Funcion() {}

    public Funcion(String sede, String titulo, String horario) {
        this.sede = sede;
        this.titulo = titulo;
        this.horario = horario;
    }

    public Object getProperty(int arg0){

        switch(arg0){

            case 0:
                return this.sede;

            case 1:
                return this.titulo;

            case 2:
                return this.horario;

            default:
                return null;
        }


    }

    public int getPropertyCount(){
        return this.countProperty;
    }

    public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info){

        switch (index){

            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "sede";
                break;


            case 1:

                info.type = PropertyInfo.STRING_CLASS;
                info.name = "titulo";

                break;


            case 2:

                info.type = PropertyInfo.STRING_CLASS;
                info.name = "horario";
                break;

            default:
                break;
        }

    }

    public void setProperty(int index, Object value)
    {

        switch (index)
        {
            case 0:
                sede = value.toString();
                break;
            case 1:
                titulo = value.toString();
                break;
            case 2:
                horario = value.toString();
                break;
            default:
                break;
        }

    }

    /******************************************
     *
     * GETTERS AND SETTERS
     *
     * *****************************************/

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }




}
