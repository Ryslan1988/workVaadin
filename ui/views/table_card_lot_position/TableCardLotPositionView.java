package ru.prominn.atombot.ui.views.table_card_lot_position;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Arrays;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridSortOrder;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.SortDirection;
import com.vaadin.flow.data.value.ValueChangeMode;

import com.vaadin.flow.shared.Registration;
import ru.prominn.atombot.backend.document_form.entity.TableCardLotPosition;
import ru.prominn.atombot.backend.document_form.entity.TableCardPosition;
import ru.prominn.atombot.backend.document_form.service.TableCardLotPositionService;
import ru.prominn.atombot.backend.document_form.service.TableCardPositionService;
import ru.prominn.atombot.ui.views.component.MainLayout;

@SuppressWarnings("serial")
@Route(value = "tableCardLotPositionView", layout = MainLayout.class)
@PageTitle("Список: Позиции лота")
public class TableCardLotPositionView extends VerticalLayout {

    private final TableCardLotPositionForm form;
    private final TableCardLotPositionAddNew dial;
    Accordion accordion = new Accordion();
    Button addPositionButton = new Button(new Icon(VaadinIcon.PLUS_CIRCLE), click -> addPositionLotPos());
    Button sortList = new Button(new Icon(VaadinIcon.ROTATE_RIGHT), click -> updateList());
    Button addContactButton = new Button("Добавить запись", click -> addPositionLot());


    Grid<TableCardLotPosition> gridLotPos = new Grid<>(TableCardLotPosition.class);
    TextField filterText = new TextField();
    Dialog dialog = new Dialog();

    private TableCardLotPositionService tableCardLotPositionService;
    public TableCardPositionService tableCardPositionService;

    public TableCardLotPositionView(TableCardLotPositionService tableCardLotPositionService, TableCardPositionService tableCardPositionService) {
        this.tableCardLotPositionService = tableCardLotPositionService;
        this.tableCardPositionService = tableCardPositionService;

        addClassName("list-view");
        setSizeFull();
        configureGridCardBasic();

        // Добавление слушателей к редакции второй таблицы TableCardPos для добавления новой позиции
        dial = new TableCardLotPositionAddNew(tableCardPositionService.findAll());
        dial.addListenerPos(TableCardLotPositionAddNew.SaveEvent.class, this::savePositionAddNew);
//        dial.addListener(TableCardLotPositionAddNew.CloseEvent.class, e -> closeEditor())

        // Добавление слушателей к редакции первой таблицы TableCardLotPos
        form = new TableCardLotPositionForm(tableCardLotPositionService.findAll());
        form.addListener(TableCardLotPositionForm.SaveEvent.class, this::savePositionLot);
        // Добавление слушателей к редакции второй таблицы TableCardPos
        form.addListenerPos(TableCardLotPositionForm.SaveEventPos.class, this::savePosition);

        form.addListener(TableCardLotPositionForm.DeleteEvent.class, this::deleteLot);
        form.addListener(TableCardLotPositionForm.CloseEvent.class, e -> closeEditor());


        Div content = new Div(gridLotPos, form);
        content.addClassName("content");
        content.setSizeFull();
        dialog.setHeight("650px");
        dialog.setWidth("650px");
        dialog.add(new Text("Добавление новой позиции"),dial);

        add(getToolBar(), content);
        updateList();
        closeEditor();
    }

    public void configureGridCardBasic() {
        gridLotPos.setVerticalScrollingEnabled(true);
        gridLotPos.addClassName("lot-grid");
        gridLotPos.removeAllColumns();
        gridLotPos.setSizeFull();

        gridLotPos.setColumns("id");
        gridLotPos.addColumn(regNum -> {
            String regNum1 = regNum.getRegNum();
            return regNum1 == null ? "-" : regNum1;
        }).setHeader("Код документа").setSortable(true);
        gridLotPos.addColumn(template -> {
            String template1 = template.getTemplate();
            return template1 == null ? "-" : template1;
        }).setHeader("Шаблон документа").setSortable(true);
        gridLotPos.addColumn(description -> {
            String description1 = description.getDescription();
            return description1 == null ? "-" : description1;
        }).setHeader("Название документа").setSortable(true);
        gridLotPos.addColumn(deleteFlag -> {
            String deleteFlag1 = deleteFlag.getDeleteFlag();
            return deleteFlag1 == null ? "-" : deleteFlag1;
        }).setHeader("Индикатор удаления документа").setSortable(true);
        gridLotPos.addColumn(parentDoc1 -> {
            String parentDoc11 = parentDoc1.getParentDoc1();
            return parentDoc11 == null ? "-" : parentDoc11;
        }).setHeader("ID вышестоящего документа 1").setSortable(true);
        gridLotPos.addColumn(statusText -> {
            String statusText1 = statusText.getStatusText();
            return statusText1 == null ? "-" : statusText1;
        }).setHeader("Статус").setSortable(true);
        gridLotPos.addColumn(createdBy -> {
            String createdBy1 = createdBy.getCreatedBy();
            return createdBy1 == null ? "-" : createdBy1;
        }).setHeader("Пользователь, создавший документ").setSortable(true);
        gridLotPos.addColumn(createdDate -> {
            String createdDate1 = createdDate.getCreatedDate();
            return createdDate1 == null ? "-" : createdDate1;
        }).setHeader("Дата создания документа").setSortable(true);
        gridLotPos.addColumn(createdTime -> {
            String createdTime1 = createdTime.getCreatedTime();
            return createdTime1 == null ? "-" : createdTime1;
        }).setHeader("Время создания документа").setSortable(true);
        gridLotPos.addColumn(changedBy -> {
            String changedBy1 = changedBy.getChangedBy();
            return changedBy1 == null ? "-" : changedBy1;
        }).setHeader("Пользователь, изменивший документ").setSortable(true);
        gridLotPos.addColumn(changedDate -> {
            String changedDate1 = changedDate.getChangedDate();
            return changedDate1 == null ? "-" : changedDate1;
        }).setHeader("Дата изменения документ").setSortable(true);
        gridLotPos.addColumn(changedTime -> {
            String changedTime1 = changedTime.getChangedTime();
            return changedTime1 == null ? "-" : changedTime1;
        }).setHeader("Время изменения документ").setSortable(true);
        gridLotPos.addColumn(closedDate -> {
            String closedDate1 = closedDate.getClosedDate();
            return closedDate1 == null ? "-" : closedDate1;
        }).setHeader("Дата закрытия документа").setSortable(true);
        gridLotPos.addColumn(closedTime -> {
            String closedTime1 = closedTime.getClosedTime();
            return closedTime1 == null ? "-" : closedTime1;
        }).setHeader("Время закрытия документа").setSortable(true);
        gridLotPos.addColumn(card_subtype -> {
            String card_subtype1 = card_subtype.getCard_subtype();
            return card_subtype1 == null ? "-" : card_subtype1;
        }).setHeader("Подтип карточки").setSortable(true);
        gridLotPos.addColumn(card_type -> {
            String card_type1 = card_type.getCard_type();
            return card_type1 == null ? "-" : card_type1;
        }).setHeader("Тип карточки").setSortable(true);
        gridLotPos.addColumn(pred -> {
            String pred1 = pred.getPred();
            return pred1 == null ? "-" : pred1;
        }).setHeader("Владелец").setSortable(true);
        gridLotPos.addColumn(kun -> {
            String kun1 = kun.getKun();
            return kun1 == null ? "-" : kun1;
        }).setHeader("Заказчик").setSortable(true);
        gridLotPos.addColumn(lifnr -> {
            String lifnr1 = lifnr.getLifnr();
            return lifnr1 == null ? "-" : lifnr1;
        }).setHeader("Поставщик").setSortable(true);
        gridLotPos.addColumn(depart -> {
            String depart1 = depart.getDepart();
            return depart1 == null ? "-" : depart1;
        }).setHeader("Подразделение").setSortable(true);
        gridLotPos.addColumn(org_purch -> {
            String org_purch1 = org_purch.getOrg_purch();
            return org_purch1 == null ? "-" : org_purch1;
        }).setHeader("Организатор закупки").setSortable(true);
        gridLotPos.addColumn(resp_person -> {
            String resp_person1 = resp_person.getResp_person();
            return resp_person1 == null ? "-" : resp_person1;
        }).setHeader("Испольнитель").setSortable(true);
        gridLotPos.addColumn(plan_year -> {
            String plan_year1 = plan_year.getPlan_year();
            return plan_year1 == null ? "-" : plan_year1;
        }).setHeader("Год планирования").setSortable(true);
        gridLotPos.addColumn(proc_type -> {
            String proc_type1 = proc_type.getProc_type();
            return proc_type1 == null ? "-" : proc_type1;
        }).setHeader("Тип процедуры").setSortable(true);
        gridLotPos.addColumn(etp_kind -> {
            String etp_kind1 = etp_kind.getEtp_kind();
            return etp_kind1 == null ? "-" : etp_kind1;
        }).setHeader("Код ЭТП владельца").setSortable(true);
        gridLotPos.addColumn(rcase_proc -> {
            String rcase_proc1 = rcase_proc.getRcase_proc();
            return rcase_proc1 == null ? "-" : rcase_proc1;
        }).setHeader("ЕОСЗ").setSortable(true);
        gridLotPos.addColumn(waers -> {
            String waers1 = waers.getWaers();
            return waers1 == null ? "-" : waers1;
        }).setHeader("Валюта").setSortable(true);
        gridLotPos.addColumn(vat -> {
            String vat1 = vat.getVat();
            return vat1 == null ? "-" : vat1;
        }).setHeader("Код НДС").setSortable(true);
        gridLotPos.addColumn(am_with_nds -> {
            String am_with_nds1 = am_with_nds.getAm_with_nds();
            return am_with_nds1 == null ? "-" : am_with_nds1;
        }).setHeader("Сумма с НДС").setSortable(true);
        gridLotPos.addColumn(amount_nds -> {
            String amount_nds1 = amount_nds.getAmount_nds();
            return amount_nds1 == null ? "-" : amount_nds1;
        }).setHeader("Сумма НДС").setSortable(true);
        gridLotPos.addColumn(am_not_nds -> {
            String am_not_nds1 = am_not_nds.getAm_not_nds();
            return am_not_nds1 == null ? "-" : am_not_nds1;
        }).setHeader("Сумма без НДС").setSortable(true);

        changeColumnName("guid", "ID документа");
        gridLotPos.getColumns().forEach(col -> col.setAutoWidth(true));
        gridLotPos.asSingleSelect().addValueChangeListener(evt -> editPositionLot(evt.getValue()));

    }

    public void selectId(String name) {

        form.gridPos.setItems(tableCardPositionService.findAllP(name));
        Grid.Column<TableCardPosition> name1 = form.gridPos.getColumnByKey("id");
        GridSortOrder<TableCardPosition> order1 = new GridSortOrder<>(name1, SortDirection.ASCENDING);
        form.gridPos.sort(Arrays.asList(order1));

    }

    private void deleteLot(TableCardLotPositionForm.DeleteEvent evt) {
        Dialog dialog = new Dialog();
        dialog.add(new Text("Лот успешно удален!"));
        dialog.open();
        updateList();
        closeEditor();
    }

    private void savePositionLot(TableCardLotPositionForm.SaveEvent evt) {
        try {
            evt.getTableCardBasic().setId(evt.getTableCardBasic().getId());
            tableCardLotPositionService.save(evt.getTableCardBasic());

            updateList();
            accordion.setVisible(true);
            addPositionButton.setVisible(false);
            closeEditor();

            Dialog dialog = new Dialog();
            dialog.add(new Text("Данные успешно обновлены!"));
            dialog.open();
        } catch (Exception e) {
            Dialog dialog = new Dialog();
            dialog.add(new Text(
                    "Ошибка! Лот изменить невозможно. Для создания нового лота используйте кнопку \"Добавить запись\""));
            dialog.open();
            e.printStackTrace();
        }
    }

    //Имеет отношение к создании новой позиции пустой
    private void savePositionAddNew(TableCardLotPositionAddNew.SaveEvent event) {
        try {
            event.getTableCardBasicAddNew().setId(event.getTableCardBasicAddNew().getId());
            tableCardPositionService.save(event.getTableCardBasicAddNew());

//            updateList();
//            closeEditor();

            Dialog dialog = new Dialog();
            dialog.add(new Text("Данные успешно обновлены!"));
            dialog.open();
        } catch (Exception e) {
            Dialog dialog = new Dialog();
            dialog.add(new Text(
                    "Ошибка! Лот изменить невозможно. Для создания нового лота используйте кнопку \"Добавить запись\""));
            dialog.open();
            e.printStackTrace();
        }
    }

    private void savePosition(TableCardLotPositionForm.SaveEventPos event) {
        try {
            event.getTableCardBasicPos().setId(event.getTableCardBasicPos().getId());
            tableCardPositionService.save(event.getTableCardBasicPos());

//            updateList();
//            closeEditor();

            Dialog dialog = new Dialog();
            dialog.add(new Text("Данные успешно обновлены!"));
            dialog.open();
        } catch (Exception e) {
            Dialog dialog = new Dialog();
            dialog.add(new Text(
                    "Ошибка! Лот изменить невозможно. Для создания нового лота используйте кнопку \"Добавить запись\""));
            dialog.open();
            e.printStackTrace();
        }
    }


    private HorizontalLayout getToolBar() {
        getMassFilter();
        accordion.close();
        filterText.setPlaceholder("Введите название...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());


        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton, sortList, accordion, addPositionButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    public void getMassFilter() {

        Div div1 = new Div();
        Div div2 = new Div();
        Div div3 = new Div();
        Div div4 = new Div();
        Div div5 = new Div();
        Div div6 = new Div();
        Div div7 = new Div();
        Div div8 = new Div();

        TextField text1 = new TextField();
        text1.setValueChangeMode(ValueChangeMode.LAZY);
        text1.setPlaceholder("ID документа..");
        text1.setClearButtonVisible(true);
        text1.addValueChangeListener(e -> updateListFilter("search1", text1));

        TextField text2 = new TextField();
        text2.setValueChangeMode(ValueChangeMode.LAZY);
        text2.setClearButtonVisible(true);
        text2.setPlaceholder("Код документа..");
        text2.addValueChangeListener(e -> updateListFilter("search2", text2));

        TextField text3 = new TextField();
        text3.setValueChangeMode(ValueChangeMode.LAZY);
        text3.setClearButtonVisible(true);
        text3.addValueChangeListener(e -> updateListFilter("search3", text3));
        text3.setPlaceholder("Шаблон документа..");

        TextField text4 = new TextField();
        text4.setValueChangeMode(ValueChangeMode.LAZY);
        text4.setClearButtonVisible(true);
        text4.addValueChangeListener(e -> updateListFilter("search4", text4));
        text4.setPlaceholder("Название документа..");

        TextField text5 = new TextField();
        text5.setValueChangeMode(ValueChangeMode.LAZY);
        text5.setClearButtonVisible(true);
        text5.addValueChangeListener(e -> updateListFilter("search5", text5));
        text5.setPlaceholder("Индикатор удаления документа..");

        TextField text6 = new TextField();
        text6.setValueChangeMode(ValueChangeMode.LAZY);
        text6.setClearButtonVisible(true);
        text6.addValueChangeListener(e -> updateListFilter("search6", text6));
        text6.setPlaceholder("ID вышестоящего документа 1..");

        TextField text7 = new TextField();
        text7.setValueChangeMode(ValueChangeMode.LAZY);
        text7.setClearButtonVisible(true);
        text7.addValueChangeListener(e -> updateListFilter("search7", text7));
        text7.setPlaceholder("Статус..");

        TextField text8 = new TextField();
        text8.setValueChangeMode(ValueChangeMode.LAZY);
        text8.setClearButtonVisible(true);
        text8.addValueChangeListener(e -> updateListFilter("search8", text8));
        text8.setPlaceholder("Пользователь, создавший документ..");

        TextField text9 = new TextField();
        text9.setValueChangeMode(ValueChangeMode.LAZY);
        text9.setClearButtonVisible(true);
        text9.addValueChangeListener(e -> updateListFilter("search9", text9));
        text9.setPlaceholder("Дата создания документа..");

        TextField text10 = new TextField();
        text10.setValueChangeMode(ValueChangeMode.LAZY);
        text10.setClearButtonVisible(true);
        text10.addValueChangeListener(e -> updateListFilter("search10", text10));
        text10.setPlaceholder("Время создания документа..");

        TextField text11 = new TextField();
        text11.setValueChangeMode(ValueChangeMode.LAZY);
        text11.setClearButtonVisible(true);
        text11.addValueChangeListener(e -> updateListFilter("search11", text11));
        text11.setPlaceholder("Пользователь, изменивший документ..");

        TextField text12 = new TextField();
        text12.setValueChangeMode(ValueChangeMode.LAZY);
        text12.setClearButtonVisible(true);
        text12.addValueChangeListener(e -> updateListFilter("search12", text12));
        text12.setPlaceholder("Дата изменения документ..");

        TextField text13 = new TextField();
        text13.setValueChangeMode(ValueChangeMode.LAZY);
        text13.setClearButtonVisible(true);
        text13.addValueChangeListener(e -> updateListFilter("search13", text13));
        text13.setPlaceholder("Время изменения документ..");

        TextField text14 = new TextField();
        text14.setValueChangeMode(ValueChangeMode.LAZY);
        text14.setClearButtonVisible(true);
        text14.addValueChangeListener(e -> updateListFilter("search14", text14));
        text14.setPlaceholder("Дата закрытия документа..");

        TextField text15 = new TextField();
        text15.setValueChangeMode(ValueChangeMode.LAZY);
        text15.setClearButtonVisible(true);
        text15.addValueChangeListener(e -> updateListFilter("search15", text15));
        text15.setPlaceholder("Время закрытия документа..");

        TextField text16 = new TextField();
        text16.setValueChangeMode(ValueChangeMode.LAZY);
        text16.setClearButtonVisible(true);
        text16.addValueChangeListener(e -> updateListFilter("search16", text16));
        text16.setPlaceholder("Подтип карточки..");

        TextField text17 = new TextField();
        text17.setValueChangeMode(ValueChangeMode.LAZY);
        text17.setClearButtonVisible(true);
        text17.addValueChangeListener(e -> updateListFilter("search17", text17));
        text17.setPlaceholder("Тип карточки..");

        TextField text18 = new TextField();
        text18.setValueChangeMode(ValueChangeMode.LAZY);
        text18.setClearButtonVisible(true);
        text18.addValueChangeListener(e -> updateListFilter("search18", text18));
        text18.setPlaceholder("Владелец..");

        TextField text19 = new TextField();
        text19.setValueChangeMode(ValueChangeMode.LAZY);
        text19.setClearButtonVisible(true);
        text19.addValueChangeListener(e -> updateListFilter("search19", text19));
        text19.setPlaceholder("Заказчик..");

        TextField text20 = new TextField();
        text20.setValueChangeMode(ValueChangeMode.LAZY);
        text20.setClearButtonVisible(true);
        text20.addValueChangeListener(e -> updateListFilter("search20", text20));
        text20.setPlaceholder("Поставщик..");

        TextField text21 = new TextField();
        text21.setValueChangeMode(ValueChangeMode.LAZY);
        text21.setClearButtonVisible(true);
        text21.addValueChangeListener(e -> updateListFilter("search21", text21));
        text21.setPlaceholder("Подразделение..");

        TextField text22 = new TextField();
        text22.setValueChangeMode(ValueChangeMode.LAZY);
        text22.setClearButtonVisible(true);
        text22.addValueChangeListener(e -> updateListFilter("search22", text22));
        text22.setPlaceholder("Организатор закупки..");

        TextField text23 = new TextField();
        text23.setValueChangeMode(ValueChangeMode.LAZY);
        text23.setClearButtonVisible(true);
        text23.addValueChangeListener(e -> updateListFilter("search23", text23));
        text23.setPlaceholder("Испольнитель..");

        TextField text24 = new TextField();
        text24.setValueChangeMode(ValueChangeMode.LAZY);
        text24.setClearButtonVisible(true);
        text24.addValueChangeListener(e -> updateListFilter("search24", text24));
        text24.setPlaceholder("Год планирования..");

        TextField text25 = new TextField();
        text25.setValueChangeMode(ValueChangeMode.LAZY);
        text25.setClearButtonVisible(true);
        text25.addValueChangeListener(e -> updateListFilter("search25", text25));
        text25.setPlaceholder("Тип процедуры..");

        TextField text26 = new TextField();
        text26.setValueChangeMode(ValueChangeMode.LAZY);
        text26.setClearButtonVisible(true);
        text26.addValueChangeListener(e -> updateListFilter("search26", text26));
        text26.setPlaceholder("Код ЭТП владельца..");

        TextField text27 = new TextField();
        text27.setValueChangeMode(ValueChangeMode.LAZY);
        text27.setClearButtonVisible(true);
        text27.addValueChangeListener(e -> updateListFilter("search27", text27));
        text27.setPlaceholder("ЕОСЗ..");

        TextField text28 = new TextField();
        text28.setValueChangeMode(ValueChangeMode.LAZY);
        text28.setClearButtonVisible(true);
        text28.addValueChangeListener(e -> updateListFilter("search28", text28));
        text28.setPlaceholder("Валюта..");

        TextField text29 = new TextField();
        text29.setValueChangeMode(ValueChangeMode.LAZY);
        text29.setClearButtonVisible(true);
        text29.addValueChangeListener(e -> updateListFilter("search29", text29));
        text29.setPlaceholder("Код НДС..");

        TextField text30 = new TextField();
        text30.setValueChangeMode(ValueChangeMode.LAZY);
        text30.setClearButtonVisible(true);
        text30.addValueChangeListener(e -> updateListFilter("search30", text30));
        text30.setPlaceholder("Сумма с НДС..");

        TextField text31 = new TextField();
        text31.setValueChangeMode(ValueChangeMode.LAZY);
        text31.setClearButtonVisible(true);
        text31.addValueChangeListener(e -> updateListFilter("search31", text31));
        text31.setPlaceholder("Сумма НДС..");

        TextField text32 = new TextField();
        text32.setValueChangeMode(ValueChangeMode.LAZY);
        text32.setClearButtonVisible(true);
        text32.addValueChangeListener(e -> updateListFilter("search32", text32));
        text32.setPlaceholder("Сумма без НДС..");

        HorizontalLayout personalInformationLayout = new HorizontalLayout();
        personalInformationLayout.add(
                text1, text2, text3, text4, text5
        );
        HorizontalLayout personalInformationLayout1 = new HorizontalLayout();
        personalInformationLayout1.add(
                text6, text7, text8, text9, text10
        );
        HorizontalLayout personalInformationLayout2 = new HorizontalLayout();
        personalInformationLayout2.add(
                text11, text12, text13, text14, text15
        );
        HorizontalLayout personalInformationLayout3 = new HorizontalLayout();
        personalInformationLayout3.add(
                text16, text17, text18, text19, text20
        );
        HorizontalLayout personalInformationLayout4 = new HorizontalLayout();
        personalInformationLayout4.add(
                text21, text22, text23, text24, text25
        );
        HorizontalLayout personalInformationLayout5 = new HorizontalLayout();
        personalInformationLayout5.add(
                text26, text27, text28, text29, text30
        );
        HorizontalLayout personalInformationLayout6 = new HorizontalLayout();
        personalInformationLayout6.add(
                text31, text32
        );

        div1.add(div2, div3, div4, div5, div6, div7, div8);
        div2.add(personalInformationLayout);
        div3.add(personalInformationLayout1);
        div4.add(personalInformationLayout2);
        div5.add(personalInformationLayout3);
        div6.add(personalInformationLayout4);
        div7.add(personalInformationLayout5);
        div8.add(personalInformationLayout6);

        accordion.add("Фильтр", div1);
    }

    private void addPositionLot() {
        updateList();
        accordion.setVisible(false);
        addPositionButton.setVisible(true);
        filterText.setVisible(false);
        sortList.setVisible(false);
        addContactButton.setVisible(false);
        form.setSizeFull();

//		grid.asMultiSelect().clear();

//		grid.asSingleSelect().clear();
        TableCardLotPosition tableCardLotPosition = new TableCardLotPosition();


//	        Authentication au = SecurityContextHolder.getContext().getAuthentication();
//			String auName = au.getName();
//	        LocalDate date = LocalDate.now();
//	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//	        LocalTime time = LocalTime.now();
//	        DateTimeFormatter formatterlc = DateTimeFormatter.ofPattern("HH:mm:ss");
//	        positionLot.setCrdate(date.format(formatter));
        // company.setAuthor(auName);
        editPositionLot(tableCardLotPosition);

    }

//Пока он выполняет совсем не то., необходимо разбираться и его редактировать. так же сохранение происходит всег одной позиции, необходимо этот момент тоже устранять
    private void addPositionLotPos() {
        dialog.open();
//        updateListPosition();
//        updateList();
        accordion.setVisible(false);
        addPositionButton.setVisible(true);
        filterText.setVisible(false);
        sortList.setVisible(false);
        form.setSizeFull();
        addContactButton.setVisible(false);

//		grid.asMultiSelect().clear();

//		grid.asSingleSelect().clear();
        TableCardPosition tableCardPosition = new TableCardPosition();


//	        Authentication au = SecurityContextHolder.getContext().getAuthentication();
//			String auName = au.getName();
//	        LocalDate date = LocalDate.now();
//	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//	        LocalTime time = LocalTime.now();
//	        DateTimeFormatter formatterlc = DateTimeFormatter.ofPattern("HH:mm:ss");
//	        positionLot.setCrdate(date.format(formatter));
        // company.setAuthor(auName);
        editPosition(tableCardPosition);

    }


    public void editPositionLot(TableCardLotPosition tableCardLotPosition) {

        if (tableCardLotPosition == null) {
            closeEditor();
//        }if(tableCardLotPosition.equals()){

        } else {
            selectId(tableCardLotPosition.getId());

            accordion.setVisible(false);
            addPositionButton.setVisible(true);
            sortList.setVisible(false);
            filterText.setVisible(false);
            addContactButton.setVisible(false);

            gridLotPos.setSizeUndefined();
            form.setIdPositionLot(tableCardLotPosition);
            form.setSizeFull();

            form.setVisible(true);

            addClassName("editing");
        }
    }

    public void editPosition(TableCardPosition tableCardPosition) {

        if (tableCardPosition == null) {
            closeEditor();
//        }if(tableCardLotPosition.equals()){

        } else {
//            selectId(tableCardPosition.getId());

            accordion.setVisible(false);
            addPositionButton.setVisible(true);
            sortList.setVisible(false);
            filterText.setVisible(false);
            addContactButton.setVisible(false);

            gridLotPos.setSizeUndefined();
            dial.setIdPositionAddNew(tableCardPosition);
            dial.setSizeFull();

            dial.setVisible(true);

            addClassName("editing");
        }
    }

    private void updateList() {
        gridLotPos.setItems(tableCardLotPositionService.findAll(filterText.getValue()));

        Grid.Column<TableCardLotPosition> name = gridLotPos.getColumnByKey("id");
        GridSortOrder<TableCardLotPosition> order = new GridSortOrder<>(name, SortDirection.ASCENDING);
        gridLotPos.sort(Arrays.asList(order));
    }

    private void updateListFilter(String nameSearch, TextField textName) {
        gridLotPos.setItems(tableCardLotPositionService.findAllFilter(nameSearch, textName.getValue()));

        Grid.Column<TableCardLotPosition> name = gridLotPos.getColumnByKey("id");
        GridSortOrder<TableCardLotPosition> order = new GridSortOrder<>(name, SortDirection.ASCENDING);
        gridLotPos.sort(Arrays.asList(order));
    }
    private void updateListPosition() {
        form.gridPos.setItems(tableCardPositionService.findAllP());

        Grid.Column<TableCardPosition> name = form.gridPos.getColumnByKey("id");
        GridSortOrder<TableCardPosition> order = new GridSortOrder<>(name, SortDirection.ASCENDING);
        form.gridPos.sort(Arrays.asList(order));
    }

    private void closeEditor() {
        accordion.setVisible(true);
        filterText.setVisible(true);
        addPositionButton.setVisible(false);
        sortList.setVisible(true);
        addContactButton.setVisible(true);
        form.setIdPositionLot(null);
        form.setVisible(false);
        gridLotPos.setSizeFull();
        dial.setVisible(false);
        removeClassName("editing");
    }

    public void changeColumnName(String propertyString, String nameString) {
        Grid.Column<TableCardLotPosition> changeNameColumn = gridLotPos.getColumnByKey(propertyString);
        if (changeNameColumn != null)
            changeNameColumn.setHeader(nameString);
    }
}