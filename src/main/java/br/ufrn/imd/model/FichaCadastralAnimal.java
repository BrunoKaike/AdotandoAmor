/**
 * Classe para objetos do tipo FichaCadastralAnimal, onde serão contidos, valores e métodos para o mesmo.
 * @author Bruno Kaike
 * @version 1.0.0
 */

package br.ufrn.imd.model;

import java.util.Date;

public class FichaCadastralAnimal {

    private Usuario usuario;

    private Date data;

    private boolean aceito;

    public FichaCadastralAnimal(Usuario usuario, Date data, Boolean aceito){

        this.data = data;
        this.usuario = usuario;
        this.aceito = aceito;

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isAceito() {
        return aceito;
    }

    public void setAceito(boolean aceito) {
        this.aceito = aceito;
    }
}
