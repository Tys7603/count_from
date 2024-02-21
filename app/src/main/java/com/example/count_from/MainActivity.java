package com.example.count_from;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText etInput;
    Button btnConfirm;
    String REGEX = "[a-zA-Z0-9]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.editTextTextPersonName);
        btnConfirm = findViewById(R.id.button);

        CharacterTelex characterTelex = new CharacterTelex();

        btnConfirm.setOnClickListener(view -> {

           if (etInput.getText().toString().isEmpty()){
               Toast.makeText(this, "Không được bỏ trống", Toast.LENGTH_SHORT).show();
           }else {

               if (validateInput(etInput.getText().toString())){
                   int count = characterTelex.countVietnameseCharacters(etInput.getText().toString());
                   Toast.makeText(this, "Số lượng chữ cái tiếng việt có thể tạo thành "  + count, Toast.LENGTH_SHORT).show();
               }else {
                   Toast.makeText(this, "Không được nhập kí tự đặc biêt và khoảng trắng", Toast.LENGTH_SHORT).show();
               }

           }

        });
    }

    public boolean validateInput(String input){
        Matcher matcher = Pattern.compile(REGEX).matcher(input);
        return matcher.matches();
    }
}