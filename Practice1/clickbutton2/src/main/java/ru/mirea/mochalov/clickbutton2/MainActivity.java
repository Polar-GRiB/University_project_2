package ru.mirea.mochalov.clickbutton2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Button button_ok;
    private Button button_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text= (TextView) findViewById(R.id.text);

        button_ok = (Button) findViewById(R.id.button_ok);
        View.OnClickListener startButtonOk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("Нажата кнопка ОК");
            }
        };
        button_ok.setOnClickListener(startButtonOk);

        button_cancel = (Button) findViewById(R.id.button_cancel);
        View.OnClickListener startButtonCancel = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("Нажата кнопка CANCEL)");
            }
        };
        button_cancel.setOnClickListener(startButtonCancel);
    }
}