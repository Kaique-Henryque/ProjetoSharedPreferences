package com.example.sharedpreferences26;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sharedpreferences26.Utils.ColorPreferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewMain = new ViewHolder();
    private ColorPreferences myColorPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.myColorPreference = new ColorPreferences(this);

        this.mViewMain.btnCor1 = this.findViewById(R.id.btnCor1);
        this.mViewMain.btnCor2 = this.findViewById(R.id.btnCor2);
        this.mViewMain.btnCor3 = this.findViewById(R.id.btnCor3);
        this.mViewMain.menu = this.findViewById(R.id.menu);

        this.mViewMain.btnCor1.setOnClickListener(this);
        this.mViewMain.btnCor2.setOnClickListener(this);
        this.mViewMain.btnCor3.setOnClickListener(this);
        mudarCor();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflando Menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuprincipal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Colocando onclick nos botões do menu
        if(item.getItemId() == R.id.cor1){
            this.myColorPreference.storeColor("cor", 1);
            mudarCor();
        }
        else if(item.getItemId() == R.id.cor2)
        {
            this.myColorPreference.storeColor("cor", 2);
            mudarCor();
        }
        else if(item.getItemId() == R.id.cor3){
            this.myColorPreference.storeColor("cor", 3);
            mudarCor();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == this.mViewMain.btnCor1.getId())
        {
            this.myColorPreference.storeColor("cor", 1);
            mudarCor();
        }
        else if(v.getId() == this.mViewMain.btnCor2.getId())
        {
            this.myColorPreference.storeColor("cor", 2);
            mudarCor();
        }
        else if(v.getId() == this.mViewMain.btnCor3.getId())
        {
            this.myColorPreference.storeColor("cor", 3);
            mudarCor();
        }
    }

    public void mudarCor(){
        //método responssavel por mudar a cor do fundo de acordo com o SharedPreferences
        if(this.myColorPreference.getStoredColor("cor") == 1)
        {
            this.mViewMain.menu.setBackgroundColor(getResources().getColor(R.color.Azul));
        }
        else if(this.myColorPreference.getStoredColor("cor") == 2)
        {
            this.mViewMain.menu.setBackgroundColor(getResources().getColor(R.color.Verde));
        }
        else if (this.myColorPreference.getStoredColor("cor") == 3){
            this.mViewMain.menu.setBackgroundColor(getResources().getColor(R.color.Cinza));
        }
    }

    private static class ViewHolder{
        private RelativeLayout menu;
        private Button btnCor1;
        private Button btnCor2;
        private Button btnCor3;
    }
}
