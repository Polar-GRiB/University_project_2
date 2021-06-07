package ru.mirea.mochalov.room;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        AppDatabase db = App.getInstance().getDatabase();
        EmployeeDao employeeDao = db.employeeDao();
        Employee employee = new Employee();
        employee.id = 1;
        employee.name = "John Smith";
        employee.salary = 10000;
        employeeDao.insert(employee);
        List<Employee> employees = employeeDao.getAll();
        employee = employeeDao.getById(1);
        employee.salary = 20000;
        employeeDao.update(employee);
        Log.d(TAG, employee.name + " " + employee.salary);

        textView.setText(employee.name + " " + employee.salary);
    }
}