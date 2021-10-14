package ru.prominn.atombot.backend.document_form.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "T_CARD_LOT_POSITION")
public class TableCardLotPosition {


    /*
     * Document ID
     * */
    @Id
    @Column(name = "ID")
    @Generated
    private String id;

    @OneToMany(mappedBy = "tCardPosition_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<TableCardPosition> tCardPosition_id;

    public TableCardLotPosition(String id, Set<TableCardPosition> tableCardPosition, String guid, String regNum, String template,
                                String description, String deleteFlag, String parentDoc1, String status, String statusText,
                                String createdBy, String createdDate, String createdTime, String changedBy, String changedDate,
                                String changedTime, String closedDate, String closedTime, String card_subtype, String card_type, String pred,
                                String kun, String lifnr, String depart, String org_purch, String resp_person, String plan_year, String proc_type,
                                String etp_kind, String rcase_proc, String waers, String vat, String am_with_nds, String amount_nds, String am_not_nds) {
        this.id = id;
        this.tCardPosition_id = tCardPosition_id;
        this.guid = guid;
        this.regNum = regNum;
        this.template = template;
        this.description = description;
        this.deleteFlag = deleteFlag;
        this.parentDoc1 = parentDoc1;
        this.status = status;
        this.statusText = statusText;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
        this.changedBy = changedBy;
        this.changedDate = changedDate;
        this.changedTime = changedTime;
        this.closedDate = closedDate;
        this.closedTime = closedTime;
        this.card_subtype = card_subtype;
        this.card_type = card_type;
        this.pred = pred;
        this.kun = kun;
        this.lifnr = lifnr;
        this.depart = depart;
        this.org_purch = org_purch;
        this.resp_person = resp_person;
        this.plan_year = plan_year;
        this.proc_type = proc_type;
        this.etp_kind = etp_kind;
        this.rcase_proc = rcase_proc;
        this.waers = waers;
        this.vat = vat;
        this.am_with_nds = am_with_nds;
        this.amount_nds = amount_nds;
        this.am_not_nds = am_not_nds;
    }

    /*
     * Document ID (GUID)
     * */

    @Column(name = "GUID")

    private String guid;

    /*
     * Document code.
     * The field is associated with
     * the ID field and participates
     * in the conversion of values
     * */
    @Column(name = "REGNUM")
    private String regNum;

    /*
     * Document template
     * */
    @Column(name = "TEMPLATE")
    private String template;

    /*
     * Document's name
     * */
    @Column(name = "DESCRIPTION")
    private String description;

    /*
     * Document deletion indicator
     * (X-document deleted)
     * */
    @Column(name = "DELETE_FLAG")
    private String deleteFlag;

    /*
     * Parent document ID 1
     * */
    @Column(name = "PARENT_DOC1")
    private String parentDoc1;

    /*
     * Document status
     * */
    @Column(name = "STATUS")
    private String status;

    /*
     * Document status text
     * */
    @Column(name = "STATUS_TEXT")
    private String statusText;

    /*
     * User who created the document
     * */
    @Column(name = "CREATED_BY")
    private String createdBy;

    /*
     * Document creation date
     * */
    @Column(name = "CREATED_DT")
    private String createdDate;

    /*
     * Document creation time
     * */
    @Column(name = "CREATED_TM")
    private String createdTime;

    /*
     * The user who changed
     * the document
     * */
    @Column(name =  "CHANGED_BY")
    private String changedBy;

    /*
     * Document change date
     * */
    @Column(name =  "CHANGED_DT")
    private String changedDate;

    /*
     * Document change time
     * */
    @Column(name =  "CHANGED_TM")
    private String changedTime;

    /*
     * Document closing date
     * */
    @Column(name =  "CLOSED_DT")
    private String closedDate;

    /*
     * Document closing time
     * */
    @Column(name =  "CLOSED_TM")
    private String closedTime;







    /*
     * Card type
     * */
    @Column(name = "CARD_SUBTYPE")
    private String card_subtype;

    /*
     * Card subtype
     * */
    @Column(name = "CARD_TYPE")
    private String card_type;

    /*
     * Owner
     * */
    @Column(name = "PRED")
    private String pred;

    /*
     * Customer
     * */
    @Column(name = "KUN")
    private String kun;

    /*
     * Provider
     * */
    @Column(name = "LIFNR")
    private String lifnr;

    /*
     * Subdivision
     * */
    @Column(name = "DEPART")
    private String depart;

    /*
     * Purchase organizer
     * */
    @Column(name = "ORG_PURCH")
    private String org_purch;

    /*
     * Executor
     * */
    @Column(name = "RESP_PERSON")
    private String resp_person;

    /*
     * Planning year
     * */
    @Column(name = "PLAN_YEAR")
    private String plan_year;

    /*
     * Procedure type
     * */
    @Column(name = "PROC_TYPE")
    private String proc_type;

    /*
     * Cod ETP owner
     * */
    @Column(name = "ETP_KIND")
    private String etp_kind;

    /*
     * ЕОСЗ
     * */
    @Column(name = "RCASE_PROC")
    private String rcase_proc;

    /*
     * Valute
     * */
    @Column(name = "WAERS")
    private String waers;

    /*
     * Valute
     * */
    @Column(name = "VAT")
    private String vat;


    /*
     * Value with NDS
     * */
    @Column(name = "AM_WITH_NDS")
    private String am_with_nds;

    /*
     * Value NDS
     * */
    @Column(name = "AMOUNT_NDS")
    private String amount_nds;

    /*
     * Value not NDS
     * */
    @Column(name = "AM_NOT_NDS")
    private String am_not_nds;


}
