//package ru.prominn.atombot.ui.views.lot;
//
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.router.Route;
//
//import ru.prominn.atombot.backend.document_form.entity.Lot;
//import ru.prominn.atombot.backend.document_form.service.LotService;
//import ru.prominn.atombot.ui.MainLayout;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Arrays;
//
//import com.vaadin.flow.component.Text;
//import com.vaadin.flow.component.UI;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.dialog.Dialog;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.grid.Grid.Column;
//import com.vaadin.flow.component.grid.GridSortOrder;
//import com.vaadin.flow.component.html.Div;
//import com.vaadin.flow.component.icon.Icon;
//import com.vaadin.flow.component.icon.VaadinIcon;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.component.upload.Upload;
//import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
//import com.vaadin.flow.data.provider.SortDirection;
//import com.vaadin.flow.data.value.ValueChangeMode;
//
//@SuppressWarnings("serial")
//@Route(value = "lot_info", layout = MainLayout.class)
//@PageTitle("Список: Лот")
//public class LotView extends VerticalLayout {
//
//	private final LotForm form;
//	Grid<Lot> grid = new Grid<>(Lot.class);
//	TextField filterText = new TextField();
//
//	private LotService lotService;
//
//	public LotView(LotService lotService) {
//
//		this.lotService = lotService;
//		addClassName("list-view");
//		setSizeFull();
//		configureGrid();
//
//		form = new LotForm(lotService.findAll());
//		form.addListener(LotForm.SaveEvent.class, this::saveLot);
//		form.addListener(LotForm.DeleteEvent.class, this::deleteLot);
//		form.addListener(LotForm.CloseEvent.class, e -> closeEditor());
//
//		Div content = new Div(grid, form);
//		content.addClassName("content");
//		content.setSizeFull();
//
//		add(getToolBar(), content);
//		updateList();
//		closeEditor();
//	}
//
//	private void deleteLot(LotForm.DeleteEvent evt) {
//		if (!lotService.delete(evt.getIdLot())) {
//			Dialog dialog = new Dialog();
//			dialog.add(new Text("Ошибка! Удалите всех пользователей этого предприятия."));
//			dialog.open();
//		} else {
//			Dialog dialog = new Dialog();
//			dialog.add(new Text("Компания успешно удалена!"));
//			dialog.open();
//			updateList();
//			closeEditor();
//		}
//	}
//
//	private void saveLot(LotForm.SaveEvent evt) {
//		try {
//			evt.getIdLot().setIdLot(evt.getIdLot().getIdLot());
//			lotService.save(evt.getIdLot());
//			updateList();
//			closeEditor();
//
//			Dialog dialog = new Dialog();
//			dialog.add(new Text("Данные успешно обновлены!"));
//			dialog.open();
//		} catch (Exception e) {
//			Dialog dialog = new Dialog();
//			dialog.add(new Text(
//					"Ошибка! Лот изменить невозможно. Для создания нового лота используйте кнопку \"Добавить запись\""));
//			dialog.open();
//
//			e.printStackTrace();
//		}
//	}
//
//	private HorizontalLayout getToolBar() {
//		MemoryBuffer buffer = new MemoryBuffer();
//		Upload upload = new Upload(buffer);
////	    Paragraph parag = new Paragraph();
//		Div output = new Div();
//
//		upload.setId("i18n-upload");
//		upload.setMaxFiles(1);
//		upload.setAcceptedFileTypes(".ioi");
//		upload.setMaxFileSize(2000);
////        Authentication au = SecurityContextHolder.getContext().getAuthentication();
////		String auName = au.getName();
//
//		upload.addSucceededListener(event -> {
////    	    Component component = createComponent(event.getMIMEType(),
////    	            event.getFileName(), buffer.getInputStream());
////    	    showOutput("Файл " + event.getFileName() + " успешно загружен и переименован.", component, output);
//			InputStreamReader isReader = new InputStreamReader(buffer.getInputStream());
//			BufferedReader br = new BufferedReader(isReader);
//			System.out.println(br);
//		});
//
//		filterText.setPlaceholder("Введите название...");
//		filterText.setClearButtonVisible(true);
//		filterText.setValueChangeMode(ValueChangeMode.LAZY);
//		filterText.addValueChangeListener(e -> updateList());
//
//		Button sortList = new Button(new Icon(VaadinIcon.ROTATE_RIGHT), click -> updateList()); // ROTATE_RIGHT
//		Button addContactButton = new Button("Добавить запись", click -> addLot());
//
//		Button redirectOnMain = new Button("Выйти в основное меню",
//				click -> UI.getCurrent().getPage().setLocation("/main"));
//		redirectOnMain.addClassName("buttonredir");
//
//		HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton, sortList, upload, output,
//				redirectOnMain);
//		toolbar.addClassName("toolbar");
//		return toolbar;
//	}
//
//	private void addLot() {
//		updateList();
////		setSizeUndefined();
//		Lot lot = new Lot();
////	       Authentication au = SecurityContextHolder.getContext().getAuthentication();
////		String auName = au.getName();
//		LocalDate date = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
////	    LocalTime time = LocalTime.now();
////	    DateTimeFormatter formatterlc = DateTimeFormatter.ofPattern("HH:mm:ss");
//		lot.setCrdate(date.format(formatter));
//		editLot(lot);
//
//	}
//
//	private void configureGrid() {
//		grid.setVerticalScrollingEnabled(true);
//		grid.addClassName("lot-grid");
//		grid.removeAllColumns();
//		grid.setSizeFull();
//
//		grid.setColumns("idLot");
//		grid.addColumn(id -> {
//			String id1 = id.getId();
//			return id1 == null ? "-" : id1;
//		}).setHeader("ID. номер").setSortable(true);
//		grid.addColumn(regNumber -> {
//			String lot = regNumber.getRegNumber();
//			return lot == null ? "-" : lot;
//		}).setHeader("Рег. номер").setSortable(true);
//		grid.addColumn(docStatusCode -> {
//			String docStatusCod = docStatusCode.getDocStatusCode();
//			return docStatusCod == null ? "-" : docStatusCod;
//		}).setHeader("Статус Документа");
//		grid.addColumn(docStatus -> {
//			String docStat = docStatus.getDocStatus();
//			return docStat == null ? "-" : docStat;
//		}).setHeader(".Статус");
//		grid.addColumn(authorCode -> {
//			String authorCod = authorCode.getAuthorCode();
//			return authorCod == null ? "-" : authorCod;
//		}).setHeader("Владелец Документа").setSortable(true);
//		grid.addColumn(author -> {
//			String auth = author.getAuthor();
//			return auth == null ? "-" : auth;
//		}).setHeader(".Владелец").setSortable(true);
//		grid.addColumn(lot -> {
//			String crdate = lot.getCrdate();
//			return crdate == null ? "-" : crdate;
//		}).setHeader("Дата регистарции").setSortable(true);
//		grid.addColumn(description -> {
//			String descript = description.getDescription();
//			return descript == null ? "-" : descript;
//		}).setHeader("Описание").setSortable(true);
//		grid.addColumn(zp_PZP_Code -> {
//			String PZPCode = zp_PZP_Code.getZp_PZP_Code();
//			return PZPCode == null ? "-" : PZPCode;
//		}).setHeader("№ ЗП/ПЗП").setSortable(true);
//		grid.addColumn(zp_PZP -> {
//			String PZP = zp_PZP.getZp_PZP();
//			return PZP == null ? "-" : PZP;
//		}).setHeader(".№ ЗП/ПЗП").setSortable(true);
//		grid.addColumn(number_lot -> {
//			String lotNumber = number_lot.getNumber_lot();
//			return lotNumber == null ? "-" : lotNumber;
//		}).setHeader("№ лота").setSortable(true);
//		grid.addColumn(number_lot_SAP -> {
//			String lotNumberSAP = number_lot_SAP.getNumber_lot_SAP();
//			return lotNumberSAP == null ? "-" : lotNumberSAP;
//		}).setHeader("№ лота в SAP CRM").setSortable(true);
//		grid.addColumn(canselLot -> {
//			String lotCansel = canselLot.getCanselLot();
//			return lotCansel == null ? "-" : lotCansel;
//		}).setHeader("Отмененный лот").setSortable(true);
//		grid.addColumn(nmcNDS -> {
//			String nmcsNds = nmcNDS.getNmcNDS();
//			return nmcsNds == null ? "-" : nmcsNds;
//		}).setHeader("НМЦ с НДС").setSortable(true);
//		grid.addColumn(summNDS -> {
//			String sumNds = summNDS.getSummNDS();
//			return sumNds == null ? "-" : sumNds;
//		}).setHeader("Сумма НДС").setSortable(true);
//		grid.addColumn(nmcNoNDS -> {
//			String nmcNoNds = nmcNoNDS.getNmcNoNDS();
//			return nmcNoNds == null ? "-" : nmcNoNds;
//		}).setHeader("НМЦ без НДС").setSortable(true);
//
//		changeColumnName("idLot", "ID документа");
////		grid.getColumnByKey("idLot").setVisible(false);
//		grid.getColumns().forEach(col -> col.setAutoWidth(true));
//		grid.asSingleSelect().addValueChangeListener(evt -> editLot(evt.getValue()));
//	}
//
//	private void editLot(Lot lot) {
//		if (lot == null) {
//			closeEditor();
//		} else {
//			grid.setSizeUndefined();
//			form.setIdLot(lot);
//			form.setVisible(true);
//			addClassName("editing");
//		}
//	}
//
//	private void updateList() {
//		grid.setItems(lotService.findAll(filterText.getValue()));
//
//		Column<Lot> name = grid.getColumnByKey("idLot");
//		GridSortOrder<Lot> order = new GridSortOrder<>(name, SortDirection.ASCENDING);
//		grid.sort(Arrays.asList(order));
//	}
//
//	private void closeEditor() {
//		grid.setSizeFull();
//		form.setIdLot(null);
//		form.setVisible(false);
//		removeClassName("editing");
//	}
//
//	private void changeColumnName(String propertyString, String nameString) {
//		Column<Lot> changeNameColumn = grid.getColumnByKey(propertyString);
//		if (changeNameColumn != null)
//			changeNameColumn.setHeader(nameString);
//	}
//}