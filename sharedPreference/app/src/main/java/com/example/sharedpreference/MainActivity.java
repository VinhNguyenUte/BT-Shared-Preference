package com.example.sharedpreference;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTitle,textViewtk,textViewmk,textViewemail,textViewsdt;
    private EditText editTexttk, editTextmk, editTextemail, editTextsdt;
    private CheckBox checkBoxLuuThongTin;
    private SharedPreferences sharedPreferences;
    private Button btnxacnhan;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewTitle = findViewById(R.id.textView);
        textViewtk = findViewById(R.id.label_tk);
        editTexttk = findViewById(R.id.editText_tk);
        textViewmk = findViewById(R.id.label_mk);
        editTextmk = findViewById(R.id.editText_mk);
        textViewemail = findViewById(R.id.label_email);
        editTextemail = findViewById(R.id.editText_email);
        textViewsdt = findViewById(R.id.label_sdt);
        editTextsdt = findViewById(R.id.editText_sdt);
        checkBoxLuuThongTin = findViewById(R.id.checkbox);
        btnxacnhan = (Button) findViewById(R.id.btnxacnhan);

        sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);

        editTexttk.setText(sharedPreferences.getString("msv",""));
        editTextmk.setText(sharedPreferences.getString("ten",""));
        editTextemail.setText(sharedPreferences.getString("khoa",""));
        editTextsdt.setText(sharedPreferences.getString("lhp",""));
        checkBoxLuuThongTin.setChecked(sharedPreferences.getBoolean("checked",false));


        btnxacnhan.setOnClickListener(v->{
            if(checkBoxLuuThongTin.isChecked()){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("msv",editTexttk.getText().toString());
                editor.putString("ten",editTextmk.getText().toString());
                editor.putString("khoa",editTextemail.getText().toString());
                editor.putString("lhp",editTextsdt.getText().toString());
                editor.putBoolean("checked",true);
                editor.commit();
            }
            else {
                SharedPreferences.Editor editor =  sharedPreferences.edit();
                editor.clear();
                editor.commit();
            }
        });


    }
}