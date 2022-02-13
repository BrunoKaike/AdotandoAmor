/**
 * Classe para objetos do tipo Ficha de adoção do animal, onde serão contidos, valores e métodos para o mesmo.
 * @author Bruno Kaike
 * @version 1.0.0
 */

package br.ufrn.imd.model;

import java.util.Date;

public class FichaDeAdocao {

    private FichaCadastralAnimal fichaCadastralAnimal;

    private Date data;

    public FichaCadastralAnimal getFichaCadastralAnimal() {
        return fichaCadastralAnimal;
    }

    public void setFichaCadastralAnimal(FichaCadastralAnimal fichaCadastralAnimal) {
        this.fichaCadastralAnimal = fichaCadastralAnimal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
