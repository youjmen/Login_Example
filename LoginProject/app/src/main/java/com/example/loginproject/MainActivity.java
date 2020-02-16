package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginproject.Resource.Res;
import com.example.loginproject.Resource.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText inputEmail;
    EditText inputPw;
    Button signIn;
    Button signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEmail = findViewById(R.id.inputEmail);
        inputPw = findViewById(R.id.inputPw);

        signUp = findViewById(R.id.signup);
        signIn = findViewById(R.id.signin);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);


            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitApi retrofit = new RetrofitApi();
                ApiInterface apiInterface = retrofit.apiInterface;
                User user = new User(inputEmail.getText().toString(),inputPw.getText().toString());

                Call<JsonParse> call = apiInterface.signinPost(user);
                call.enqueue(new Callback<JsonParse>() {
                    @Override
                    public void onResponse(Call<JsonParse> call, Response<JsonParse> response) {
                        Log.d("code",response.toString());
                        if(response.code()==200) {
                            makeToast(response.body().accessToken);
                            Log.d("success",response.body().accessToken);

                            Intent intent = new Intent(MainActivity.this, LoginState.class);
                            intent.putExtra("username",response.body().userName);
                            intent.putExtra("token",response.body().accessToken);
                            startActivity(intent);
                            finish();
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


            }
        });
    }
    private void makeToast(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
