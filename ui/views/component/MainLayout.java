package ru.prominn.atombot.ui.views.component;


import com.helger.commons.state.ICloseable;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import ru.prominn.atombot.ui.views.table_card_lot_position.TableCardLotPositionView;

import javax.swing.text.html.ListView;

@CssImport("./styles/shared-styles2.css")
public class MainLayout extends AppLayout implements BeforeEnterObserver {
    HorizontalLayout header = new HorizontalLayout();
    H5 logo = new H5("ВИД");

    @Autowired
    public MainLayout() {
        createHeader();
        header.add(new DrawerToggle(),logo);

        createDrawer();
    }

    private void createHeader() {
//        H5 logo = new H5("Атомбот");
        logo.addClassNames("text-l", "m-m");

//        HorizontalLayout header = new HorizontalLayout(
//                new DrawerToggle(),
//                logo
//        );
        Button redirectOnMain = new Button("Выйти в основное меню",
                click -> UI.getCurrent().getPage().setLocation("main"));
        redirectOnMain.addClassName("buttonredir");

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidth("100%");
        header.addClassNames("header");

        addToNavbar(header,redirectOnMain);

    }

    private void createDrawer() {
        RouterLink listLinkTableCardLotPosition = new RouterLink("Позиция лота", TableCardLotPositionView.class);
        listLinkTableCardLotPosition.setHighlightCondition(HighlightConditions.sameLocation());

//        RouterLink listLinkTableCardPosition = new RouterLink("TableCardPositionView", TableCardPositionView.class);
//        listLinkTableCardPosition.setHighlightCondition(HighlightConditions.sameLocation());


        addToDrawer(new VerticalLayout(
                listLinkTableCardLotPosition
//                ,listLinkTableCardPosition
        ));
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {

    }
}

