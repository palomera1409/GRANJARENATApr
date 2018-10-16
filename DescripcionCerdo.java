package isic.tala.tec.granjarenata;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Palomera on 24/09/2018.
 */

class DescripcionCerdo extends AppCompatActivity {
    @BindView(R.id.txtraza)
    TextView raza;
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






    public static void crearInstancia(Activity contexto, Parametros parametros)
    {
        Intent i = crearIntencion(contexto,parametros);
        contexto.startActivity(i);
    }




    private static Intent crearIntencion(Activity contexto, Parametros parametros)
    {

        Intent i = new Intent(contexto,DescripcionCerdo.class);

        i.putExtra("Nombre_del_cerdo",parametros.getNombre());
        i.putExtra("raza",parametros.getRaza());
        i.putExtra("Linea",parametros.getLinea());
        i.putExtra("edad",parametros.getEdad());
        i.putExtra("existencias",parametros.getExistencia_de_dosis());
        i.putExtra("descripcion",parametros.getDescripcion());
        i.putExtra("imagen",parametros.getImagen());

    return i;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

    }




}
