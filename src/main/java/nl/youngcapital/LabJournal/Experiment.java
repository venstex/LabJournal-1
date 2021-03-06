package nl.youngcapital.LabJournal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//Lets go
@Entity
public class Experiment { //xyz
	private String description;
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@OneToMany(mappedBy = "experiment")
	List <Operation> operations=new ArrayList();
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	@ManyToMany 
	@JoinTable(
		      name="Sample_Experiment",
		      joinColumns=@JoinColumn(name="experiment_id", referencedColumnName="id"),
		      inverseJoinColumns=@JoinColumn(name="sample_id", referencedColumnName="id")) 
	List <Sample> samples = new ArrayList();
	public Experiment() {
		super();
	}
	public String getDescription() {
		return description;
	}
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Project getProject() {
		return project;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}
}
