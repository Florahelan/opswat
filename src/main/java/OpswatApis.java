import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

//All the api's are defined here

public interface OpswatApis {
     /*
     To Upload a file and retrieve data_id
     */
    @POST("v2/file/")
    Call<String> uploadFile(
            @Header("apikey") ApiKey apiKey,
            @Body RequestBody body);

     /*
     To retrieve data_id and hash
     */

    @GET("v2/file/{dataId}")
    Call<String> retrieveDataId(
            @Path("dataId") String dataId,
            @Header("apikey") ApiKey apiKey);

    /*
     To retrieve report for the hash
     */

    @GET("v2/hash/{hash}")
    Call<String> retrieveHash(
            @Path("hash") String hash,
            @Header("apikey") ApiKey apiKey);


}
