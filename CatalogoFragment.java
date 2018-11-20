package isic.tala.tec.granjarenata;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CatalogoFragment extends Fragment {

    //declaramos una lista de tipo parametros que es la que se tiene que traer las caracteristicas
    // de la clase parametros
    public List<Parametros> datos;
    //el progress dialog lo unico que hace es  crear un mensaje de tipo   progress, que congelara la pantalla
    // hasta que lo pares
    ProgressDialog dialog;
    //Recycler   es un list view pero mas avanzado por lo cual  dara mas precentacion al proyecto
  @BindView(R.id.recycler)
  RecyclerView rv;








    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ;
       View v = inflater.inflate(R.layout.fragment_catalogo, container, false);
        ButterKnife.bind(this,v);


        return  v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            dialog = ProgressDialog.show(getContext(),"","Cargando Datos Espere un Momento"); // lo que tendra el
        // mensaje tipo progres
            final  String url ="https://www.lagranjaderenata.com/Webservice/";// la url del webservice de donde se traera
        //la cadena tipo json con los datos
            Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();/*
          Se instancea el metodo de retrofit y se agrega un converson de json a objetos*/

            ServicioContacto servicioContacto = retrofit.create(ServicioContacto.class);
        // declaramos una variable tipo interfaz servicio contacto y la igualamos a  el retrofit que trae el servicio de contacto

            Call <List<Parametros>> peticion =  servicioContacto.traerdatos();
            /*agregamos una variable del tipo de lista que traes desde la interfaz*/
            peticion.enqueue(new Callback<List<Parametros>>() {// ejecutamos un enqueue  para que mande un evento response y un onfauilre
                // que se encargara  de ejecutar algo asi como un try y catch  si se hace la consutal se trera  los datos si no sera un error
                // conexion
                @Override
                public void onResponse(Call<List<Parametros>> call, Response<List<Parametros>> response)
                {
                    datos = response.body(); // asignamos el resultado a una variable de tipo parametros y ejecutamos un metodo
                    // que se encargara de llenar el recycler
                    llenar_recicler();
                    dialog.dismiss();// paramos el progress

                }


                @Override
                public void onFailure(Call<List<Parametros>> call, Throwable t)
                {
                    dialog.dismiss(); // si falla paramos el progres y ponemos error de conexion
                    Toast.makeText(getContext(),"Error Inesperado Revise su conexión",Toast.LENGTH_LONG).show();
                }

            });

    }

    private void llenar_recicler() {
        /*se va declarar una variable de  tipo adaptador recicler que es una clase que tenemos echa
        * y un set layautmanager que se encargara de tomas los contextos  y se lo asignaeroms al  recycler junto con un adaptater
        * la variable de tipo adaptador reclycler*/

        adaptador_recycler adaptador_recycler = new adaptador_recycler(getContext(),datos);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adaptador_recycler);


     }









    @Override
    public void onResume() {
        super.onResume();
    }








}








