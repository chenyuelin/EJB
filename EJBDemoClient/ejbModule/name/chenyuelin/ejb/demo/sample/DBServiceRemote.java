package name.chenyuelin.ejb.demo.sample;

public interface DBServiceRemote {
	public int[] persist(String content,String name,byte id,String aname) throws Exception;
}
