package br.com.adsnoobs.loginregistro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity {
EditText et_username, et_pass1, et_pass2;
Button bt_registrar;

   DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        db = new DBHelper(this);


        et_username = (EditText)findViewById(R.id.et_reg_username);
        et_pass1 = (EditText)findViewById(R.id.et_reg_password1);
        et_pass2 = (EditText)findViewById(R.id.et_reg_password2);

        bt_registrar = (Button)findViewById(R.id.bt_registrarnovo);

        bt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String username = et_username.getText().toString();
                 String p1 = et_pass1.getText().toString();
                 String p2 = et_pass2.getText().toString();


                 if(username.equals("")){
                     Toast.makeText(RegistrarActivity.this, "Username não inserido, tente novamente ", Toast.LENGTH_SHORT).show();

                 }
                 else if (p1.equals("") || p2.equals("")){
                     Toast.makeText(RegistrarActivity.this, "Deve preencher a password , tente novamente ", Toast.LENGTH_SHORT).show();

                 }
                 else if (!p1.equals(p2)){
                     Toast.makeText(RegistrarActivity.this, "As duas password não correspodem , tente novamente ", Toast.LENGTH_SHORT).show();

                 } else {
                    long res = db.CriarUtilizador(username,p1);
                    if(res>0){
                        Toast.makeText(RegistrarActivity.this, "Registro OK", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(RegistrarActivity.this, "Registro invalido, tente novamente ", Toast.LENGTH_SHORT).show();
                    }


                    }
            }
        });


    }
}
