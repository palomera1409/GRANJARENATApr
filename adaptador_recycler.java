package isic.tala.tec.granjarenata;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;
import java.util.Objects;





import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Palomera on 24/09/2018.
 */

class adaptador_recycler  extends RecyclerView.Adapter <adaptador_recycler.ViewHolderParametros> implements ItemClickListener {
 // declaramos dos variable una del tipo lista con parametros como valor
    //y un contexto nuevo
    List<Parametros> parametros;
    Context context;


    public adaptador_recycler(Context context, List<Parametros> datos)
    {
        this.parametros = datos;// a la variable parametros le agregamos los datos que es lo que trae el arreglo de  datos en json

        this.context = context; // y el contexto qeu nos tragimos desde el catalogofragmen lo asignamos a este mismo contexto


    }

    @Override
    public adaptador_recycler.ViewHolderParametros onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,parent,false);
        // inflamos una variable de
     ViewHolderParametros ventana = new ViewHolderParametros(v);

        return  ventana ;
    }

    @Override
    public void onBindViewHolder(final adaptador_recycler.ViewHolderParametros holder, int position) {
        final Parametros parametro = parametros.get(position);


         holder.raza.setText("Raza: "+parametro.getRaza());
         holder.linea.setText("Linea: "+parametro.getLinea());
         holder.nombre.setText("Nombre: "+parametro.getNombre());
         holder.edad.setText("Edad: "+ parametro.getEdad());
         holder.exitencia.setText("Existencias:"+parametro.getExistencia_de_dosis());
         holder.descripcion.setText("Descripcion: "+parametro.getDescripcion());
         holder.precio.setText("Precio: "+ parametro.getPrecio());
         parametro.getImagen().replace("<img src=","");
   String imagen="";




             String url="https://penurious-lots.000webhostapp.com/Granjaporcina/"+ parametro.getImagen();
             url= url.replace("<img src=\"","");
             String urlfinal =url.replace("\" >","");
        Log.d("url", urlfinal);
             final ImageRequest imageRequest = new ImageRequest(urlfinal, new Response.Listener<Bitmap>() {
                 @Override
                 public void onResponse(Bitmap response) {
                     holder.imgcerdo.setImageBitmap(response);

                                                         }
             }

                     , 0, 0, ImageView.ScaleType.CENTER, null, new Response.ErrorListener() {
                 @Override
                 public void onErrorResponse(VolleyError error) {

                     holder.imgcerdo.setImageResource(R.drawable.york);


                 }
             });


holder.request.add(imageRequest);



  holder.comprar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

          String aux = parametro.getPrecio().toString();
          Log.e("valor", "el valor es,"+aux.toString() );

          if (aux=="300")
          {


              Intent Bmeters = new Intent(context ,CompraFragment.class);
              context.startActivity(Bmeters);

          }
       if (Objects.equals(parametro.getPrecio().toString(), "500"))
          {
              Toast.makeText(context,"el valor es de quinientos",Toast.LENGTH_LONG).show();
              Log.d("de 500", "entro al 500");
          }



      }
  });

     }

    @Override
    public int getItemCount() {
        return parametros.size();

    }


    public class ViewHolderParametros extends RecyclerView.ViewHolder implements isic.tala.tec.granjarenata.ViewHolderParametros {

        @BindView(R.id.txtraza)
        TextView raza;
        @BindView (R.id.comprar)
        Button comprar;
        @BindView(R.id.txtnlinea)
        TextView linea;
        @BindView(R.id.txtnombre)
        TextView nombre;
        @BindView(R.id.txtedad)
        TextView edad;
        @BindView(R.id.txtexistencia)
        TextView exitencia;
        @BindView(R.id.txtdescripcion )
        TextView descripcion;
        @BindView(R.id.avatar)
        CircleImageView imgcerdo;
        @BindView(R.id.txtprecio)
        TextView precio;
        RequestQueue request= Volley.newRequestQueue(context);

        public ViewHolderParametros(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }


}
