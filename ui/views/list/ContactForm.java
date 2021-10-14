//package ru.prominn.atombot.ui.views.list;
//
//import com.vaadin.flow.component.Component;
//import com.vaadin.flow.component.ComponentEvent;
//import com.vaadin.flow.component.ComponentEventListener;
//import com.vaadin.flow.component.Key;
//import com.vaadin.flow.component.Text;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.button.ButtonVariant;
//import com.vaadin.flow.component.checkbox.CheckboxGroup;
//import com.vaadin.flow.component.formlayout.FormLayout;
//import com.vaadin.flow.component.html.Div;
//import com.vaadin.flow.component.html.Span;
//import com.vaadin.flow.component.icon.Icon;
//import com.vaadin.flow.component.icon.VaadinIcon;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.select.Select;
//import com.vaadin.flow.component.textfield.PasswordField;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.data.binder.BeanValidationBinder;
//import com.vaadin.flow.data.binder.Binder;
//import com.vaadin.flow.data.binder.ValidationException;
//import com.vaadin.flow.data.value.ValueChangeMode;
//import com.vaadin.flow.shared.Registration;
//
//import ru.prominn.atombot.backend.directory.entity.Company;
//import ru.prominn.atombot.backend.directory.entity.Contact;
//import ru.prominn.atombot.backend.directory.service.CompanyService;
//import ru.prominn.atombot.backend.directory.service.ContactService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@SuppressWarnings("serial")
//public class ContactForm extends FormLayout {
//
//	TextField login = new TextField("Логин");
//	TextField fullName = new TextField("ФИО");
//	TextField crdate = new TextField("Дата");
//	TextField crtime = new TextField("Время");
//	TextField author = new TextField("Автор");
//	PasswordField password = new PasswordField("Пароль");
//
//	CheckboxGroup<String> group = new CheckboxGroup<String>();
//	CheckboxGroup<String> checkforpassword = new CheckboxGroup<String>();
//
//	Select<String> companyList = new Select<String>();
//
//	Button save = new Button("Сохранить");
//	Button delete = new Button("Удалить");
//	Button close = new Button("Отмена");
//
//	Binder<Contact> binder = new BeanValidationBinder<>(Contact.class);
//
//	private String contactPassword;
//	private Contact contact;
//	private Span passwordStrengthText;
//	private Div passwordStrength;
//	private Icon checkPasswordIcon;
//	private Icon checkLoginIcon;
//	private boolean formStatus = false;
//	private boolean companyStatus = false;
//	private CompanyService companies;
//
//	public ContactForm(CompanyService companies, ContactService contactService) {
//		this.companies = companies;
//
//		addClassName("contact-form");
//
//		crdate.setReadOnly(true);
//		crtime.setReadOnly(true);
//		author.setReadOnly(false);
//
//		login.setRequired(true);
//		login.setRequiredIndicatorVisible(true);
//
//		fullName.setRequired(true);
//		fullName.setRequiredIndicatorVisible(true);
//
//		passwordStrength = new Div();
//		passwordStrengthText = new Span();
//		passwordStrengthText.setText("введите пароль");
//	    passwordStrength.add(new Text("Надежность пароля: "), passwordStrengthText);
//	    passwordStrength.setVisible(false);
//
//		checkPasswordIcon = VaadinIcon.CHECK.create();
//		checkPasswordIcon.setVisible(false);
//		checkPasswordIcon.getStyle().set("color", "var(--lumo-success-color)");
//
//		checkLoginIcon = VaadinIcon.CLOSE.create();
//		checkLoginIcon.setVisible(false);
//		checkLoginIcon.getStyle().set("color", "var(--lumo-error-color)");
//
//		group.setLabel("Настройки пользователя");
//		group.setItems("Администратор", "Заблокирован");
//
//		// Check field for exist users
//		checkforpassword.setLabel("Создание пароля");
//		checkforpassword.setItems("Нужен новый пароль");
//		checkforpassword.addValueChangeListener(e -> {
//			if(e.getValue().contains("Нужен новый пароль")) {
//				password.setInvalid(false);
//				password.setVisible(true);
//				passwordStrength.setVisible(true);
//				save.setEnabled(false);
//			} else {
//				save.setEnabled(true);
//				password.setVisible(false);
//				passwordStrength.setVisible(false);
//			}
//		});
//
//		// Login field for all users
//		login.setSuffixComponent(checkLoginIcon);
//		login.setValueChangeMode(ValueChangeMode.EAGER);
//		login.addValueChangeListener(e -> {
//			if(contactService.findByUsername(login.getValue()) != null) {
//				if(contact.getLogin() == null) {
//					checkLoginIcon = VaadinIcon.CLOSE.create();
//					checkLoginIcon.getStyle().set("color", "var(--lumo-error-color)");
//					checkLoginIcon.setVisible(true);
//					login.setSuffixComponent(checkLoginIcon);
//					save.setEnabled(false);
//					delete.setEnabled(false);
//					formStatus = false;
//				}
//			} else {
//				if(!e.getValue().isEmpty()) {
//					checkLoginIcon = VaadinIcon.CHECK.create();
//					checkLoginIcon.getStyle().set("color", "var(--lumo-success-color)");
//					checkLoginIcon.setVisible(true);
//					login.setSuffixComponent(checkLoginIcon);
//					formStatus = true;
//					delete.setEnabled(true);
//					if(binder.isValid() && companyStatus) save.setEnabled(true);
//				} else {
//					checkLoginIcon.setVisible(false);
//				}
//			}
//		});
//
//		// Password field for all users
//		password.setLabel("Пароль");
//		password.setRequired(true);
//		password.setRequiredIndicatorVisible(true);
//		password.setPlaceholder("Введите новый пароль");
//		password.setMinLength(8);
//		password.setMaxLength(32);
//		password.setPattern("^"
//				+ "(?=.*[0-9])"
//				+ "(?=.*[a-z])"
//				+ "(?=.*[_.!@#&()–[{}]:;',?/*~$^+=<>])"
//				+ "(?=.*[A-Z])."
//				+ "{8}.*"
//				+ "$");
//		password.setErrorMessage("Пароль должен быть длиннее 8 символов, содержать хотя бы одну "
//				+ "прописную букву, одну заглавную букву, одну цифру и один специальный символ.");
//		password.setSuffixComponent(checkPasswordIcon);
//	    password.setValueChangeMode(ValueChangeMode.EAGER);
//	    password.addValueChangeListener(e -> {
//	    	if(contact != null) {
//		    	if(checkforpassword.getSelectedItems().contains("Нужен новый пароль") || contact.getLogin() == null) {
//		    		passwordStrength.setVisible(true);
//		    	}
//		        String pass = e.getValue();
//		        updateHelper(pass);
//	    	}
//	    });
//	    password.setVisible(false);
//
//	    List<String> nameCompanyList = new ArrayList<String>();
//
//	    for(Company company : companies.findAll()) {
//	    	nameCompanyList.add(company.getName() + ": " + company.getCompanyName());
//	    }
//
//	    companyList.setLabel("Компания");
//	    companyList.setItems(nameCompanyList);
//	    companyList.addValueChangeListener(e -> {
//	    	if(e.getValue().equals("")) {
//	    		companyStatus = true;
//	    	} else {
//	    		companyStatus = true;
//	    		if(binder.isValid() && formStatus) {
//	    			save.setEnabled(true);
//	    		}
//	    	}
//	    });
//
//		save.setEnabled(false);
//
//		binder.bindInstanceFields(this);
//
//		// Add fields to for form
//		add(
//				login,
//				fullName,
//				companyList,
//				checkforpassword,
//				password,
//				passwordStrength,
//				group,
//				crdate,
//				crtime,
//				author,
//				createButtonsLayout());
//	}
//
//	// Set contact from grid
//	public void setContact(Contact contact) {
//
//		this.contact = contact;
//		binder.readBean(contact);
//
//		group.deselect("Администратор", "Заблокирован");
//
//		companyList.setValue("");
//
//		if(contact != null) {
//
//			delete.setEnabled(true);
//			fullName.setVisible(true);
//			companyList.setVisible(false);
//
//			if(contact.getLogin() != null) {
//				if(contact.getLogin().equals("admin")) {
//					login.setEnabled(false);
//					contactPassword = contact.getPassword();
//					fullName.setVisible(false);
//					companyList.setVisible(false);
//					password.setVisible(false);
//					passwordStrength.setVisible(false);
//					checkforpassword.setVisible(true);
//					checkforpassword.deselect("Нужен новый пароль");
//					save.setEnabled(true);
//					delete.setEnabled(false);
//				} else {
//					login.setEnabled(false);
//					contactPassword = contact.getPassword();
//					companyList.setValue(contact.getCompany().getName() + ": " + contact.getCompany().getCompanyName());
//					password.setVisible(false);
//					passwordStrength.setVisible(false);
//					checkforpassword.setVisible(true);
//					checkforpassword.deselect("Нужен новый пароль");
//					save.setEnabled(true);
//					}
//			} else {
//				login.setEnabled(true);
//				password.setVisible(true);
//				passwordStrength.setVisible(false);
//				checkforpassword.select("Нужен новый пароль");
//				checkforpassword.setVisible(false);
//				save.setEnabled(false);
//			}
//
//			if(contact.getAdmin()) {
//				group.select("Администратор");
//			}
//			if(contact.getBlock()) {
//				group.select("Заблокирован");
//			}
//		} else {
//			login.setEnabled(true);
//			password.setVisible(true);
//			passwordStrength.setVisible(false);
//			checkforpassword.setVisible(false);
//		}
//
//		password.setValue("");
//	}
//
//	// Create save, delete, close buttons
//	private Component createButtonsLayout() {
//		save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
//		delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
//		close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
//
//		save.addClickShortcut(Key.ENTER);
//		close.addClickShortcut(Key.ESCAPE);
//
//		save.addClickListener(click -> validateAndSave());
//		delete.addClickListener(click -> fireEvent(new DeleteEvent(this, contact)));
//		close.addClickListener(click -> fireEvent(new CloseEvent(this)));
//
//		return new HorizontalLayout(save, delete, close);
//	}
//
//	// Save function, fill in fields admin/block
//	// If user exist and password is not changed, set old password and save user
//	private void validateAndSave() {
//		try {
//			binder.bindInstanceFields(this);
//			contact.setAdmin(false);
//			contact.setBlock(false);
//
//			for(String param : group.getSelectedItems()) {
//				if(param.equals("Администратор")) contact.setAdmin(true);
//				if(param.equals("Заблокирован")) contact.setBlock(true);
//			}
//
//			if(!checkforpassword.getValue().contains("Нужен новый пароль")) {
//				binder.removeBinding(password);
//				contact.setPassword(contactPassword);
//			}
//
////			String[] companyName = companyList.getValue().split(": ");
//
////			for(Company company : companies.findAll()) {
////				if(companyName[0].equals(company.getName())) {
////					contact.setCompany(company);
////				}
////			}
//
//			if(login.getValue().equals("admin")) {
//				contact.setCompanyName("-");
//			}
//
//			binder.writeBean(contact);
//			fireEvent(new SaveEvent(this, contact));
//		} catch (ValidationException e) {
//			System.out.println("Form validation error");
//			e.printStackTrace();
//		}
//	}
//
//	// Events
//	public static abstract class ContactFormEvent extends ComponentEvent<ContactForm> {
//		private Contact contact;
//
//		protected ContactFormEvent(ContactForm source, Contact contact) {
//			super(source, false);
//			this.contact = contact;
//		}
//
//		public Contact getContact() {
//			return contact;
//		}
//	}
//
//	public static class SaveEvent extends ContactFormEvent {
//		SaveEvent(ContactForm source, Contact contact) {
//			super(source, contact);
//		}
//	}
//
//	public static class DeleteEvent extends ContactFormEvent {
//		DeleteEvent(ContactForm source, Contact contact) {
//			super(source, contact);
//		}
//
//	}
//
//	public static class CloseEvent extends ContactFormEvent {
//		CloseEvent(ContactForm source) {
//			super(source, null);
//		}
//	}
//
//	private void updateHelper(String contactPassword) {
//
//		// If password field is not valid, disable save button and change password status
//		// If check password field not set, enable save button
//		if (password.isInvalid()) {
//			save.setEnabled(false);
//	    	passwordStrengthText.setText("недопустимый");
//	    	passwordStrengthText.getStyle().set("color", "var(--lumo-error-color)");
//	    	checkPasswordIcon.setVisible(false);
//	    	if(!checkforpassword.getValue().contains("Нужен новый пароль")) {
//	    		save.setEnabled(true);
//	    	}
//	    	return;
//		}
//		// Change password strength text
//
//		if(!login.isEnabled()) {
//			formStatus = true;
//		}
//
//		if (contactPassword.length() > 16) {
//			passwordStrengthText.setText("отличный");
//			passwordStrengthText.getStyle().set("color", "var(--lumo-success-color)");
//			checkPasswordIcon.setVisible(true);
//			if(binder.isValid() && formStatus && companyStatus || login.getValue().equals("admin")) save.setEnabled(true);
//			return;
//	    } else if (contactPassword.length() > 11) {
//	    	passwordStrengthText.setText("средний");
//	    	passwordStrengthText.getStyle().set("color", "#e7c200");
//	    	checkPasswordIcon.setVisible(true);
//	    	if(binder.isValid() && formStatus && companyStatus || login.getValue().equals("admin")) save.setEnabled(true);
//	    	return;
//	    } else {
//	    	passwordStrengthText.setText("слабый");
//	    	passwordStrengthText.getStyle().set("color", "var(--lumo-error-color)");
//	    	checkPasswordIcon.setVisible(true);
//	    	if(binder.isValid() && formStatus && companyStatus || login.getValue().equals("admin")) save.setEnabled(true);
//	    	return;
//	    }
//	}
//
//	public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
//			ComponentEventListener<T> listener) {
//		return getEventBus().addListener(eventType, listener);
//	}
//}
