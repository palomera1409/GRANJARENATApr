package isic.tala.tec.granjarenata;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.mercadopago.android.px.core.MercadoPagoCheckout;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CompraFragment extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener{

    @BindView(R.id.text_cliente)
    EditText cliente;
    @BindView(R.id.text_ejemplar)
    EditText ejemplar;
    @BindView(R.id.text_receptor)
    EditText receptor;
    @BindView(R.id.spinner_Estado)
    Spinner estado;
    @BindView(R.id.spinner_sucursal)
    Spinner sucursal;
    @BindView(R.id.btn_Comprar)
    Button comparar;

    ProgressDialog dialog;
    RequestQueue requet;
    JsonObjectRequest jsonObjectRequest;

    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        final MercadoPagoCheckout checkout = new MercadoPagoCheckout.Builder
                ("TEST-83b97183-2707-48c7-920b-10173838e373", "4815953826428075").build();

        checkout.startPayment(getContext(), 200);


        Retrofit retrofit = new Retrofit.Builder().baseUrl("")
                .addConverterFactory(GsonConverterFactory.create()).build();

        View view = inflater.inflate(R.layout.fragment_compra, container, false);


        requet = Volley.newRequestQueue(getContext());
        comparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar_webservice();
            }
        });




        ButterKnife.bind(this, view);

        return view;





     }

    private void Cargar_webservice()

    {
    String  url ="https://penurious-lots.000webhostapp.com/Granjaporcina/Webservice/" +
            "insertar_catalogo.php?Id_Cliente=0&Nombre_cliente="+cliente.getText().toString()+"&Cerdo="+ejemplar.getText().toString()+
            "&Entidad_fed=jalisco&sucursal=Tala&Receptor=pepe";
    url = url.replace(" ","%20");
    jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
    requet.add(jsonObjectRequest);


    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(),"Error Fatal "+ error.toString(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(),"Se registro correctamente el envio",Toast.LENGTH_LONG).show();
        cliente.setText("");
        ejemplar.setText("");
        receptor.setText("");

    }
}
