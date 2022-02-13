/**
 * Classe para objetos do tipo Cachorro.
 * @author Bruno Kaike
 * @version 1.0.0
 * @see br.ufrn.imd.model.Animal
 */

package br.ufrn.imd.model;

public class Cachorro extends Animal{

    public Cachorro(String nome, int idade, boolean filhote, boolean adotado, String descricao, FichaCadastralAnimal fichaCadastralAnimal){

        super(nome, idade, filhote, adotado, descricao, fichaCadastralAnimal);

    }

}
