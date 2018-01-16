package back.core.impl;

import java.util.ArrayList;
import back.core.impl.dao.customerDAO;
import back.dominio.Customer;

public class CalculaMedia {
	public ArrayList<Customer> calcular() {
		int i;			// contador
		double total;	// auxiliar para c�lculo de m�dia
		int n;			// quantidade de clientes usados no c�lculo
		double media;	// cont�m a m�dia final
		customerDAO cDAO = new customerDAO();	// objeto do DAO do cliente
		ArrayList<Customer> cs = cDAO.consultar();	// ArrayList com todos os clientes cadastrados
		ArrayList<Customer> cs2 = new ArrayList<Customer>();	// Arraylist que conter� os clientes dentro dos parametros
		// loop para percorrer os clientes
		for(i = 0, n = 0, total = 0, media = 0;
				i < cs.size(); i++) {
			// verifica se o cliente est� dentro dos parametros
			if(cs.get(i).getId_customer() > 1500 &&
					cs.get(i).getId_customer() < 2700 &&
					cs.get(i).getVl_total() > 560.00) {
				total += cs.get(i).getVl_total();	// aumenta o valor total
				n++;								// incrementa a quantidade de clientes
				cs2.add(cs.get(i));					// salva na lista de clientes usados para a m�dia
			}
		}
		media = total/n;							// calcula a m�dia
		System.out.println("A m�dia dos sal�rios acima de 560 dos clientes com identifica��o entre 1500 e 2700 �: " + media);
		return cs2;									// retorna a lista de clientes
	}
}
