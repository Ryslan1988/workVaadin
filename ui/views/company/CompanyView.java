//package ru.prominn.atombot.ui.views.company;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Arrays;
//
////import org.springframework.security.core.Authentication;
////import org.springframework.security.core.context.SecurityContextHolder;
//
//import com.vaadin.flow.component.Text;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.dialog.Dialog;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.grid.GridSortOrder;
//import com.vaadin.flow.component.grid.Grid.Column;
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
//import ru.prominn.atombot.backend.directory.service.CompanyService;
//import ru.prominn.atombot.backend.directory.service.ContactService;
//import ru.prominn.atombot.ui.MainLayout;
//
//@SuppressWarnings("serial")
//@Route(value = "company", layout = MainLayout.class)
//@PageTitle("Настройка предприятий")
//public class CompanyView extends VerticalLayout {
//
//	private final CompanyForm form;
//    Grid<Company> grid = new Grid<>(Company.class);
//    TextField filterText = new TextField();
//
//    private CompanyService companyService;
//
//    public CompanyView(ContactService contactService,
//            CompanyService companyService) {
//		this.companyService = companyService;
//    	addClassName("list-view");
//    	setSizeFull();
//        configureGrid();
//
//        form = new CompanyForm(companyService.findAll());
//        form.addListener(CompanyForm.SaveEvent.class, this::saveCompany);
//        form.addListener(CompanyForm.DeleteEvent.class, this::deleteCompany);
//        form.addListener(CompanyForm.CloseEvent.class, e -> closeEditor());
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
//    private void deleteCompany(CompanyForm.DeleteEvent evt) {
//        if(!companyService.delete(evt.getCompany())) {
//        	Dialog dialog = new Dialog();
//        	dialog.add(new Text("Ошибка! Удалите всех пользователей этого предприятия."));
//        	dialog.open();
//        } else {
//        	Dialog dialog = new Dialog();
//        	dialog.add(new Text("Компания успешно удалена!"));
//        	dialog.open();
//	        updateList();
//	        closeEditor();
//        }
//    }
//
//    private void saveCompany(CompanyForm.SaveEvent evt) {
//        try {
//        	evt.getCompany().setKuns(evt.getCompany().getName());
//        	companyService.save(evt.getCompany());
//            updateList();
//            closeEditor();
//
//        	Dialog dialog = new Dialog();
//        	dialog.add(new Text("Данные успешно обновлены!"));
//        	dialog.open();
//        } catch (Exception e) {
//        	Dialog dialog = new Dialog();
//        	dialog.add(new Text("Ошибка! Код компании изменить невозможно. Для создания новой компании используйте кнопку \"Добавить запись\""));
//        	dialog.open();
//
//        	e.printStackTrace();
//        }
//    }
//
//
//    private HorizontalLayout getToolBar() {
//        filterText.setPlaceholder("Введите название...");
//        filterText.setClearButtonVisible(true);
//        filterText.setValueChangeMode(ValueChangeMode.LAZY);
//        filterText.addValueChangeListener(e -> updateList());
//
//        Button sortList = new Button(new Icon(VaadinIcon.ROTATE_RIGHT), click -> updateList()); //ROTATE_RIGHT
//        Button addContactButton = new Button("Добавить запись", click -> addContact());
//
//        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton, sortList);
//        toolbar.addClassName("toolbar");
//        return toolbar;
//    }
//
//    private void addContact() {
//    	updateList();
//
//        grid.asSingleSelect().clear();
//        Company company = new Company();
////        Authentication au = SecurityContextHolder.getContext().getAuthentication();
////		String auName = au.getName();
//        LocalDate date = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalTime time = LocalTime.now();
//        DateTimeFormatter formatterlc = DateTimeFormatter.ofPattern("HH:mm:ss");
//        company.setCRDate(date.format(formatter));
//        company.setCRTime(time.format(formatterlc));
//   //     company.setAuthor(auName);
//        editCompany(company);
//    }
//
//    private void configureGrid() {
//        grid.addClassName("contact-grid");
//        grid.removeAllColumns();
//        grid.setSizeFull();
//        grid.setColumns("name");
//        grid.addColumn(contact -> {
//        	String company = contact.getCompanyName();
//        	return company == null ? "-" : company;
//        }).setHeader("Наименование предприятия").setSortable(true);
//        grid.addColumn(contact -> {
//        	boolean admin = contact.getStatus();
//        	return admin ? "Да" : "Нет";
//        }).setHeader("Заблокировано");
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
//        changeColumnName("name", "Код предприятия");
//        grid.getColumns().forEach(col -> col.setAutoWidth(true));
//        grid.asSingleSelect().addValueChangeListener(evt -> editCompany(evt.getValue()));
//    }
//
//    private void editCompany(Company company) {
//        if (company == null) {
//            closeEditor();
//        } else {
//            form.setCompany(company);
//            form.setVisible(true);
//            addClassName("editing");
//        }
//    }
//
//    private void updateList() {
//        grid.setItems(companyService.findAll(filterText.getValue()));
//
//        Column<Company> name = grid.getColumnByKey("name");
//		GridSortOrder<Company> order = new GridSortOrder<>(name, SortDirection.ASCENDING);
//        grid.sort(Arrays.asList(order));
//    }
//
//    private void closeEditor() {
//        form.setCompany(null);
//        form.setVisible(false);
//        removeClassName("editing");
//    }
//
//    private void changeColumnName(String propertyString, String nameString) {
//        Column<Company> changeNameColumn = grid.getColumnByKey(propertyString);
//        if (changeNameColumn != null) changeNameColumn.setHeader(nameString);
//    }
//}
