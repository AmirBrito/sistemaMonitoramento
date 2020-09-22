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
		
		
		unidades.add(new UnidadeEuclidiana(1, true, true, true, true, padrao));
		unidades.add(new UnidadeEuclidiana(2, false, false, false, false, padrao));
		unidades.add(new UnidadeManhattan(3, false, true, false, true, padrao));
		unidades.add(new UnidadeManhattan(4, true, false, true, false, padrao));			
		
							
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
		
		System.out.println(unidadeHabilitada.isEmpty());
		
		Localizacao destino = new Localizacao(10,20);
		
		System.out.println(unidadeHabilitada.get(0).calcularDistancia(destino));
		
		
		
		sc.close();

	}
}