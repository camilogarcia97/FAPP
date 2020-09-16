package co.edu.unimagdalena.apmoviles.tallerunimag1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SenconActivity extends AppCompatActivity implements View.OnClickListener{

    EditText n1, n2;
    Button suma, resta, division, multiplicacion, mayor, mcm, mcd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sencon);
        n1 = findViewById(R.id.edtn1);
        n2 = findViewById(R.id.edtn2);
        suma = findViewById(R.id.btnSumar);
        resta = findViewById(R.id.btnRestar);
        division = findViewById(R.id.btndiv);
        multiplicacion = findViewById(R.id.btnMul);
        mayor = findViewById(R.id.btnMayor);
        mcm = findViewById(R.id.btnMcm);
        mcd = findViewById(R.id.btnMcd);

        suma.setOnClickListener(this);
        resta.setOnClickListener(this);
        division.setOnClickListener(this);
        multiplicacion.setOnClickListener(this);
        mayor.setOnClickListener(this);
        mcm.setOnClickListener(this);
        mcd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int num1 = Integer.parseInt(n1.getText().toString());
        int num2 = Integer.parseInt(n2.getText().toString());
        switch (v.getId()){
            case R.id.btnSumar:
                Toast.makeText(this, "Suma = " + (num1 + num2), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRestar:
                Toast.makeText(this, "Resta = " + (num1 - num2), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btndiv:
                if(num1 == 0){
                    Toast.makeText(this, "Syntax error", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "división = " + (num1 / num2), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnMul:
                Toast.makeText(this, "multiplicación = " + (num1 * num2), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnMayor:
                Toast.makeText(this, "Mayor = " + mayor(num1, num2), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnMcm:
                Toast.makeText(this, "Mcm = " + mcm(num1, num2), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnMcd:
                Toast.makeText(this, "Mcm = " + mcd(num1, num2), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }
    }

    public int mayor(int num1,int num2){
        if(num1 > num2){
            return num1;
        }else{
            return num2;
        }
    }

    public int mcm(int num1, int num2){
        int multiplo;

        multiplo = mayor(num1, num2);

        while (multiplo%num1!=0 || multiplo%num2!=0)
            multiplo++;
        return multiplo;
    }

    public int mcd(int num1,int num2){
        while(num1 != num2)
            if(num1>num2) {
                num1 = num1 - num2;
            }else {
                num2 = num2 - num1;
            }
        return num1;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.m1: Toast.makeText(this,"Menu 1", Toast.LENGTH_LONG).show();
            break;
            case R.id.m2: Toast.makeText(this,"Menu 2", Toast.LENGTH_LONG).show();
            break;
            case R.id.m3: Toast.makeText(this,"Menu 3", Toast.LENGTH_LONG).show();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}