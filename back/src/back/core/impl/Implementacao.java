package back.core.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import back.core.impl.dao.customerDAO;
import back.dominio.Customer;

public class Implementacao {

	public static void main(String[] args) throws SQLException {
		customerDAO cDAO = new customerDAO();	// DAO para inserir os clientes
		cDAO.salvar();							// salva os clientes no banco de dados
		CalculaMedia cm = new CalculaMedia();	// objeto para calculo da média
		ArrayList<Customer> cs = cm.calcular();	// Arraylist dos clientes que foram usados para o calculo da média
		int i;									// indice e contador genérico
		Boolean flgTroca = true;				// true = houve troca, false = não houve troca
		Customer aux;							// auxiliar para troca de posições
		// enquanto houver troca, loop
		while(flgTroca) {
			flgTroca = false;
			for(i = 0; i < (cs.size() - 1); i++) {
				if(cs.get(i).getVl_total() < cs.get(i + 1).getVl_total()) {
					flgTroca = true;
					aux = cs.get(i);
					cs.set(i, cs.get(i + 1));
					cs.set(i + 1, aux);
				}
			}
		}
		System.out.println("Lista de clientes usados para o calculo da média:");
		for(i = 0; i < cs.size(); i++) {
			System.out.println("\n" + cs.get(i).getId_customer());
			System.out.println(cs.get(i).getCpf_cnpj());
			System.out.println(cs.get(i).getNm_customer());
			System.out.println(cs.get(i).getVl_total());
		}
	}

}
