package com.lincoln.userregistrationapp;
// Importa as anotacoes e classes da biblioteca room e do Android
import android.content.Context;// classe que representa o contexto da aplicação ( necessario para acessar recursos)
import androidx.room.Database; // Anotacao para marcar a classe como um banco de dados room
import androidx.room.Room;
import androidx.room.RoomDatabase; // Classe base que representa o BD

// Anotacao @Database define que a classe representa o banco de dados room
// Ela especifica as entidades (tabelas) que o banco ira conter e a versao do BD
@Database(entities = {User.class}, version = 1)
public abstract class UserDataBase extends RoomDatabase {
    // Instancia unica (singleton) do BD
    private static UserDataBase instance;

    //metodo abstrato que sera implementado pela room
    public abstract UserDao userDao();

    //Metodo que retorna a instancia do BD
    //O Uso do 'synchronized' garante que apenas uma thread possa acessar este metodo por vez, evitando que duas instancias do BD sejam criadas acidentalmente
    public static synchronized UserDataBase getInstance(Context context) {
    // Verificar se ja existe uma instancia de BD
        if(instance == null){
            // Cria a instancia do BD usando Room
            // usa o contexto da aplicacao para evitar vazamento de memoria
            // fallbackToDestructiveMigration - se houver mudança de versao e nao houver migracao, o BD sera recriado do zero
            instance = Room.databaseBuilder(context.getApplicationContext(), UserDataBase.class, "user-database" ).fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        // Retorna a instancia criada
        return instance;
    }

}
