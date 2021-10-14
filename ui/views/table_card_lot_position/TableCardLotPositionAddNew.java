package ru.prominn.atombot.ui.views.table_card_lot_position;

import ch.qos.logback.core.joran.util.StringToObjectConverter;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.PropertyId;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.communication.rpc.StringToEnumDecoder;
import com.vaadin.flow.shared.Registration;
import org.springframework.dao.DataIntegrityViolationException;
import ru.prominn.atombot.backend.document_form.entity.TableCardLotPosition;
import ru.prominn.atombot.backend.document_form.entity.TableCardPosition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class TableCardLotPositionAddNew extends VerticalLayout {

    @PropertyId("guid")
    TextField firstGuid = new TextField("Позиция Детализации лот");
    @PropertyId("lot_pos")
    TextField firstLot_pos = new TextField("Позиция Детализации лот");
    @PropertyId("regNum")
    TextField firsRegNum = new TextField("Регистрационный номер");
//    @PropertyId("tCardPosition_id")
    TextField firsTCardPosition_id = new TextField();
    @PropertyId("template")
    TextField firsTemplate = new TextField("Шаблон документа");
    @PropertyId("description")
    TextField firstDescription = new TextField("Название документа");
    @PropertyId("deleteFlag")
    TextField firstDeleteFlag = new TextField("Индикатор удаления документа");
    @PropertyId("parentDoc1")
    TextField firstParentDoc1 = new TextField("Индикатор вышестоящего документа");
    @PropertyId("status")
    TextField firstStatus = new TextField("Статус документа");
    @PropertyId("statusText")
    TextField firstStatusText = new TextField("Статус");
    @PropertyId("createdBy")
    TextField firstCreatedBy = new TextField("Пользователь создавший документ");
    @PropertyId("createdDate")
    TextField firstСreatedDate = new TextField("Дата создания документ");
    @PropertyId("createdTime")
    TextField firstСreatedTime = new TextField("Время создания документ");
    @PropertyId("changedBy")
    TextField firstСhangedBy = new TextField("Пользователь изменивший документ");
    @PropertyId("changedDate")
    TextField firstChangedDate = new TextField("Дата изменения документ");
    @PropertyId("changedTime")
    TextField firstChangedTime = new TextField("Время изменения документ");
    @PropertyId("closedDate")
    TextField firstClosedDate = new TextField("Дата закрытия документ");
    @PropertyId("closedTime")
    TextField firstClosedTime = new TextField("Время закрытия документ");
    @PropertyId("lot_status")
    TextField firstLot_status = new TextField("Дата закрытия документ");
    @PropertyId("pucknum")
    TextField firstPucknum = new TextField("Номер пакета");
    @PropertyId("puckpos")
    TextField firstPuckpos = new TextField("Номер позиции пакета");
    @PropertyId("req_price")
    TextField firstReq_price = new TextField("Цена за Ед.сНДСвРуб.");
    @PropertyId("common_price")
    TextField firstCommon_price = new TextField("Цена за Ед.сНДСвРуб.");
    @PropertyId("common_price_flag")
    TextField firstCommon_price_flag = new TextField("Индикатор общая цена");
    @PropertyId("vat")
    TextField firstVat = new TextField("Валюта");
    @PropertyId("tech_cr_name")
    TextField firstTech_cr_name = new TextField("Создал");
    @PropertyId("tech_cr_date")
    TextField firstTech_cr_date = new TextField("Дата создания");
    @PropertyId("tech_cr_time")
    TextField firstTech_cr_time = new TextField("Время создания");
    @PropertyId("tech_agree_date")
    TextField firstTech_agree_date = new TextField("Дата согласования");
    @PropertyId("tech_ch_name")
    TextField firstTech_ch_name = new TextField("Изменил");
    @PropertyId("tech_ch_date")
    TextField firstTech_ch_date = new TextField("Дата изменения");
    @PropertyId("tech_ch_time")
    TextField firstTech_ch_time = new TextField("Время изменения");
    @PropertyId("value_curr")
    TextField firstValue_curr = new TextField("Стоимость с НДС в вал");
    @PropertyId("value_curr_c")
    TextField firstValue_curr_c = new TextField("Цена за ед. с НДС в вал.");
    @PropertyId("preis")
    TextField firstPreis = new TextField("Цена за ед. без НДС в Руб.");
    @PropertyId("rlwrt")
    TextField firstRlwrt = new TextField("Стоимость без НДС в Руб.");
    @PropertyId("preis_curr")
    TextField firstPreis_curr = new TextField("Цена за ед. без НДС в вал.");
    @PropertyId("rlwrt_curr")
    TextField firstRlwrt_curr = new TextField("Стоимость без НДС в вал.");

    Button savePos = new Button("Сохранить");
    Button closePos = new Button("Отмена");


    Binder<TableCardPosition> binder1 = new BeanValidationBinder<>(TableCardPosition.class);


    private TableCardPosition tableCardPosition;

    public TableCardLotPositionAddNew(List<TableCardPosition> components) {
        this.tableCardPosition = tableCardPosition;

        binder1.bindInstanceFields(this);

//        binder1.forField(firsTCardPosition_id)
//                // Validator will be run with the String value of the field
//                .withValidator(text -> text.length() == 4,
//                        "Doesn't look like a year")
//                // Converter will only be run for strings with 4 characters
//                .withConverter(
//                        new StringToObjectConverter())
//                // Validator will be run with the converted value
////                .withValidator(year -> year >= 1900 && year < 2000,
////                        "Person must be born in the 20th century")
//                .bind(TableCardPosition::getTCardPosition_id, TableCardPosition::setTCardPosition_id);

        firstGuid.setRequired(true);
        firstLot_pos.setValueChangeMode(ValueChangeMode.EAGER);
        firsTemplate.setValueChangeMode(ValueChangeMode.EAGER);
        firsRegNum.setValueChangeMode(ValueChangeMode.EAGER);
        firstDescription.setValueChangeMode(ValueChangeMode.EAGER);
        firstDeleteFlag.setValueChangeMode(ValueChangeMode.EAGER);
        firstParentDoc1.setValueChangeMode(ValueChangeMode.EAGER);
        firstStatus.setValueChangeMode(ValueChangeMode.EAGER);
        firstStatusText.setValueChangeMode(ValueChangeMode.EAGER);
        firstCreatedBy.setValueChangeMode(ValueChangeMode.EAGER);
        firstСreatedDate.setValueChangeMode(ValueChangeMode.EAGER);
        firstСreatedTime.setValueChangeMode(ValueChangeMode.EAGER);
        firstСhangedBy.setValueChangeMode(ValueChangeMode.EAGER);
        firstChangedDate.setValueChangeMode(ValueChangeMode.EAGER);
        firstChangedTime.setValueChangeMode(ValueChangeMode.EAGER);
        firstClosedDate.setValueChangeMode(ValueChangeMode.EAGER);
        firstClosedTime.setValueChangeMode(ValueChangeMode.EAGER);
        firstLot_status.setValueChangeMode(ValueChangeMode.EAGER);
        firstPucknum.setValueChangeMode(ValueChangeMode.EAGER);
        firstPuckpos.setValueChangeMode(ValueChangeMode.EAGER);
        firstReq_price.setValueChangeMode(ValueChangeMode.EAGER);
        firstCommon_price.setValueChangeMode(ValueChangeMode.EAGER);
        firstCommon_price_flag.setValueChangeMode(ValueChangeMode.EAGER);
        firstVat.setValueChangeMode(ValueChangeMode.EAGER);
        firstTech_cr_name.setValueChangeMode(ValueChangeMode.EAGER);
        firstTech_cr_date.setValueChangeMode(ValueChangeMode.EAGER);
        firstTech_cr_time.setValueChangeMode(ValueChangeMode.EAGER);
        firstTech_agree_date.setValueChangeMode(ValueChangeMode.EAGER);
        firstTech_ch_name.setValueChangeMode(ValueChangeMode.EAGER);
        firstTech_ch_date.setValueChangeMode(ValueChangeMode.EAGER);
        firstTech_ch_time.setValueChangeMode(ValueChangeMode.EAGER);
        firstValue_curr.setValueChangeMode(ValueChangeMode.EAGER);
        firstValue_curr_c.setValueChangeMode(ValueChangeMode.EAGER);
        firstPreis.setValueChangeMode(ValueChangeMode.EAGER);
        firstRlwrt.setValueChangeMode(ValueChangeMode.EAGER);
        firstPreis_curr.setValueChangeMode(ValueChangeMode.EAGER);
        firstRlwrt_curr.setValueChangeMode(ValueChangeMode.EAGER);
        firsTCardPosition_id.setValueChangeMode(ValueChangeMode.EAGER);

        Div div1 = new Div();
        Div div2 = new Div();
        Div div3 = new Div();
        Div div4 = new Div();
        Div div5 = new Div();
        Div div6 = new Div();
        Div div7 = new Div();
        Div div8 = new Div();
        Div div9 = new Div();
        Div div10 = new Div();
        Div div11 = new Div();
        Div div12 = new Div();
        Div div13 = new Div();
        Div div14 = new Div();

        HorizontalLayout horiz1 = new HorizontalLayout();
        HorizontalLayout horiz2 = new HorizontalLayout();
        HorizontalLayout horiz3 = new HorizontalLayout();
        HorizontalLayout horiz4 = new HorizontalLayout();
        HorizontalLayout horiz5 = new HorizontalLayout();
        HorizontalLayout horiz6 = new HorizontalLayout();
        HorizontalLayout horiz7 = new HorizontalLayout();
        HorizontalLayout horiz8 = new HorizontalLayout();
        HorizontalLayout horiz9 = new HorizontalLayout();
        HorizontalLayout horiz10 = new HorizontalLayout();
        HorizontalLayout horiz11 = new HorizontalLayout();
        HorizontalLayout horiz12 = new HorizontalLayout();
        HorizontalLayout horiz13 = new HorizontalLayout();

        div1.add(div2, div3, div4, div5,div6, div7, div8,div9, div10,div11,div12,div13,div14);
        div2.add(horiz1);
        div3.add(horiz2);
        div4.add(horiz3);
        div5.add(horiz4);
        div6.add(horiz5);
        div7.add(horiz6);
        div8.add(horiz7);
        div9.add(horiz8);
        div10.add(horiz9);
        div11.add(horiz10);
        div12.add(horiz11);
        div13.add(horiz12);
        div14.add(horiz13);

        horiz1.add(firsTemplate,firstLot_pos,firsRegNum);
        horiz2.add(firstDescription,firstDeleteFlag,firstParentDoc1);
        horiz3.add(firstStatus,firstStatusText,firstCreatedBy);
        horiz4.add(firstСreatedDate,firstСreatedTime,firstСhangedBy);
        horiz5.add(firstChangedDate,firstChangedTime,firstClosedDate);
        horiz6.add(firstClosedTime,firstLot_status,firstPucknum);
        horiz7.add(firstPuckpos,firstReq_price,firstCommon_price);
        horiz8.add(firstCommon_price_flag,firstVat,firstTech_cr_name);
        horiz9.add(firstTech_cr_date,firstTech_cr_time,firstTech_agree_date);
        horiz10.add(firstTech_ch_name,firstTech_ch_date,firstTech_ch_time);
        horiz11.add(firstValue_curr,firstValue_curr_c,firstPreis);
        horiz12.add(firstRlwrt,firstPreis_curr,firstRlwrt_curr);
        horiz13.add(firstGuid,firsTCardPosition_id,createButtonsLayout());


        add(div1);

    }

    private Component createButtonsLayout() {
        savePos.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        closePos.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        savePos.addClickShortcut(Key.ENTER);
        closePos.addClickShortcut(Key.ESCAPE);

        savePos.addClickListener(click -> validateAndSavePosNew());
        closePos.addClickListener(click -> fireEvent(new TableCardLotPositionAddNew.CloseEvent(this)));


        binder1.addStatusChangeListener(evt -> savePos.setEnabled(binder1.isValid()));

        return new HorizontalLayout( savePos);
    }

    private void validateAndSavePosNew() {
        try {
            if (tableCardPosition != null) {
                if (tableCardPosition.getId() == null) {
//                    if (tableCardLotPosition != null)
                    tableCardPosition.setId(firstGuid.getValue());
                }
                binder1.writeBean(tableCardPosition);
                fireEvent(new TableCardLotPositionAddNew.SaveEvent(this, tableCardPosition));
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

    public void setIdPositionAddNew(TableCardPosition tableCardPosition) {
        this.tableCardPosition = tableCardPosition;
        binder1.readBean(tableCardPosition);
        savePos.setEnabled(true);
        try {
            if (tableCardPosition.getId() != null) {
                firstGuid.setEnabled(false);
            } else {
                firstGuid.setEnabled(true);
            }
        } catch (NullPointerException e) {
            // Company not exist
        }

    }


    public static abstract class PositionAddNewEvent extends ComponentEvent<TableCardLotPositionAddNew> {
        private final TableCardPosition tableCardPosition;

        protected PositionAddNewEvent(TableCardLotPositionAddNew source, TableCardPosition tableCardPosition) {
            super(source, false);
            this.tableCardPosition = tableCardPosition;
        }

        public TableCardPosition getTableCardBasicAddNew() {
            return tableCardPosition;
        }
    }

    public static class SaveEvent extends TableCardLotPositionAddNew.PositionAddNewEvent {
        SaveEvent(TableCardLotPositionAddNew source, TableCardPosition tableCardPosition) {
            super(source, tableCardPosition);
        }
    }


    public static class CloseEvent extends TableCardLotPositionAddNew.PositionAddNewEvent {
        CloseEvent(TableCardLotPositionAddNew source) {
            super(source, null);
        }
    }
    protected <K extends ComponentEvent<?>> Registration addListenerPos(Class<K> eventType,
                                                                        ComponentEventListener<K> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
