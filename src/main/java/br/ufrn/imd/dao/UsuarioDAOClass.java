/**
 * Implementação das funções relativas a manipulação de objetos do tipo Usuario salvos na memória.
 * @author Bruno Kaike
 * @version 1.0.0
 * @see br.ufrn.imd.dao.UsuarioDAO
 */
package br.ufrn.imd.dao;

import br.ufrn.imd.model.Usuario;

import java.util.HashMap;
import java.util.Map;

public class UsuarioDAOClass implements UsuarioDAO{

    HashMap<Integer, Usuario> usuarios = new HashMap<Integer, Usuario>();
    int idCadastro = 1;

    /**
     * {@inheritDoc}
     */
    @Override
    public void salvar(Usuario usuario){

        usuarios.put(idCadastro, usuario);
        idCadastro++;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void editar(int id, Usuario usuario){

        usuarios.put(id, usuario);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remover(int id){

        usuarios.remove(id);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HashMap<Integer, Usuario> retornarUsuarios(){

        return usuarios;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Usuario retornarUsuarioPorId(int id){

        return usuarios.get(id);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map.Entry<Integer, Usuario> retornarUsuarioPorEmailESenha(String email, String senha){

        for ( Map.Entry<Integer, Usuario> entry : usuarios.entrySet()) {

            Usuario tab = entry.getValue();
            if(tab.getEmail().equals(email) && tab.getSenha().equals(senha)){

                return entry;

            }
        }

        return null;

    }

}
