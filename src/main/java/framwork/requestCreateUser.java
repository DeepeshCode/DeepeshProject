package framwork;

public class requestCreateUser {
	
	private String name;
	private String leader;
	
	public requestCreateUser(String name, String leader) {
		this.name = name;
		this.leader = leader;
		
	}

	public String getLeader() {
		return leader;
	}

	public  void setLeader(String leader) {
		this.leader = leader;
	}

	public  String getName() {
		return name;
	}

	public  void setName(String name) {
		this.name = name;
	}

}
