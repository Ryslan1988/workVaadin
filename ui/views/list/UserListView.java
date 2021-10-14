//package ru.prominn.atombot.ui.views.list;
//
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.core.Authentication;
////import org.springframework.security.core.context.SecurityContextHolder;
////import org.springframework.security.core.userdetails.User;
////import org.springframework.security.core.userdetails.UsernameNotFoundException;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.vaadin.flow.component.Html;
//import com.vaadin.flow.component.Text;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.dialog.Dialog;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.grid.Grid.Column;
//import com.vaadin.flow.component.grid.GridSortOrder;
//import com.vaadin.flow.component.html.Div;
//import com.vaadin.flow.component.icon.Icon;
//import com.vaadin.flow.component.icon.VaadinIcon;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.data.provider.SortDirection;
//import com.vaadin.flow.data.value.ValueChangeMode;
//import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.router.Route;
//
//import ru.prominn.atombot.backend.directory.entity.Company;
//import ru.prominn.atombot.backend.directory.entity.Contact;
//import ru.prominn.atombot.backend.directory.service.CompanyService;
//import ru.prominn.atombot.backend.directory.service.ContactService;
//
//
//import ru.prominn.atombot.ui.MainLayout;
//
//@SuppressWarnings("serial")
//@Route(value = "", layout = MainLayout.class)
//@PageTitle("Настройка пользователей")
//public class UserListView extends VerticalLayout {
//
//	private final ContactForm form;
//    Grid<Contact> grid = new Grid<>(Contact.class);
//    TextField filterText = new TextField();
//
//
//    private ContactService contactService;
//
//    @Autowired
//    public UserListView(ContactService contactService,
//    		CompanyService companyService) {
//    		//,LicenseKeyService licenseKeyService) {
//        this.contactService = contactService;
////        this.licenseKeyService = licenseKeyService;
//
//        addClassName("list-view");
//        setSizeFull();
//        configureGrid();
//
//        form = new ContactForm(companyService, contactService);
//        form.addListener(ContactForm.SaveEvent.class, this::saveContact);
//        form.addListener(ContactForm.DeleteEvent.class, this::deleteContact);
//        form.addListener(ContactForm.CloseEvent.class, e -> closeEditor());
//
//        Div content = new Div(grid, form);
//        content.addClassName("content");
//        content.setSizeFull();
//
//        add(getToolBar(), content);
//        updateList();
//        closeEditor();
//    }
//
//    // Delete contact from database and from local in-memory repository
//    private void deleteContact(ContactForm.DeleteEvent evt) {
//
//    	try {
//    		contactService.delete(evt.getContact());
//    	} catch (Exception e) {
//
//    	}
//
//    	System.out.println(contactService.findAllContactFiles(evt.getContact().getLogin()));
//
//    	if(contactService.findAllContactFiles(evt.getContact().getLogin()).isEmpty()) {
//    	    try{
//  //  	    	SecurityConfiguration.userDetailsManager.deleteUser(evt.getContact().getLogin());
//
//    		  	Dialog dialog = new Dialog();
//    		  	dialog.add(new Text("Привязанных файлов не найдено. Пользователь успешно удален! "));
//    		  	dialog.open();
//    	    } catch (NullPointerException e) {
//    		  	Dialog dialog = new Dialog();
//    		  	dialog.add(new Text("Пользователь не существует."));
//    		  	dialog.open();
//    	    }
//    	} else {
//    		Html html = new Html("<div>Невозможно удалить пользователя, так как он имеет привязанные файлы.<br>"
//    				+ "Пожалуйста, удалите файлы пользователя через основной сайт \"АРМ Эксперт\"<br>");
//
//		  	Dialog dialog = new Dialog();
//		  	dialog.add(html);
//		  	dialog.open();
//    	}
//
//    	updateList();
//    	closeEditor();
//    }
//
//
//	private void saveContact(ContactForm.SaveEvent evt) {
//		Contact currentContact = evt.getContact();
//
//		boolean nameStatus = false;
//		boolean dateStatus = false;
//		boolean newUser = true;
//
//		int count = 0;
//		int companyCount = 0;
//
//		try {
////			List<LicenseKey> keyList = licenseKeyService.findAll();
//			List<Contact> contactList = contactService.findAll();
//
//			// Check scmehe.company = company
////        	for(LicenseKey key: keyList) {
////        		 Check company
////        		if(key.getParam().equals(LicenseKey.Parameter.NAME_PRED)) {
////        			if(currentContact.getCompany().getCompanyName().equals(key.getValue())) {
////        				companyName = key.getValue();
////        		        nameStatus = true;
////        		        filename = key.getFilename();
////        			}
////        		}
////        		 Check time
////        		if(key.getParam().equals(LicenseKey.Parameter.DATE_END) && key.getFilename().equals(filename)) {
////        			LocalDate date = LocalDate.now();
////        			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
////        			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////        			Date currentDate = dateFormat.parse(date.format(formatter));
////        			Date keyDate = dateFormat.parse(key.getValue());
////        			if(!(keyDate.compareTo(currentDate) < 0)) {
////        				dateStatus = true;
////        			}
////        		}
////        		 Check count
////        		if(key.getParam().equals(LicenseKey.Parameter.USER_COUNT) && key.getFilename().equals(filename)) {
////        			companyCount = Integer.parseInt(key.getValue());
////        		}
////        	}
//
//			// Just check date
//			LocalDate date = LocalDate.now();
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			Date currentDate = dateFormat.parse(date.format(formatter));
//
////			for (LicenseKey key : keyList) {
////				if (key.getFilename().equals("LicenseKey") && key.getParam().equals(LicenseKey.Parameter.DATE_END)) {
////					if (!(dateFormat.parse(key.getValue()).compareTo(currentDate) < 0)) {
////						dateStatus = true;
////						nameStatus = true;
////					}
////				}
////				if (key.getFilename().equals("LicenseKey") && key.getParam().equals(LicenseKey.Parameter.USER_COUNT)) {
////					companyCount = Integer.parseInt(key.getValue());
////				}
////			}
//
//			for (Contact contact : contactList) {
////        		if(contact.getCompany().getCompanyName().equals(companyName)) {
////        			count++;
////        		}
//
//				count++;
//
////				if (currentContact.getLogin().equals(contact.getLogin())) {
////					newUser = false;
////				}
//			}
//
//			if (newUser) {
//				if (currentContact.getPassword().equals("")) {
//					Dialog dialog = new Dialog();
//					dialog.add(new Text("Ошибка! Введите пароль для нового пользователя."));
//					dialog.open();
//					return;
//				}
//			}
//
//			if ((nameStatus && dateStatus && companyCount >= (count + (newUser ? 1 : 0)) - 1)
//					|| currentContact.getLogin().equals("admin")) {
//
//				Dialog dialog = new Dialog();
//				dialog.add(new Text("Данные успешно обновлены!"));
//				dialog.open();
//
////				if (currentContact.getPassword().length() < 33) {
////					PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
////					currentContact.setPassword(passwordEncoder.encode(currentContact.getPassword()));
////					currentContact.setAccess(false);
////					if (currentContact.getLogin().equals("admin"))
////						currentContact.setAccess(true);
////				}
//
//				if (!currentContact.getLogin().equals("admin")) {
//					currentContact.setCompanyName(currentContact.getCompany().getCompanyName());
//				}
//
////				try {
////					SecurityConfiguration.userDetailsManager.updatePassword(
////							SecurityConfiguration.userDetailsManager.loadUserByUsername(currentContact.getLogin()),
////							"{bcrypt}" + currentContact.getPassword());
////				} catch (UsernameNotFoundException e) {
////					SecurityConfiguration.userDetailsManager.createUser(User.withUsername(currentContact.getLogin())
////							.password("{bcrypt}" + currentContact.getPassword()).roles("USER").build());
////				}
//
//				contactService.save(currentContact);
//				updateList();
//				closeEditor();
//
//				return;
//			}
//
////			if (!nameStatus) {
////				Dialog dialog = new Dialog();
////				dialog.add(new Html(
////						"<div>Ошибка! Ключ не найден, либо его срок истёк.<br> Зайдите в раздел \"Настройка лицензионного ключа\" и проверьте действующий ключ</div>"));
////				dialog.open();
////			} else {
////				if (!(companyCount >= (count + (newUser ? 1 : 0) - 1))) {
////					Dialog dialog = new Dialog();
////					dialog.add(new Text("Ошибка! Создано максимальное количество пользователей."));
////					dialog.open();
////				} else {
////					Dialog dialog = new Dialog();
////					dialog.add(new Text("Ошибка! Истек период использования лицензионного ключа для данной компании."));
////					dialog.open();
////				}
////			}
//		} catch (Exception e) {
//			System.out.println("Use save error");
//			e.printStackTrace();
//		}
//	}
//
//
//
//
//
//
//
//	private HorizontalLayout getToolBar() {
//        filterText.setPlaceholder("Введите имя...");
//        filterText.setClearButtonVisible(true);
//        filterText.setValueChangeMode(ValueChangeMode.LAZY);
//        filterText.addValueChangeListener(e -> updateList());
//
//        Button sortList = new Button(new Icon(VaadinIcon.ROTATE_RIGHT), click -> updateList()); //ROTATE_RIGHT
//        Button addContactButton = new Button("Добавить запись", click -> addContact());
//        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton, sortList);
//
//        toolbar.addClassName("toolbar");
//        return toolbar;
//    }
//
//    private void addContact() {
//        grid.asSingleSelect().clear();
//        Contact contact = new Contact();
//        LocalDate date = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalTime time = LocalTime.now();
//        DateTimeFormatter formatterlc = DateTimeFormatter.ofPattern("HH:mm:ss");
//
//    	contact.setCRDate(date.format(formatter));
//        contact.setCRTime(time.format(formatterlc));
//        editContact(contact);
//    }
//
//    private void configureGrid() {
//        grid.addClassName("contact-grid");
//        grid.setSizeFull();
////        grid.removeColumnByKey("company");
//        grid.setColumns("login");
//        grid.addColumn(contact -> {
//        	String fullName = contact.getFullName();
//        	return fullName == null ? "-" : fullName;
//        }).setHeader("ФИО").setSortable(true);
//        grid.addColumn(contact -> {
//        	Company company = contact.getCompany();
//        	return company == null ? "-" : company.getName();
//        }).setHeader("Код предприятия").setSortable(true);
//        grid.addColumn(contact -> {
//        	Company company = contact.getCompany();
//        	return company == null ? "-" : company.getCompanyName();
//        }).setHeader("Название предприятия").setSortable(true);
//        grid.addColumn(contact -> {
//        	boolean admin = contact.getAdmin();
//        	return admin ? "Да" : "Нет";
//        }).setHeader("Администратор").setSortable(true);
//        grid.addColumn(contact -> {
//        	boolean passwordStatus = contact.getAccess();
//        	return passwordStatus? "Постоянный" : "Начальный";
//        }).setHeader("Пароль").setSortable(true);
//        grid.addColumn(contact -> {
//        	boolean block = contact.getBlock();
//        	return block ? "Да" : "Нет";
//        }).setHeader("Заблокирован").setSortable(true);
//        grid.addColumn(contact -> {
//        	String crdate = contact.getCRDate();
//        	return crdate == null ? "-" : crdate;
//        }).setHeader("Дата создания").setSortable(true);
//        grid.addColumn(contact -> {
//        	String crtime = contact.getCRTime();
//        	return crtime == null ? "-" : crtime;
//        }).setHeader("Время создания").setSortable(true);
//        grid.addColumn(contact -> {
//        	String author = contact.getAuthor();
//        	return author == null ? "-" : author;
//        }).setHeader("Автор").setSortable(true);
//
//        grid.getColumns().forEach(col -> col.setAutoWidth(true));
//
//        changeColumnName("login", "Логин");
//
//        grid.asSingleSelect().addValueChangeListener(evt -> {
//        	editContact(evt.getValue());
//        });
//    }
//
//    private void editContact(Contact contact) {
//        if (contact == null) {
//            closeEditor();
//        } else {
//            form.setContact(contact);
//            form.setVisible(true);
//            addClassName("editing");
//        }
//    }
//
//    private void closeEditor() {
//        form.setContact(null);
//        form.setVisible(false);
//        removeClassName("editing");
//    }
//
//    private void updateList() {
//        grid.setItems(contactService.findAll(filterText.getValue()));
//
//        Column<Contact> login = grid.getColumnByKey("login");
//		GridSortOrder<Contact> order = new GridSortOrder<>(login, SortDirection.ASCENDING);
//
//        grid.sort(Arrays.asList(order));
//    }
//
//    private void changeColumnName(String propertyString, String nameString) {
//        Column<Contact> changeNameColumn = grid.getColumnByKey(propertyString);
//        if (changeNameColumn != null) changeNameColumn.setHeader(nameString);
//    }
//}
