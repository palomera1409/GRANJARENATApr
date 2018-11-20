package isic.tala.tec.granjarenata;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;



public class CompraFragment extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener {

    @BindView(R.id.text_cliente)
    EditText cliente;
    @BindView(R.id.text_ejemplar)
    EditText ejemplar;
    @BindView(R.id.text_receptor)
    EditText receptor;
    @BindView(R.id.spinner_Estado)
    Spinner estado;
    @BindView(R.id.sucursal)
    EditText sucursal;
    @BindView(R.id.btn_Comprar)
    Button comprar;
    @BindView(R.id.number_cantidad)
    EditText cantidad;

    ProgressDialog dialog;
    RequestQueue requet;
    JsonObjectRequest jsonObjectRequest;
    StringRequest stringRequest;
    RequestQueue requet1;
    JsonObjectRequest jsonObjectRequest1;

    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_compra, container, false);
        ButterKnife.bind(this, view);



        // Inflate the layout for this fragment

     //   final MercadoPagoCheckout checkout = new MercadoPagoCheckout.Builder
               // ("TEST-83b97183-2707-48c7-920b-10173838e373", "4815953826428075").build();

       // checkout.startPayment(getContext(), 200);

      final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
              (getContext(),R.array.Estados,android.R.layout.simple_spinner_item);
        estado.setAdapter(adapter);

        requet = Volley.newRequestQueue(getContext());

         comprar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
           //  compra_de_semen();
             Toast.makeText(getContext(),"prueba de precio", Toast.LENGTH_LONG);
             }
         });

        return view;




     }


    public void  compra_de_semen()
    {


        if (cantidad.getText().equals("1")) {

            Log.d("comparacion", "compra_de_semen entro al primer if");
            String url = "https://www.mercadopago.com/mlm/checkout/start?pref_id=361722166-13a3fc66-36b9-41fc-a193-3e54c19d8d4d";

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }

        if (cantidad.getText().equals("2")) {
            Log.d("comparacion", "compra_de_semen entro al segundo if");
            String url = "https://www.mercadopago.com/mlm/checkout/start?pref_id=361722166-2f8318cc-93bf-44c7-a342-4228f61ae35e";

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        if (cantidad.getText().equals("3")) {
            Log.d("comparacion", "compra_de_semen entro al tercer if");
            String url = "https://www.mercadopago.com/mlm/checkout/start?pref_id=361722166-62bb2c20-0a98-419d-ab3d-ad7b63375d15";

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }




    }
    private void Cargar_webservice()

    {


        estado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String estado_valor = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
               Toast.makeText(parent.getContext(),"no se pudo seleccionar estado",Toast.LENGTH_LONG);
            }
        });


       /* String url2= "https://penurious-lots.000webhostapp.com/Granjaporcina/Webservice/Actualizar_catalogo.php?Cerdo="+ejemplar.getText().toString()+"" +
                "&Cantidades="+cantidad.getText();
         url2 = url2.replace(" ","%20");

         jsonObjectRequest1 = new JsonObjectRequest(Request.Method.GET,url2,null,null,null);
         requet1.add(jsonObjectRequest1);*/


        String  url ="https://penurious-lots.000webhostapp.com/Granjaporcina/Webservice/" +
            "insertar_catalogo.php?Id_Cliente=0&Nombre_cliente="+cliente.getText().toString()+"&Cerdo="+ejemplar.getText().toString()+
            "&Entidad_fed="+estado.getSelectedItem()+"&sucursal= Tala &Receptor="+receptor.getText().toString()+"&dosis="+cantidad.getText().toString();
    url = url.replace(" ","%20");
    jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
    requet.add(jsonObjectRequest);


    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(),"Error Fatal "+ error.toString(),Toast.LENGTH_LONG).show();
        Log.d("errorfatal", "el error es "+ error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(),"Se registro correctamente la compra * aun no funciona el cobro*",Toast.LENGTH_LONG).show();
        cliente.setText("");
        ejemplar.setText("");
        receptor.setText("");
    }





}

