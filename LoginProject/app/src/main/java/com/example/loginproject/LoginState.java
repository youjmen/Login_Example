package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginState extends AppCompatActivity {
    Button logOut;

    TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_state);
        userName = findViewById(R.id.textView2);
        Intent intent = getIntent();
        String user_name =intent.getExtras().getString("username");
        Log.d("name",user_name);
        userName.setText(user_name);



        logOut = findViewById(R.id.logOut);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginState.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    /*public void getUserName(){
        RetrofitApi retrofit = new RetrofitApi();
        ApiInterface apiInterface = retrofit.apiInterface;

        Intent intent = getIntent();

        Call<JsonParse> call = apiInterface.getUserInfo(intent.getExtras().getString("token"));
        call.enqueue(new Callback<JsonParse>() {
            @Override
            public void onResponse(Call<JsonParse> call, Response<JsonParse> response) {
                Log.d("code",response.toString());
                if(response.code()==200) {
                    makeToast(response.body().accessToken);
                    Log.d("success",response.body().accessToken);

                }
                else if(response.code()==400)
                    makeToast("로그인 실패");
                else
                    Log.d("unknown error",response.code()+"");
            }

            @Override
            public void onFailure(Call<JsonParse> call, Throwable t) {
                Log.e("error",t.getMessage());
            }
        });

    }*/
    private void makeToast(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
