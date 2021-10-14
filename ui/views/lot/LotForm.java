//package ru.prominn.atombot.ui.views.lot;
//
//import com.vaadin.flow.component.*;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.button.ButtonVariant;
//import com.vaadin.flow.component.checkbox.CheckboxGroup;
//import com.vaadin.flow.component.dependency.CssImport;
//import com.vaadin.flow.component.dialog.Dialog;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.splitlayout.SplitLayout;
//import com.vaadin.flow.component.splitlayout.SplitLayoutVariant;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.data.binder.BeanValidationBinder;
//import com.vaadin.flow.data.binder.Binder;
//import com.vaadin.flow.data.binder.ValidationException;
//import com.vaadin.flow.data.value.ValueChangeMode;
//import com.vaadin.flow.shared.Registration;
//import org.springframework.dao.DataIntegrityViolationException;
//import ru.prominn.atombot.backend.document_form.entity.Lot;
//import ru.prominn.atombot.backend.document_form.entity.Position;
//
//import java.util.List;
//
//
//@SuppressWarnings("serial")
//@CssImport("./styles/shared-styles2.css")
//public class LotForm extends VerticalLayout {
//    //something new for test
//    Grid<Position> gridPosition = new Grid<>(Position.class);
//
//    TextField idLot = new TextField("ID документа");
//    TextField id = new TextField("ID номер");
//    TextField regNumber = new TextField("Рег. номер");
//    TextField docStatusCode = new TextField("Статус Документа");
//    TextField docStatus = new TextField(".Статус");
//    TextField authorCode = new TextField("Владелец Документа");
//    TextField author = new TextField(".Владелец");
//    TextField crdate = new TextField("Дата регистарции");
//    TextField description = new TextField("Описание");
//    TextField zp_PZP_Code = new TextField("№ ЗП/ПЗП");
//    TextField zp_PZP = new TextField(".№ ЗП/ПЗП");
//    TextField number_lot = new TextField("№ лота");
//    TextField number_lot_SAP = new TextField("№ лота в SAP CRM");
//    TextField canselLot = new TextField("Отмененный лот");
//    TextField nmcNDS = new TextField("НМЦ с НДС");
//    TextField summNDS = new TextField("Сумма НДС");
//    TextField nmcNoNDS = new TextField("НМЦ без НДС");
//
//
//    CheckboxGroup<String> group = new CheckboxGroup<String>();
//
//    Button save = new Button("Сохранить");
//    Button delete = new Button("Удалить");
//    Button close = new Button("Отмена");
//
//    Binder<Lot> binder = new BeanValidationBinder<>(Lot.class);
//    private Lot lot;
//
//    public LotForm(List<Lot> companies) {
//        SplitLayout layout = new SplitLayout();
//		layout.setSizeFull();
//		layout.addThemeVariants(SplitLayoutVariant.LUMO_SMALL);
//        layout.setOrientation(SplitLayout.Orientation.VERTICAL);
//        addClassName("lot-form");
//
//        binder.bindInstanceFields(this);
//
//        idLot.setRequired(true);
//        regNumber.setRequired(true);
//        docStatusCode.setValueChangeMode(ValueChangeMode.EAGER);
//        id.setValueChangeMode(ValueChangeMode.EAGER);
//        docStatus.setValueChangeMode(ValueChangeMode.EAGER);
//        authorCode.setValueChangeMode(ValueChangeMode.EAGER);
//        author.setValueChangeMode(ValueChangeMode.EAGER);
//        crdate.setValueChangeMode(ValueChangeMode.EAGER);
//        description.setValueChangeMode(ValueChangeMode.EAGER);
//        zp_PZP_Code.setValueChangeMode(ValueChangeMode.EAGER);
//        zp_PZP.setValueChangeMode(ValueChangeMode.EAGER);
//        number_lot.setValueChangeMode(ValueChangeMode.EAGER);
//        number_lot_SAP.setValueChangeMode(ValueChangeMode.EAGER);
//        canselLot.setValueChangeMode(ValueChangeMode.EAGER);
//        nmcNDS.setValueChangeMode(ValueChangeMode.EAGER);
//        summNDS.setValueChangeMode(ValueChangeMode.EAGER);
//        nmcNoNDS.setValueChangeMode(ValueChangeMode.EAGER);
//        regNumber.setValueChangeMode(ValueChangeMode.EAGER);
//        regNumber.addValueChangeListener(e -> {
//            if (!e.getValue().isEmpty()) {
//                save.setEnabled(true);
//            } else {
//                save.setEnabled(false);
//            }
//        });
//
//        group.setLabel("Настройки предприятия");
//        group.setItems("Заблокировано");
//
//		layout.addToSecondary(gridPosition);
//        layout.addToPrimary(idLot, id, regNumber, docStatusCode, docStatus, authorCode, author, crdate, description, zp_PZP_Code, zp_PZP,
//                number_lot, number_lot_SAP, canselLot, nmcNDS, summNDS, nmcNoNDS, createButtonsLayout());
//
//
//		add(layout);
//    }
//    //puch test
//    public void setIdLot(Lot lot) {
//        this.lot = lot;
//        binder.readBean(lot);
//
//        save.setEnabled(true);
//        try {
//            if (lot.getRegNumber() != null) {
//                idLot.setEnabled(false);
//            } else {
//                idLot.setEnabled(true);
//            }
//        } catch (NullPointerException e) {
//            // Company not exist
//        }
//
//    }
//
//    private Component createButtonsLayout() {
//        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
//        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
//        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
//
//        save.addClickShortcut(Key.ENTER);
//        close.addClickShortcut(Key.ESCAPE);
//
//        save.addClickListener(click -> validateAndSave());
//        delete.addClickListener(click -> fireEvent(new DeleteEvent(this, lot)));
//        close.addClickListener(click -> fireEvent(new CloseEvent(this)));
//
//        binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));
//
//        return new HorizontalLayout(save, delete, close);
//    }
//
//    public void configGridPos() {
//        gridPosition.addColumn("idContracts");
//        gridPosition.setVerticalScrollingEnabled(true);
//        gridPosition.addClassName("lot-grid");
//        gridPosition.removeAllColumns();
//        gridPosition.setSizeUndefined();
//
//        gridPosition.setColumns("idLot");
//        gridPosition.addColumn(id -> {
//            String id1 = id.getIdPosition();
//            return id1 == null ? "-" : id1;
//        }).setHeader("ID. номер").setSortable(true);
//        gridPosition.addColumn(regNumber -> {
//            String lot = regNumber.getPositionRegNumber();
//            return lot == null ? "-" : lot;
//        }).setHeader("Рег. номер").setSortable(true);
//        gridPosition.addColumn(docStatusCode -> {
//            String docStatusCod = docStatusCode.getPositionName();
//            return docStatusCod == null ? "-" : docStatusCod;
//        }).setHeader("Статус Документа");
//        gridPosition.addColumn(docStatus -> {
//            String docStat = docStatus.getPositionAmount();
//            return docStat == null ? "-" : docStat;
//        }).setHeader(".Статус");
//
//		gridPosition.getColumns().forEach(col -> col.setAutoWidth(true));
//
//
//    }
//
//    private void validateAndSave() {
//
//        try {
//            if (lot != null) {
//                if (lot.getIdLot() == null) {
//                }
//                lot.setIdLot(idLot.getValue());
//
//            }
//
//            binder.writeBean(lot);
//            fireEvent(new SaveEvent(this, lot));
//
//        } catch (ValidationException e) {
//        } catch (DataIntegrityViolationException e1) {
//            Dialog dialog = new Dialog();
//            dialog.add(new Text(
//                    "Ошибка! Код компании изменить невозможно. Для создания новой компании используйте кнопку \"Добавить запись\""));
//            dialog.open();
//            e1.printStackTrace();
//        }
//    }
//
//    public static abstract class LotFormEvent extends ComponentEvent<LotForm> {
//        private Lot lot;
//
//        protected LotFormEvent(LotForm source, Lot lot) {
//            super(source, false);
//            this.lot = lot;
//        }
//
//        public Lot getIdLot() {
//            return lot;
//        }
//    }
//
//    public static class SaveEvent extends LotFormEvent {
//        SaveEvent(LotForm source, Lot lot) {
//            super(source, lot);
//        }
//    }
//
//    public static class DeleteEvent extends LotFormEvent {
//        DeleteEvent(LotForm source, Lot lot) {
//            super(source, lot);
//        }
//    }
//
//    public static class CloseEvent extends LotFormEvent {
//        CloseEvent(LotForm source) {
//            super(source, null);
//        }
//    }
//
//    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
//                                                                  ComponentEventListener<T> listener) {
//        return getEventBus().addListener(eventType, listener);
//    }
//
//}