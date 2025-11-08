package br.uniopet.cadastro.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.uniopet.cadastro.factory.FabricaConexao;
import br.uniopet.cadastro.model.Cadastro;

public class CadastroRepository {

    private Connection conexao = FabricaConexao.getConexao();

    // CREATE
    public void salvar(Cadastro cadastro) {
        String sql = "INSERT INTO cadastro (nome, idade) VALUES (?, ?)";

        try (PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());
            pst.execute();
            System.out.println("Cadastro inserido com sucesso.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // UPDATE
    public void alterar(Cadastro cadastro) {
        String sql = "UPDATE cadastro SET nome = ?, idade = ? WHERE id = ?";

        try (PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());
            pst.setInt(3, cadastro.getId());
            pst.execute();
            System.out.println("Cadastro alterado com sucesso.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // DELETE
    public void excluir(Integer id) {
        String sql = "DELETE FROM cadastro WHERE id = ?";

        try (PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.execute();
            System.out.println("Cadastro excluído com sucesso.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // SELECT ALL
    public List<Cadastro> listar() {
        List<Cadastro> lista = new ArrayList<>();
        String sql = "SELECT id, nome, idade FROM cadastro";

        try (PreparedStatement pst = conexao.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Cadastro c = new Cadastro();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setIdade(rs.getInt("idade"));
                lista.add(c);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    // SELECT BY ID
    public Cadastro buscar(Integer id) {
        String sql = "SELECT id, nome, idade FROM cadastro WHERE id = ?";

        try (PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setInt(1, id);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Cadastro c = new Cadastro();
                    c.setId(rs.getInt("id"));
                    c.setNome(rs.getString("nome"));
                    c.setIdade(rs.getInt("idade"));
                    return c;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
