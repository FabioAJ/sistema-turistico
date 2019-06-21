package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_passeio")
public class Passeio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codPasseio;
	private String nome;
	private BigDecimal preco;
	private String cidade;
	
	@OneToMany(mappedBy="passeio")
	private List<Item> itens = new ArrayList<>();
	
	public Passeio() {
		super();
	}

	public Passeio(Integer codPasseio, String nome, BigDecimal preco, String cidade) {
		super();
		this.codPasseio = codPasseio;
		this.nome = nome;
		this.preco = preco;
		this.cidade = cidade;
		itens = new ArrayList<>();
	}

	public Integer getCodPasseio() {
		return codPasseio;
	}

	public void setCodPasseio(Integer codPasseio) {
		this.codPasseio = codPasseio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	public void addItem(Item x) {
		this.itens.add(x);
		x.setPasseio(this);
	}
	
	public void removeItem(Item x) {
		this.itens.remove(x);
	}

	@Override
	public String toString() {
		return "Passeio [codPasseio=" + codPasseio + ", nome=" + nome + ", preco=" + preco + ", cidade=" + cidade + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((codPasseio == null) ? 0 : codPasseio.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passeio other = (Passeio) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (codPasseio == null) {
			if (other.codPasseio != null)
				return false;
		} else if (!codPasseio.equals(other.codPasseio))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		return true;
	}

}
