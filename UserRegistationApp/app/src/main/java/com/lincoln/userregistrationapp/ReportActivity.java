package com.lincoln.userregistrationapp;

// Importacoes de componentes de UI, intencoes e a biblioteca ROOM
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


import java.util.List;

public class ReportActivity extends AppCompatActivity {
    //Campo de Texto onde os dados do banco serao exibidos
    private TextView textViewReport;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // Define o layout XML dessa tela de relatorio
        setContentView(R.layout.activity_report);
        // Mapeamento do textView do XML para o Java
        textViewReport = findViewById(R.id.textViewReport);
        // encontra o botao e define o clique para voltar
        Button btnVoltar = findViewById(R.id.btnVoltar);
        //O botao de retorno utilizando expressao lambda
        btnVoltar.setOnClickListener(v -> voltarParaCadastro());

        /*
        Conexao com o banco de dados
        1 - Cria uma Instancia do banco "user-database"
        2 - .allowMainThreadQueries(): Serve para liberar operacoes de consulta feitas em threads da UI.
                                        Por padrao, ROOM proibe isso. O correto seria fazer consultas em threads separadas.
        */
        UserDataBase db = Room.databaseBuilder(getApplicationContext(), UserDataBase.class, "user-database").allowMainThreadQueries().build();

        // Obtem o objeto DAO (Data acess Object) que contem as queries SQL
        UserDao userDao = db.userDao();
        // Recupera todos os usuarios salvos no BD e armazena numa lista
        List<User> userList = userDao.getAllUsers();
        // StringBuilder: forma eficiente de construtor uma String longa dentro de um laço (loop)
        StringBuilder report = new StringBuilder();

        // Loop "for-each" para percorrer cada objeto User dentro da lista separada
        for(User user : userList){
            report.append("Nome: ").append(user.getName()).append("\n").append("CPF: ").append(user.getCpf()).append("\n\n");
        }

        // Exibe o relatorio final montado na TextView da tela
        textViewReport.setText(report.toString());
    }

    // Metodo responsavel pela navegacao entre as telas do app
    public void voltarParaCadastro(){
    // Intencao para abrir a tela de cadastro
        Intent intent = new Intent(ReportActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // fecha a tela de relatorio para nao acumular na pilha de tarefas

    }
}
