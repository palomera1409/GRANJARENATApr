package isic.tala.tec.granjarenata;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;


public class EnvioFragment extends Fragment implements  ItemClickListener {

    @BindView(R.id.btn_sucursal)
    Button sucursal;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment





        View v =inflater.inflate(R.layout.fragment_envio, container, false);
        ButterKnife.bind(this,v);
    sucursal.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            envio();
        }
    });

        return v;



    }



    public  void  envio ()
    {

        String url = "https://www.estafeta.com/Herramientas/Frecuencias-de-entrega?fbclid=IwAR11KPy2pThCbgL_F8sGpJRVl5TeOTzdFn1cBB0unwLCIRddRJpBlaeE198";

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }




}
