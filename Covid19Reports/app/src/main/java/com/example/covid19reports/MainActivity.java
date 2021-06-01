package com.example.covid19reports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.covid19reports.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
       dialog=new ProgressDialog(this);
       dialog.setTitle("Data Fetching..");
       dialog.setMessage("Please wait ...");
       dialog.show();
        EndPointInterface ep=Retrofit_API_Instance.getRetrofit().create(EndPointInterface.class);
        Call<String> c=ep.getData();
        c.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
               Log.i("ting",response.body());
               dialog.dismiss();
                try {
                    JSONArray rootAry=new JSONArray(response.body());
                    JSONObject obj=rootAry.getJSONObject(rootAry.length()-1);
                    String resCountry=obj.getString("Country");
                    String resDate=obj.getString("Date");
                    String resConfirmed=obj.getString("Confirmed");
                    String resDeaths=obj.getString("Deaths");
                    String resRecovered=obj.getString("Recovered");
                    String resActive=obj.getString("Active");

                    binding.tvCountry.setText("Country :"+resCountry);
                    binding.tvDate.setText("Date :"+forDateFormat(resDate));
                    binding.tvConfirmed.setText("Confirmed :"+resConfirmed);
                    binding.tvDeath.setText("Deaths :"+resDeaths);
                    binding.tvRecovered.setText("Recovered :"+resRecovered);
                    binding.tvActive.setText("Active :"+resActive);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // Toast.makeText(MainActivity.this, ""+response.body().toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "faild", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private String forDateFormat(String dt) {
        String inputPattern="yy-mm-dd";
        String outputPattern="dd-mm-yy";

        SimpleDateFormat inputFormat=new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat=new SimpleDateFormat(outputPattern);
        Date d=null;
        String str=null;
        try {
            d=inputFormat.parse(dt);
            str=outputFormat.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;

    }
}