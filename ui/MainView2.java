//package ru.prominn.atombot.ui;
//
//import com.vaadin.annotations.Title;
//import com.vaadin.flow.component.UI;
//import com.vaadin.flow.component.applayout.DrawerToggle;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.button.ButtonVariant;
//import com.vaadin.flow.component.dependency.CssImport;
//import com.vaadin.flow.component.html.Div;
//import com.vaadin.flow.component.html.H1;
//import com.vaadin.flow.component.html.H4;
//import com.vaadin.flow.component.html.H5;
//import com.vaadin.flow.component.icon.Icon;
//import com.vaadin.flow.component.icon.VaadinIcon;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.progressbar.ProgressBar;
//import com.vaadin.flow.router.Route;
//import org.springframework.beans.factory.annotation.Autowired;
//import ru.prominn.atombot.backend.directory.entity.Contact;
//import ru.prominn.atombot.backend.directory.repository.ContactRepository;
//import ru.prominn.atombot.backend.document_form.entity.TableCardLotPosition;
//import ru.prominn.atombot.backend.document_form.repository.TableCardLotPositionRepository;
//
//import java.util.List;
//
//
//@Title("Atombot")
//@Route("main2")
////@CssImport("./styles/shared-styles2.css")
//public class MainView2 extends Div {
//
//	private Button butn;
//	private Button butn1;
//	private Button butn2;
//	private Button butn3;
//	private Button butn4;
//	private Button butn5;
//	private Button butn6;
//	private Button butn7;
//	private Button butn8;
//
//	@Autowired
//	public MainView2(ContactRepository contactRepository, TableCardLotPositionRepository positionLotRepository) {
//		List<Contact> contactList = contactRepository.findAll();
//		createHeader(contactList);
//
//		HorizontalLayout horiz = new HorizontalLayout();
//		Div div1 = new Div();
//		Div div2 = new Div();
//		Div div3 = new Div();
//		Div div4 = new Div();
//		VerticalLayout vertical1 = new VerticalLayout();
//		VerticalLayout vertical2 = new VerticalLayout();
//		VerticalLayout vertical3 = new VerticalLayout();
//		VerticalLayout vertical4 = new VerticalLayout();
//
//
//		// Set first button, if not its not working
//		butn = new Button(" ");
//		butn.setHeight("250px");
//		butn.setWidth("250px");
//		butn.addThemeVariants(ButtonVariant.LUMO_LARGE);
//		vertical1.add(butn);
////		add(butn);
////		butn.addClassName("butn");
//
//		// Set next button from SIZE * on 2
//		newButton(butn1, " ", "butn1", "/", vertical1);
//		newButton(butn2, " ", "butn2", "/",vertical2);
//		newButton(butn3, " ", "butn3", "/lot_info",vertical2);
//		newButton(butn4, " ", "butn4", "/",vertical3);
//		newButton(butn5, " ", "butn5", "/",vertical3);
//		newButton(butn6, " ", "butn4", "/",vertical4);
//
//		butn7 = new Button(" ");
//		butn7.setHeight("250px");
//		butn7.setWidth("510px");
//		butn7.addThemeVariants(ButtonVariant.LUMO_LARGE);
//		vertical4.add(butn7);
////		add(butn7);
////		butn7.addClassName("butn4");
//
//		newButton(butn8, " ", "butn4", "/",vertical4);
//
//
////		setIconWidjets(VaadinIcon.CHART_LINE, getNumber(positionLotRepository), "Позиция Лота", "Количество операций",
////				"icons", "h1", "h3", "h5");
////		setIconWidjets(VaadinIcon.BAR_CHART, "3", "Закупочная процедура", "Обработанных процедур", "icons1", "h1-1",
////				"h3-1", "h5-1");
////		setIconWidjets(VaadinIcon.AT, "156", "Техническое задание", "Входящих заявок - 15", "icons2", "h1-2", "h3-2",
////				"h5-2", "h4-2", "Обработанных пользователей");
////		setIconWidjets(VaadinIcon.PROGRESSBAR, "10%", "Лот", "icons3", "h1-3", "h3-3");
////		setIconWidjets(VaadinIcon.CHEVRON_CIRCLE_DOWN, "25%", "НМЦ", "icons4", "h1-4", "h3-4");
////		setIconWidjets(VaadinIcon.CARET_LEFT, "7", "Проект договора", "Количество запросов", "icons5", "h1-5", "h3-5",
////				"h5-5");
////		setIconWidjets(VaadinIcon.CHART_TIMELINE, "10", "ТКП", "icons6", "h1-6", "h3-6");
////		setIconWidjets(VaadinIcon.WORKPLACE, "156", "Заявка участника", "Входящих предложений - 5", "icons7", "h1-7",
////				"h3-7", "h5-7", "h4-7", "Обработанных поставщиков");
////		setIconWidjets(VaadinIcon.TOOLBOX, "2", "Источник ценовой информации ", "icons8", "h1-8", "h3-8", "h6-8", 0.33f);
//
//
//
////		vertical1.add(butn,butn1);
////		vertical2.add(butn2,butn3);
////		vertical3.add(butn4,butn5);
////		vertical4.add(butn6,butn7,butn8);
//
//		div1.add(vertical1);
//		div2.add(vertical2);
//		div3.add(vertical3);
//		div4.add(vertical4);
//
//		horiz.add(div1,div2,div3,div4);
//		add(horiz);
//
//
//
//		/** That is actionLIstener on the button redirect */
//		butn.addClickListener(e -> {
//			redirect("tableCardLotPositionView");
//
//		});
//
//	}
//
//	/** The metod place the number of operations on a tile first button */
//	private String getNumber(TableCardLotPositionRepository positionLotRepository) {
//		List<TableCardLotPosition> positionLotList = positionLotRepository.findAll();
//		int posLotOperation = positionLotList.size();
//
//		String positionLotOperation = Integer.toString(posLotOperation);
//		return positionLotOperation;
//	}
//
//	/** widjets 1 */
//	public void setIconWidjets(VaadinIcon iconca, String number, String buttonName, String operation, String nameClass,
//			String nameClassH1, String nameClassH3, String nameClassH5) {
//		Icon icon = new Icon(iconca);
//		H5 text = new H5(operation);
//		H1 text1 = new H1(number);
//		H4 text2 = new H4(buttonName);
//
//		icon.addClassName(nameClass);
//		text.addClassName(nameClassH5);
//		text1.addClassName(nameClassH1);
//		text2.addClassName(nameClassH3);
//
//		icon.setSize("30px");
//		add(icon, text1, text2, text);
//	}
//
//	/** widjets 2 */
//	public void setIconWidjets(VaadinIcon iconca, String number, String buttonName, String operation, String nameClass,
//			String nameClassH1, String nameClassH3, String nameClassH5, String nameClassH4, String info) {
//		Icon icon = new Icon(iconca);
//		H5 text = new H5(operation);
//		H1 text1 = new H1(number);
//		H4 text2 = new H4(buttonName);
//		H5 text3 = new H5(info);
//
//		icon.addClassName(nameClass);
//		text.addClassName(nameClassH5);
//		text1.addClassName(nameClassH1);
//		text2.addClassName(nameClassH3);
//		text3.addClassName(nameClassH4);
//
//		icon.setSize("30px");
//		add(icon, text1, text2, text, text3);
//	}
//
//	/** widjets 3 */
//	public void setIconWidjets(VaadinIcon iconca, String number, String buttonName, String nameClass,
//			String nameClassH1, String nameClassH3) {
//		Icon icon = new Icon(iconca);
//		H1 text1 = new H1(number);
//		H4 text2 = new H4(buttonName);
//		icon.addClassName(nameClass);
//		text1.addClassName(nameClassH1);
//		text2.addClassName(nameClassH3);
//
//		icon.setSize("30px");
//		add(icon, text1, text2);
//	}
//
//	/** widjets 4 */
//	public void setIconWidjets(VaadinIcon iconca, String number, String buttonName, String nameClass,
//			String nameClassH1, String nameClassH3, String nameClassH6, float progr) {
//		Icon icon = new Icon(iconca);
//		ProgressBar progressBar = new ProgressBar();
//		progressBar.setValue(progr);
//		progressBar.setMaxWidth("300px");
//		H1 text1 = new H1(number);
//		H4 text2 = new H4(buttonName);
//		icon.addClassName(nameClass);
//		text1.addClassName(nameClassH1);
//		text2.addClassName(nameClassH3);
//		progressBar.addClassName(nameClassH6);
//
//		icon.setSize("30px");
//		add(icon, text1, text2, progressBar);
//	}
//
//	/** Create a new button */
//	private void newButton(Button name, String button, String name1, String adress, VerticalLayout vertical) {
//		name = new Button(button);
//		name.setHeight("250px");
//		name.setWidth("250px");
//		name.addThemeVariants(ButtonVariant.LUMO_LARGE);
//		vertical.add(name);
////		add(name);
//		name.addClassName(name1);
//		name.addClickListener(e -> {
//			redirect(adress);
//		});
//	}
//
//	/** That is mace a new Header on the page */
//	private void createHeader(List<Contact> contactList) {
//		H1 logo = new H1("Атомбот");
//		H1 userInfo = new H1();
//		logo.addClassName("logo");
//
//		String username = "Admin";
//		String name = "ФИО не задано";
//
//		for (Contact contact : contactList) {
//			if (contact.getLogin().equals(username)) {
//				name = contact.getFullName();
//				break;
//			}
//		}
//
//		userInfo.setText("Текущий пользователь: " + username + " / " + name + ".");
//		userInfo.addClassName("logo");
//
//		HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, userInfo);
//		header.expand(logo);
//		header.setWidth("100%");
//		header.addClassName("header");
//		add(header);
//
//	}
//
//	/** This is redirect on company */
//	public void redirect(String urlAdress) {
//		UI.getCurrent().getPage().setLocation(urlAdress);
//	}
//}
