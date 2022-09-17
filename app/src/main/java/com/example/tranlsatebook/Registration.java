package com.example.tranlsatebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tranlsatebook.activity.LoginActivity;
import com.example.tranlsatebook.activity.Main;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {
    
    private EditText email_reg;
    private EditText password_reg;
    private Button btm_reg;

    private FirebaseAuth mAuth;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        email_reg = findViewById(R.id.editTextTextEmailAddress);
        password_reg = findViewById(R.id.editTextTextPassword);
        btm_reg = findViewById(R.id.button_reg);

        mAuth = FirebaseAuth.getInstance();
        
        btm_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email_reg.getText().toString().isEmpty() || password_reg.getText().toString().isEmpty()){
                    Toast.makeText(Registration.this, "Field can not be empty", Toast.LENGTH_SHORT).show();
                }else{
                    mAuth.createUserWithEmailAndPassword(email_reg.getText().toString(), password_reg.getText().toString()).
                            addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        Intent intent = new Intent(Registration.this, LoginActivity.class);
                                        startActivity(intent);
                                    }else{
                                        Toast.makeText(Registration.this, "You have some errors", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}