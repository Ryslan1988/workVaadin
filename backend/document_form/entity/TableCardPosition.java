package ru.prominn.atombot.backend.document_form.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringSummary;
import org.hibernate.annotations.SQLInsert;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "T_CARD_POSITION")
public class TableCardPosition implements Cloneable {

    /* *ID TableCardLotPosition */
    @Id
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "ID")
    public String id;

    /*
     * Many to one annatacia
     * */
    @ManyToOne
    @ToStringSummary
    @JoinColumn(name = "tCardPosition_id", nullable = true, foreignKey = @ForeignKey(name ="ID"))
    private TableCardLotPosition tCardPosition_id;

//    public void setTCardPosition_id(String tCardPosition_id) {
//        tCardPosition_id.toString();
//    }


//	public String toString() {
//		return this.getTCardPosition_id();
//	}
//	@Transient
//	@ToStringSummary
//	private String tCardPos_id;
//
//	public void getTCardPos_id(){
//		this.tCardPos_id = tCardPosition_id;
//	}

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


    // Finish Basick

    /* *itemized lot position */
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "LOT_POS")
    public String lot_pos;

    /* *status lot position */
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "LOT_STATUS")
    public String lot_status;

    /* *number of packet */
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "PUCKNUM")
    public String pucknum;

    /* *number of position packet */
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "PUCKPOS")
    public String puckpos;

    /* *unit price not NDS*/
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "REQ_PRICE")
    public String req_price;

    /* *unit price with NDS */
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "COMMON_PRICE")
    public String common_price;

    /* *unit price indicator */
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "COMMON_PRICE_FLAG")
    public String common_price_flag;

    /* *valute */
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "VAT")
    public String vat;

    /* *build name*/
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "TECH_CR_MAME")
    public String tech_cr_name;

    /* *build date*/
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "TECH_CR_DATE")
    public String tech_cr_date;

    /* *build time*/
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "TECH_CR_TIME")
    public String tech_cr_time;

    /* *agree date*/
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "TECH_AGREE_DATE")
    public String tech_agree_date;

    /* *changed name*/
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "TECH_CH_NAME")
    public String tech_ch_name;

    /* *changed date*/
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "TECH_CH_DATE")
    public String tech_ch_date;

    /* *changed time*/
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "TECH_CH_TIME")
    public String tech_ch_time;

    /* *value vall with NDS*/
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "VALUE_CURR")
    public String value_curr;

    /* *value vall for one with NDS*/
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "VALUE_CURR_C")
    public String value_curr_c;

    /* *price have not NDS*/
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "PREIS")
    public String preis;

    /* *price have not NDS*/
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "RLWRT")
    public String rlwrt;

    /* *price have not NDS*/
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "PREIS_CURR")
    public String preis_curr;

    /* *price have not NDS*/
    @NotNull
    @NotEmpty(message = "Поле не может быть пустым")
    @Column(name = "RLWRT_CURR")
    public String rlwrt_curr;

}
