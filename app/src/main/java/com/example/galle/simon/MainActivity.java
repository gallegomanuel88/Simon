package com.example.galle.simon;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> color = new ArrayList<Integer>();
    MediaPlayer [] sonidos;

    Button botonVerde;
    Button botonRojo;
    Button botonAmarillo;
    Button botonAzul;
    Button botonJugar;
    Intent prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonVerde = (Button) findViewById(R.id.color0);
        botonRojo = (Button) findViewById(R.id.color1);
        botonAmarillo = (Button) findViewById(R.id.color2);
        botonAzul = (Button) findViewById(R.id.color3);
        botonJugar = (Button) findViewById(R.id.jugar);
        sonidos = new MediaPlayer[5];
        sonidos [0] = MediaPlayer.create(this,R.raw.sonidodo);
        sonidos [1] = MediaPlayer.create(this,R.raw.sonidore);
        sonidos [2] = MediaPlayer.create(this,R.raw.sonidomi);
        sonidos [3] = MediaPlayer.create(this,R.raw.sonidofa);
        sonidos [4] = MediaPlayer.create(this,R.raw.error);
        prueba = new Intent (MainActivity.this, MainActiviti2.class);
    }

    int dificultad = 4;
    static int pulsaciones = 0;

    int retardoComprobacion = 0;
    int retardoComprobacion2 = 450;

    public void metodoVerde (View view){
        if (pulsaciones < dificultad) {
            if (0 == color.get(pulsaciones)) {
                botonVerde.postDelayed(new Runnable() {
                    public void run() {
                        botonVerde.setText("bien");
                    }
                }, retardoComprobacion);
                botonVerde.postDelayed(new Runnable() {
                    public void run() {
                        botonVerde.setText("");
                    }
                }, retardoComprobacion2);

                pulsaciones++;
                Toast.makeText(this, "hola toast", Toast.LENGTH_SHORT).show();
            }
            /**if (color.size() == 0){
             Toast.makeText(this, "hola toast", Toast.LENGTH_SHORT).show();
             }*/
            else {
                botonVerde.postDelayed(new Runnable() {
                    public void run() {
                        botonVerde.setText("mal");
                    }
                }, retardoComprobacion);
                botonVerde.postDelayed(new Runnable() {
                    public void run() {
                        botonVerde.setText("");
                    }
                }, retardoComprobacion2);
            }
        }
    }
    public void metodoRojo (View view){
        if (pulsaciones < dificultad) {
            if (1 == color.get(pulsaciones)) {
                botonRojo.postDelayed(new Runnable() {
                    public void run() {
                        botonRojo.setText("bien");
                    }
                }, retardoComprobacion);
                botonRojo.postDelayed(new Runnable() {
                    public void run() {
                        botonRojo.setText("");
                    }
                }, retardoComprobacion2);
                pulsaciones++;
            } else {
                botonRojo.postDelayed(new Runnable() {
                    public void run() {
                        botonRojo.setText("mal");
                    }
                }, retardoComprobacion);
                botonRojo.postDelayed(new Runnable() {
                    public void run() {
                        botonRojo.setText("");
                    }
                }, retardoComprobacion2);
            }
        }
    }
    public void metodoAmarilo (View view){
        if (pulsaciones < dificultad) {
            if (2 == color.get(pulsaciones)) {
                botonAmarillo.postDelayed(new Runnable() {
                    public void run() {
                        botonAmarillo.setText("bien");
                    }
                }, retardoComprobacion);
                botonAmarillo.postDelayed(new Runnable() {
                    public void run() {
                        botonAmarillo.setText("");
                    }
                }, retardoComprobacion2);
                pulsaciones++;
            } else {
                botonAmarillo.postDelayed(new Runnable() {
                    public void run() {
                        botonAmarillo.setText("mal");
                    }
                }, retardoComprobacion);
                botonAmarillo.postDelayed(new Runnable() {
                    public void run() {
                        botonAmarillo.setText("");
                    }
                }, retardoComprobacion2);
            }
        }
    }
    public void metodoAzul (View view){
        if (pulsaciones < dificultad) {
            if (3 == color.get(pulsaciones)) {
                botonAzul.postDelayed(new Runnable() {
                    public void run() {
                        botonAzul.setText("bien");
                    }
                }, retardoComprobacion);
                botonAzul.postDelayed(new Runnable() {
                    public void run() {
                        botonAzul.setText("");
                    }
                }, retardoComprobacion2);
                pulsaciones++;
            } else {
                botonAzul.postDelayed(new Runnable() {
                    public void run() {
                        botonAzul.setText("mal");
                    }
                }, retardoComprobacion);
                botonAzul.postDelayed(new Runnable() {
                    public void run() {
                        botonAzul.setText("");
                    }
                }, retardoComprobacion2);
            }
        }
    }

    public void comprobar (int colorSeleccionado) {
        if (colorSeleccionado == color.get(pulsaciones)){
            sonidos[colorSeleccionado].start();
            pulsaciones++;
            if (pulsaciones == dificultad){
                Toast.makeText(this, "Muy bien has ganado", Toast.LENGTH_SHORT).show();
                startActivity(prueba);
                botonJugar.setText("JUGAR");
            }
        }
        else {
            sonidos [4].start();
        }
     }

    public void neutro (View v){
        final Button boton = (Button)v;
        if (color.size() == 0){
            Toast.makeText(this, "Pulsa el boton 'JUGAR' para empezar", Toast.LENGTH_SHORT).show();
        }
        else if (pulsaciones < dificultad) {
            if (boton.getId() == R.id.color0) {
                cambiarColor(R.color.verdeBrillante, R.color.verdeSimon, boton);
                comprobar(0);
            } else if (boton.getId() == R.id.color1) {
                cambiarColor(R.color.rojoBrillante, R.color.rojoSimon, boton);
                comprobar(1);
            } else if (boton.getId() == R.id.color2) {
                cambiarColor(R.color.amarilloBrillante, R.color.amarilloSimon, boton);
                comprobar(2);
            } else if (boton.getId() == R.id.color3) {
                cambiarColor(R.color.azulBrillante, R.color.azulSimon, boton);
                comprobar(3);
            }
        }
    }

    public void cambiarColor(final int colorNuevo,final int colorViejo, final Button boton){
        boton.postDelayed(new Runnable() {
            public void run() {
                boton.setBackgroundResource(colorNuevo);
            }
        }, retardoComprobacion);
        botonVerde.postDelayed(new Runnable() {
            public void run() {
                boton.setBackgroundResource(colorViejo);
            }
        }, retardoComprobacion2);
    }

    public void generador (View v){

        botonJugar.setText("REINICIAR");
        color.clear();
        pulsaciones = 0;

        int retardoGenerador=0;
        int retardoGenerador2=460;

        for (int i = 0; i < dificultad; i++) {
            int numeroAleatorio = (int) (Math.random()*4);
            color.add(numeroAleatorio);

            retardoGenerador +=700;
            retardoGenerador2 +=700;
            if(numeroAleatorio==0){
                botonVerde.postDelayed(new Runnable() {
                    public void run() {
                        botonVerde.setText("Verde");
                        cambiarColor(R.color.verdeBrillante, R.color.verdeSimon, botonVerde);
                        sonidos[0].start();
                    }
                }, retardoGenerador);
                botonVerde.postDelayed(new Runnable() {
                    public void run() {
                        MainActivity.this.botonVerde.setText("");
                    }
                }, retardoGenerador2);
            }

            if(numeroAleatorio==1){
                botonRojo.postDelayed(new Runnable() {
                    public void run() {
                        botonRojo.setText("Rojo");
                        cambiarColor(R.color.rojoBrillante, R.color.rojoSimon, botonRojo);
                        sonidos[1].start();
                    }
                }, retardoGenerador);
                botonRojo.postDelayed(new Runnable() {
                    public void run() {
                        MainActivity.this.botonRojo.setText("");
                    }
                }, retardoGenerador2);
            }

            if(numeroAleatorio==2){
                botonAmarillo.postDelayed(new Runnable() {
                    public void run() {
                        botonAmarillo.setText("Amarillo");
                        cambiarColor(R.color.amarilloBrillante, R.color.amarilloSimon, botonAmarillo);
                        sonidos[2].start();
                    }
                }, retardoGenerador);
                botonAmarillo.postDelayed(new Runnable() {
                    public void run() {
                        MainActivity.this.botonAmarillo.setText("");
                    }
                }, retardoGenerador2);
            }

            if(numeroAleatorio==3){
                botonAzul.postDelayed(new Runnable() {
                    public void run() {
                        botonAzul.setText("Azul");
                        cambiarColor(R.color.azulBrillante, R.color.azulSimon, botonAzul);
                        sonidos[3].start();
                    }
                }, retardoGenerador);
                botonAzul.postDelayed(new Runnable() {
                    public void run() {
                        MainActivity.this.botonAzul.setText("");
                    }
                }, retardoGenerador2);
            }

        }
    }

}
