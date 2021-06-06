package ru.mirea.mochalov.mireaproject.ui.calculate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.mochalov.mireaproject.R;

public class CalculateFragment extends Fragment {

    String text_calculate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);
        Button button_1 = (Button) view.findViewById(R.id.calculate_button_1);
        Button button_2 = (Button) view.findViewById(R.id.calculate_button_2);
        Button button_3 = (Button) view.findViewById(R.id.calculate_button_3);
        Button button_4 = (Button) view.findViewById(R.id.calculate_button_4);
        Button button_5 = (Button) view.findViewById(R.id.calculate_button_5);
        Button button_6 = (Button) view.findViewById(R.id.calculate_button_6);
        Button button_7 = (Button) view.findViewById(R.id.calculate_button_7);
        Button button_8 = (Button) view.findViewById(R.id.calculate_button_8);
        Button button_9 = (Button) view.findViewById(R.id.calculate_button_9);
        Button button_0 = (Button) view.findViewById(R.id.calculate_button_0);
        Button button_p = (Button) view.findViewById(R.id.calculate_button_p);
        Button button_m = (Button) view.findViewById(R.id.calculate_button_m);
        Button button_d = (Button) view.findViewById(R.id.calculate_button_d);
        Button button_y = (Button) view.findViewById(R.id.calculate_button_y);
        Button button_e = (Button) view.findViewById(R.id.calculate_button_e);
        TextView numberView = view.findViewById(R.id.number_calculate);
        TextView signView = view.findViewById(R.id.sign_calculate);
        TextView textView = view.findViewById(R.id.text_calculate);

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                /*
                text_calculate = textView.getText().toString();
                text_calculate += "1";
                textView.setText(text_calculate);
                */
                textView.append("1");
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                textView.append("2");
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                textView.append("3");
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                textView.append("4");
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                textView.append("5");
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                textView.append("6");
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                textView.append("7");
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                textView.append("8");
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                textView.append("9");
            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                textView.append("0");
            }
        });

        button_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (numberView.getText().toString().equals("")) {
                    numberView.setText(textView.getText().toString());
                }
                textView.setText("");
                signView.setText("+");
            }
        });

        button_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (numberView.getText().toString().equals("")) {
                    numberView.setText(textView.getText().toString());
                }
                textView.setText("");
                signView.setText("-");
            }
        });

        button_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (numberView.getText().toString().equals("")) {
                    numberView.setText(textView.getText().toString());
                }
                textView.setText("");
                signView.setText("/");
            }
        });

        button_y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (numberView.getText().toString().equals("")) {
                    numberView.setText(textView.getText().toString());
                }
                textView.setText("");
                signView.setText("*");
            }
        });

        button_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                /*
                text_calculate = textView.getText().toString();
                String[] numbers = text_calculate.split("\\+");
                for(String number : numbers) {
                    result += Integer.parseInt(number);
                }
                text_calculate = "";
                textView.setText(String.valueOf(result));
                */
                double number1 = Double.parseDouble(numberView.getText().toString());
                double number2 = Double.parseDouble(textView.getText().toString());
                String sign = signView.getText().toString();
                if(sign.equals("+")) {
                    numberView.setText(String.valueOf(number1 + number2));
                } else if(sign.equals("-")) {
                    numberView.setText(String.valueOf(number1 - number2));
                } else if(sign.equals("*")) {
                    numberView.setText(String.valueOf(number1 * number2));
                } else {
                    numberView.setText(String.valueOf(number1 / number2));
                }
                signView.setText("");
                textView.setText("");
            }
        });

        return view;
    }

    public void onNumber() {

    }
}