package udinova.fanatico.Models.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import udinova.fanatico.R;

/**
 * Created by luisp on 17/5/2018.
 */

public class Alert_Dialog_P {
    Dialog customDialog;
    Button btnAceptar,btnCancelar,btnNeutro;
    TextView titulo,contenido;
    LinearLayout containerbotonsino, containerbotoneutro,containerLoading;
    ImageView loading;
    Context context;

    public Alert_Dialog_P(Context contexto){
        this.context = contexto;
        customDialog = new Dialog(context, R.style.Theme_Dialog_Translucent);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setCancelable(false);
        customDialog.setContentView(R.layout.alertdialog_personalize);

        titulo = (TextView) customDialog.findViewById(R.id.al_titulo);
        contenido = (TextView) customDialog.findViewById(R.id.al_contenido);
        btnAceptar = (Button)customDialog.findViewById(R.id.al_btnaceptar);
        btnCancelar = (Button)customDialog.findViewById(R.id.al_btncancelar);
        btnNeutro = (Button)customDialog.findViewById(R.id.al_btnneutro);
        loading = (ImageView) customDialog.findViewById(R.id.al_loading);
        containerbotonsino = (LinearLayout) customDialog.findViewById(R.id.al_botonera);
        containerbotoneutro = (LinearLayout) customDialog.findViewById(R.id.al_botoneraneutral);
        containerLoading = (LinearLayout)  customDialog.findViewById(R.id.al_loadingcont);

        btnAceptar.setOnClickListener(click);
        btnCancelar.setOnClickListener(click);
        btnNeutro.setOnClickListener(click);
        customDialog.setCanceledOnTouchOutside(true);

    }

    public View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         customDialog.dismiss();
        }
    };
    public void show(){
        containerLoading.setVisibility(View.GONE);
        contenido.setVisibility(View.VISIBLE);
        customDialog.show();
    }
    public void showwait(){
        Glide.with(context)
                .load(R.drawable.loading_gif)
                .asGif()
                .into(loading);
        containerLoading.setVisibility(View.VISIBLE);
        containerbotonsino.setVisibility(View.GONE);
        containerbotoneutro.setVisibility(View.GONE);
        contenido.setVisibility(View.GONE);
        titulo.setText("Espere un momento");
        customDialog.show();
    }
    public void setTitulo(String cadena){
        titulo.setText(cadena);
    }
    public void setContenido(String cadena){
        contenido.setText(cadena);
    }

    public void setTextNeutralButton(String  cadena){
        btnNeutro.setText(cadena);
    }
    public void enableNeutralButton(Boolean bol){
        if (bol) {
            containerbotoneutro.setVisibility(View.VISIBLE);
        }else {
            containerbotonsino.setVisibility(View.GONE);
        }

    }
    public void enableBotones(Boolean bol){
        if (bol) {
            containerbotonsino.setVisibility(View.VISIBLE);
        }else {
            containerbotonsino.setVisibility(View.GONE);
        }

    }
    public void dismiss(){
        customDialog.dismiss();
    }
}
