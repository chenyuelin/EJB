package name.chenyuelin.ejb.demo.sample.transformer;

import name.chenyuelin.ejb.demo.sample.dto.T1DTO;
import name.chenyuelin.ejb.demo.sample.model.T1;

public class Transformer {
	public static T1DTO toT1DTO(T1 t1){
		if(t1==null){
			return null;
		}
		T1DTO dto=new T1DTO();
		dto.setContent(t1.getContent());
		dto.setDt(t1.getDt());
		dto.setFild1(t1.getFild1());
		dto.setId(t1.getId());
		dto.setParentId(t1.getParentId());
		dto.setTimee(t1.getTimee());
		return dto;
	}
}
