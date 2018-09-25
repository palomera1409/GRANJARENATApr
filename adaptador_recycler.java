package isic.tala.tec.granjarenata;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Palomera on 24/09/2018.
 */

class adaptador_recycler  extends RecyclerView.Adapter <adaptador_recycler.ViewHolderParametros> {

    List<Parametros> parametros;
    Context context;


    public adaptador_recycler(Context context, List<Parametros> datos)
    {
        this.parametros = datos;

        this.context = context;

    }

    @Override
    public adaptador_recycler.ViewHolderParametros onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,parent,false);
     ViewHolderParametros ventana = new ViewHolderParametros(v);

        return  ventana ;
    }

    @Override
    public void onBindViewHolder(adaptador_recycler.ViewHolderParametros holder, int position) {
        Parametros parametro = parametros.get(position);
         holder.raza.setText(parametro.getRaza());

    }

    @Override
    public int getItemCount() {
        return parametros.size();
    }

    public class ViewHolderParametros extends RecyclerView.ViewHolder {

        @BindView(R.id.txtraza)
        TextView raza;
        public ViewHolderParametros(View itemView) {
            super(itemView);
        }
    }
}
