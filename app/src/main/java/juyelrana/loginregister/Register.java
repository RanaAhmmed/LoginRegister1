package juyelrana.loginregister;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.Voice;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Register extends AppCompatActivity {

    private EditText etFirstname,etLastname,etEmail,etUsername,etPassword;

    private Button btnRegister;

    private String firstname,lastname,email,username,password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFirstname = (EditText)findViewById(R.id.etFirstname);
        etLastname = (EditText)findViewById(R.id.etLastname);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);

        btnRegister = (Button)findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Register();

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void Register(){

        //Showing the progress dialog
        final ProgressDialog loading = ProgressDialog.show(this,"Registering...","Please wait...",false,false);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.REGISTERURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //Disimissing the progress dialog
                        loading.dismiss();
                        //Showing toast message of the response
                        Toast.makeText(Register.this, s, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //Dismissing the progress dialog
                        loading.dismiss();

                        //Showing toast
                        Toast.makeText(Register.this, volleyError.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                }){


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                firstname = etFirstname.getText().toString().trim();
                lastname = etLastname.getText().toString().trim();
                email = etEmail.getText().toString().trim();
                username = etUsername.getText().toString().trim();
                password = etPassword.getText().toString().trim();


                //Creating parameters
                Map<String,String> params = new Hashtable<String, String>();

                //Adding parameters
                params.put(Config.FIRSTNAME,firstname);
                params.put(Config.LASTNAME, lastname);
                params.put(Config.EMAIL, email);
                params.put(Config.USERNAME,username);
                params.put(Config.PASSWORD,password);

                //returning parameters
                return params;
            }
        };

        //Creating a Request Queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(stringRequest);
    }

}
