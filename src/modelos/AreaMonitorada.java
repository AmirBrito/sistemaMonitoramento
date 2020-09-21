package modelos;

import java.util.ArrayList;
import java.util.List;

public class AreaMonitorada {

	private Integer id;
	private String name;
	private List<UnidadeMonitoramento> unidades = new ArrayList<>();

	public AreaMonitorada(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UnidadeMonitoramento> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<UnidadeMonitoramento> unidades) {
		this.unidades = unidades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "areaMonitorada [id=" + id + ", name=" + name + "]";
	}

}
