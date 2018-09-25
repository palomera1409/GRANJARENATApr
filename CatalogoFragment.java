package isic.tala.tec.granjarenata;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    public List<Parametros> datos;
    ProgressDialog dialog;
  private RecyclerView rv;
View v;






    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        return  inflater.inflate(R.layout.fragment_catalogo, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            //dialog = ProgressDialog.show(this,"","Cargando Datos Espere un Minuto");
            final  String url ="https://penurious-lots.000webhostapp.com/Granjaporcina/Webservice/";
            Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

            ServicioContacto servicioContacto = retrofit.create(ServicioContacto.class);

            Call <List<Parametros>> peticion =  servicioContacto.traerdatos();
            peticion.enqueue(new Callback<List<Parametros>>() {
                @Override
                public void onResponse(Call<List<Parametros>> call, Response<List<Parametros>> response)
                {
                    datos = response.body();
                    llenar_recicler();


                }


                @Override
                public void onFailure(Call<List<Parametros>> call, Throwable t)
                {
                    Toast.makeText(getContext(),"Entro al onFailure",Toast.LENGTH_LONG).show();
                }

            });










    }

    private void llenar_recicler() {

        adaptador_recycler adaptador_recycler = new adaptador_recycler(getContext(),datos);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adaptador_recycler);

     }







    @Override
    public void onResume() {
        super.onResume();
    }








}








