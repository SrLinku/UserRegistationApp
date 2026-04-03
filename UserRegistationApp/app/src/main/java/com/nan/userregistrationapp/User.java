package com.nan.userregistrationapp;

//Importa anotaçoes do ROOM necessários para está classe como uma entidade do banco de dados
//comando: alt+enter para o gradle sincronizar e importar o room

import  androidx.room.Entity;
import  androidx.room.PrimaryKey;

@Entity

public class User {
//Define o campo 'id' como chave primária e configura para ser gerado automaticamente

@PrimaryKey(autoGenerate = true)
//Criando id da entidade
    private int id;
//Campo que representa as colunas para armazenar os dados do usuário
    private String name; // nome do usuário
    private String cpf; // cpf do usuário
    private String email; // email do usuário
    private String phone; // telefone do usuário

    //Construtor de classe que será usado para criar novo objeto

    public User(String name, String cpf, String email, String phone){
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
    }

    //Método getter e setter para acessar e modificar os doados do objetos User

    //Retorna o ID do usuário
    public  int getId()
    {
        return id;
    }

    //Define o ID do usuário (usado pelo room para preencher automaticamente
    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        //nome do usuario
        return name;
    }
    public String getCpf()
    {
       //cpf do usuario
        return cpf;
    }

    public String getEmail()
    {   //email do usuário
        return email;
    }

    public String getPhone()
    {   //phone do usuário
        return phone;
    }
}


