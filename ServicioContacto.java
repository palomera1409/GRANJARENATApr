package isic.tala.tec.granjarenata;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Palomera on 13/09/2018.
 */

public interface ServicioContacto {
  //public  static final String url="https://penurious-lots.000webhostapp.com/Granjaporcina/Webservice/";


@POST("Select_catalogo.php") // nombre del php que esta fungiendo como webservices



 Call<List<Parametros>> traerdatos();


}
