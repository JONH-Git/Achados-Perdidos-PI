package models;

import play.data.validation.*;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Usuario extends Model {

    @Required
    @MinSize(4)
    public String nome;

    @Required
    @MinSize(6)
    public String senha;

    @Required
    @Email
    @Unique
    public String email;

    @Required
    public String turma;

    @Required
    @MinSize(9)
    @MaxSize(9)
    @Unique
    public String telefone;

    @Enumerated(EnumType.STRING)
    public Status status;

    @Enumerated(EnumType.STRING)
    public TipoUsuario tipoUsuario;

    public Usuario() {
        this.status = Status.ATIVO;
        this.tipoUsuario = TipoUsuario.USUARIO;
    }

    public Usuario(String nome, String senha, String email, String telefone, TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.status = Status.ATIVO;
        this.tipoUsuario = tipoUsuario;
    }
}