package isic.tala.tec.granjarenata;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;

/**
 * Created by Palomera on 24/09/2018.
 */

class DescripcionCerdo extends AppCompatActivity {






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




}
