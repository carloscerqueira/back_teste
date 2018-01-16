package back.core.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import back.core.util.Conexao;
import back.dominio.Customer;

public class customerDAO {
	
	protected Connection connection;
	
	public void salvar() throws SQLException {
		// abre conexão e cria um statement para os comandos sql
		openConnection();
        PreparedStatement preparedStatement = null;
        // prepara o sql do insert
        String sql = null;
        sql = "INSERT INTO tb_customer_account"
                + "(id_customer, cpf_cnpj, nm_customer, is_active, vl_total) VALUES"
                + "(?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            connection.setAutoCommit(false);
            // valores ficticios a serem salvos no banco
            preparedStatement.setInt(1, 100);
            preparedStatement.setString(2, "12345678911");
            preparedStatement.setString(3, "José da Silva Junior");
            preparedStatement.setBoolean(4, true);
            preparedStatement.setDouble(5, 1250.60);
            preparedStatement.addBatch();

            preparedStatement.setInt(1, 1501);
            preparedStatement.setString(2, "22345678922");
            preparedStatement.setString(3, "Roberto Araujo Sales");
            preparedStatement.setBoolean(4, true);
            preparedStatement.setDouble(5, 2500.00);
            preparedStatement.addBatch();
            
            preparedStatement.setInt(1, 2699);
            preparedStatement.setString(2, "32345678933");
            preparedStatement.setString(3, "Luiz Azevedo");
            preparedStatement.setBoolean(4, true);
            preparedStatement.setDouble(5, 10250.40);
            preparedStatement.addBatch();
            
            preparedStatement.setInt(1, 1500);
            preparedStatement.setString(2, "42345678944");
            preparedStatement.setString(3, "Alberto Narapa Souza");
            preparedStatement.setBoolean(4, true);
            preparedStatement.setDouble(5, 1500.50);
            preparedStatement.addBatch();
            
            preparedStatement.setInt(1, 2700);
            preparedStatement.setString(2, "52345678955");
            preparedStatement.setString(3, "José das Couves");
            preparedStatement.setBoolean(4, true);
            preparedStatement.setDouble(5, 2500.70);
            preparedStatement.addBatch();
            
            preparedStatement.setInt(1, 1697);
            preparedStatement.setString(2, "62345678966");
            preparedStatement.setString(3, "Maria Bertalia");
            preparedStatement.setBoolean(4, true);
            preparedStatement.setDouble(5, 7400.30);
            preparedStatement.addBatch();
            
            preparedStatement.setInt(1, 2130);
            preparedStatement.setString(2, "72345678977");
            preparedStatement.setString(3, "Zanira Baruti");
            preparedStatement.setBoolean(4, true);
            preparedStatement.setDouble(5, 9780.50);
            preparedStatement.addBatch();
            
            preparedStatement.setInt(1, 1503);
            preparedStatement.setString(2, "82345678988");
            preparedStatement.setString(3, "Judith da Silva");
            preparedStatement.setBoolean(4, true);
            preparedStatement.setDouble(5, 560.00);
            preparedStatement.addBatch();
            
            preparedStatement.setInt(1, 2560);
            preparedStatement.setString(2, "92345678999");
            preparedStatement.setString(3, "Maria Silvestre");
            preparedStatement.setBoolean(4, true);
            preparedStatement.setDouble(5, 561.00);
            preparedStatement.addBatch();
            
            // executa o batch e commita no banco de dados
            preparedStatement.executeBatch();

            connection.commit();
            
            System.out.println("Os valores foram inseridos na tabela");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            connection.rollback();

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }

    }
	
	public ArrayList<Customer> consultar() {
		// prepara o statement e a string para execução dos comandos sql
		PreparedStatement pst = null;
		String sql = null;
		sql = "SELECT * FROM tb_customer_account";
		
	try {
		// abre a conexão
		openConnection();
		pst = connection.prepareStatement(sql);
		// executa o select
		ResultSet rs = pst.executeQuery();
		ArrayList<Customer> cs = new ArrayList<Customer>();	// array para salvar os clientes
		// loop para salvar os clientes no arraylist
		while (rs.next()) {
			Customer c = new Customer();
			c.setId_customer(rs.getInt("id_customer"));
			c.setCpf_cnpj(rs.getString("cpf_cnpj"));
			c.setNm_customer(rs.getString("nm_customer"));
			c.setIs_active(rs.getBoolean("is_active"));
			c.setVl_total(rs.getDouble("vl_total"));
			cs.add(c);
		}
		return cs;											// retorna arraylist
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}
	// Método para abrir conexão se estiver null ou fechada
	protected void openConnection(){
		try {
			
			if(connection == null || connection.isClosed())
				connection = Conexao.getConnection();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
