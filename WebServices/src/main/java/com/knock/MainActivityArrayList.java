package com.knock;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;

import java.util.ArrayList;

public class MainActivityArrayList extends Activity {

    /*******************************************
     *
       CONFIGURACION DEL ACCESO AL WS
     *
     *********************************************/

        //IP DEL SERVICIO O PAGINA DONDE SE ENCUENTRA CON SU PUERTO
    private static final String LOCALIZACION = "192.168.1.68:8080";
        // NAME SPACE DEL WEBSERVICE DEFINIDO EN EL NETBEANS
    private static final String NAMESPACE = "hello_webservice";
    private static final String URL = "http://"+LOCALIZACION+"/WBSERVICESYOUTUBE/hello_webservice?WSDL";
        // NOMBRE DEL METODO AL QUE VA A ACCEDER Y EL
    private static final String METHOD_NAME = "resultados";
        // NAME SPACE MÁS EL METODO A LLAMAR
    private static final String SOAP_ACTION = "hello_webservice/resultados";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView myTexto;
        myTexto = (TextView) findViewById(R.id.myTexto);

        ///EJECUCION EN EL HILO PRINCIPAL RECOMENDABLE HACERLO EN UN HILO PARALELO
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
        StrictMode.setThreadPolicy(policy);


        // INICIALIZO LOS ELEMENTOS DEL WEBSERVICE DE LA LIBRERÍA KSOAP2

        /***
         *
         * EJEMPLO DE COMO AÑADIR PARAMETROS AL WEBSERVICE
         *
         * /*PropertyInfo propInfo=new PropertyInfo();
         propInfo.name="nombre";
         propInfo.type=PropertyInfo.STRING_CLASS;
         Request.addProperty(propInfo, "Señor vicoysito Rebelde");
         *
         *
         */

        SoapObject Request = new SoapObject(NAMESPACE,METHOD_NAME);
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.setOutputSoapObject(Request);
        AndroidHttpTransport aht = new AndroidHttpTransport(URL);
        aht.debug = true;

        try {
            aht.call(SOAP_ACTION, soapEnvelope);
            /***
             * EN CASO DE LLAMAR A UN STRING
             * MANDAR LLAMAR LA CLASE UtilesWS.envToString
             * EN CASO DE LLAMAR UN ARRAY LIST DE TIPO STRING
             * MANDAR LLAMAR LA CLASE UtilesWs.envToAlString
             */

            ArrayList<String> recivedlistItems = UtilesWS.envToAlString(soapEnvelope);

            for (String s:recivedlistItems){
                Log.d("MI ARRAY:: ",s);
                
            }

            myTexto.setText("Resultado: "+recivedlistItems.get(0));

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    
}
