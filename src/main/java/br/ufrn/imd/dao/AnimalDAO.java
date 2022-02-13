/**
 * Formatação das funções relativas a manipulação de objetos do tipo Animal salvos na memória.
 * @author Bruno Kaike
 * @version 1.0.0
 */
package br.ufrn.imd.dao;
import br.ufrn.imd.model.Animal;
import java.util.HashMap;

public interface AnimalDAO {

    /**
     * Salva na memória o animal recebido.
     * @param animal animal a ser cadastrado.
     */
    void salvar(Animal animal);

    /**
     * Edita na memória o animal referente ao id recebido.
     * @param id id do animal a ser atualizado.
     * @param animal objeto animal que irá substituir o antigo.
     */
    void editar(int id, Animal animal);

    /**
     * Remove da memória o animal com base no id recebido.
     * @param id id do animal a ser removido.
     */
    void remover(int id);

    /**
     * Retorna todos os animais salvos na memória.
     * @return todos os animais
     */
    HashMap<Integer, Animal> retornarAnimais();

    /**
     * Retorna um animal de acordo com o id recebido.
     * @param id id do animal a ser retornado.
     * @return animal que corresponde ao id recebido
     */
    Animal retornarAnimalPorId(int id);

}
