package instanciacao;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import dominio.Contrato;
import dominio.Hotel;
import dominio.Item;
import dominio.Pacote;
import dominio.Passeio;

@WebServlet("/Instanciacao")
public class Instanciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Cliente jorge = new Cliente(1, "jorge", "jorge1@email.com", "(34) 190-190", "5242424-42", sdf.parse("11/11/1971"),
				new BigDecimal("2000000.00"));
		
		Hotel h1 = new Hotel(1, "hotel1", "hongKong", new BigDecimal("2000.00"));
		
		Pacote p1 = new Pacote(1, "pacote1", 3, h1);
		
		Contrato c1 = new Contrato(1, sdf.parse("11/11/1971"), jorge, p1);
		
		Passeio pa1 = new Passeio(1, "paraquedas", new BigDecimal("500.00"), "Chinginhog");
		
		Item i1 = new Item(1, 1, p1, pa1);
		
		response.getWriter().append("Funcionaste!");
		
		} catch (ParseException e) {
			response.getWriter().append("Erro ao instanciar data. Instância não criada");
		}
	}
}