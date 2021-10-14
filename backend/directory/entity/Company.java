package ru.prominn.atombot.backend.directory.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.LinkedList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "company_info")
public class Company implements Cloneable {

	@Id
//	@NotNull
//	@NotEmpty(message = "Поле не может быть пустым")
	@Column(name = "company_code")
	public String name;
	
	@Column(name = "kuns")
	private String kuns;
	
//	@NotNull
//	@NotEmpty(message = "Поле не может быть пустым")
	@Column(name = "company_name")
	private String companyName;

	@NotNull
	@NotEmpty
	@Column(name = "crdate")
	private String crdate;

	@NotNull
	@NotEmpty
	@Column(name = "crtime")
	private String crtime;

	@NotNull
	@NotEmpty
	@Column(name = "crlogin")
	private String author;
	
	@OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
	private List<Contact> employees = new LinkedList<>();

	@NotNull
	@Column(name = "block")
	private boolean status;


	public Company() {
	}

	public Company(String name) {
		setName(name);
	}
	
	public String getKuns() {
		return kuns;
	}

	public void setKuns(String kuns) {
		this.kuns = kuns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Contact> getEmployees() {
		return employees;
	}

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCRDate() {
        return crdate;
    }

    public void setCRDate(String crdate) {
        this.crdate = crdate;
    }
//
    public String getCRTime() {
        return crtime;
    }

    public void setCRTime(String crtime) {
        this.crtime = crtime;
    }
//
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
//
}