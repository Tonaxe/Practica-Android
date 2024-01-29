package com.example.unavezportodas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class JuegoFragment extends Fragment {

    private Button[][] botonesCelda = new Button[3][3];
    private boolean turnoJugador1 = true;
    private int contadorMovimientos;
    private TextView tvResultado;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_juego, container, false);

        tvResultado = root.findViewById(R.id.tv_resultado);

        // Inicializar los botones de las celdas y establecer el listener de clic
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "btn_celda" + (i * 3 + j + 1);
                int resID = getResources().getIdentifier(buttonID, "id", requireActivity().getPackageName());
                botonesCelda[i][j] = root.findViewById(resID);
                botonesCelda[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onCellClicked(v);
                    }
                });
            }
        }

        // Botón para reiniciar el juego
        Button btnReiniciar = root.findViewById(R.id.btn_reiniciar);
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciarJuego();
            }
        });

        return root;
    }

    // Método para manejar el clic en una celda
    public void onCellClicked(View v) {
        Button button = (Button) v;
        if (!button.getText().toString().equals("")) {
            // La celda ya está ocupada
            return;
        }

        if (turnoJugador1) {
            button.setText("X");
        } else {
            button.setText("O");
        }

        contadorMovimientos++;

        if (verificarGanador()) {
            if (turnoJugador1) {
                mostrarResultado("¡Jugador 1 ha ganado!");
            } else {
                mostrarResultado("¡Jugador 2 ha ganado!");
            }
        } else if (contadorMovimientos == 9) {
            mostrarResultado("¡Empate!");
        } else {
            turnoJugador1 = !turnoJugador1;
        }
    }

    // Método para verificar si hay un ganador
    private boolean verificarGanador() {
        String[][] tablero = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = botonesCelda[i][j].getText().toString();
            }
        }

        // Verificar filas y columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0].equals(tablero[i][1]) && tablero[i][0].equals(tablero[i][2]) && !tablero[i][0].equals("")) {
                return true;
            }
            if (tablero[0][i].equals(tablero[1][i]) && tablero[0][i].equals(tablero[2][i]) && !tablero[0][i].equals("")) {
                return true;
            }
        }

        // Verificar diagonales
        if (tablero[0][0].equals(tablero[1][1]) && tablero[0][0].equals(tablero[2][2]) && !tablero[0][0].equals("")) {
            return true;
        }
        if (tablero[0][2].equals(tablero[1][1]) && tablero[0][2].equals(tablero[2][0]) && !tablero[0][2].equals("")) {
            return true;
        }

        return false;
    }

    // Método para reiniciar el juego
    private void reiniciarJuego() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botonesCelda[i][j].setText("");
            }
        }
        tvResultado.setText("");
        contadorMovimientos = 0;
        turnoJugador1 = true;
    }

    // Método para mostrar el resultado en el TextView
    private void mostrarResultado(String mensaje) {
        tvResultado.setText(mensaje);
    }
}
