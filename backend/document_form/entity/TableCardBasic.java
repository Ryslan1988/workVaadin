package ru.prominn.atombot.backend.document_form.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "T_CARD_BASIC")
public class TableCardBasic {

    /*
    * Document ID (GUID)
    * */
    @Id
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

}
