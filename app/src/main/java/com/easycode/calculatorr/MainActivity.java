package com.easycode.calculatorr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.easycode.calculatorr.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private Computation computation;
    private String number = "";
    private final static String KEY ="key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init () {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        computation = new Computation();
        binding.button0.setOnClickListener(this);
        binding.button1.setOnClickListener(this);
        binding.button2.setOnClickListener(this);
        binding.button3.setOnClickListener(this);
        binding.button4.setOnClickListener(this);
        binding.button5.setOnClickListener(this);
        binding.button6.setOnClickListener(this);
        binding.button7.setOnClickListener(this);
        binding.button8.setOnClickListener(this);
        binding.button9.setOnClickListener(this);
        binding.buttonPoint.setOnClickListener(this);
        binding.divide.setOnClickListener(this::signClick);
        binding.equals.setOnClickListener(this::equalsClick);
        binding.fold.setOnClickListener(this::signClick);
        binding.multiply.setOnClickListener(this::signClick);
//        binding.percent.setOnClickListener(this);
        binding.subtract.setOnClickListener(this::signClick);
        binding.del.setOnClickListener(this::delClick);
        binding.clear.setOnClickListener(this::clearClick);

    }

    public void equalsClick (View view) {
        Button btn = (Button) view;
        computation.computation(number);
        number = "";
        binding.screen.setText(binding.screen.getText() + btn.getText().toString());
        binding.screen.setText(binding.screen.getText() + computation.solution().toString() +"\n");
    }

    public void signClick(View view) {
        Button btn = (Button) view;
        computation.computation(number);
        number = "";
        computation.setSign(btn.getText().charAt(0));
        binding.screen.setText(binding.screen.getText() + btn.getText().toString());

    }

    public void clearClick(View view) {
        binding.screen.setText("");
    }

    public void delClick(View view) {
        if (binding.screen.getText().length() > 0){
            binding.screen.setText(binding.screen.getText().subSequence(0, binding.screen.getText().length() - 1));
        }

    }
    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        number = number + btn.getText().toString();
        binding.screen.setText(binding.screen.getText() + btn.getText().toString());

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        computation.setText(binding.screen.getText().toString());
        instanceState.putSerializable(KEY, computation);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        computation = (Computation) instanceState.getSerializable(KEY);
        binding.screen.setText(computation.getText());
    }
}