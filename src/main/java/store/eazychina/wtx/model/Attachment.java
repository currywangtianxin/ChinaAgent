package store.eazychina.wtx.model;

public class Attachment {
	private int id;
	private String  newName;
	private String oldName;
	private long size;
	private String suffix;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public Attachment(int id, String newName, String oldName, long size,
			String suffix) {
		super();
		this.id = id;
		this.newName = newName;
		this.oldName = oldName;
		this.size = size;
		this.suffix = suffix;
	}
	public Attachment() {
		super();
	}
	public Attachment(String newName, String oldName, long size, String suffix) {
		super();
		this.newName = newName;
		this.oldName = oldName;
		this.size = size;
		this.suffix = suffix;
	}
	
	
}
