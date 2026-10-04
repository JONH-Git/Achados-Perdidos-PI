package models;

import play.data.validation.InPast;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Objeto extends Model {

    @Required
    @MinSize(4)
    public String nome;

    @Required
    @MinSize(10)
    public String descricao;

    @Required
    @MinSize(10)
    public String local;

    @InPast
    public Date dataAchado;

    @Enumerated(EnumType.STRING)
    public Status status;

    @Enumerated(EnumType.STRING)
    public StatusObjeto statusObjeto;

    @ManyToOne
    public Usuario usuario;

    public Objeto() {
        this.status = Status.ATIVO;
        this.statusObjeto = StatusObjeto.REGISTRADO;
    }

    public void devolver() {
        this.statusObjeto = StatusObjeto.DEVOLVIDO;
        this.save();
    }
}