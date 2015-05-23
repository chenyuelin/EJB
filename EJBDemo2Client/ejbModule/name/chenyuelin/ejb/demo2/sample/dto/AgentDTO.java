package name.chenyuelin.ejb.demo2.sample.dto;

import java.io.Serializable;

public class AgentDTO implements Serializable {

	private static final long serialVersionUID = 8306594856369419147L;
	
	private byte id;
	
	private String name;

	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AgentDTO [id=" + id + ", name=" + name + "]";
	}
}
