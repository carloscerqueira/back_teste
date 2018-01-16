package back.core.impl;

import java.util.ArrayList;
import back.core.impl.dao.customerDAO;
import back.dominio.Customer;

public class CalculaMedia {
	public ArrayList<Customer> calcular() {
		int i;			// contador
		double total;	// auxiliar para cálculo de média
		int n;			// quantidade de clientes usados no cálculo
		double media;	// contém a média final
		customerDAO cDAO = new customerDAO();	// objeto do DAO do cliente
		ArrayList<Customer> cs = cDAO.consultar();	// ArrayList com todos os clientes cadastrados
		ArrayList<Customer> cs2 = new ArrayList<Customer>();	// Arraylist que conterá os clientes dentro dos parametros
		// loop para percorrer os clientes
		for(i = 0, n = 0, total = 0, media = 0;
				i < cs.size(); i++) {
			// verifica se o cliente está dentro dos parametros
			if(cs.get(i).getId_customer() > 1500 &&
					cs.get(i).getId_customer() < 2700 &&
					cs.get(i).getVl_total() > 560.00) {
				total += cs.get(i).getVl_total();	// aumenta o valor total
				n++;								// incrementa a quantidade de clientes
				cs2.add(cs.get(i));					// salva na lista de clientes usados para a média
			}
		}
		media = total/n;							// calcula a média
		System.out.println("A média dos salários acima de 560 dos clientes com identificação entre 1500 e 2700 é: " + media);
		return cs2;									// retorna a lista de clientes
	}
}
