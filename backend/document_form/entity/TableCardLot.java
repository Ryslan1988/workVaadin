package ru.prominn.atombot.backend.document_form.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "T_CARD_LOT")
public class TableCardLot {

//    /*
//     * Document ID (GUID)
//     * */
//    @Id
//    @Column(name = "GUID")
//
//    private String guid;

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
     * Organization
     * */
    @Column(name = "PRED")
    private String pred;

    /*
     * Date
     * */
    @Column(name = "REGIST_DATE")
    private String registeredDate;

    /*
     * Contract currency
     * */
    @Column(name = "WAERS")
    private String waers;

    /*
     * NmcWithNDS
     * */
    @Column(name = "NMC_WITH_NDS")
    private String nmcWithNDS;

    /*
     * Amount NDS
     * */
    @Column(name = "AMOUNT_NDS")
    private String amountNDS;

    /*
     * Amount Not NDS
     * */
    @Column(name = "AM_NOT_NDS")
    private String amNotNDS;

    /*
     * Without NDS
     * */
    @Column(name = "WITHOUT_NDS")
    private String withOutNDS;

    /*
     *
     * */
    @Column(name = "NUM_PROT_CZK")
    private String numberProtocolCZK;

    /*
     *
     * */
    @Column(name = "DAT_PROT_CZK")
    private String dateProtocolCZK;

    /*
     * Number of Lot in SRM
     * */
    @Column(name = "SRM_NUM_LOT")
    private String numberSRMLot;

    /*
     *
     * */
    @Column(name = "NUM_LOT")
    private String numberLot;

    /*
     * Minimum auction step
     * */
    @Column(name = "MIN_STA_INP")
    private String minAuctionStep;

    /*
     * Minimum auction step
     * in currency
     * */
    @Column(name = "MIN_STA_INV")
    private String minAuctionINV;

    /*
     * Maximum auction step
     * */
    @Column(name = "MAX_STA_INP")
    private String maxAuctionStep;

    /*
     * Maximum auction step
     * in currency
     * */
    @Column(name = "MAX_STA_INV")
    private String maxAuctionINV;

}
