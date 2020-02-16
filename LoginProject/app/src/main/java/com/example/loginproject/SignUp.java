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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignUp extends AppCompatActivity {
    EditText userName;
    EditText password;
    EditText email;
    Button confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userName = findViewById(R.id.inputUserName);
        password = findViewById(R.id.inputPw);
        email = findViewById(R.id.inputEmail);

        confirm = findViewById(R.id.confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitApi retrofit = new RetrofitApi();
                ApiInterface apiInterface = retrofit.apiInterface;
                Res res = new Res(email.getText().toString(),password.getText().toString(),userName.getText().toString());

                Call<JsonParse> call = apiInterface.signupPost(res);
                call.enqueue(new Callback<JsonParse>() {
                    @Override
                    public void onResponse(Call<JsonParse> call, Response<JsonParse> response) {
                        Log.d("code",response.toString());
                        if(response.code()==200) {
                            makeToast("회원가입 성공");
                            Log.d("success","성공");

                            Intent intent = new Intent(SignUp.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else if(response.code()==400) {
                            makeToast("아이디 중복");
                        }
                        else {
                            makeToast("알수없는 오류");
                            Log.d("unknown error", response.code() + "");
                        }
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
