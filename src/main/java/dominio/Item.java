package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_item")
public class Item implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private static final long serialVersionUID = 1L;
	private Integer codItem;
	private Integer ordem;
	
	@ManyToOne
	@JoinColumn(name="pacote")
	private Pacote pacote;
	
	@ManyToOne
	@JoinColumn(name="passeio")
	private Passeio passeio;
	
	public Item() {
		super();
	}

	public Item(Integer codItem, Integer ordem, Pacote pacote, Passeio passeio) {
		super();
		this.codItem = codItem;
		this.ordem = ordem;
		this.pacote = pacote;
		pacote.addItem(this);
		this.passeio = passeio;
		passeio.addItem(this);
	}

	public Integer getCodItem() {
		return codItem;
	}

	public void setCodItem(Integer codItem) {
		this.codItem = codItem;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	public Passeio getPasseio() {
		return passeio;
	}

	public void setPasseio(Passeio passeio) {
		this.passeio = passeio;
	}

	@Override
	public String toString() {
		return "Item [codItem=" + codItem + ", ordem=" + ordem + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codItem == null) ? 0 : codItem.hashCode());
		result = prime * result + ((ordem == null) ? 0 : ordem.hashCode());
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
		Item other = (Item) obj;
		if (codItem == null) {
			if (other.codItem != null)
				return false;
		} else if (!codItem.equals(other.codItem))
			return false;
		if (ordem == null) {
			if (other.ordem != null)
				return false;
		} else if (!ordem.equals(other.ordem))
			return false;
		return true;
	}

}
