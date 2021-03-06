package ru.prominn.atombot.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Title;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.router.Route;

import ru.prominn.atombot.backend.directory.entity.Contact;
import ru.prominn.atombot.backend.document_form.entity.TableCardLotPosition;
import ru.prominn.atombot.backend.directory.repository.ContactRepository;
import ru.prominn.atombot.backend.document_form.repository.TableCardLotPositionRepository;



@Title("Atombot")
@Route("main")
@CssImport("./styles/shared-styles2.css")
public class MainView extends Div {

	private Button butn;
	private Button butn1;
	private Button butn2;
	private Button butn3;
	private Button butn4;
	private Button butn5;
	private Button butn6;
	private Button butn7;
	private Button butn8;

	@Autowired
	public MainView(ContactRepository contactRepository, TableCardLotPositionRepository positionLotRepository) {
		List<Contact> contactList = contactRepository.findAll();
		createHeader(contactList);

		// Set first button, if not its not working
		butn = new Button(" ");
		butn.setHeight("250px");
		butn.setWidth("250px");
		butn.addThemeVariants(ButtonVariant.LUMO_LARGE);
		add(butn);
		butn.addClassName("butn");

		// Set next button from SIZE * on 2
		newButton(butn1, " ", "butn1", "/");
		newButton(butn2, " ", "butn2", "/");
		newButton(butn3, " ", "butn3", "/lot_info");
		newButton(butn4, " ", "butn4", "/");
		newButton(butn5, " ", "butn5", "/");
		newButton(butn6, " ", "butn4", "/");

		butn7 = new Button(" ");
		butn7.setHeight("250px");
		butn7.setWidth("510px");
		butn7.addThemeVariants(ButtonVariant.LUMO_LARGE);
		add(butn7);
		butn7.addClassName("butn4");

		newButton(butn8, " ", "butn4", "/");

		
		setIconWidjets(VaadinIcon.CHART_LINE, getNumber(positionLotRepository), "?????????????? ????????", "???????????????????? ????????????????",
				"icons", "h1", "h3", "h5");
		setIconWidjets(VaadinIcon.BAR_CHART, "3", "???????????????????? ??????????????????", "???????????????????????? ????????????????", "icons1", "h1-1",
				"h3-1", "h5-1");
		setIconWidjets(VaadinIcon.AT, "156", "?????????????????????? ??????????????", "???????????????? ???????????? - 15", "icons2", "h1-2", "h3-2",
				"h5-2", "h4-2", "???????????????????????? ??????????????????????????");
		setIconWidjets(VaadinIcon.PROGRESSBAR, "10%", "??????", "icons3", "h1-3", "h3-3");
		setIconWidjets(VaadinIcon.CHEVRON_CIRCLE_DOWN, "25%", "??????", "icons4", "h1-4", "h3-4");
		setIconWidjets(VaadinIcon.CARET_LEFT, "7", "???????????? ????????????????", "???????????????????? ????????????????", "icons5", "h1-5", "h3-5",
				"h5-5");
		setIconWidjets(VaadinIcon.CHART_TIMELINE, "10", "??????", "icons6", "h1-6", "h3-6");
		setIconWidjets(VaadinIcon.WORKPLACE, "156", "???????????? ??????????????????", "???????????????? ?????????????????????? - 5", "icons7", "h1-7",
				"h3-7", "h5-7", "h4-7", "???????????????????????? ??????????????????????");
		setIconWidjets(VaadinIcon.TOOLBOX, "2", "???????????????? ?????????????? ???????????????????? ", "icons8", "h1-8", "h3-8", "h6-8", 0.33f);

		/** That is actionLIstener on the button redirect */
		butn.addClickListener(e -> {
			redirect("tableCardLotPositionView");

		});

	}

	/** The metod place the number of operations on a tile first button */
	private String getNumber(TableCardLotPositionRepository positionLotRepository) {
		List<TableCardLotPosition> positionLotList = positionLotRepository.findAll();
		int posLotOperation = positionLotList.size();

		String positionLotOperation = Integer.toString(posLotOperation);
		return positionLotOperation;
	}

	/** widjets 1 */
	public void setIconWidjets(VaadinIcon iconca, String number, String buttonName, String operation, String nameClass,
			String nameClassH1, String nameClassH3, String nameClassH5) {
		Icon icon = new Icon(iconca);
		H5 text = new H5(operation);
		H1 text1 = new H1(number);
		H4 text2 = new H4(buttonName);

		icon.addClassName(nameClass);
		text.addClassName(nameClassH5);
		text1.addClassName(nameClassH1);
		text2.addClassName(nameClassH3);

		icon.setSize("30px");
		add(icon, text1, text2, text);
	}

	/** widjets 2 */
	public void setIconWidjets(VaadinIcon iconca, String number, String buttonName, String operation, String nameClass,
			String nameClassH1, String nameClassH3, String nameClassH5, String nameClassH4, String info) {
		Icon icon = new Icon(iconca);
		H5 text = new H5(operation);
		H1 text1 = new H1(number);
		H4 text2 = new H4(buttonName);
		H5 text3 = new H5(info);

		icon.addClassName(nameClass);
		text.addClassName(nameClassH5);
		text1.addClassName(nameClassH1);
		text2.addClassName(nameClassH3);
		text3.addClassName(nameClassH4);

		icon.setSize("30px");
		add(icon, text1, text2, text, text3);
	}

	/** widjets 3 */
	public void setIconWidjets(VaadinIcon iconca, String number, String buttonName, String nameClass,
			String nameClassH1, String nameClassH3) {
		Icon icon = new Icon(iconca);
		H1 text1 = new H1(number);
		H4 text2 = new H4(buttonName);
		icon.addClassName(nameClass);
		text1.addClassName(nameClassH1);
		text2.addClassName(nameClassH3);

		icon.setSize("30px");
		add(icon, text1, text2);
	}

	/** widjets 4 */
	public void setIconWidjets(VaadinIcon iconca, String number, String buttonName, String nameClass,
			String nameClassH1, String nameClassH3, String nameClassH6, float progr) {
		Icon icon = new Icon(iconca);
		ProgressBar progressBar = new ProgressBar();
		progressBar.setValue(progr);
		progressBar.setMaxWidth("300px");
		H1 text1 = new H1(number);
		H4 text2 = new H4(buttonName);
		icon.addClassName(nameClass);
		text1.addClassName(nameClassH1);
		text2.addClassName(nameClassH3);
		progressBar.addClassName(nameClassH6);

		icon.setSize("30px");
		add(icon, text1, text2, progressBar);
	}

	/** Create a new button */
	private void newButton(Button name, String button, String name1, String adress) {
		name = new Button(button);
		name.setHeight("250px");
		name.setWidth("250px");
		name.addThemeVariants(ButtonVariant.LUMO_LARGE);
		add(name);
		name.addClassName(name1);
		name.addClickListener(e -> {
			redirect(adress);
		});
	}

	/** That is mace a new Header on the page */
	private void createHeader(List<Contact> contactList) {
		H1 logo = new H1("??????????????");
		H1 userInfo = new H1();
		logo.addClassName("logo");

		String username = "Admin";
		String name = "?????? ???? ????????????";

		for (Contact contact : contactList) {
			if (contact.getLogin().equals(username)) {
				name = contact.getFullName();
				break;
			}
		}

		userInfo.setText("?????????????? ????????????????????????: " + username + " / " + name + ".");
		userInfo.addClassName("logo");

		HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, userInfo);
		header.expand(logo);
		header.setWidth("100%");
		header.addClassName("header");
		add(header);

	}

	/** This is redirect on company */
	public void redirect(String urlAdress) {
		UI.getCurrent().getPage().setLocation(urlAdress);
	}
}
