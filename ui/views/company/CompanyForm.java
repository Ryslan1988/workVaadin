//package ru.prominn.atombot.ui.views.company;
//
//import java.util.List;
//
//import org.springframework.dao.DataIntegrityViolationException;
//
//import com.vaadin.flow.component.Component;
//import com.vaadin.flow.component.ComponentEvent;
//import com.vaadin.flow.component.ComponentEventListener;
//import com.vaadin.flow.component.Key;
//import com.vaadin.flow.component.Text;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.button.ButtonVariant;
//import com.vaadin.flow.component.checkbox.CheckboxGroup;
//import com.vaadin.flow.component.dialog.Dialog;
//import com.vaadin.flow.component.formlayout.FormLayout;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.data.binder.BeanValidationBinder;
//import com.vaadin.flow.data.binder.Binder;
//import com.vaadin.flow.data.binder.ValidationException;
//import com.vaadin.flow.data.value.ValueChangeMode;
//import com.vaadin.flow.shared.Registration;
//
//import ru.prominn.atombot.backend.directory.entity.Company;
//
//
//
//@SuppressWarnings("serial")
//public class CompanyForm extends FormLayout {
//
//	TextField name = new TextField("Код предприятия");
//	TextField companyName = new TextField("Компания");
//	TextField crdate = new TextField("Дата");
//	TextField crtime = new TextField("Время");
//	TextField author = new TextField("Автор");
//
//	CheckboxGroup<String> group = new CheckboxGroup<String>();
//
//	Button save = new Button("Сохранить");
//	Button delete = new Button("Удалить");
//	Button close = new Button("Отмена");
//
//	Binder<Company> binder = new BeanValidationBinder<>(Company.class);
//	private Company company;
//
//
//
//	public CompanyForm(List<Company> companies) {
//		addClassName("contact-form");
//
//		binder.bindInstanceFields(this);
//
//		name.setRequired(true);
//		companyName.setRequired(true);
//
//		crdate.setReadOnly(true);
//		crtime.setReadOnly(true);
//		author.setReadOnly(true);
//
//		companyName.setValueChangeMode(ValueChangeMode.EAGER);
//		companyName.addValueChangeListener(e -> {
//			if(!e.getValue().isEmpty()) {
//				save.setEnabled(true);
//			} else {
//				save.setEnabled(false);
//			}
//		});
//
//		group.setLabel("Настройки предприятия");
//		group.setItems("Заблокировано");
//
//		add(
//				name,
//				companyName,
//				group,
//				crdate,
//				crtime,
//				author,
//				createButtonsLayout());
//	}
//
//	public void setCompany(Company company) {
//		this.company = company;
//		binder.readBean(company);
//
//		save.setEnabled(true);
//		try {
//			if(company.getStatus()) {
//				group.select("Заблокировано");
//			}
//			if(company.getCompanyName() != null) {
//				name.setEnabled(false);
//			} else {
//				name.setEnabled(true);
//			}
//		} catch(NullPointerException e) {
//			// Company not exist
//		}
//
//	}
//
//	private Component createButtonsLayout() {
//		save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
//		delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
//		close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
//
//		save.addClickShortcut(Key.ENTER);
//		close.addClickShortcut(Key.ESCAPE);
//
//		save.addClickListener(click -> validateAndSave());
//		delete.addClickListener(click -> fireEvent(new DeleteEvent(this, company)));
//		close.addClickListener(click -> fireEvent(new CloseEvent(this)));
//
//		binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));
//
//		return new HorizontalLayout(save, delete, close);
//	}
//
//	private void validateAndSave() {
//
//		try {
//			if (company != null) {
//				if(company.getKuns() == null) company.setKuns(name.getValue());
//
//				company.setStatus(false);
//
//				for(String param : group.getSelectedItems()) {
//					if(param.equals("Заблокировано")) {
//						company.setStatus(true);
//					}
//
//				}
//
//				binder.writeBean(company);
//				fireEvent(new SaveEvent(this, company));
//			}
//		} catch (ValidationException e) {
//		} catch (DataIntegrityViolationException e1) {
//        	Dialog dialog = new Dialog();
//        	dialog.add(new Text("Ошибка! Код компании изменить невозможно. Для создания новой компании используйте кнопку \"Добавить запись\""));
//        	dialog.open();
//        	e1.printStackTrace();
//		}
//	}
//
//	public static abstract class CompanyFormEvent extends ComponentEvent<CompanyForm> {
//		private Company company;
//
//		protected CompanyFormEvent(CompanyForm source, Company company) {
//			super(source, false);
//			this.company = company;
//		}
//
//		public Company getCompany() {
//			return company;
//		}
//	}
//
//	public static class SaveEvent extends CompanyFormEvent {
//		SaveEvent(CompanyForm source, Company company) {
//			super(source, company);
//		}
//	}
//
//	public static class DeleteEvent extends CompanyFormEvent {
//		DeleteEvent(CompanyForm source, Company company) {
//			super(source, company);
//		}
//	}
//
//	public static class CloseEvent extends CompanyFormEvent {
//		CloseEvent(CompanyForm source) {
//			super(source, null);
//		}
//	}
//
//	public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
//			ComponentEventListener<T> listener) {
//		return getEventBus().addListener(eventType, listener);
//	}
//}
