package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import modelos.AreaMonitorada;
import modelos.UnidadeEuclidiana;
import modelos.UnidadeManhattan;
import modelos.UnidadeMonitoramento;
import utilities.Localizacao;


public class Application {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//testando code
		
		AreaMonitorada areaMonitorada = new AreaMonitorada(001, "Amazonia");		
		System.out.println(areaMonitorada.toString());
		
		areaMonitorada.setId(002);
		areaMonitorada.setName("Pantanal");
		System.out.println(areaMonitorada.toString());
		
		List<UnidadeMonitoramento> unidades = new ArrayList<>();
		
		Localizacao padrao = new Localizacao(0,0);
		Localizacao novoLocal = new Localizacao(70,35);
		Localizacao novoLocal2 = new Localizacao(33,90);
		Localizacao novoLocal3 = new Localizacao(14,25);
		
		unidades.add(new UnidadeEuclidiana(1, true, true, true, true, padrao));
		unidades.add(new UnidadeEuclidiana(2, true, true, true, true, novoLocal));
		unidades.add(new UnidadeManhattan(3, true, true, true, true, novoLocal2));
		unidades.add(new UnidadeManhattan(4, true, true, true, true, novoLocal3));			
		
		
							
		for (UnidadeMonitoramento id : unidades) { 
			System.out.println("Dado: " + id);
		}
		
		// testando config min
		List<UnidadeMonitoramento> unidadeHabilitada = new ArrayList<>();
		
		
		for (int i=0; i<unidades.size(); i++) {
			if(unidades.get(i).hasConfigMin(true, true, true, true)){
				unidadeHabilitada.add(unidades.get(i));
			}
		}
		
		
		// calculando distancia
		Localizacao destino = new Localizacao(10,20);
		
		for(int i=0; i<unidadeHabilitada.size(); i++) {
			System.out.println(unidadeHabilitada.get(i).calcularDistancia(destino));
			
		}
		
		// selecionar unidade
		
		Localizacao destinoFinal = new Localizacao(15,15);
		
		unidadeHabilitada.get(3).monitorar(destinoFinal, true, true, true, true);
		System.out.println(unidadeHabilitada.get(3));
		sc.close();

	}
}