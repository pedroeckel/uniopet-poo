package br.uniopet.cadastro.app;

import java.util.List;

import br.uniopet.cadastro.model.Cadastro;
import br.uniopet.cadastro.repository.CadastroRepository;

public class SistemaCadastro {
    public static void main(String[] args) {

        CadastroRepository repository = new CadastroRepository();

        // Exemplo de inclusão
        Cadastro novo = new Cadastro(null, "Joana", 15);
        repository.salvar(novo);

        // Exemplo de alteração
        Cadastro atualizado = new Cadastro(1, "Joana Almeida", 16);
        repository.alterar(atualizado);

        // Exemplo de exclusão
        repository.excluir(2);

        // Exemplo de listagem
        List<Cadastro> lista = repository.listar();
        for (Cadastro c : lista) {
            System.out.println(c.getId() + " - " + c.getNome() + " - " + c.getIdade());
        }

        // Exemplo de busca por ID
        Cadastro resultado = repository.buscar(3);
        if (resultado != null) {
            System.out.println("Encontrado: " + resultado.getNome());
        } else {
            System.out.println("Nenhum registro encontrado para o ID informado.");
        }

    }
}

