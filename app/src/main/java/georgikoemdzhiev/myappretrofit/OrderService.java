package georgikoemdzhiev.myappretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

interface OrderService {
    @GET("Orders/{id}")
    Call<Order> getOrderByID(@Path("id") int id);

    @GET("Orders")
    Call<List<Order>>getAllOrders();

    @PUT("Orders/{id}")
    Call<Order> updateOrderByID(@Path("id") int id, @Body Order order);


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}