/**
 * Classe para objetos do tipo Usuario, onde serão contidos, valores e métodos para o mesmo.
 * @author Bruno Kaike
 * @version 1.0.0
 */

package br.ufrn.imd.model;
import java.util.Map;

public class Usuario {

    /**
     * nome do usuario.
     */
    private String nome;

    /**
     * email do usuario que poderá ser usado para o login.
     */
    private String email;

    /**
     * senha do usuario que poderá ser usada para o login.
     */
    private String senha;

    /**
     * endereco do usuario que será usado como informação para a adoção e cadastro de um animal.
     */
    private Endereco endereco;

    /**
     * Fichas referentes a todas as adoções do usuario.
     */
    private Map<Integer, FichaDeAdocao> fichasDeAdocao;

    public Usuario(String nome, String email, String senha, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Map<Integer, FichaDeAdocao> getFichasDeAdocao() {
        return fichasDeAdocao;
    }

    public void setFichasDeAdocao(Map<Integer, FichaDeAdocao> fichasDeAdocao) {
        this.fichasDeAdocao = fichasDeAdocao;
    }

}
