/**
 * Implementação das funções relativas a manipulação de objetos do tipo FichaCadastralAnimal salvos na memória.
 * @author Bruno Kaike
 * @version 1.0.0
 * @see br.ufrn.imd.dao.FichaCadastralAnimalDAO
 */
package br.ufrn.imd.dao;

import br.ufrn.imd.model.FichaCadastralAnimal;

import java.util.HashMap;

public class FichaCadastralAnimalDAOClass implements FichaCadastralAnimalDAO{

    HashMap<Integer, FichaCadastralAnimal> fichas = new HashMap<Integer, FichaCadastralAnimal>();
    int idCadastro = 1;

    /**
     * {@inheritDoc}
     */
    @Override
    public void salvar(FichaCadastralAnimal ficha){

        fichas.put(idCadastro, ficha);
        idCadastro++;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void editar(int id, FichaCadastralAnimal ficha){

        fichas.put(id, ficha);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remover(int id){

        fichas.remove(id);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HashMap<Integer, FichaCadastralAnimal> retornarFichas(){

        return fichas;

    }

}
