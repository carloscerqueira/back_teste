package back.dominio;

public class Customer {
	private int id_customer;		// identificação unica do cliente
	private String cpf_cnpj;		// cpf ou cnpj do cliente
	private String nm_customer;		// nome do cliente
	private Boolean is_active;		// indica se o cliente está ativo ou não
	private Double vl_total;		// mostra o saldo do cliente
	
	// Getters e Setters //
	
	public int getId_customer() {
		return id_customer;
	}
	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	public String getNm_customer() {
		return nm_customer;
	}
	public void setNm_customer(String nm_customer) {
		this.nm_customer = nm_customer;
	}
	public Boolean getIs_active() {
		return is_active;
	}
	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	public Double getVl_total() {
		return vl_total;
	}
	public void setVl_total(Double vl_total) {
		this.vl_total = vl_total;
	}
}
