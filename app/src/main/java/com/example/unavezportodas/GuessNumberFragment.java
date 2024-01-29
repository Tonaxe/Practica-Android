package com.example.unavezportodas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import java.util.Random;

public class GuessNumberFragment extends Fragment {
    private EditText etGuess;
    private Button btnGuess, btnRestart;
    private TextView tvHint;
    private int randomNumber;

    public GuessNumberFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guess_number, container, false);

        etGuess = view.findViewById(R.id.et_guess);
        btnGuess = view.findViewById(R.id.btn_guess);
        btnRestart = view.findViewById(R.id.btn_restart);
        tvHint = view.findViewById(R.id.tv_hint);

        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartGame();
            }
        });

        // Generar un número aleatorio al iniciar el juego
        generateRandomNumber();

        return view;
    }

    private void generateRandomNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(10) + 1; // Número aleatorio entre 1 y 100
    }

    private void checkGuess() {
        if (!etGuess.getText().toString().isEmpty()) {
            int guess = Integer.parseInt(etGuess.getText().toString());
            if (guess == randomNumber) {
                tvHint.setText("¡Adivinaste! El número secreto era " + randomNumber);
            } else if (guess < randomNumber) {
                tvHint.setText("Intenta con un número mayor.");
            } else {
                tvHint.setText("Intenta con un número menor.");
            }
        } else {
            Toast.makeText(getActivity(), "Por favor, introduce un número.", Toast.LENGTH_SHORT).show();
        }
    }

    private void restartGame() {
        etGuess.setText("");
        tvHint.setText("");
        generateRandomNumber();
    }
}