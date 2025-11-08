package br.uniopet.cadastro.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {

    private static Connection conexao;

    public static Connection getConexao() {

        if (conexao == null) {
            try {
                String url = "jdbc:postgresql://localhost:5432/workspace_db?ssl=false";
                String usuario = "admin";
                String senha = "admin";

                conexao = DriverManager.getConnection(url, usuario, senha);

                System.out.println("Conexão realizada com sucesso.");

            } catch (Exception ex) {
                System.err.println("Falha ao conectar ao banco.");
                ex.printStackTrace();
            }
        }

        return conexao;
    }
}

