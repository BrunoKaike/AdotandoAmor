/**
 * Formatação das funções relativas a manipulação de objetos do tipo Usuario salvos na memória.
 * @author Bruno Kaike
 * @version 1.0.0
 */
package br.ufrn.imd.dao;

import br.ufrn.imd.model.Usuario;

import java.util.HashMap;
import java.util.Map;

public interface UsuarioDAO {

    /**
     * Salva na memória o usuario recebido.
     * @param usuario usuario a ser cadastrado.
     */
    void salvar(Usuario usuario);

    /**
     * Edita na memória o usuario referente ao id recebido.
     * @param id id do usuario a ser atualizado.
     * @param usuario objeto usuario que irá substituir o antigo.
     */
    void editar(int id, Usuario usuario);

    /**
     * Remove da memória o usuario com base no id recebido.
     * @param id id do usuario a ser removido.
     */
    void remover(int id);

    /**
     * Retorna todos os usuarios salvos na memória.
     * @return todos os usuarios
     */
    HashMap<Integer, Usuario> retornarUsuarios();

    /**
     * Retorna um usuario de acordo com o id recebido.
     * @param id id do usuario a ser retornado.
     * @return usuario que corresponde ao id recebido
     */
    Usuario retornarUsuarioPorId(int id);

    /**
     * Retorna um usuario de acordo com o email e senha recebidos.
     * @param email email do usuario a ser buscado
     * @param senha senha do usuario a ser buscado
     * @return usuario que corresponde ao email e senha recebidos
     */
    Map.Entry<Integer, Usuario> retornarUsuarioPorEmailESenha(String email, String senha);

}
