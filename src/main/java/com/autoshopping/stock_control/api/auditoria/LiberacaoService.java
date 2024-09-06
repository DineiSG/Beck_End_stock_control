package com.autoshopping.stock_control.api.auditoria;
import javax.mail.MessagingException;
import java.sql.*;

public class LiberacaoService {

    public static void verificarLiberacoes() throws SQLException, MessagingException{
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/controledeacesso", "postgres", "123456");

        String query="SELECT * FROM vaga.liberacoes WHERE data_registro <= CURRENT_DATE - INTERVAL '5 days'";
        Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            String veiculoPlaca = resultSet.getString("placa");
            String veiculoMarca = resultSet.getString("marca");
            String veiculoModelo = resultSet.getString("modelo");
            String veiculoCor = resultSet.getString("cor");
            String veiculoLoja=resultSet.getString("loja");

            String emailBody = "Favor realizar a auditoria do veiculo " +veiculoModelo +", da marca " +veiculoMarca+ ", de cor "+veiculoCor+
                    ", placa "+veiculoPlaca+ ", com a liberaçao realizada a pedido da loja "+veiculoLoja;

            EmailService.enviarEmail("diretoria@aspago.com.br", "Solicitação de Auditoria", emailBody);
        }
    }
}
