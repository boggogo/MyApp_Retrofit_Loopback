package georgikoemdzhiev.myappretrofit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OrderService orderService = OrderService.retrofit.create(OrderService.class);


//                final Call<Order> call = orderService.getOrderByID(2);
//
//                call.enqueue(new Callback<Order>() {
//                    @Override
//                    public void onResponse(Call<Order> call, Response<Order> response) {
//                        Log.e("MainActivity","onResponce");
//                        final TextView textView = (TextView) findViewById(R.id.textView);
//
//                        textView.setText(response.body().toString());
//                    }
//
//                    @Override
//                    public void onFailure(Call<Order> call, Throwable t) {
//                        Log.e("MainActivity","onFailure" + t.toString());
//                        final TextView textView = (TextView) findViewById(R.id.textView);
//                        textView.setText("Something went wrong: " + t.getMessage());
//                    }
//
//                });

//                Call<List<Order>> call = orderService.getAllOrders();
//                call.enqueue(new Callback<List<Order>>() {
//                    @Override
//                    public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
//                        Log.e("MainActivity","onResponce");
//                        final TextView textView = (TextView) findViewById(R.id.textView);
//
//                        for(Order o:response.body()){
//                            textView.append(o.getName() + "\n");
//                        }
//
////                        textView.setText(response.body().toString());
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Order>> call, Throwable t) {
//
//                    }
//                });

                Order order = new Order();
                order.setCustomerID(2);
                order.setName("Working Retrofit!");

                Call call = orderService.updateOrderByID(2, order);
                call.enqueue(new Callback<Order>() {
                    @Override
                    public void onResponse(Call<Order> call, Response<Order> response) {
                        Log.e("MainActivity","onResponse");
                    }

                    @Override
                    public void onFailure(Call<Order> call, Throwable t) {
                        Log.e("MainActivity","onFailure");
                    }
                });

            }
        });
    }























    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
