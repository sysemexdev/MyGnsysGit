package sysemex.mygnsys;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class W_inicial extends AppCompatActivity implements View.OnClickListener{

    final private int tiempocarga = 1000;


    private ImageView imv_logo;
    private ProgressBar pba_cargando;
    private TextView tev_nombre_app;
    private RelativeLayout vista_inicial, vista_final;

    private Button bot_iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_w_inicial);

        InicializaControles();
        new CountDownTimer(tiempocarga, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                pba_cargando.setVisibility(GONE);
                tev_nombre_app.setVisibility(GONE);
                //vista_inicial.setBackgroundColor(ContextCompat.getColor(W_inicial.this, R.color.colorSplashText));
                vista_inicial.setBackgroundResource(R.drawable.im_fondo3);
                //imv_logo.setImageResource(R.drawable.ic_action_test2);
                startAnimation();
            }
        }.start();

    }

    private void InicializaControles() {
        imv_logo = findViewById(R.id.imagen_logo);
        tev_nombre_app = findViewById(R.id.tex_nomlogo);
        pba_cargando = findViewById(R.id.loadingProgressBar);
        vista_inicial = findViewById(R.id.vista_inicial);
        vista_final = findViewById(R.id.vista_final);

        bot_iniciar = findViewById(R.id.iniciar_sesion);
        bot_iniciar.setOnClickListener(this);
    }

    private void startAnimation() {
        ViewPropertyAnimator viewPropertyAnimator = imv_logo.animate();
        viewPropertyAnimator.y(350f);
        viewPropertyAnimator.setDuration(1000);
        viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                vista_final.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }


    @Override
    public void onClick(View view) {
        if (view.equals(bot_iniciar))        Acceso();
    }


    private void Acceso(){
        try
        {
            Intent intent = new Intent(W_inicial.this, W_principal.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);

        }catch (Exception ex){}

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_w_inicial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
