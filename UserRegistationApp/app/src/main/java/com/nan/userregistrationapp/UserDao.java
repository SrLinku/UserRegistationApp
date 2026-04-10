package com.nan.userregistrationapp;

//O Data Access Object é o componente que serve para persistencia de dados. Serve para definir as operações que podem ser feitas no banco de dados com relação á entidade User.

//Importa as notações do Room necessários para definir o DAO (DATA ACCESS OBJECT )
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import java.util.List;

@Dao
public interface UserDao {
    //Método para inserir um usuário na tabela do BANCO DE DADOS
    //A anotação @insert informa a Room que este método deve ser para inserir dados

    @Insert
    void insert(User user);
    //Método para buscar todos os usuários cadastrados no BD
    //A anotação @Query permite definir uma consulta SQL personalizada
    @Query("SELECT * FROM user")
    //Salvar o que foi selecionado no banco de dados em uma lista
    List<User> getAllUsers();
}

