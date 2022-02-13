/**
 * Formatação das funções relativas a manipulação de objetos do tipo FichaCadastralAnimal salvos na memória.
 * @author Bruno Kaike
 * @version 1.0.0
 */
package br.ufrn.imd.dao;

import br.ufrn.imd.model.FichaCadastralAnimal;

import java.util.HashMap;

public interface FichaCadastralAnimalDAO {

    /**
     * Salva na memória a ficha de cadastro recebida.
     * @param ficha ficha de cadastro a ser cadastrada.
     */
    void salvar(FichaCadastralAnimal ficha);

    /**
     * Remove da memória a ficha de cadastro com base no id recebido.
     * @param id id da ficha de cadastro a ser removida.
     */
    void remover(int id);

    /**
     * Edita na memória a ficha de cadastro referente ao id recebido.
     * @param id id da ficha de cadastro a ser atualizada.
     * @param ficha objeto ficha de cadastro que irá substituir o antigo.
     */
    void editar(int id, FichaCadastralAnimal ficha);

    /**
     * Retorna todos as fichas de cadastro salvas na memória.
     * @return todos as fichas de cadastro
     */
    HashMap<Integer, FichaCadastralAnimal> retornarFichas();

}
