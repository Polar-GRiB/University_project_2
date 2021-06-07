package ru.mirea.mochalov.notebook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private EditText fileName;
    private EditText fileText;
    private String name;
    private String text;
    final String SAVED_TEXT = "saved_text";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fileName = findViewById(R.id.fileName);
        fileText = findViewById(R.id.fileText);
        preferences = getPreferences(MODE_PRIVATE);

        new Thread(new Runnable() {
            public void run() {
                fileText.post(new Runnable() {
                    public void run() {
                        fileName.setText(preferences.getString(SAVED_TEXT, "Empty"));
                        fileText.setText(getTextFromFile());
                    }
                });
            }
        }).start();
    }

    public String getTextFromFile() {
        name = preferences.getString(SAVED_TEXT, "Empty");
        FileInputStream fin = null;
        try {
            fin = openFileInput(name);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            Log.d(LOG_TAG, text);
            return text;
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return null;
    }

    public void onClickSave(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SAVED_TEXT, fileName.getText().toString());
        editor.apply();
        name = preferences.getString(SAVED_TEXT, "Empty");
        text = fileText.getText().toString();
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(name, Context.MODE_PRIVATE);
            outputStream.write(text.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    public void onClickLoad(View view) {
        new Thread(new Runnable() {
            public void run() {
                fileText.post(new Runnable() {
                    public void run() {
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString(SAVED_TEXT, fileName.getText().toString());
                        editor.apply();
                        fileName.setText(preferences.getString(SAVED_TEXT, "Empty"));
                        fileText.setText(getTextFromFile());
                    }
                });
            }
        }).start();
    }
}