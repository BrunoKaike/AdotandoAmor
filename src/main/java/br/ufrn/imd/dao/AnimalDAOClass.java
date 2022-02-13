/**
 * Implementação das funções relativas a manipulação de objetos do tipo Animal salvos na memória.
 * @author Bruno Kaike
 * @version 1.0.0
 * @see br.ufrn.imd.dao.AnimalDAO
 */

package br.ufrn.imd.dao;

import br.ufrn.imd.model.Animal;
import java.util.HashMap;

public class AnimalDAOClass implements AnimalDAO{

    HashMap<Integer, Animal> animais = new HashMap<Integer, Animal>();
    int idCadastro = 1;

    /**
     * {@inheritDoc}
     */
    @Override
    public void salvar(Animal animal){

        animais.put(idCadastro, animal);
        idCadastro++;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void editar(int id, Animal animal){

        animais.put(id, animal);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remover(int id){

        animais.remove(id);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HashMap<Integer, Animal> retornarAnimais(){

        return animais;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Animal retornarAnimalPorId(int id){

        return animais.get(id);

    }

}
