package isic.tala.tec.granjarenata;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Palomera on 13/09/2018.
 */

public class ServicioProvedor {
    /*esta  variable va traer si tuviera ya un servicio precargado  y lo ejecutaria.
    private static ServicioContacto service;

    public static  ServicioContacto getService()
    {
        /*creo una clase aparte  con  el sevicio y mediante la condicion veo si viene vacio si viene vacio
          le asigno  uno mediante  el retrofit.builder y le asigno una url en este caso la url el local host
          lo sustituyo por la ip del  dispositivo a funcionar (deve de estar conectado a  la misma red  si es un celular o otro
          dispositivo no emulado a lo que me traiga lo traire como gson por lo cual es el converFactory  y lo creo en la clase
          ServicioContacto). como es la url base esa no cambiara si lo pusieramos en un host seria la ip del  host


         if (service== null)
         {
             service= new Retrofit.Builder().baseUrl("http//192.168.3.9/Granjaporcina/Webservice").
                     addConverterFactory(GsonConverterFactory.create()).build().create(ServicioContacto.class);
         }
 return service;




    }*/
}
