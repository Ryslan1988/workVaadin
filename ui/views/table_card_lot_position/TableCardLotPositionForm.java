package ru.prominn.atombot.ui.views.table_card_lot_position;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.vaadin.flow.component.*;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;

import com.vaadin.flow.component.splitlayout.SplitLayoutVariant;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import org.apache.commons.io.IOUtils;
import org.springframework.dao.DataIntegrityViolationException;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.dialog.Dialog;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.shared.Registration;


import ru.prominn.atombot.backend.document_form.entity.TableCardLotPosition;
import ru.prominn.atombot.backend.document_form.entity.TableCardPosition;


@SuppressWarnings("serial")
public class TableCardLotPositionForm extends VerticalLayout {

    Grid<TableCardPosition> gridPos = new Grid<>(TableCardPosition.class);
    // Текстфилы под первую таблицу для обработки ее сохранений TableCardLotPosition
    private final TextField guid = new TextField("ID документа");
    private final TextField regNum = new TextField("Код документа");
    private final TextField template = new TextField("Шаблон документа");
    private final TextField description = new TextField("Название документа");
    private final TextField deleteFlag = new TextField("Индикатор удаления документа");
    private final TextField parentDoc1 = new TextField("ID вышестоящего документа 1");
    private final TextField statusText = new TextField("Статус");
    private final TextField createdBy = new TextField("Пользователь, создавший документ");
    private final TextField createdDate = new TextField("Дата создания документа");
    private final TextField createdTime = new TextField("Время создания документа");
    private final TextField changedBy = new TextField("Пользователь, изменивший документ");
    private final TextField changedDate = new TextField("Дата изменения документ");
    private final TextField changedTime = new TextField("Время изменения документ");
    private final TextField closedDate = new TextField("Дата закрытия документа");
    private final TextField closedTime = new TextField("Время закрытия документа");
    private final TextField card_subtype = new TextField("Подтип карточки");
    private final TextField card_type = new TextField("Тип карточки");
    private final TextField pred = new TextField("Владелец");
    private final TextField kun = new TextField("Заказчик");
    private final TextField lifnr = new TextField("Поставщик");
    private final TextField depart = new TextField("Подразделение");
    private final TextField org_purch = new TextField("Организатор закупки");
    private final TextField resp_person = new TextField("Испольнитель");
    private final TextField plan_year = new TextField("Год планирования");
    private final TextField proc_type = new TextField("Тип процедуры");
    private final TextField etp_kind = new TextField("Код ЭТП владельца");
    private final TextField rcase_proc = new TextField("ЕОСЗ");
    private final TextField waers = new TextField("Валюта");
    private final TextField vat = new TextField("Код НДС");
    private final TextField am_with_nds = new TextField("Сумма с НДС");
    private final TextField amount_nds = new TextField("Сумма НДС");
    private final TextField am_not_nds = new TextField("Сумма без НДС");
    // Текстфилы под вторую таблицу для обработки ее сохранений TableCardLotPosition
    TextField firstLot_pos = new TextField();
    TextField firsRegNum = new TextField();
    TextField firsTCardPosition_id = new TextField();
    TextField firsTemplate = new TextField();
    TextField firstDescription = new TextField();
    TextField firstDeleteFlag = new TextField();
    TextField firstParentDoc1 = new TextField();
    TextField firstStatus = new TextField();
    TextField firstStatusText = new TextField();
    TextField firstCreatedBy = new TextField();
    TextField firstСreatedDate = new TextField();
    TextField firstСreatedTime = new TextField();
    TextField firstСhangedBy = new TextField();
    TextField firstChangedDate = new TextField();
    TextField firstChangedTime = new TextField();
    TextField firstClosedDate = new TextField();
    TextField firstClosedTime = new TextField();
    TextField firstLot_status = new TextField();
    TextField firstPucknum = new TextField();
    TextField firstPuckpos = new TextField();
    TextField firstReq_price = new TextField();
    TextField firstCommon_price = new TextField();
    TextField firstCommon_price_flag = new TextField();
    TextField firstVat = new TextField();
    TextField firstTech_cr_name = new TextField();
    TextField firstTech_cr_date = new TextField();
    TextField firstTech_cr_time = new TextField();
    TextField firstTech_agree_date = new TextField();
    TextField firstTech_ch_name = new TextField();
    TextField firstTech_ch_date = new TextField();
    TextField firstTech_ch_time = new TextField();
    TextField firstValue_curr = new TextField();
    TextField firstValue_curr_c = new TextField();
    TextField firstPreis = new TextField();
    TextField firstRlwrt = new TextField();
    TextField firstPreis_curr = new TextField();
    TextField firstRlwrt_curr = new TextField();


    CheckboxGroup<String> group = new CheckboxGroup<String>();

    Button save = new Button("Сохранить");
    Button delete = new Button("Удалить");
    Button close = new Button("Отмена");
    Button savePos = new Button("Сохранить позицию");

    Binder<TableCardLotPosition> binder = new BeanValidationBinder<>(TableCardLotPosition.class);
    Binder<TableCardPosition> binder1 = new BeanValidationBinder<>(TableCardPosition.class);


    private TableCardLotPosition tableCardLotPosition;
    private TableCardPosition tableCardPosition;


    public TableCardLotPositionForm(List<TableCardLotPosition> companies) {
        this.tableCardLotPosition = tableCardLotPosition;

        SplitLayout layout = new SplitLayout();
        layout.setOrientation(SplitLayout.Orientation.VERTICAL);
//        setSizeFull();
        addClassName("lot-form");

        binder.bindInstanceFields(this);

        guid.setRequired(true);
        regNum.setRequired(true);
        template.setValueChangeMode(ValueChangeMode.EAGER);
        description.setValueChangeMode(ValueChangeMode.EAGER);
        deleteFlag.setValueChangeMode(ValueChangeMode.EAGER);
        parentDoc1.setValueChangeMode(ValueChangeMode.EAGER);
        statusText.setValueChangeMode(ValueChangeMode.EAGER);
        createdBy.setValueChangeMode(ValueChangeMode.EAGER);
        createdDate.setValueChangeMode(ValueChangeMode.EAGER);
        createdTime.setValueChangeMode(ValueChangeMode.EAGER);
        changedBy.setValueChangeMode(ValueChangeMode.EAGER);
        changedDate.setValueChangeMode(ValueChangeMode.EAGER);
        changedTime.setValueChangeMode(ValueChangeMode.EAGER);
        closedDate.setValueChangeMode(ValueChangeMode.EAGER);
        closedTime.setValueChangeMode(ValueChangeMode.EAGER);
        card_subtype.setValueChangeMode(ValueChangeMode.EAGER);
        card_type.setValueChangeMode(ValueChangeMode.EAGER);
        pred.setValueChangeMode(ValueChangeMode.EAGER);
        kun.setValueChangeMode(ValueChangeMode.EAGER);
        lifnr.setValueChangeMode(ValueChangeMode.EAGER);
        depart.setValueChangeMode(ValueChangeMode.EAGER);
        org_purch.setValueChangeMode(ValueChangeMode.EAGER);
        resp_person.setValueChangeMode(ValueChangeMode.EAGER);
        plan_year.setValueChangeMode(ValueChangeMode.EAGER);
        proc_type.setValueChangeMode(ValueChangeMode.EAGER);
        etp_kind.setValueChangeMode(ValueChangeMode.EAGER);
        rcase_proc.setValueChangeMode(ValueChangeMode.EAGER);
        waers.setValueChangeMode(ValueChangeMode.EAGER);
        vat.setValueChangeMode(ValueChangeMode.EAGER);
        am_with_nds.setValueChangeMode(ValueChangeMode.EAGER);
        amount_nds.setValueChangeMode(ValueChangeMode.EAGER);
        am_not_nds.setValueChangeMode(ValueChangeMode.EAGER);

        regNum.addValueChangeListener(e -> {
            save.setEnabled(!e.getValue().isEmpty());
        });

        configureGridCardPosistion();
// Добавляем первую сущность
        Div div1 = new Div();
        Div div2 = new Div();
        Div div3 = new Div();
        Div div4 = new Div();
        Div div5 = new Div();

        HorizontalLayout horiz1 = new HorizontalLayout();
        HorizontalLayout horiz2 = new HorizontalLayout();
        HorizontalLayout horiz3 = new HorizontalLayout();
        HorizontalLayout horiz4 = new HorizontalLayout();

        div1.add(div2, div3, div4, div5);
        div2.add(horiz1);
        div3.add(horiz2);
        div4.add(horiz3);
        div5.add(horiz4);

        horiz1.add(guid, regNum, template, description, deleteFlag, parentDoc1, statusText, createdBy);
        horiz2.add(createdDate, createdTime, changedBy, changedDate, changedTime, closedDate, closedTime, card_subtype);
        horiz3.add(card_type, pred, kun, lifnr, depart, org_purch, resp_person, plan_year);
        horiz4.add(proc_type, etp_kind, rcase_proc, waers, vat, am_with_nds, amount_nds, am_not_nds);

        //добавляем второую сущность
        HorizontalLayout hor = new HorizontalLayout();
        hor.add(uploadFile());

        group.setLabel("Настройки предприятия");
        group.setItems("Заблокировано");

//        layout.setSizeFull();
        layout.addToPrimary(div1, createButtonsLayout());

        layout.addToSecondary(gridPos);
        setSpacing(true);
        layout.setSplitterPosition(60);
        layout.addThemeVariants(SplitLayoutVariant.LUMO_SMALL);
//        add(layout);

//Добавляем в коллекии переключатели верхних вкладок меню
        Tab tab1 = new Tab("Карточка");
        Div page1 = new Div();
        page1.add(layout);
        page1.setSizeFull();
        layout.setSizeFull();

        Tab tab2 = new Tab("Файлы");
        Div page2 = new Div();
        page2.add(hor);
        page2.setVisible(false);
        page2.setSizeFull();

        Tab tab3 = new Tab("Маршрут согласованияe");
        Div page3 = new Div();
        page3.setText("Page#3");
        page3.setVisible(false);
        page3.setSizeFull();

        Map<Tab, Component> tabsToPages = new HashMap<>();
        tabsToPages.put(tab1, page1);
        tabsToPages.put(tab2, page2);
        tabsToPages.put(tab3, page3);
        Tabs tabs = new Tabs(tab1, tab2, tab3);
        Div pages = new Div(page1, page2, page3);
        pages.setSizeFull();

        tabs.addSelectedChangeListener(event -> {
            tabsToPages.values().forEach(page -> page.setVisible(false));
            Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
            selectedPage.setVisible(true);
        });

        add(tabs, pages);

    }


    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        save.addClickListener(click -> validateAndSave());
        savePos.addClickListener(click -> validateAndSavePos());
        delete.addClickListener(click -> fireEvent(new DeleteEvent(this, tableCardLotPosition)));
        close.addClickListener(click -> fireEvent(new CloseEvent(this)));

        binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));
        binder1.addStatusChangeListener(evt -> savePos.setEnabled(binder1.isValid()));

        return new HorizontalLayout(save, delete, close, savePos);
    }

    private void validateAndSave() {
        try {
            if (tableCardLotPosition != null) {
                if (tableCardLotPosition.getId() == null) {
//                    if (tableCardLotPosition != null)
                    tableCardLotPosition.setId(guid.getValue());
                }
                binder.writeBean(tableCardLotPosition);
                fireEvent(new SaveEvent(this, tableCardLotPosition));
            }
        } catch (ValidationException e) {
        } catch (DataIntegrityViolationException e1) {
            Dialog dialog = new Dialog();
            dialog.add(new Text(
                    "Ошибка! Код позиции лота изменить невозможно. Для создания новой позиции лота используйте кнопку \"Добавить запись\""));
            dialog.open();
            e1.printStackTrace();
        }
    }

    private void validateAndSavePos() {
        try {
            if (tableCardPosition != null) {
                if (tableCardPosition.getId() == null) {
//                    if (tableCardPosition != null)
                    tableCardPosition.setId(firstLot_pos.getValue());
                }
                binder1.writeBean(tableCardPosition);
                fireEvent(new SaveEventPos(this, tableCardPosition));
            }
        } catch (ValidationException e) {
        } catch (DataIntegrityViolationException e1) {
            Dialog dialog = new Dialog();
            dialog.add(new Text(
                    "Ошибка! Код позиции лота изменить невозможно. Для создания новой позиции лота используйте кнопку \"Добавить запись\""));
            dialog.open();
            e1.printStackTrace();
        }
    }

    //    public void setIdPositionLot(TableCardLotPosition tableCardLotPosition) {
//        this.tableCardLotPosition = tableCardLotPosition;
//        binder.readBean(tableCardLotPosition);
//        save.setEnabled(true);
//        try {
//            guid.setEnabled(tableCardLotPosition.getId() == null);
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//            // Company not exist
//        }
//    }
    public void setIdPositionLot(TableCardLotPosition tableCardLotPosition) {
        this.tableCardLotPosition = tableCardLotPosition;
        binder.readBean(tableCardLotPosition);
        save.setEnabled(true);
        try {
            if (tableCardLotPosition.getId() != null) {
                guid.setEnabled(false);
            } else {
                guid.setEnabled(true);
            }
        } catch (NullPointerException e) {
            // Company not exist
        }

    }


    public void editPosition(TableCardPosition tableCardPosition) {

        if (tableCardPosition == null) {
            closeEditor();
        } else {
//            gridBasic.setSizeUndefined();
            setIdPositionPos(tableCardPosition);
//            form.setIdPosition(tableCardPosition);
//            formPos.setVisible(true);
//            form.gridPos.setVisible(true);
            addClassName("editing");
        }
    }

    public void setIdPositionPos(TableCardPosition tableCardPosition) {
        this.tableCardPosition = tableCardPosition;
        binder1.readBean(tableCardPosition);
        savePos.setEnabled(true);
        try {
            if (tableCardPosition.getId() != null) {
//                firstLot_pos.setEnabled(false);
            } else {
                firstLot_pos.setEnabled(true);
            }
        } catch (NullPointerException e) {
            // Company not exist
        }

    }

//    public void setIdPositionPos(TableCardPosition tableCardPosition) {
//        this.tableCardPosition = tableCardPosition;
//        binder1.readBean(tableCardPosition);
//        savePos.setEnabled(true);
//        try {
////            firstLot_pos.setEnabled(tableCardPosition.getId() == null);
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//            // Company not exist
//        }
//
//    }

    //Создаем таблицу для TableCardPosition
    public void configureGridCardPosistion() {

        gridPos.setVerticalScrollingEnabled(true);
        gridPos.addClassName("lot-grid");
        gridPos.removeAllColumns();
        gridPos.setSizeFull();

        binder1.bindInstanceFields(this);

        gridPos.setColumns("id");

        Grid.Column<TableCardPosition> lot_pos = gridPos.addColumn(TableCardPosition::getLot_pos)
                .setHeader("Позиция Детализации лот");
        Grid.Column<TableCardPosition> regNum = gridPos.addColumn(TableCardPosition::getRegNum)
                .setHeader("Регистрационный номер");
//        Grid.Column<TableCardPosition> tCardPosition_id = gridPos.addColumn(TableCardPosition::getTCardPosition_id)
//                .setHeader("Номер вышестоящего документа");

        Grid.Column<TableCardPosition> template = gridPos.addColumn(TableCardPosition::getTemplate)
                .setHeader("Шаблон документа");
        Grid.Column<TableCardPosition> description = gridPos.addColumn(TableCardPosition::getDescription)
                .setHeader("Название документа");
        Grid.Column<TableCardPosition> deleteFlag = gridPos.addColumn(TableCardPosition::getDeleteFlag)
                .setHeader("Индикатор удаления документа");
        Grid.Column<TableCardPosition> parentDoc1 = gridPos.addColumn(TableCardPosition::getParentDoc1)
                .setHeader("Индикатор вышестоящего документа");
        Grid.Column<TableCardPosition> status = gridPos.addColumn(TableCardPosition::getStatus)
                .setHeader("Статус документа");
        Grid.Column<TableCardPosition> statusText = gridPos.addColumn(TableCardPosition::getStatusText)
                .setHeader("Статус");
        Grid.Column<TableCardPosition> createdBy = gridPos.addColumn(TableCardPosition::getCreatedBy)
                .setHeader("Пользователь создавший документ");
        Grid.Column<TableCardPosition> createdDate = gridPos.addColumn(TableCardPosition::getCreatedDate)
                .setHeader("Дата создания документ");
        Grid.Column<TableCardPosition> createdTime = gridPos.addColumn(TableCardPosition::getCreatedTime)
                .setHeader("Время создания документ");
        Grid.Column<TableCardPosition> changedBy = gridPos.addColumn(TableCardPosition::getChangedBy)
                .setHeader("Пользователь изменивший документ");
        Grid.Column<TableCardPosition> changedDate = gridPos.addColumn(TableCardPosition::getChangedDate)
                .setHeader("Дата изменения документ");
        Grid.Column<TableCardPosition> changedTime = gridPos.addColumn(TableCardPosition::getChangedTime)
                .setHeader("Время изменения документ");
        Grid.Column<TableCardPosition> closedDate = gridPos.addColumn(TableCardPosition::getClosedDate)
                .setHeader("Дата закрытия документ");
        Grid.Column<TableCardPosition> closedTime = gridPos.addColumn(TableCardPosition::getClosedTime)
                .setHeader("Время закрытия документ");
        Grid.Column<TableCardPosition> lot_status = gridPos.addColumn(TableCardPosition::getLot_status)
                .setHeader("Дата закрытия документ");
        Grid.Column<TableCardPosition> pucknum = gridPos.addColumn(TableCardPosition::getPucknum)
                .setHeader("Номер пакета");
        Grid.Column<TableCardPosition> puckpos = gridPos.addColumn(TableCardPosition::getPuckpos)
                .setHeader("Номер позиции пакета");
        Grid.Column<TableCardPosition> req_price = gridPos.addColumn(TableCardPosition::getReq_price)
                .setHeader("Цена за Ед.сНДСвРуб.");
        Grid.Column<TableCardPosition> common_price = gridPos.addColumn(TableCardPosition::getCommon_price)
                .setHeader("Цена за Ед.сНДСвРуб.");
        Grid.Column<TableCardPosition> common_price_flag = gridPos.addColumn(TableCardPosition::getCommon_price_flag)
                .setHeader("Индикатор общая цена");
        Grid.Column<TableCardPosition> vat = gridPos.addColumn(TableCardPosition::getVat)
                .setHeader("Валюта");
        Grid.Column<TableCardPosition> tech_cr_name = gridPos.addColumn(TableCardPosition::getTech_cr_name)
                .setHeader("Создал");
        Grid.Column<TableCardPosition> tech_cr_date = gridPos.addColumn(TableCardPosition::getTech_cr_date)
                .setHeader("Дата создания");
        Grid.Column<TableCardPosition> tech_cr_time = gridPos.addColumn(TableCardPosition::getTech_cr_time)
                .setHeader("Время создания");
        Grid.Column<TableCardPosition> tech_agree_date = gridPos.addColumn(TableCardPosition::getTech_agree_date)
                .setHeader("Дата согласования");
        Grid.Column<TableCardPosition> tech_ch_name = gridPos.addColumn(TableCardPosition::getTech_ch_name)
                .setHeader("Изменил");
        Grid.Column<TableCardPosition> tech_ch_date = gridPos.addColumn(TableCardPosition::getTech_ch_date)
                .setHeader("Дата изменения");
        Grid.Column<TableCardPosition> tech_ch_time = gridPos.addColumn(TableCardPosition::getTech_ch_time)
                .setHeader("Время изменения");
        Grid.Column<TableCardPosition> value_curr = gridPos.addColumn(TableCardPosition::getValue_curr)
                .setHeader("Стоимость с НДС в вал");
        Grid.Column<TableCardPosition> value_curr_c = gridPos.addColumn(TableCardPosition::getValue_curr_c)
                .setHeader("Цена за ед. с НДС в вал.");
        Grid.Column<TableCardPosition> preis = gridPos.addColumn(TableCardPosition::getPreis)
                .setHeader("Цена за ед. без НДС в Руб.");
        Grid.Column<TableCardPosition> rlwrt = gridPos.addColumn(TableCardPosition::getRlwrt)
                .setHeader("Стоимость без НДС в Руб.");
        Grid.Column<TableCardPosition> preis_curr = gridPos.addColumn(TableCardPosition::getPreis_curr)
                .setHeader("Цена за ед. без НДС в вал.");
        Grid.Column<TableCardPosition> rlwrt_curr = gridPos.addColumn(TableCardPosition::getRlwrt_curr)
                .setHeader("Стоимость без НДС в вал.");

        gridPos.getEditor().setBinder(binder1);

        firstLot_pos.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstLot_pos)
                .bind("lot_pos");
        lot_pos.setEditorComponent(firstLot_pos);
        firsRegNum.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firsRegNum)
                .bind("regNum");
        regNum.setEditorComponent(firsRegNum);

//        firsTCardPosition_id.getElement()
//                .addEventListener("keydown",
//                        event -> gridPos.getEditor().cancel())
//                .setFilter("event.key === 'Tab' && event.shiftKey");
//        binder1.forField(firsTCardPosition_id)
//                .bind("tCardPosition_id");
//        tCardPosition_id.setEditorComponent(firsTCardPosition_id);

        firsTemplate.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firsTemplate)
                .bind("template");
        template.setEditorComponent(firsTemplate);
        firstDescription.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstDescription)
                .bind("description");
        description.setEditorComponent(firstDescription);
        firstDescription.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstDescription)
                .bind("description");
        description.setEditorComponent(firstDescription);
        firstDeleteFlag.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstDeleteFlag)
                .bind("deleteFlag");
        deleteFlag.setEditorComponent(firstDeleteFlag);
        firstParentDoc1.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstParentDoc1)
                .bind("parentDoc1");
        parentDoc1.setEditorComponent(firstParentDoc1);
        firstStatus.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstStatus)
                .bind("status");
        status.setEditorComponent(firstStatus);
        firstStatusText.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstStatusText)
                .bind("statusText");
        statusText.setEditorComponent(firstStatusText);
        firstCreatedBy.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstCreatedBy)
                .bind("createdBy");
        createdBy.setEditorComponent(firstCreatedBy);
        firstСreatedDate.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstСreatedDate)
                .bind("createdDate");
        createdDate.setEditorComponent(firstСreatedDate);
        firstСreatedTime.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstСreatedTime)
                .bind("createdTime");
        createdTime.setEditorComponent(firstСreatedTime);
        firstСhangedBy.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstСhangedBy)
                .bind("changedBy");
        changedBy.setEditorComponent(firstСhangedBy);
        firstChangedDate.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstChangedDate)
                .bind("changedDate");
        changedDate.setEditorComponent(firstChangedDate);
        firstChangedTime.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstChangedTime)
                .bind("changedTime");
        changedTime.setEditorComponent(firstChangedTime);
        firstClosedDate.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstClosedDate)
                .bind("closedDate");
        closedDate.setEditorComponent(firstClosedDate);
        firstClosedTime.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstClosedTime)
                .bind("closedTime");
        closedTime.setEditorComponent(firstClosedTime);
        firstLot_status.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstLot_status)
                .bind("lot_status");
        lot_status.setEditorComponent(firstLot_status);
        firstPucknum.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstPucknum)
                .bind("pucknum");
        pucknum.setEditorComponent(firstPucknum);
        firstPuckpos.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstPuckpos)
                .bind("puckpos");
        puckpos.setEditorComponent(firstPuckpos);
        firstReq_price.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstReq_price)
                .bind("req_price");
        req_price.setEditorComponent(firstReq_price);
        firstCommon_price.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstCommon_price)
                .bind("common_price");
        common_price.setEditorComponent(firstCommon_price);
        firstCommon_price_flag.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstCommon_price_flag)
                .bind("common_price_flag");
        common_price_flag.setEditorComponent(firstCommon_price_flag);
        firstCommon_price_flag.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstCommon_price_flag)
                .bind("common_price_flag");
        common_price_flag.setEditorComponent(firstCommon_price_flag);
        firstVat.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstVat)
                .bind("vat");
        vat.setEditorComponent(firstVat);
        firstTech_cr_name.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstTech_cr_name)
                .bind("tech_cr_name");
        tech_cr_name.setEditorComponent(firstTech_cr_name);
        firstTech_cr_date.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstTech_cr_date)
                .bind("tech_cr_date");
        tech_cr_date.setEditorComponent(firstTech_cr_date);
        firstTech_cr_time.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstTech_cr_time)
                .bind("tech_cr_time");
        tech_cr_time.setEditorComponent(firstTech_cr_time);
        firstTech_agree_date.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstTech_agree_date)
                .bind("tech_agree_date");
        tech_agree_date.setEditorComponent(firstTech_agree_date);
        firstTech_ch_name.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstTech_ch_name)
                .bind("tech_ch_name");
        tech_ch_name.setEditorComponent(firstTech_ch_name);
        firstTech_ch_date.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstTech_ch_date)
                .bind("tech_ch_date");
        tech_ch_date.setEditorComponent(firstTech_ch_date);
        firstTech_ch_time.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstTech_ch_time)
                .bind("tech_ch_time");
        tech_ch_time.setEditorComponent(firstTech_ch_time);
        firstValue_curr.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstValue_curr)
                .bind("value_curr");
        value_curr.setEditorComponent(firstValue_curr);
        firstValue_curr_c.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstValue_curr_c)
                .bind("value_curr_c");
        value_curr_c.setEditorComponent(firstValue_curr_c);
        firstPreis.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstPreis)
                .bind("preis");
        preis.setEditorComponent(firstPreis);
        firstRlwrt.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstRlwrt)
                .bind("rlwrt");
        rlwrt.setEditorComponent(firstRlwrt);
        firstPreis_curr.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstPreis_curr)
                .bind("preis_curr");
        preis_curr.setEditorComponent(firstPreis_curr);
        firstRlwrt_curr.getElement()
                .addEventListener("keydown",
                        event -> gridPos.getEditor().cancel())
                .setFilter("event.key === 'Tab' && event.shiftKey");
        binder1.forField(firstRlwrt_curr)
                .bind("rlwrt_curr");
        rlwrt_curr.setEditorComponent(firstRlwrt_curr);
//        gridPos.asSingleSelect().addValueChangeListener(evt -> editPosition(evt.getValue()));
        gridPos.addItemDoubleClickListener(event -> {
            gridPos.getEditor().editItem(event.getItem());
            firstLot_pos.focus();
            editPosition(event.getItem());
        });
//        savePos.addClickListener(event -> {
//            if (binder1.getBean() != null) {
//                try {
//                    if (tableCardPosition != null) {
//                        if (tableCardPosition.getId() == null)
//                            tableCardPosition.setId(firstLot_pos.getValue());
//                    }
//                    binder1.writeBean(tableCardPosition);
//                    fireEvent(new SaveEventPos(this, tableCardPosition));
//
//                } catch (ValidationException e) {
//                    e.printStackTrace();
//                }
//            }

//        });
        add(gridPos);

        changeColumnName("id", "ID лота позиции");
        gridPos.getColumns().forEach(col -> col.setAutoWidth(true));
        // Ее инициализируем через поиск значения по клику
//        gridPos.asSingleSelect().addValueChangeListener(evt -> editPosition(evt.getValue()));
    }


    private void closeEditor() {
//		form.setIdPositionLot(null);
//		setVisible(false);
//        gridBasic.setSizeFull();
//		grid.setSizeFull();
        removeClassName("editing");
    }

    //Загрузка и обработка файла
    private Component uploadFile() {
        MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
        Upload upload = new Upload(buffer);

        Button uploadButton = new Button("Upload");
        upload.setUploadButton(uploadButton);


        Span dropLabel = new Span("Drop files here!");
        upload.setDropLabel(dropLabel);

        Span dropIcon = new Span("");
        upload.setDropLabelIcon(dropIcon);
        Div output = new Div();


//        upload.addSucceededListener(event -> {
//            Component component = createComponent(event.getMIMEType(),
//                    event.getFileName(),
//                    buffer.getInputStream(event.getFileName()));
//            showOutput(event.getFileName(), component, output);
//        });

        HorizontalLayout toolbar = new HorizontalLayout(upload, output);
//
        return toolbar;
    }





    public void changeColumnName(String propertyString, String nameString) {
        Grid.Column<TableCardPosition> changeNameColumn = gridPos.getColumnByKey(propertyString);
        if (changeNameColumn != null)
            changeNameColumn.setHeader(nameString);
    }

    public static abstract class PositionLotFormEvent extends ComponentEvent<TableCardLotPositionForm> {
        private final TableCardLotPosition tableCardLotPosition;

        protected PositionLotFormEvent(TableCardLotPositionForm source, TableCardLotPosition tableCardLotPosition) {
            super(source, false);
            this.tableCardLotPosition = tableCardLotPosition;
        }

        public TableCardLotPosition getTableCardBasic() {
            return tableCardLotPosition;
        }
    }

    public static class SaveEvent extends PositionLotFormEvent {
        SaveEvent(TableCardLotPositionForm source, TableCardLotPosition tableCardLotPosition) {
            super(source, tableCardLotPosition);
        }
    }

    public static class DeleteEvent extends PositionLotFormEvent {
        DeleteEvent(TableCardLotPositionForm source, TableCardLotPosition tableCardLotPosition) {
            super(source, tableCardLotPosition);
        }
    }

    public static class CloseEvent extends PositionLotFormEvent {
        CloseEvent(TableCardLotPositionForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }


    public static abstract class PositionFormEvent extends ComponentEvent<TableCardLotPositionForm> {
        private final TableCardPosition tableCardPosition;

        protected PositionFormEvent(TableCardLotPositionForm source, TableCardPosition tableCardPosition) {
            super(source, false);
            this.tableCardPosition = tableCardPosition;
        }

        public TableCardPosition getTableCardBasicPos() {
            return tableCardPosition;
        }
    }

    public static class SaveEventPos extends PositionFormEvent {
        SaveEventPos(TableCardLotPositionForm source, TableCardPosition tableCardPosition) {
            super(source, tableCardPosition);
        }
    }

    public static class CloseEventPos extends PositionFormEvent {
        CloseEventPos(TableCardLotPositionForm source) {
            super(source, null);
        }
    }

    protected <N extends ComponentEvent<?>> Registration addListenerPos(Class<N> eventType,
                                                                        ComponentEventListener<N> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}