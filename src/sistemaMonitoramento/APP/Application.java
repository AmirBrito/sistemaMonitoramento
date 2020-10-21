package sistemaMonitoramento.APP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import sistemaMonitoramento.LOGICA.AreaMonitorada;
import sistemaMonitoramento.LOGICA.UnidadeEuclidiana;
import sistemaMonitoramento.LOGICA.UnidadeManhattan;
import sistemaMonitoramento.LOGICA.UnidadeMonitoramento;
import sistemaMonitoramento.UTILITIES.Localizacao;


public class Application {

	public static void main(String[] args) throws Exception {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//testando code
		
		AreaMonitorada areaMonitorada = new AreaMonitorada(001, "Amazonia");		
		System.out.println(areaMonitorada.toString());
		
		areaMonitorada.setId(002);
		areaMonitorada.setName("Pantanal");
		System.out.println(areaMonitorada.toString());
		
		//List<UnidadeMonitoramento> unidades = new ArrayList<>();
		
		Localizacao padrao = new Localizacao(0,0);
		Localizacao novoLocal = new Localizacao(70,35);
		Localizacao novoLocal2 = new Localizacao(33,90);
		Localizacao novoLocal3 = new Localizacao(14,25);
		Localizacao destinoFinal = new Localizacao(15,15);
	
		
		/*areaMonitorada.addUnidadeEuclidiana(1, true, true, true, true, padrao);
		areaMonitorada.addUnidadeEuclidiana(2, true, true, true, true, novoLocal);
		areaMonitorada.addUnidadeManhattan(3, true, true, true, true, novoLocal2);
		areaMonitorada.addUnidadeManhattan(4, true, true, true, true, novoLocal3);*/
			
		areaMonitorada.validarUnidades(destinoFinal, true, true, true, true);		
		System.out.println(areaMonitorada.getUnidades().get(1).getLocalizacao());
		
		Localizacao destinoFinal2 = new Localizacao(0,0);		
		areaMonitorada.validarUnidades(destinoFinal2, true, true, true, true);				
		System.out.println(areaMonitorada.getUnidades().get(1).getLocalizacao());
		
		for (UnidadeMonitoramento id : areaMonitorada.getUnidades()) { 
			System.out.println("Dado: " + id);
		}

		sc.close();

		
		/*		
			DriverManager.registerDriver(new org.h2.Driver());
			Connection con = DriverManager.getConnection("jdbc:h2:~/dataMonitoramento");
			
			System.out.println("end");
			con.close();		
		*/
	}
}