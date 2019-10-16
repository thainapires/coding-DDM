package com.thaina.simplestapptiattrtcib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    //Subscrever contrato/inferface -> Assumir compromisso(s) OnClick

    /*
    Membros de dados de uma class, são identificadores acessíveis em todos os metodos da class,
    declarados fora de qualquer método, em qualquer lugar da class, embora seja comum declará-los
    no início
     */

    /*
    Quando não indicamos o nível de acesso é como se fosse protected, é um default

    Ou não dizemos nada ou private

     */

    private Button mBtnExample;
    Context mContext; //Ponte para várias coisas relacionadas com a activity (métodos) - Ferramentas a disposição de uma activity

    //Técnica 2, +reutilizável e simples
    //Declarar objeto dedicado a tarefa de responder a clicks em quaisquer Button
    Button.OnClickListener mButtonClickHandler = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch(id){
                case R.id.idBtnExample:
                    //sol particular para idBtnExample
                    break;
            }//switch

            //Solução comum a todos
            sayHello("pela tecnica 2");

        }//onClick
    };//Não esquecer de terminar com ponto e virgula

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }//onCreate

    /*
    no nosso padrão, em init queremos fazer duas coisas:
    1) Associar membros de dados Java e elementos XML relevantes
    2) Conferir aos elementos XML relevantes, via membros de dados Java, comportamentos
     */

    void init(){
        //1
        mBtnExample = findViewById(R.id.idBtnExample);
        //Context mContext = MainActivity.this;
        //mContext = getApplicationContext();
        mContext = this;

        //2
        Boolean bDesligarComportamentos = true;
        if(!bDesligarComportamentos){
            if (mBtnExample!=null){
                //Conferir comportamento(s)
                //Técnica #1 - não nos interessa muito
            /*
            this significa a instância corrente desta Activity; neste caso, significa também
            que é a instância que está a fornecer a solução para responder a click (via método
            onClick, conforme contrato subscrito)
             */
                mBtnExample.setOnClickListener((this)); //t1

            /*
            Esta instrução rouba efeitos a instruçao anterior porque faz com que o comportamento,
            em caso de click do mBtnExample passe a ser feito pela técnica #2 (que é a de usarmos
            um objeto dedicado para dar conta de todos os clicks)
             */
                mBtnExample.setOnClickListener(mButtonClickHandler); //t2
            }//if
        }

    }//init

    /*
    Técnica #1 para responder a click em button
    Assumir a inferface Button.OnClickListener que vem com a obrigação de escrever um método void
    de nome "onClick", que receba por param, a View que tiver sido clicked
    O esqueleto do método pode ser obtid automagicamente via atalho ALT+ENTER
     */
    @Override
    public void onClick(View v) {
        sayHello("Pela técnica 1");
    }//onClick

    void sayHello(String pStr){
        //Pela técnica 1
        /*String strHello = this.getResources().getString(R.string.strHello);
        Toast t = Toast.makeText(
                mContext,
                strHello,
                Toast.LENGTH_SHORT
        );*/

        //Prefixar o hello com o parametro
        String strHello = pStr+" "+this.getResources().getString(R.string.strHello);
        Toast t = Toast.makeText(
                mContext,
                strHello,
                Toast.LENGTH_SHORT
        );

        t.show();
    }//sayHello

    //Método precisa seguir regras, public ... etc
    public void tecnica3(View nomeDaView){
        sayHello("Técnica 3");
    }//tecnica3

}//MainActivity
