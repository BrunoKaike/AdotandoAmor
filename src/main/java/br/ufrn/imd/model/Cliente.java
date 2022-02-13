/**
 * Classe para objetos do tipo Cliente.
 * @author Bruno Kaike
 * @version 1.0.0
 * @see br.ufrn.imd.model.Usuario
 */
package br.ufrn.imd.model;

public class Cliente extends Usuario{

    public Cliente(String nome, String email, String senha, Endereco endereco){

        super(nome, email, senha, endereco);

    }
}
