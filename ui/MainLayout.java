//package ru.prominn.atombot.ui;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.vaadin.flow.component.applayout.AppLayout;
//import com.vaadin.flow.component.applayout.DrawerToggle;
//import com.vaadin.flow.component.dependency.CssImport;
//import com.vaadin.flow.component.html.H1;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.router.BeforeEnterEvent;
//import com.vaadin.flow.router.BeforeEnterObserver;
//
//import ru.prominn.atombot.backend.directory.entity.Contact;
//import ru.prominn.atombot.backend.directory.repository.ContactRepository;
//
//
//@SuppressWarnings("serial")
//@CssImport("./styles/shared-styles.css")
//public class MainLayout extends AppLayout implements BeforeEnterObserver{
//
//	private static final Logger log = LoggerFactory.getLogger(MainLayout.class);
//
//	@Autowired
//	public void MainLayout(ContactRepository contactRepository) {
//    	List<Contact> contactList = contactRepository.findAll();
//    	createHeader(contactList);
//    	createDrawer();
//
//
//    }
//
//	private void createHeader(List<Contact> contactList) {
//        H1 logo = new H1("Атомбот");
//        H1 userInfo = new H1();
//        logo.addClassName("logo");
//
//        String username = "Admin";
//        String name = "ФИО не задано";
//
//        for(Contact contact : contactList) {
//        	if(contact.getLogin().equals(username)) {
//            	name = contact.getFullName();
//            	break;
//        	}
//        }
//
//        userInfo.setText("Текущий пользователь: " + username + " / " + name + ".");
//        userInfo.addClassName("logo");
//
//        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, userInfo);
//        header.expand(logo);
//        header.setWidth("100%");
//        header.addClassName("header");
//
//        addToNavbar(header);
//    }
//
//    private void createDrawer() {
//
////        RouterLink listLink = new RouterLink("Настройка пользователей", UserListView.class);
////        listLink.setHighlightCondition(HighlightConditions.sameLocation());
////        RouterLink companyLink = new RouterLink("Настройка предприятий", CompanyView.class);
////        addToDrawer(new VerticalLayout(listLink, companyLink));
//    }
//
//
//	@Override
//	public void beforeEnter(BeforeEnterEvent event) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//
//}
