package ru.prominn.atombot.backend.directory.entity;

import ru.prominn.atombot.backend.directory.entity.Company;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_info")
public class Contact implements Cloneable {
	
	@Id
	@NotNull
	@NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "login")
    private String login;
    
	@NotNull
	@NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "name")
    private String fullName;
    
	@NotEmpty(message = "Необходимо ввести пароль. Используйте символы латинского алфавита")
	@Size(min = 8, message = "Пароль должен быть длиннее 8 символов, содержать хотя бы одну "
			+ "прописную букву, одну заглавную букву, одну цифру и один специальный символ.")
	@Pattern(regexp = "^"
			+ "(?=.*[0-9])"
			+ "(?=.*[a-z])"
			+ "(?=.*[_.!@#&()–[{}]:;',?/*~$^+=<>])"
			+ "(?=.*[A-Z])."
			+ "{8}.*"
			+ "$", message = "Пароль должен быть длиннее 8 символов, содержать хотя бы одну "
					+ "прописную букву, одну заглавную букву, одну цифру и один специальный символ.")
    @Column(name = "password")
    private String password;
    
	@NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "company_name")
    private String company_name;
    
    @Column(name = "has_full_access")
    private boolean hfa;
    
	@NotNull
	@NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "crdate")
    private String crdate;
    
	@NotNull
	@NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "crtime")
    private String crtime;
    
//	@NotNull
//	@NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "crlogin")
    private String author;
    
	@ManyToOne
    @JoinColumn(name = "company_code")
    private Company company;
    
	@NotNull
    @Column(name = "admin")
    private boolean admin;
    
	@NotNull
    @Column(name = "block")
    private boolean block;

    public boolean getAccess() {
    	return hfa;
    }
    
    
    
    public Contact() {
		super();
	}

    public Contact(String login, String name, String password) {
    	super();
        this.login = login;
        this.fullName = name;
        this.password = password;
    }

    public Contact(String login, String name, String password, Company companyCode) {
    	super();
        this.login = login;
        this.fullName = name;
        this.password = password;
        this.company = companyCode;
  
    }    

    
    
    public void setAccess(boolean hfa) {
    	this.hfa = hfa;
    }
    
    public String getCompanyName() {
    	return company_name;
    }
    
    public void setCompanyName(String company_name) {
    	this.company_name = company_name;
    }
    
    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    public boolean getBlock() {
        return block;
    }
    
    public void setBlock(boolean block) {
        this.block = block;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }   
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getCRDate() {
        return crdate;
    }

    public void setCRDate(String crdate) {
        this.crdate = crdate;
    }

    public String getCRTime() {
        return crtime;
    }

    public void setCRTime(String crtime) {
        this.crtime = crtime;
    }    
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }   
    
    @Override
    public String toString() {
        return login + " " + fullName;
    }

}
