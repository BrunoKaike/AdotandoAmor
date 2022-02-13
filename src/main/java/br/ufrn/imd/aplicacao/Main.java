/**
 * Classe responsavel pela aplicacao do projeto.
 * @author Bruno Kaike
 * @version 1.0.0
 */

package br.ufrn.imd.aplicacao;

import br.ufrn.imd.dao.AnimalDAOClass;
import br.ufrn.imd.dao.FichaCadastralAnimalDAOClass;
import br.ufrn.imd.dao.UsuarioDAOClass;
import br.ufrn.imd.excecoes.CheckedEx;
import br.ufrn.imd.model.Animal;
import br.ufrn.imd.model.Cachorro;
import br.ufrn.imd.model.FichaCadastralAnimal;
import br.ufrn.imd.model.Gato;
import br.ufrn.imd.model.Administrador;
import br.ufrn.imd.model.Cliente;
import br.ufrn.imd.model.Endereco;
import br.ufrn.imd.model.Usuario;

import java.util.*;

public class Main {

    /**
     * Id do usuario logado atualmente, sendo 0 um valor invalido.
     */
    public static int userLogadoId = 0;

    /**
     * Objeto do tipo Usuario que representa o usuario logado atualmente.
     */
    public static Usuario userLogado;

    /**
     * DAO de Usuario.
     */
    public static UsuarioDAOClass usuarioDao = new UsuarioDAOClass();

    /**
     * DAO de Animal.
     */
    public static AnimalDAOClass animalDao = new AnimalDAOClass();

    /**
     * DAO de FichaCadastralAnimal.
     */
    public static FichaCadastralAnimalDAOClass fichaCadastralAnimalDao = new FichaCadastralAnimalDAOClass();

    /**
     * Imprime um menu que pode direcionar para as telas de login ou cadastro, ou finalizar a aplicacao.
     */
    public static void main(String[] args) throws Exception {

        int acao;
        inicializarDados();

        do{

            Scanner sc1 = new Scanner(System.in);

            System.out.println("1- Realizar login\n2- Realizar cadastro\n3- Finalizar aplicação");
            acao = sc1.nextInt();

            switch(acao){
                case 1:
                    login();
                    break;

                case 2:
                    cadastroUsuario();
                    break;

                case 4:
                    listarUsuarios();
                    break;
            }


        }while(acao!=3);

    }

    /**
     * Imprime um formulário de login que direciona para a tela inicial caso o login seja efetuado com sucesso.
     * @throws CheckedEx caso os dados de email e senha inseridos nao batam com nenhum usuario cadastrado no sistema.
     */
    public static  void login() throws Exception {

        System.out.println("Login");

        Scanner sc1 = new Scanner(System.in);
        String email, senha;

        System.out.println("Digite seu email:");
        email = sc1.nextLine();

        System.out.println("Digite sua senha:");
        senha = sc1.nextLine();

        Map.Entry<Integer, Usuario> find = usuarioDao.retornarUsuarioPorEmailESenha(email, senha);

        if(find!= null){

            userLogadoId = find.getKey();
            userLogado = find.getValue();
            telaInicial();

        } else {

            throw new CheckedEx("Usuario não encontrado! Verifique seus dados novamente.");

        }

    }

    /**
     * Imprime um menu personalizado dependendo da categoria de usuario, sendo ela cliente ou administrador.
     */
    public static void telaInicial(){

        if(userLogado.getClass().getSimpleName().equals("Administrador")){

            int acao;
            do{

                Scanner sc1 = new Scanner(System.in);

                System.out.println("1- Cadastrar animal para adoção\n2- Visualizar fichas cadastrais de animais pendentes\n3- Visualizar usuários cadastrados\n4- Visualizar animais cadastrados\n5- Deslogar");
                acao = sc1.nextInt();

                switch(acao){
                    case 1:
                        cadastroAnimais();
                        break;

                    case 2:
                        listarFichasCadastraisPendentes();
                        break;

                    case 3:
                        listarUsuarios();
                        break;

                    case 4:
                        listarAnimaisCadastradosAceitos();
                        break;
                }


            }while(acao!=5);

        } else {

            int acao;
            do{

                Scanner sc1 = new Scanner(System.in);

                System.out.println("1- Cadastrar animal para adoção\n2- Visualizar animais cadastrados\n3- Deslogar");
                acao = sc1.nextInt();

                switch(acao){
                    case 1:
                        cadastroAnimais();
                        break;

                    case 2:
                        listarAnimaisCadastradosAceitos();
                        break;

                }


            }while(acao!=3);

        }

    }

    /**
     * Formulario para cadastro de novos usuarios.
     */
    public static void cadastroUsuario(){

        System.out.println("Cadastro");

        Scanner sc1 = new Scanner(System.in);

        String nome, email, senha, cidade, estado;

        System.out.println("Digite seu nome:");
        nome = sc1.nextLine();

        System.out.println("Digite seu email:");
        email = sc1.nextLine();

        System.out.println("Digite sua senha:");
        senha = sc1.nextLine();

        System.out.println("Digite sua cidade:");
        cidade = sc1.nextLine();

        System.out.println("Digite o estado:");
        estado = sc1.nextLine();

        Endereco novoEndereco = new Endereco(cidade,estado);
        Cliente novoUsuario = new Cliente(nome, email,senha, novoEndereco);

        usuarioDao.salvar(novoUsuario);

    }

    /**
     * Formulario para o cadastro de novos animais a serem adotados.
     */
    public static void cadastroAnimais(){

        System.out.println("Cadastro de animais");

        Scanner sc1 = new Scanner(System.in);

        String nome, descricao, entrada;
        int idade;
        boolean filhote, aprovado;

        System.out.println("Digite o nome do pet:");
        nome = sc1.nextLine();

        System.out.println("Digite a idade do pet:");
        idade = sc1.nextInt();
        sc1.nextLine();

        System.out.println("O pet é um filhote? (S/N):");
        entrada = sc1.nextLine();

        filhote = entrada.equals("S");

        System.out.println("Seu pet é um gato ou cachorro? (G/C):");
        entrada = sc1.nextLine();

        System.out.println("Descreva seu pet:");
        descricao = sc1.nextLine();

        aprovado = userLogado.getClass().getSimpleName().equals("Administrador");

        Date dataAual = new Date();

        FichaCadastralAnimal novaFichaCadastralAnimal = new FichaCadastralAnimal(userLogado, dataAual, aprovado);
        fichaCadastralAnimalDao.salvar(novaFichaCadastralAnimal);

        if(entrada.equals("G")){

            Gato novoGato = new Gato(nome, idade, filhote, false, descricao, novaFichaCadastralAnimal);
            animalDao.salvar(novoGato);

        } else {

            Cachorro novoCachorro = new Cachorro(nome, idade, filhote, false, descricao, novaFichaCadastralAnimal);
            animalDao.salvar(novoCachorro);
        }

    }

    /**
     * Lista todos os usuarios cadastrados no sistema.
     */
    public static void listarUsuarios(){

        usuarioDao.retornarUsuarios().forEach((key, value) -> System.out.println("Id: " + key + "\n" + "Nome:" + value.getNome()
                + "\n" + "Email: " + value.getEmail()
                + "\n" + "Cidade: " + value.getEndereco().getCidade()
                + "\n" + "Estado: " + value.getEndereco().getEstado() + "\n"));

    }

    /**
     * Lista todos os animais disponiveis para adocao.
     */
    public static void listarAnimaisCadastradosAceitos(){

        for(Map.Entry<Integer, Animal> entry : animalDao.retornarAnimais().entrySet()) {
            int key = entry.getKey();
            Animal value = entry.getValue();

            if(value.getFichaCadastralAnimal().isAceito() && !value.isAdotado()){
                System.out.println("\n---------------------------------------"
                        + "\nDados do pet:");
                System.out.println("Id: " + key);

                if(value.getClass().getSimpleName().equals("Gato")){

                    System.out.println("Categoria: Gato");

                } else {

                    System.out.println("Categoria: Cachorro");

                }

                System.out.println("Nome do pet: " + value.getNome()
                        + "\n" + "Idade do pet: " + value.getIdade() + " meses"
                        + "\n" + "Sexo do pet: " + value.getSexo()
                        + "\n" + "Filhote: " + ((value.isFilhote()) ? "Sim" : "Não")
                        + "\n" + "Descrição: " + value.getDescricao()
                        + "\n---------------------------------------"
                        + "\nDados do usuário que cadastrou o pet:"
                        + "\n" + "Nome do usuario: " + value.getFichaCadastralAnimal().getUsuario().getNome()
                        + "\n" + "Email do usuario: " + value.getFichaCadastralAnimal().getUsuario().getEmail()
                        + "\n" + "Endereço do usuario: " + value.getFichaCadastralAnimal().getUsuario().getEndereco().getCidade() + "/" + value.getFichaCadastralAnimal().getUsuario().getEndereco().getEstado() + "\n");

            }

        }

        int acao;
        do{

            Scanner sc1 = new Scanner(System.in);

            System.out.println("1- Adotar pet\n2- Voltar");
            acao = sc1.nextInt();

            if(acao==1){

                System.out.println("Digite o id do pet a ser adotado:");
                int idEdicao = sc1.nextInt();

                Animal temp = animalDao.retornarAnimalPorId(idEdicao);
                temp.setAdotado(true);
                animalDao.editar(idEdicao, temp);
                return;

            }


        }while(acao!=2);

    }

    /**
     * Imprime todas as fichas cadastrais de animais que ainda necessitas ser validadas por um administrador
     */
    public static void listarFichasCadastraisPendentes(){

        for (Map.Entry<Integer, Animal> entry : animalDao.retornarAnimais().entrySet()) {
            int key = entry.getKey();
            Animal value = entry.getValue();

            if (!value.getFichaCadastralAnimal().isAceito()) {

                System.out.println("Id: " + key + "\n" + "Nome do pet: " + value.getNome()
                        + "\n" + "Nome do usuario: " + value.getFichaCadastralAnimal().getUsuario().getNome()
                        + "\n" + "Email do usuario: " + value.getFichaCadastralAnimal().getUsuario().getEmail()
                        + "\n" + "Endereço do usuario: " + value.getFichaCadastralAnimal().getUsuario().getEndereco().getCidade() + "/" + value.getFichaCadastralAnimal().getUsuario().getEndereco().getEstado() + "\n");

            }
        }

        int acao;
        do{

            Scanner sc1 = new Scanner(System.in);

            System.out.println("1- Validar cadastro\n2- Sair");
            acao = sc1.nextInt();

            if(acao==1){

                System.out.println("Digite o id a ser validado:");
                int idEdicao = sc1.nextInt();

                Animal temp = animalDao.retornarAnimalPorId(idEdicao);
                temp.getFichaCadastralAnimal().setAceito(true);
                animalDao.editar(idEdicao, temp);

            }


        }while(acao!=2);

    }

    /**
     * Inicializa alguns dados criando e salvando objetos base do projeto como administrador, cliente e animais.
     */
    public static void inicializarDados(){

        // ENDEREÇOS
        Endereco e1 = new Endereco("Alexandria","RN");
        Endereco e2 = new Endereco("Natal","RN");

        // USUARIOS

        Administrador u1 = new Administrador("Bruno", "bruno@gmail.com","123", e1);
        Cliente u2 = new Cliente("Thales", "thales@gmail.com","123", e2);

        usuarioDao.salvar(u1);
        usuarioDao.salvar(u2);

        Date dataAual = new Date();

        //ANIMAIS

        FichaCadastralAnimal novaFichaCadastralAnimal = new FichaCadastralAnimal(u2, dataAual,false);
        fichaCadastralAnimalDao.salvar(novaFichaCadastralAnimal);

        Gato novoGato = new Gato("Teo", 1, true, false, "Gato muito meigo que se dá bem com cachorros.", novaFichaCadastralAnimal);
        animalDao.salvar(novoGato);

        novaFichaCadastralAnimal = new FichaCadastralAnimal(u1, dataAual, true);
        fichaCadastralAnimalDao.salvar(novaFichaCadastralAnimal);

        Cachorro novoCachorro = new Cachorro("Bob", 2, false, false, "Cachorro brincalhão.", novaFichaCadastralAnimal);
        animalDao.salvar(novoCachorro);

    }

}
