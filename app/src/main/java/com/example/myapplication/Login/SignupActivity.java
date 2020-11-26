package com.example.myapplication.Login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.AsyncTaskLoader.SingupLoader;
import com.example.myapplication.R;

public class SignupActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>, Loader.OnLoadCanceledListener<String> {

    private EditText editUserName;
    private EditText editPassword;
    private EditText editPassCom;
    private String UserName;
    private String Password;
    LoaderManager loaderManager;
    private final int SIGNUP = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editUserName = findViewById(R.id.Signup_Username);
        editPassword = findViewById(R.id.Signup_Password);
        editPassCom = findViewById(R.id.Signup_VaPassword);
        loaderManager = LoaderManager.getInstance(this);
    }


    public void UserSignup(View view) {
        UserName = editUserName.getText().toString();
        Password = editPassword.getText().toString();
        String passcom = editPassCom.getText().toString();
        Log.d("TEST",Password);
        Loader<String> loader =  loaderManager.getLoader(SIGNUP);
        if (loader == null) {
            loader = loaderManager.initLoader(SIGNUP, null, this);
        } else {
            loader = loaderManager.restartLoader(SIGNUP, null, this);
        }
        loader.registerOnLoadCanceledListener(this);
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new SingupLoader(this,UserName,Password);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

    @Override
    public void onLoadCanceled(@NonNull Loader<String> loader) {

    }
}