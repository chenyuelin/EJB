package name.chenyuelin.ejb.demo2.sample;

import name.chenyuelin.ejb.demo2.sample.dto.AgentDTO;

public interface DestinationServiceRemote {
	public AgentDTO getAgent(byte id);
	
	public AgentDTO createAgent(String name);
}
