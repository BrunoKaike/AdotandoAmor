/**
 * Classe para objetos do tipo Animal, onde serão contidos, valores e métodos para o mesmo.
 * @author Bruno Kaike
 * @version 1.0.0
 */

package br.ufrn.imd.model;

public class Animal {

    /**
     * Nome do animal.
     */
    private String nome;

    /**
     * sexo do animal.
     */
    private String sexo;

    /**
     * idade do animal.
     */
    private int idade;

    /**
     * classificação do animal como sendo filhote ou não.
     */
    private boolean filhote;

    /**
     * disponibilidade do animal para adoção.
     */
    private boolean adotado;

    /**
     * descrição das caracteristicas do animal.
     */
    private String descricao;

    /**
     * Ficha de cadastro do animal.
     */
    private FichaCadastralAnimal fichaCadastralAnimal;

    public Animal(String nome, String sexo, int idade, boolean filhote, boolean adotado, String descricao, FichaCadastralAnimal fichaCadastralAnimal){

        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.filhote = filhote;
        this.adotado = adotado;
        this.descricao = descricao;
        this.fichaCadastralAnimal = fichaCadastralAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isFilhote() {
        return filhote;
    }

    public void setFilhote(boolean filhote) {
        this.filhote = filhote;
    }

    public boolean isAdotado() {
        return adotado;
    }

    public void setAdotado(boolean adotado) {
        this.adotado = adotado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public FichaCadastralAnimal getFichaCadastralAnimal() {
        return fichaCadastralAnimal;
    }

    public void setFichaCadastralAnimal(FichaCadastralAnimal fichaCadastralAnimal) {
        this.fichaCadastralAnimal = fichaCadastralAnimal;
    }
}
