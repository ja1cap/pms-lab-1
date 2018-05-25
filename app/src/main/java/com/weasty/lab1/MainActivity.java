package com.weasty.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText weightEditText;
    EditText heightEditText;
    EditText ageEditText;
    RadioGroup genderRadioGroup;
    RadioGroup activityRadioGroup;

    TextView resultTextView;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = findViewById(R.id.weight);
        heightEditText = findViewById(R.id.height);
        ageEditText = findViewById(R.id.age);
        genderRadioGroup = findViewById(R.id.gender);
        activityRadioGroup = findViewById(R.id.activity);

        resultTextView = findViewById(R.id.calories_result);
        submitBtn = findViewById(R.id.submit);

        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double BMR;
                double AMR;

                int weight = Integer.valueOf(weightEditText.getText().toString());
                int age = Integer.valueOf(ageEditText.getText().toString());
                int height = Integer.valueOf(heightEditText.getText().toString());

                RadioButton checkedGender = findViewById(genderRadioGroup.getCheckedRadioButtonId());
                switch (checkedGender.getId()){
                    case R.id.gender_male:
                        BMR = 66.4730 + (13.7516 * weight) + (5.0033 * height) - (6.7550 * age);
                        break;
                    case R.id.gender_female:
                    default:
                        BMR = 655.0955 + (9.5634 * weight) + (1.8496 * height) - (4.6756 * age);
                }

                RadioButton checkedActivity = findViewById(activityRadioGroup.getCheckedRadioButtonId());
                switch (checkedActivity.getId()){
                    case R.id.activity_slow:
                        AMR = 1.2;
                        break;
                    case R.id.activity_superman:
                        AMR = 1.725;
                        break;
                    case R.id.activity_base:
                    default:
                        AMR = 1.375;
                }

                double caloriesAmount = Math.round(BMR * AMR);

                resultTextView.setText("Необходимое количество калорий: "+String.valueOf(caloriesAmount));
            }
        };

        submitBtn.setOnClickListener(onClick);

    }
}
