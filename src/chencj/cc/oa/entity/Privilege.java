package chencj.cc.oa.entity;

import java.util.HashSet;
import java.util.Set;

public class Privilege {

	private long priId;
	private String priName;
	private String priUrl;
	private Set<Role> roles = new HashSet<>();
	private Privilege priParent;
	private Set<Privilege> priChildren = new HashSet<>();
	public long getPriId() {
		return priId;
	}
	public void setPriId(long priId) {
		this.priId = priId;
	}
	public String getPriName() {
		return priName;
	}
	public void setPriName(String priName) {
		this.priName = priName;
	}
	public String getPriUrl() {
		return priUrl;
	}
	public void setPriUrl(String priUrl) {
		this.priUrl = priUrl;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Privilege getPriParent() {
		return priParent;
	}
	public void setPriParent(Privilege priParent) {
		this.priParent = priParent;
	}
	public Set<Privilege> getPriChildren() {
		return priChildren;
	}
	public void setPriChildren(Set<Privilege> priChildren) {
		this.priChildren = priChildren;
	}
	@Override
	public String toString() {
		return "Privilege [priId=" + priId + ", priName=" + priName + ", priUrl=" + priUrl + "]";
	}
	
	
	
}
