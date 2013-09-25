package com.knock;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;

import java.util.ArrayList;

/**
 * Created by victordespinosavazquez on 12/06/13.
 */
public class UtilesWS {

    /** *
     * @param soapEnvelope SoapSerializationEnvelope Esta método utilitario sirve para convertir un objeto XML
     *                     a tipo Array list para facilitar su manejo
     */

    public static ArrayList<String> envToAlString(SoapSerializationEnvelope soapEnvelope){

            ArrayList<String> arrList = new ArrayList<String>();

            SoapObject result=(SoapObject)soapEnvelope.bodyIn;
            int childCount = result.getPropertyCount();
            for (int i = 0; i < childCount; i++) {
            String temp= result.getProperty(i).toString();
            arrList.add(temp);
            }

            return arrList;

    }

    /** *
     * @param soapEnvelope SoapSerializationEnvelope Esta método utilitario sirve para convertir un objeto XML
     *                     a tipo String para facilitar su manejo
     */

    public static String envToString(SoapSerializationEnvelope soapEnvelope){
        String s = "";
        try {
            SoapPrimitive resultString = (SoapPrimitive)soapEnvelope.getResponse();
            s = resultString.toString();
        }catch(Exception e){
            e.printStackTrace();
        }

        return s;
    }


    /** *
     * @param soapEnvelope SoapSerializationEnvelope Esta método utilitario sirve para convertir un objeto XML
     *                     de un tipo complejo explico su funcionamiento ejemplo aqui Clase Función
     */


    public static ArrayList<Funcion> envToCompex(SoapSerializationEnvelope soapEnvelope){
        // CREO EL ARREGLO A REGRESAR
        ArrayList<Funcion> arregloFun = new ArrayList<Funcion>();


        // OBTENGO EL CUERPO DEL ENVELOPE
        SoapObject response = (SoapObject) soapEnvelope.bodyIn;
        // OBTENGO EL TAMAÑO PARA PODERLO ITERAR Y SACAR LOS DATOS
        int childCount = response.getPropertyCount();
        // RECORRO EL CUERPO DEL ENVELOPE PARA SACAR CADA UNO DE LOS OBJETOS
        for (int i = 0; i < childCount; i++) {
            SoapObject respuesta = (SoapObject)response.getProperty(i);
            // SACO CADA UNO DE LOS ATRIBUTOS DEL OBJETO CON EL metodo getProperty y el numero o nombre con getPropertyAsString
            arregloFun.add(new Funcion(respuesta.getProperty(0).toString(),respuesta.getPropertyAsString(1),respuesta.getPropertyAsString("hora")));
        }

        return arregloFun;

    }
}
