package br.ufrn.imd.model;

public class Endereco {

    /**
     * cidade referente ao endereço do usuario.
     */
    private String cidade;

    /**
     * estado referente ao endereço do usuario.
     */
    private String estado;

    public Endereco(String cidade, String estado){

        this.cidade = cidade;
        this.estado = estado;

    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
