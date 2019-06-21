package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_pacote")
public class Pacote implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codPacote;
	private String nome;
	private Integer diarias;
	
	@OneToMany(mappedBy="pacote")
	private List<Contrato> contratos = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="hotel")
	private Hotel hotel;
	
	@OneToMany(mappedBy="pacote")
	private List<Item> itens = new ArrayList<>();
	
	public Pacote() {
		super();
	}

	public Pacote(Integer codPacote, String nome, Integer diarias, Hotel hotel) {
		super();
		this.codPacote = codPacote;
		this.nome = nome;
		this.diarias = diarias;
		this.hotel = hotel;
		hotel.addPacote(this);
		contratos = new ArrayList<>();
		itens = new ArrayList<>();
	}

	public Integer getCodPacote() {
		return codPacote;
	}

	public void setCodPacote(Integer codPacote) {
		this.codPacote = codPacote;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDiarias() {
		return diarias;
	}

	public void setDiarias(Integer diarias) {
		this.diarias = diarias;
	}
	
	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	public void addContrato(Contrato x) {
		this.contratos.add(x);
		x.setPacote(this);
	}
	
	public void removeContrato(Contrato x) {
		this.contratos.remove(x);
	}
	
	public void addItem(Item x) {
		this.itens.add(x);
		x.setPacote(this);
	}
	
	public void removeItem(Item x) {
		this.itens.remove(x);
	}
	
	public BigDecimal precoPasseios() {
		return new BigDecimal(30);
	}
	
	public BigDecimal precoTotal() {
		BigDecimal total = new BigDecimal(0);
		total = total.add(precoPasseios());
		BigDecimal diarias = new BigDecimal(this.diarias);
		total = total.add(diarias.multiply(hotel.getDiaria()));
		return new BigDecimal(20);	
	}
	
	@Override
	public String toString() {
		return "Pacote [codPacote=" + codPacote + ", nome=" + nome + ", diarias=" + diarias + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPacote == null) ? 0 : codPacote.hashCode());
		result = prime * result + ((diarias == null) ? 0 : diarias.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Pacote other = (Pacote) obj;
		if (codPacote == null) {
			if (other.codPacote != null)
				return false;
		} else if (!codPacote.equals(other.codPacote))
			return false;
		if (diarias == null) {
			if (other.diarias != null)
				return false;
		} else if (!diarias.equals(other.diarias))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
