package ru.prominn.atombot.backend.document_form.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "T_CARD_QUOT_SUPPLIERS")
public class TableCardQuotSuppliers {

    /*
     * Document ID (GUID)
     * */

    @Column(name = "GUID")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @OneToMany(fetch = FetchType.LAZY,
//              cascade = CascadeType.ALL)
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
    @Column(name = "CHANGED_BY")
    private String changedBy;

    /*
     * Document change date
     * */
    @Column(name = "CHANGED_DT")
    private String changedDate;

    /*
     * Document change time
     * */
    @Column(name = "CHANGED_TM")
    private String changedTime;

    /*
     * Document closing date
     * */
    @Column(name = "CLOSED_DT")
    private String closedDate;

    /*
     * Document closing time
     * */
    @Column(name = "CLOSED_TM")
    private String closedTime;



    /*
     * Document ID
     * */
    @Id
    @Column(name = "ID")
    private String id;

    /*
     * CARD_TYPE
     * */
    @Column(name = "CARD_TYPE")
    private String card_type;

    /*
     * CARD_SUBTYPE
     * */
    @Column(name = "CARD_SUBTYPE")
    private String card_subtype;

    /*
     * Company
     * */
    @Column(name = "PRED")
    private String pred;

    /*
     * Registration date
     * */
    @Column(name = "REGISTR_DATE")
    private String register_date;

    /*
     * Purchase organizer
     * */
    @Column(name = "ORG_PURCH")
    private String org_purch;

    /*
     * Customer
     * */
    @Column(name = "KUN")
    private String kun;

    /*
     * Executor
     * */
    @Column(name = "RESP_PERSON")
    private String resp_person;

    /*
     * Subdivision
     * */
    @Column(name = "DEPART")
    private String depart;

    /*
     * Procedure type
     * */
    @Column(name = "PROC_TYPE")
    private String proc_type;

    /*
     * Opening date of the envelope
     * */
    @Column(name = "KEND_DATE")
    private String kend_date;

    /*
     * Meeting date
     * */
    @Column(name = "SOV_DATE")
    private String sov_date;

    /*
     * Value with NDS
     * */
    @Column(name = "AM_WITH_NDS")
    private String am_with_nds;

    /*
     * Values NDS
     * */
    @Column(name = "AMOUNT_NDS")
    private String amount_nds;

    /*
     * Values not NDS
     * */
    @Column(name = "AM_NOT_NDS")
    private String am_not_nds;

    /*
     * Contract currency
     * */
    @Column(name = "WAERS")
    private String waers;

    /*
     * № ПП на ЭТП
     * */
    @Column(name = "OFFERID")
    private String offerid;

    /*
     * Номер проц. на ЭТП
     * */
    @Column(name = "SRM_NUM_ZP")
    private String srm_num_zp;

    /*
     * № лота на ЭТП
     * */
    @Column(name = "SRM_NUM_LOT")
    private String srm_num_lot;

    /*
     * Date of Bid Submission
     * */
    @Column(name = "SEND_OFFER_DATE")
    private String send_offer_date;

    /*
     * Time of Bid Submission
     * */
    @Column(name = "SEND_OFFER_TIME")
    private String send_offer_time;

    /*
     * INN
     * */
    @Column(name = "INN")
    private String inn;

    /*
     * KPP
     * */
    @Column(name = "KPP")
    private String kpp;

    /*
     * OGRN
     * */
    @Column(name = "OGRN")
    private String ogrn;

}
