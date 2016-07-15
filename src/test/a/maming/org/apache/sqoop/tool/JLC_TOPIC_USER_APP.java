package a.maming.org.apache.sqoop.tool;


import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JLC_TOPIC_USER_APP extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private String create_date;
  public String get_create_date() {
    return create_date;
  }
  public void set_create_date(String create_date) {
    this.create_date = create_date;
  }
  public JLC_TOPIC_USER_APP with_create_date(String create_date) {
    this.create_date = create_date;
    return this;
  }
  private String end_date;
  public String get_end_date() {
    return end_date;
  }
  public void set_end_date(String end_date) {
    this.end_date = end_date;
  }
  public JLC_TOPIC_USER_APP with_end_date(String end_date) {
    this.end_date = end_date;
    return this;
  }
  private String channel;
  public String get_channel() {
    return channel;
  }
  public void set_channel(String channel) {
    this.channel = channel;
  }
  public JLC_TOPIC_USER_APP with_channel(String channel) {
    this.channel = channel;
    return this;
  }
  private Integer period;
  public Integer get_period() {
    return period;
  }
  public void set_period(Integer period) {
    this.period = period;
  }
  public JLC_TOPIC_USER_APP with_period(Integer period) {
    this.period = period;
    return this;
  }
  private Integer activity_num;
  public Integer get_activity_num() {
    return activity_num;
  }
  public void set_activity_num(Integer activity_num) {
    this.activity_num = activity_num;
  }
  public JLC_TOPIC_USER_APP with_activity_num(Integer activity_num) {
    this.activity_num = activity_num;
    return this;
  }
  private Integer reg_num;
  public Integer get_reg_num() {
    return reg_num;
  }
  public void set_reg_num(Integer reg_num) {
    this.reg_num = reg_num;
  }
  public JLC_TOPIC_USER_APP with_reg_num(Integer reg_num) {
    this.reg_num = reg_num;
    return this;
  }
  private Integer open_num;
  public Integer get_open_num() {
    return open_num;
  }
  public void set_open_num(Integer open_num) {
    this.open_num = open_num;
  }
  public JLC_TOPIC_USER_APP with_open_num(Integer open_num) {
    this.open_num = open_num;
    return this;
  }
  private Integer inv_num;
  public Integer get_inv_num() {
    return inv_num;
  }
  public void set_inv_num(Integer inv_num) {
    this.inv_num = inv_num;
  }
  public JLC_TOPIC_USER_APP with_inv_num(Integer inv_num) {
    this.inv_num = inv_num;
    return this;
  }
  private Integer inv_freq;
  public Integer get_inv_freq() {
    return inv_freq;
  }
  public void set_inv_freq(Integer inv_freq) {
    this.inv_freq = inv_freq;
  }
  public JLC_TOPIC_USER_APP with_inv_freq(Integer inv_freq) {
    this.inv_freq = inv_freq;
    return this;
  }
  private java.math.BigDecimal inv_amount;
  public java.math.BigDecimal get_inv_amount() {
    return inv_amount;
  }
  public void set_inv_amount(java.math.BigDecimal inv_amount) {
    this.inv_amount = inv_amount;
  }
  public JLC_TOPIC_USER_APP with_inv_amount(java.math.BigDecimal inv_amount) {
    this.inv_amount = inv_amount;
    return this;
  }
  private Integer inv100_num;
  public Integer get_inv100_num() {
    return inv100_num;
  }
  public void set_inv100_num(Integer inv100_num) {
    this.inv100_num = inv100_num;
  }
  public JLC_TOPIC_USER_APP with_inv100_num(Integer inv100_num) {
    this.inv100_num = inv100_num;
    return this;
  }
  private Integer inv100_freq;
  public Integer get_inv100_freq() {
    return inv100_freq;
  }
  public void set_inv100_freq(Integer inv100_freq) {
    this.inv100_freq = inv100_freq;
  }
  public JLC_TOPIC_USER_APP with_inv100_freq(Integer inv100_freq) {
    this.inv100_freq = inv100_freq;
    return this;
  }
  private java.math.BigDecimal inv100_amount;
  public java.math.BigDecimal get_inv100_amount() {
    return inv100_amount;
  }
  public void set_inv100_amount(java.math.BigDecimal inv100_amount) {
    this.inv100_amount = inv100_amount;
  }
  public JLC_TOPIC_USER_APP with_inv100_amount(java.math.BigDecimal inv100_amount) {
    this.inv100_amount = inv100_amount;
    return this;
  }
  private Integer inv1st_num;
  public Integer get_inv1st_num() {
    return inv1st_num;
  }
  public void set_inv1st_num(Integer inv1st_num) {
    this.inv1st_num = inv1st_num;
  }
  public JLC_TOPIC_USER_APP with_inv1st_num(Integer inv1st_num) {
    this.inv1st_num = inv1st_num;
    return this;
  }
  private java.math.BigDecimal inv1st_amount;
  public java.math.BigDecimal get_inv1st_amount() {
    return inv1st_amount;
  }
  public void set_inv1st_amount(java.math.BigDecimal inv1st_amount) {
    this.inv1st_amount = inv1st_amount;
  }
  public JLC_TOPIC_USER_APP with_inv1st_amount(java.math.BigDecimal inv1st_amount) {
    this.inv1st_amount = inv1st_amount;
    return this;
  }
  private Integer inv1st100_num;
  public Integer get_inv1st100_num() {
    return inv1st100_num;
  }
  public void set_inv1st100_num(Integer inv1st100_num) {
    this.inv1st100_num = inv1st100_num;
  }
  public JLC_TOPIC_USER_APP with_inv1st100_num(Integer inv1st100_num) {
    this.inv1st100_num = inv1st100_num;
    return this;
  }
  private java.math.BigDecimal inv1st100_amount;
  public java.math.BigDecimal get_inv1st100_amount() {
    return inv1st100_amount;
  }
  public void set_inv1st100_amount(java.math.BigDecimal inv1st100_amount) {
    this.inv1st100_amount = inv1st100_amount;
  }
  public JLC_TOPIC_USER_APP with_inv1st100_amount(java.math.BigDecimal inv1st100_amount) {
    this.inv1st100_amount = inv1st100_amount;
    return this;
  }
  private java.math.BigDecimal inv1st_all_amont;
  public java.math.BigDecimal get_inv1st_all_amont() {
    return inv1st_all_amont;
  }
  public void set_inv1st_all_amont(java.math.BigDecimal inv1st_all_amont) {
    this.inv1st_all_amont = inv1st_all_amont;
  }
  public JLC_TOPIC_USER_APP with_inv1st_all_amont(java.math.BigDecimal inv1st_all_amont) {
    this.inv1st_all_amont = inv1st_all_amont;
    return this;
  }
  private Integer inv1st_all100_num;
  public Integer get_inv1st_all100_num() {
    return inv1st_all100_num;
  }
  public void set_inv1st_all100_num(Integer inv1st_all100_num) {
    this.inv1st_all100_num = inv1st_all100_num;
  }
  public JLC_TOPIC_USER_APP with_inv1st_all100_num(Integer inv1st_all100_num) {
    this.inv1st_all100_num = inv1st_all100_num;
    return this;
  }
  private java.math.BigDecimal inv1st_all100_amount;
  public java.math.BigDecimal get_inv1st_all100_amount() {
    return inv1st_all100_amount;
  }
  public void set_inv1st_all100_amount(java.math.BigDecimal inv1st_all100_amount) {
    this.inv1st_all100_amount = inv1st_all100_amount;
  }
  public JLC_TOPIC_USER_APP with_inv1st_all100_amount(java.math.BigDecimal inv1st_all100_amount) {
    this.inv1st_all100_amount = inv1st_all100_amount;
    return this;
  }
  private Integer inv2nd_num;
  public Integer get_inv2nd_num() {
    return inv2nd_num;
  }
  public void set_inv2nd_num(Integer inv2nd_num) {
    this.inv2nd_num = inv2nd_num;
  }
  public JLC_TOPIC_USER_APP with_inv2nd_num(Integer inv2nd_num) {
    this.inv2nd_num = inv2nd_num;
    return this;
  }
  private java.math.BigDecimal inv2nd_amount;
  public java.math.BigDecimal get_inv2nd_amount() {
    return inv2nd_amount;
  }
  public void set_inv2nd_amount(java.math.BigDecimal inv2nd_amount) {
    this.inv2nd_amount = inv2nd_amount;
  }
  public JLC_TOPIC_USER_APP with_inv2nd_amount(java.math.BigDecimal inv2nd_amount) {
    this.inv2nd_amount = inv2nd_amount;
    return this;
  }
  private Integer invre_num;
  public Integer get_invre_num() {
    return invre_num;
  }
  public void set_invre_num(Integer invre_num) {
    this.invre_num = invre_num;
  }
  public JLC_TOPIC_USER_APP with_invre_num(Integer invre_num) {
    this.invre_num = invre_num;
    return this;
  }
  private Integer invre_freq;
  public Integer get_invre_freq() {
    return invre_freq;
  }
  public void set_invre_freq(Integer invre_freq) {
    this.invre_freq = invre_freq;
  }
  public JLC_TOPIC_USER_APP with_invre_freq(Integer invre_freq) {
    this.invre_freq = invre_freq;
    return this;
  }
  private java.math.BigDecimal invre_amount;
  public java.math.BigDecimal get_invre_amount() {
    return invre_amount;
  }
  public void set_invre_amount(java.math.BigDecimal invre_amount) {
    this.invre_amount = invre_amount;
  }
  public JLC_TOPIC_USER_APP with_invre_amount(java.math.BigDecimal invre_amount) {
    this.invre_amount = invre_amount;
    return this;
  }
  private Integer redeem_num;
  public Integer get_redeem_num() {
    return redeem_num;
  }
  public void set_redeem_num(Integer redeem_num) {
    this.redeem_num = redeem_num;
  }
  public JLC_TOPIC_USER_APP with_redeem_num(Integer redeem_num) {
    this.redeem_num = redeem_num;
    return this;
  }
  private Integer redeem_freq;
  public Integer get_redeem_freq() {
    return redeem_freq;
  }
  public void set_redeem_freq(Integer redeem_freq) {
    this.redeem_freq = redeem_freq;
  }
  public JLC_TOPIC_USER_APP with_redeem_freq(Integer redeem_freq) {
    this.redeem_freq = redeem_freq;
    return this;
  }
  private java.math.BigDecimal redeem_amount;
  public java.math.BigDecimal get_redeem_amount() {
    return redeem_amount;
  }
  public void set_redeem_amount(java.math.BigDecimal redeem_amount) {
    this.redeem_amount = redeem_amount;
  }
  public JLC_TOPIC_USER_APP with_redeem_amount(java.math.BigDecimal redeem_amount) {
    this.redeem_amount = redeem_amount;
    return this;
  }
  private Integer regular1st_num;
  public Integer get_regular1st_num() {
    return regular1st_num;
  }
  public void set_regular1st_num(Integer regular1st_num) {
    this.regular1st_num = regular1st_num;
  }
  public JLC_TOPIC_USER_APP with_regular1st_num(Integer regular1st_num) {
    this.regular1st_num = regular1st_num;
    return this;
  }
  private java.math.BigDecimal regular1st_amount;
  public java.math.BigDecimal get_regular1st_amount() {
    return regular1st_amount;
  }
  public void set_regular1st_amount(java.math.BigDecimal regular1st_amount) {
    this.regular1st_amount = regular1st_amount;
  }
  public JLC_TOPIC_USER_APP with_regular1st_amount(java.math.BigDecimal regular1st_amount) {
    this.regular1st_amount = regular1st_amount;
    return this;
  }
  private Integer regular_num;
  public Integer get_regular_num() {
    return regular_num;
  }
  public void set_regular_num(Integer regular_num) {
    this.regular_num = regular_num;
  }
  public JLC_TOPIC_USER_APP with_regular_num(Integer regular_num) {
    this.regular_num = regular_num;
    return this;
  }
  private Integer regular_freq;
  public Integer get_regular_freq() {
    return regular_freq;
  }
  public void set_regular_freq(Integer regular_freq) {
    this.regular_freq = regular_freq;
  }
  public JLC_TOPIC_USER_APP with_regular_freq(Integer regular_freq) {
    this.regular_freq = regular_freq;
    return this;
  }
  private java.math.BigDecimal regular_amount;
  public java.math.BigDecimal get_regular_amount() {
    return regular_amount;
  }
  public void set_regular_amount(java.math.BigDecimal regular_amount) {
    this.regular_amount = regular_amount;
  }
  public JLC_TOPIC_USER_APP with_regular_amount(java.math.BigDecimal regular_amount) {
    this.regular_amount = regular_amount;
    return this;
  }
  private Integer reg_open_num;
  public Integer get_reg_open_num() {
    return reg_open_num;
  }
  public void set_reg_open_num(Integer reg_open_num) {
    this.reg_open_num = reg_open_num;
  }
  public JLC_TOPIC_USER_APP with_reg_open_num(Integer reg_open_num) {
    this.reg_open_num = reg_open_num;
    return this;
  }
  private Integer reg_inv1st_num;
  public Integer get_reg_inv1st_num() {
    return reg_inv1st_num;
  }
  public void set_reg_inv1st_num(Integer reg_inv1st_num) {
    this.reg_inv1st_num = reg_inv1st_num;
  }
  public JLC_TOPIC_USER_APP with_reg_inv1st_num(Integer reg_inv1st_num) {
    this.reg_inv1st_num = reg_inv1st_num;
    return this;
  }
  private java.math.BigDecimal reg_inv1st_amount;
  public java.math.BigDecimal get_reg_inv1st_amount() {
    return reg_inv1st_amount;
  }
  public void set_reg_inv1st_amount(java.math.BigDecimal reg_inv1st_amount) {
    this.reg_inv1st_amount = reg_inv1st_amount;
  }
  public JLC_TOPIC_USER_APP with_reg_inv1st_amount(java.math.BigDecimal reg_inv1st_amount) {
    this.reg_inv1st_amount = reg_inv1st_amount;
    return this;
  }
  private Integer reg_inv2nd_num;
  public Integer get_reg_inv2nd_num() {
    return reg_inv2nd_num;
  }
  public void set_reg_inv2nd_num(Integer reg_inv2nd_num) {
    this.reg_inv2nd_num = reg_inv2nd_num;
  }
  public JLC_TOPIC_USER_APP with_reg_inv2nd_num(Integer reg_inv2nd_num) {
    this.reg_inv2nd_num = reg_inv2nd_num;
    return this;
  }
  private java.math.BigDecimal reg_inv2nd_amount;
  public java.math.BigDecimal get_reg_inv2nd_amount() {
    return reg_inv2nd_amount;
  }
  public void set_reg_inv2nd_amount(java.math.BigDecimal reg_inv2nd_amount) {
    this.reg_inv2nd_amount = reg_inv2nd_amount;
  }
  public JLC_TOPIC_USER_APP with_reg_inv2nd_amount(java.math.BigDecimal reg_inv2nd_amount) {
    this.reg_inv2nd_amount = reg_inv2nd_amount;
    return this;
  }
  private Integer reg_inv3rdm_num;
  public Integer get_reg_inv3rdm_num() {
    return reg_inv3rdm_num;
  }
  public void set_reg_inv3rdm_num(Integer reg_inv3rdm_num) {
    this.reg_inv3rdm_num = reg_inv3rdm_num;
  }
  public JLC_TOPIC_USER_APP with_reg_inv3rdm_num(Integer reg_inv3rdm_num) {
    this.reg_inv3rdm_num = reg_inv3rdm_num;
    return this;
  }
  private java.math.BigDecimal reg_inv3rdm_amount;
  public java.math.BigDecimal get_reg_inv3rdm_amount() {
    return reg_inv3rdm_amount;
  }
  public void set_reg_inv3rdm_amount(java.math.BigDecimal reg_inv3rdm_amount) {
    this.reg_inv3rdm_amount = reg_inv3rdm_amount;
  }
  public JLC_TOPIC_USER_APP with_reg_inv3rdm_amount(java.math.BigDecimal reg_inv3rdm_amount) {
    this.reg_inv3rdm_amount = reg_inv3rdm_amount;
    return this;
  }
  private java.math.BigDecimal reg_inv1st_all_amount;
  public java.math.BigDecimal get_reg_inv1st_all_amount() {
    return reg_inv1st_all_amount;
  }
  public void set_reg_inv1st_all_amount(java.math.BigDecimal reg_inv1st_all_amount) {
    this.reg_inv1st_all_amount = reg_inv1st_all_amount;
  }
  public JLC_TOPIC_USER_APP with_reg_inv1st_all_amount(java.math.BigDecimal reg_inv1st_all_amount) {
    this.reg_inv1st_all_amount = reg_inv1st_all_amount;
    return this;
  }
  private Integer reg_inv1st_all100_num;
  public Integer get_reg_inv1st_all100_num() {
    return reg_inv1st_all100_num;
  }
  public void set_reg_inv1st_all100_num(Integer reg_inv1st_all100_num) {
    this.reg_inv1st_all100_num = reg_inv1st_all100_num;
  }
  public JLC_TOPIC_USER_APP with_reg_inv1st_all100_num(Integer reg_inv1st_all100_num) {
    this.reg_inv1st_all100_num = reg_inv1st_all100_num;
    return this;
  }
  private java.math.BigDecimal reg_inv1st_all100_amount;
  public java.math.BigDecimal get_reg_inv1st_all100_amount() {
    return reg_inv1st_all100_amount;
  }
  public void set_reg_inv1st_all100_amount(java.math.BigDecimal reg_inv1st_all100_amount) {
    this.reg_inv1st_all100_amount = reg_inv1st_all100_amount;
  }
  public JLC_TOPIC_USER_APP with_reg_inv1st_all100_amount(java.math.BigDecimal reg_inv1st_all100_amount) {
    this.reg_inv1st_all100_amount = reg_inv1st_all100_amount;
    return this;
  }
  private Integer inv1st_inv2nd_num;
  public Integer get_inv1st_inv2nd_num() {
    return inv1st_inv2nd_num;
  }
  public void set_inv1st_inv2nd_num(Integer inv1st_inv2nd_num) {
    this.inv1st_inv2nd_num = inv1st_inv2nd_num;
  }
  public JLC_TOPIC_USER_APP with_inv1st_inv2nd_num(Integer inv1st_inv2nd_num) {
    this.inv1st_inv2nd_num = inv1st_inv2nd_num;
    return this;
  }
  private java.math.BigDecimal inv1st_inv2nd_amount;
  public java.math.BigDecimal get_inv1st_inv2nd_amount() {
    return inv1st_inv2nd_amount;
  }
  public void set_inv1st_inv2nd_amount(java.math.BigDecimal inv1st_inv2nd_amount) {
    this.inv1st_inv2nd_amount = inv1st_inv2nd_amount;
  }
  public JLC_TOPIC_USER_APP with_inv1st_inv2nd_amount(java.math.BigDecimal inv1st_inv2nd_amount) {
    this.inv1st_inv2nd_amount = inv1st_inv2nd_amount;
    return this;
  }
  private Integer inv1st_inv3rdm_num;
  public Integer get_inv1st_inv3rdm_num() {
    return inv1st_inv3rdm_num;
  }
  public void set_inv1st_inv3rdm_num(Integer inv1st_inv3rdm_num) {
    this.inv1st_inv3rdm_num = inv1st_inv3rdm_num;
  }
  public JLC_TOPIC_USER_APP with_inv1st_inv3rdm_num(Integer inv1st_inv3rdm_num) {
    this.inv1st_inv3rdm_num = inv1st_inv3rdm_num;
    return this;
  }
  private java.math.BigDecimal inv1st_inv3rdm_amount;
  public java.math.BigDecimal get_inv1st_inv3rdm_amount() {
    return inv1st_inv3rdm_amount;
  }
  public void set_inv1st_inv3rdm_amount(java.math.BigDecimal inv1st_inv3rdm_amount) {
    this.inv1st_inv3rdm_amount = inv1st_inv3rdm_amount;
  }
  public JLC_TOPIC_USER_APP with_inv1st_inv3rdm_amount(java.math.BigDecimal inv1st_inv3rdm_amount) {
    this.inv1st_inv3rdm_amount = inv1st_inv3rdm_amount;
    return this;
  }
  private java.math.BigDecimal exp_amount;
  public java.math.BigDecimal get_exp_amount() {
    return exp_amount;
  }
  public void set_exp_amount(java.math.BigDecimal exp_amount) {
    this.exp_amount = exp_amount;
  }
  public JLC_TOPIC_USER_APP with_exp_amount(java.math.BigDecimal exp_amount) {
    this.exp_amount = exp_amount;
    return this;
  }
  private java.math.BigDecimal exp_int_amount;
  public java.math.BigDecimal get_exp_int_amount() {
    return exp_int_amount;
  }
  public void set_exp_int_amount(java.math.BigDecimal exp_int_amount) {
    this.exp_int_amount = exp_int_amount;
  }
  public JLC_TOPIC_USER_APP with_exp_int_amount(java.math.BigDecimal exp_int_amount) {
    this.exp_int_amount = exp_int_amount;
    return this;
  }
  private java.math.BigDecimal exp_recover_amount;
  public java.math.BigDecimal get_exp_recover_amount() {
    return exp_recover_amount;
  }
  public void set_exp_recover_amount(java.math.BigDecimal exp_recover_amount) {
    this.exp_recover_amount = exp_recover_amount;
  }
  public JLC_TOPIC_USER_APP with_exp_recover_amount(java.math.BigDecimal exp_recover_amount) {
    this.exp_recover_amount = exp_recover_amount;
    return this;
  }
  private Integer regular_1_num;
  public Integer get_regular_1_num() {
    return regular_1_num;
  }
  public void set_regular_1_num(Integer regular_1_num) {
    this.regular_1_num = regular_1_num;
  }
  public JLC_TOPIC_USER_APP with_regular_1_num(Integer regular_1_num) {
    this.regular_1_num = regular_1_num;
    return this;
  }
  private java.math.BigDecimal regular_1_amount;
  public java.math.BigDecimal get_regular_1_amount() {
    return regular_1_amount;
  }
  public void set_regular_1_amount(java.math.BigDecimal regular_1_amount) {
    this.regular_1_amount = regular_1_amount;
  }
  public JLC_TOPIC_USER_APP with_regular_1_amount(java.math.BigDecimal regular_1_amount) {
    this.regular_1_amount = regular_1_amount;
    return this;
  }
  private Integer regular_2_num;
  public Integer get_regular_2_num() {
    return regular_2_num;
  }
  public void set_regular_2_num(Integer regular_2_num) {
    this.regular_2_num = regular_2_num;
  }
  public JLC_TOPIC_USER_APP with_regular_2_num(Integer regular_2_num) {
    this.regular_2_num = regular_2_num;
    return this;
  }
  private java.math.BigDecimal regular_2_amount;
  public java.math.BigDecimal get_regular_2_amount() {
    return regular_2_amount;
  }
  public void set_regular_2_amount(java.math.BigDecimal regular_2_amount) {
    this.regular_2_amount = regular_2_amount;
  }
  public JLC_TOPIC_USER_APP with_regular_2_amount(java.math.BigDecimal regular_2_amount) {
    this.regular_2_amount = regular_2_amount;
    return this;
  }
  private Integer regular_3_num;
  public Integer get_regular_3_num() {
    return regular_3_num;
  }
  public void set_regular_3_num(Integer regular_3_num) {
    this.regular_3_num = regular_3_num;
  }
  public JLC_TOPIC_USER_APP with_regular_3_num(Integer regular_3_num) {
    this.regular_3_num = regular_3_num;
    return this;
  }
  private java.math.BigDecimal regular_3_amount;
  public java.math.BigDecimal get_regular_3_amount() {
    return regular_3_amount;
  }
  public void set_regular_3_amount(java.math.BigDecimal regular_3_amount) {
    this.regular_3_amount = regular_3_amount;
  }
  public JLC_TOPIC_USER_APP with_regular_3_amount(java.math.BigDecimal regular_3_amount) {
    this.regular_3_amount = regular_3_amount;
    return this;
  }
  private Integer regular_4_num;
  public Integer get_regular_4_num() {
    return regular_4_num;
  }
  public void set_regular_4_num(Integer regular_4_num) {
    this.regular_4_num = regular_4_num;
  }
  public JLC_TOPIC_USER_APP with_regular_4_num(Integer regular_4_num) {
    this.regular_4_num = regular_4_num;
    return this;
  }
  private java.math.BigDecimal regular_4_amount;
  public java.math.BigDecimal get_regular_4_amount() {
    return regular_4_amount;
  }
  public void set_regular_4_amount(java.math.BigDecimal regular_4_amount) {
    this.regular_4_amount = regular_4_amount;
  }
  public JLC_TOPIC_USER_APP with_regular_4_amount(java.math.BigDecimal regular_4_amount) {
    this.regular_4_amount = regular_4_amount;
    return this;
  }
  private Integer regular_5_num;
  public Integer get_regular_5_num() {
    return regular_5_num;
  }
  public void set_regular_5_num(Integer regular_5_num) {
    this.regular_5_num = regular_5_num;
  }
  public JLC_TOPIC_USER_APP with_regular_5_num(Integer regular_5_num) {
    this.regular_5_num = regular_5_num;
    return this;
  }
  private java.math.BigDecimal regular_5_amount;
  public java.math.BigDecimal get_regular_5_amount() {
    return regular_5_amount;
  }
  public void set_regular_5_amount(java.math.BigDecimal regular_5_amount) {
    this.regular_5_amount = regular_5_amount;
  }
  public JLC_TOPIC_USER_APP with_regular_5_amount(java.math.BigDecimal regular_5_amount) {
    this.regular_5_amount = regular_5_amount;
    return this;
  }
  private Integer regular_6_num;
  public Integer get_regular_6_num() {
    return regular_6_num;
  }
  public void set_regular_6_num(Integer regular_6_num) {
    this.regular_6_num = regular_6_num;
  }
  public JLC_TOPIC_USER_APP with_regular_6_num(Integer regular_6_num) {
    this.regular_6_num = regular_6_num;
    return this;
  }
  private java.math.BigDecimal regular_6_amount;
  public java.math.BigDecimal get_regular_6_amount() {
    return regular_6_amount;
  }
  public void set_regular_6_amount(java.math.BigDecimal regular_6_amount) {
    this.regular_6_amount = regular_6_amount;
  }
  public JLC_TOPIC_USER_APP with_regular_6_amount(java.math.BigDecimal regular_6_amount) {
    this.regular_6_amount = regular_6_amount;
    return this;
  }
  private Integer regular_7_num;
  public Integer get_regular_7_num() {
    return regular_7_num;
  }
  public void set_regular_7_num(Integer regular_7_num) {
    this.regular_7_num = regular_7_num;
  }
  public JLC_TOPIC_USER_APP with_regular_7_num(Integer regular_7_num) {
    this.regular_7_num = regular_7_num;
    return this;
  }
  private java.math.BigDecimal regular_7_amount;
  public java.math.BigDecimal get_regular_7_amount() {
    return regular_7_amount;
  }
  public void set_regular_7_amount(java.math.BigDecimal regular_7_amount) {
    this.regular_7_amount = regular_7_amount;
  }
  public JLC_TOPIC_USER_APP with_regular_7_amount(java.math.BigDecimal regular_7_amount) {
    this.regular_7_amount = regular_7_amount;
    return this;
  }
  private Integer regular_8_num;
  public Integer get_regular_8_num() {
    return regular_8_num;
  }
  public void set_regular_8_num(Integer regular_8_num) {
    this.regular_8_num = regular_8_num;
  }
  public JLC_TOPIC_USER_APP with_regular_8_num(Integer regular_8_num) {
    this.regular_8_num = regular_8_num;
    return this;
  }
  private java.math.BigDecimal regular_8_amount;
  public java.math.BigDecimal get_regular_8_amount() {
    return regular_8_amount;
  }
  public void set_regular_8_amount(java.math.BigDecimal regular_8_amount) {
    this.regular_8_amount = regular_8_amount;
  }
  public JLC_TOPIC_USER_APP with_regular_8_amount(java.math.BigDecimal regular_8_amount) {
    this.regular_8_amount = regular_8_amount;
    return this;
  }
  private Integer regular_9_num;
  public Integer get_regular_9_num() {
    return regular_9_num;
  }
  public void set_regular_9_num(Integer regular_9_num) {
    this.regular_9_num = regular_9_num;
  }
  public JLC_TOPIC_USER_APP with_regular_9_num(Integer regular_9_num) {
    this.regular_9_num = regular_9_num;
    return this;
  }
  private java.math.BigDecimal regular_9_amount;
  public java.math.BigDecimal get_regular_9_amount() {
    return regular_9_amount;
  }
  public void set_regular_9_amount(java.math.BigDecimal regular_9_amount) {
    this.regular_9_amount = regular_9_amount;
  }
  public JLC_TOPIC_USER_APP with_regular_9_amount(java.math.BigDecimal regular_9_amount) {
    this.regular_9_amount = regular_9_amount;
    return this;
  }
  private Integer regular_10_num;
  public Integer get_regular_10_num() {
    return regular_10_num;
  }
  public void set_regular_10_num(Integer regular_10_num) {
    this.regular_10_num = regular_10_num;
  }
  public JLC_TOPIC_USER_APP with_regular_10_num(Integer regular_10_num) {
    this.regular_10_num = regular_10_num;
    return this;
  }
  private java.math.BigDecimal regular_10_amount;
  public java.math.BigDecimal get_regular_10_amount() {
    return regular_10_amount;
  }
  public void set_regular_10_amount(java.math.BigDecimal regular_10_amount) {
    this.regular_10_amount = regular_10_amount;
  }
  public JLC_TOPIC_USER_APP with_regular_10_amount(java.math.BigDecimal regular_10_amount) {
    this.regular_10_amount = regular_10_amount;
    return this;
  }
  private Integer regular_11_num;
  public Integer get_regular_11_num() {
    return regular_11_num;
  }
  public void set_regular_11_num(Integer regular_11_num) {
    this.regular_11_num = regular_11_num;
  }
  public JLC_TOPIC_USER_APP with_regular_11_num(Integer regular_11_num) {
    this.regular_11_num = regular_11_num;
    return this;
  }
  private java.math.BigDecimal regular_11_amount;
  public java.math.BigDecimal get_regular_11_amount() {
    return regular_11_amount;
  }
  public void set_regular_11_amount(java.math.BigDecimal regular_11_amount) {
    this.regular_11_amount = regular_11_amount;
  }
  public JLC_TOPIC_USER_APP with_regular_11_amount(java.math.BigDecimal regular_11_amount) {
    this.regular_11_amount = regular_11_amount;
    return this;
  }
  private Integer regular_12_num;
  public Integer get_regular_12_num() {
    return regular_12_num;
  }
  public void set_regular_12_num(Integer regular_12_num) {
    this.regular_12_num = regular_12_num;
  }
  public JLC_TOPIC_USER_APP with_regular_12_num(Integer regular_12_num) {
    this.regular_12_num = regular_12_num;
    return this;
  }
  private java.math.BigDecimal regular_12_amount;
  public java.math.BigDecimal get_regular_12_amount() {
    return regular_12_amount;
  }
  public void set_regular_12_amount(java.math.BigDecimal regular_12_amount) {
    this.regular_12_amount = regular_12_amount;
  }
  public JLC_TOPIC_USER_APP with_regular_12_amount(java.math.BigDecimal regular_12_amount) {
    this.regular_12_amount = regular_12_amount;
    return this;
  }
  private java.math.BigDecimal regular_premium;
  public java.math.BigDecimal get_regular_premium() {
    return regular_premium;
  }
  public void set_regular_premium(java.math.BigDecimal regular_premium) {
    this.regular_premium = regular_premium;
  }
  public JLC_TOPIC_USER_APP with_regular_premium(java.math.BigDecimal regular_premium) {
    this.regular_premium = regular_premium;
    return this;
  }
  private java.math.BigDecimal regular_expire;
  public java.math.BigDecimal get_regular_expire() {
    return regular_expire;
  }
  public void set_regular_expire(java.math.BigDecimal regular_expire) {
    this.regular_expire = regular_expire;
  }
  public JLC_TOPIC_USER_APP with_regular_expire(java.math.BigDecimal regular_expire) {
    this.regular_expire = regular_expire;
    return this;
  }
  private java.math.BigDecimal regular_premium_1;
  public java.math.BigDecimal get_regular_premium_1() {
    return regular_premium_1;
  }
  public void set_regular_premium_1(java.math.BigDecimal regular_premium_1) {
    this.regular_premium_1 = regular_premium_1;
  }
  public JLC_TOPIC_USER_APP with_regular_premium_1(java.math.BigDecimal regular_premium_1) {
    this.regular_premium_1 = regular_premium_1;
    return this;
  }
  private java.math.BigDecimal regular_premium_2;
  public java.math.BigDecimal get_regular_premium_2() {
    return regular_premium_2;
  }
  public void set_regular_premium_2(java.math.BigDecimal regular_premium_2) {
    this.regular_premium_2 = regular_premium_2;
  }
  public JLC_TOPIC_USER_APP with_regular_premium_2(java.math.BigDecimal regular_premium_2) {
    this.regular_premium_2 = regular_premium_2;
    return this;
  }
  private java.math.BigDecimal regular_premium_3;
  public java.math.BigDecimal get_regular_premium_3() {
    return regular_premium_3;
  }
  public void set_regular_premium_3(java.math.BigDecimal regular_premium_3) {
    this.regular_premium_3 = regular_premium_3;
  }
  public JLC_TOPIC_USER_APP with_regular_premium_3(java.math.BigDecimal regular_premium_3) {
    this.regular_premium_3 = regular_premium_3;
    return this;
  }
  private java.math.BigDecimal regular_premium_4;
  public java.math.BigDecimal get_regular_premium_4() {
    return regular_premium_4;
  }
  public void set_regular_premium_4(java.math.BigDecimal regular_premium_4) {
    this.regular_premium_4 = regular_premium_4;
  }
  public JLC_TOPIC_USER_APP with_regular_premium_4(java.math.BigDecimal regular_premium_4) {
    this.regular_premium_4 = regular_premium_4;
    return this;
  }
  private java.math.BigDecimal regular_premium_5;
  public java.math.BigDecimal get_regular_premium_5() {
    return regular_premium_5;
  }
  public void set_regular_premium_5(java.math.BigDecimal regular_premium_5) {
    this.regular_premium_5 = regular_premium_5;
  }
  public JLC_TOPIC_USER_APP with_regular_premium_5(java.math.BigDecimal regular_premium_5) {
    this.regular_premium_5 = regular_premium_5;
    return this;
  }
  private java.math.BigDecimal regular_premium_6;
  public java.math.BigDecimal get_regular_premium_6() {
    return regular_premium_6;
  }
  public void set_regular_premium_6(java.math.BigDecimal regular_premium_6) {
    this.regular_premium_6 = regular_premium_6;
  }
  public JLC_TOPIC_USER_APP with_regular_premium_6(java.math.BigDecimal regular_premium_6) {
    this.regular_premium_6 = regular_premium_6;
    return this;
  }
  private java.math.BigDecimal regular_premium_7;
  public java.math.BigDecimal get_regular_premium_7() {
    return regular_premium_7;
  }
  public void set_regular_premium_7(java.math.BigDecimal regular_premium_7) {
    this.regular_premium_7 = regular_premium_7;
  }
  public JLC_TOPIC_USER_APP with_regular_premium_7(java.math.BigDecimal regular_premium_7) {
    this.regular_premium_7 = regular_premium_7;
    return this;
  }
  private java.math.BigDecimal regular_premium_8;
  public java.math.BigDecimal get_regular_premium_8() {
    return regular_premium_8;
  }
  public void set_regular_premium_8(java.math.BigDecimal regular_premium_8) {
    this.regular_premium_8 = regular_premium_8;
  }
  public JLC_TOPIC_USER_APP with_regular_premium_8(java.math.BigDecimal regular_premium_8) {
    this.regular_premium_8 = regular_premium_8;
    return this;
  }
  private java.math.BigDecimal regular_premium_9;
  public java.math.BigDecimal get_regular_premium_9() {
    return regular_premium_9;
  }
  public void set_regular_premium_9(java.math.BigDecimal regular_premium_9) {
    this.regular_premium_9 = regular_premium_9;
  }
  public JLC_TOPIC_USER_APP with_regular_premium_9(java.math.BigDecimal regular_premium_9) {
    this.regular_premium_9 = regular_premium_9;
    return this;
  }
  private java.math.BigDecimal regular_premium_10;
  public java.math.BigDecimal get_regular_premium_10() {
    return regular_premium_10;
  }
  public void set_regular_premium_10(java.math.BigDecimal regular_premium_10) {
    this.regular_premium_10 = regular_premium_10;
  }
  public JLC_TOPIC_USER_APP with_regular_premium_10(java.math.BigDecimal regular_premium_10) {
    this.regular_premium_10 = regular_premium_10;
    return this;
  }
  private java.math.BigDecimal regular_premium_11;
  public java.math.BigDecimal get_regular_premium_11() {
    return regular_premium_11;
  }
  public void set_regular_premium_11(java.math.BigDecimal regular_premium_11) {
    this.regular_premium_11 = regular_premium_11;
  }
  public JLC_TOPIC_USER_APP with_regular_premium_11(java.math.BigDecimal regular_premium_11) {
    this.regular_premium_11 = regular_premium_11;
    return this;
  }
  private java.math.BigDecimal regular_premium_12;
  public java.math.BigDecimal get_regular_premium_12() {
    return regular_premium_12;
  }
  public void set_regular_premium_12(java.math.BigDecimal regular_premium_12) {
    this.regular_premium_12 = regular_premium_12;
  }
  public JLC_TOPIC_USER_APP with_regular_premium_12(java.math.BigDecimal regular_premium_12) {
    this.regular_premium_12 = regular_premium_12;
    return this;
  }
  private Integer inv_interval_1k;
  public Integer get_inv_interval_1k() {
    return inv_interval_1k;
  }
  public void set_inv_interval_1k(Integer inv_interval_1k) {
    this.inv_interval_1k = inv_interval_1k;
  }
  public JLC_TOPIC_USER_APP with_inv_interval_1k(Integer inv_interval_1k) {
    this.inv_interval_1k = inv_interval_1k;
    return this;
  }
  private Integer inv_interval_5k;
  public Integer get_inv_interval_5k() {
    return inv_interval_5k;
  }
  public void set_inv_interval_5k(Integer inv_interval_5k) {
    this.inv_interval_5k = inv_interval_5k;
  }
  public JLC_TOPIC_USER_APP with_inv_interval_5k(Integer inv_interval_5k) {
    this.inv_interval_5k = inv_interval_5k;
    return this;
  }
  private Integer inv_interval_1w;
  public Integer get_inv_interval_1w() {
    return inv_interval_1w;
  }
  public void set_inv_interval_1w(Integer inv_interval_1w) {
    this.inv_interval_1w = inv_interval_1w;
  }
  public JLC_TOPIC_USER_APP with_inv_interval_1w(Integer inv_interval_1w) {
    this.inv_interval_1w = inv_interval_1w;
    return this;
  }
  private Integer inv_interval_2w;
  public Integer get_inv_interval_2w() {
    return inv_interval_2w;
  }
  public void set_inv_interval_2w(Integer inv_interval_2w) {
    this.inv_interval_2w = inv_interval_2w;
  }
  public JLC_TOPIC_USER_APP with_inv_interval_2w(Integer inv_interval_2w) {
    this.inv_interval_2w = inv_interval_2w;
    return this;
  }
  private Integer inv_interval_5w;
  public Integer get_inv_interval_5w() {
    return inv_interval_5w;
  }
  public void set_inv_interval_5w(Integer inv_interval_5w) {
    this.inv_interval_5w = inv_interval_5w;
  }
  public JLC_TOPIC_USER_APP with_inv_interval_5w(Integer inv_interval_5w) {
    this.inv_interval_5w = inv_interval_5w;
    return this;
  }
  private Integer inv_interval_10w;
  public Integer get_inv_interval_10w() {
    return inv_interval_10w;
  }
  public void set_inv_interval_10w(Integer inv_interval_10w) {
    this.inv_interval_10w = inv_interval_10w;
  }
  public JLC_TOPIC_USER_APP with_inv_interval_10w(Integer inv_interval_10w) {
    this.inv_interval_10w = inv_interval_10w;
    return this;
  }
  private Integer inv_interval_20w;
  public Integer get_inv_interval_20w() {
    return inv_interval_20w;
  }
  public void set_inv_interval_20w(Integer inv_interval_20w) {
    this.inv_interval_20w = inv_interval_20w;
  }
  public JLC_TOPIC_USER_APP with_inv_interval_20w(Integer inv_interval_20w) {
    this.inv_interval_20w = inv_interval_20w;
    return this;
  }
  private Integer inv_interval_20wm;
  public Integer get_inv_interval_20wm() {
    return inv_interval_20wm;
  }
  public void set_inv_interval_20wm(Integer inv_interval_20wm) {
    this.inv_interval_20wm = inv_interval_20wm;
  }
  public JLC_TOPIC_USER_APP with_inv_interval_20wm(Integer inv_interval_20wm) {
    this.inv_interval_20wm = inv_interval_20wm;
    return this;
  }
  private Integer red_interval_1h;
  public Integer get_red_interval_1h() {
    return red_interval_1h;
  }
  public void set_red_interval_1h(Integer red_interval_1h) {
    this.red_interval_1h = red_interval_1h;
  }
  public JLC_TOPIC_USER_APP with_red_interval_1h(Integer red_interval_1h) {
    this.red_interval_1h = red_interval_1h;
    return this;
  }
  private Integer red_interval_1k;
  public Integer get_red_interval_1k() {
    return red_interval_1k;
  }
  public void set_red_interval_1k(Integer red_interval_1k) {
    this.red_interval_1k = red_interval_1k;
  }
  public JLC_TOPIC_USER_APP with_red_interval_1k(Integer red_interval_1k) {
    this.red_interval_1k = red_interval_1k;
    return this;
  }
  private Integer red_interval_5k;
  public Integer get_red_interval_5k() {
    return red_interval_5k;
  }
  public void set_red_interval_5k(Integer red_interval_5k) {
    this.red_interval_5k = red_interval_5k;
  }
  public JLC_TOPIC_USER_APP with_red_interval_5k(Integer red_interval_5k) {
    this.red_interval_5k = red_interval_5k;
    return this;
  }
  private Integer red_interval_1w;
  public Integer get_red_interval_1w() {
    return red_interval_1w;
  }
  public void set_red_interval_1w(Integer red_interval_1w) {
    this.red_interval_1w = red_interval_1w;
  }
  public JLC_TOPIC_USER_APP with_red_interval_1w(Integer red_interval_1w) {
    this.red_interval_1w = red_interval_1w;
    return this;
  }
  private Integer red_interval_2w;
  public Integer get_red_interval_2w() {
    return red_interval_2w;
  }
  public void set_red_interval_2w(Integer red_interval_2w) {
    this.red_interval_2w = red_interval_2w;
  }
  public JLC_TOPIC_USER_APP with_red_interval_2w(Integer red_interval_2w) {
    this.red_interval_2w = red_interval_2w;
    return this;
  }
  private Integer red_interval_5w;
  public Integer get_red_interval_5w() {
    return red_interval_5w;
  }
  public void set_red_interval_5w(Integer red_interval_5w) {
    this.red_interval_5w = red_interval_5w;
  }
  public JLC_TOPIC_USER_APP with_red_interval_5w(Integer red_interval_5w) {
    this.red_interval_5w = red_interval_5w;
    return this;
  }
  private Integer red_interval_10w;
  public Integer get_red_interval_10w() {
    return red_interval_10w;
  }
  public void set_red_interval_10w(Integer red_interval_10w) {
    this.red_interval_10w = red_interval_10w;
  }
  public JLC_TOPIC_USER_APP with_red_interval_10w(Integer red_interval_10w) {
    this.red_interval_10w = red_interval_10w;
    return this;
  }
  private Integer red_interval_20w;
  public Integer get_red_interval_20w() {
    return red_interval_20w;
  }
  public void set_red_interval_20w(Integer red_interval_20w) {
    this.red_interval_20w = red_interval_20w;
  }
  public JLC_TOPIC_USER_APP with_red_interval_20w(Integer red_interval_20w) {
    this.red_interval_20w = red_interval_20w;
    return this;
  }
  private java.math.BigDecimal inv_diff;
  public java.math.BigDecimal get_inv_diff() {
    return inv_diff;
  }
  public void set_inv_diff(java.math.BigDecimal inv_diff) {
    this.inv_diff = inv_diff;
  }
  public JLC_TOPIC_USER_APP with_inv_diff(java.math.BigDecimal inv_diff) {
    this.inv_diff = inv_diff;
    return this;
  }
  private java.math.BigDecimal inv100_diff;
  public java.math.BigDecimal get_inv100_diff() {
    return inv100_diff;
  }
  public void set_inv100_diff(java.math.BigDecimal inv100_diff) {
    this.inv100_diff = inv100_diff;
  }
  public JLC_TOPIC_USER_APP with_inv100_diff(java.math.BigDecimal inv100_diff) {
    this.inv100_diff = inv100_diff;
    return this;
  }
  private java.math.BigDecimal inv1st_diff;
  public java.math.BigDecimal get_inv1st_diff() {
    return inv1st_diff;
  }
  public void set_inv1st_diff(java.math.BigDecimal inv1st_diff) {
    this.inv1st_diff = inv1st_diff;
  }
  public JLC_TOPIC_USER_APP with_inv1st_diff(java.math.BigDecimal inv1st_diff) {
    this.inv1st_diff = inv1st_diff;
    return this;
  }
  private java.math.BigDecimal inv1st_all_diff;
  public java.math.BigDecimal get_inv1st_all_diff() {
    return inv1st_all_diff;
  }
  public void set_inv1st_all_diff(java.math.BigDecimal inv1st_all_diff) {
    this.inv1st_all_diff = inv1st_all_diff;
  }
  public JLC_TOPIC_USER_APP with_inv1st_all_diff(java.math.BigDecimal inv1st_all_diff) {
    this.inv1st_all_diff = inv1st_all_diff;
    return this;
  }
  private java.math.BigDecimal reg_inv_diff;
  public java.math.BigDecimal get_reg_inv_diff() {
    return reg_inv_diff;
  }
  public void set_reg_inv_diff(java.math.BigDecimal reg_inv_diff) {
    this.reg_inv_diff = reg_inv_diff;
  }
  public JLC_TOPIC_USER_APP with_reg_inv_diff(java.math.BigDecimal reg_inv_diff) {
    this.reg_inv_diff = reg_inv_diff;
    return this;
  }
  private Integer invre_red_num;
  public Integer get_invre_red_num() {
    return invre_red_num;
  }
  public void set_invre_red_num(Integer invre_red_num) {
    this.invre_red_num = invre_red_num;
  }
  public JLC_TOPIC_USER_APP with_invre_red_num(Integer invre_red_num) {
    this.invre_red_num = invre_red_num;
    return this;
  }
  private java.math.BigDecimal invre_red_amount;
  public java.math.BigDecimal get_invre_red_amount() {
    return invre_red_amount;
  }
  public void set_invre_red_amount(java.math.BigDecimal invre_red_amount) {
    this.invre_red_amount = invre_red_amount;
  }
  public JLC_TOPIC_USER_APP with_invre_red_amount(java.math.BigDecimal invre_red_amount) {
    this.invre_red_amount = invre_red_amount;
    return this;
  }
  private Integer churn_num;
  public Integer get_churn_num() {
    return churn_num;
  }
  public void set_churn_num(Integer churn_num) {
    this.churn_num = churn_num;
  }
  public JLC_TOPIC_USER_APP with_churn_num(Integer churn_num) {
    this.churn_num = churn_num;
    return this;
  }
  private java.math.BigDecimal premium;
  public java.math.BigDecimal get_premium() {
    return premium;
  }
  public void set_premium(java.math.BigDecimal premium) {
    this.premium = premium;
  }
  public JLC_TOPIC_USER_APP with_premium(java.math.BigDecimal premium) {
    this.premium = premium;
    return this;
  }
  private java.math.BigDecimal premium_diff;
  public java.math.BigDecimal get_premium_diff() {
    return premium_diff;
  }
  public void set_premium_diff(java.math.BigDecimal premium_diff) {
    this.premium_diff = premium_diff;
  }
  public JLC_TOPIC_USER_APP with_premium_diff(java.math.BigDecimal premium_diff) {
    this.premium_diff = premium_diff;
    return this;
  }
  private java.math.BigDecimal premium_cur;
  public java.math.BigDecimal get_premium_cur() {
    return premium_cur;
  }
  public void set_premium_cur(java.math.BigDecimal premium_cur) {
    this.premium_cur = premium_cur;
  }
  public JLC_TOPIC_USER_APP with_premium_cur(java.math.BigDecimal premium_cur) {
    this.premium_cur = premium_cur;
    return this;
  }
  private Integer inv_old_num;
  public Integer get_inv_old_num() {
    return inv_old_num;
  }
  public void set_inv_old_num(Integer inv_old_num) {
    this.inv_old_num = inv_old_num;
  }
  public JLC_TOPIC_USER_APP with_inv_old_num(Integer inv_old_num) {
    this.inv_old_num = inv_old_num;
    return this;
  }
  private java.math.BigDecimal inv_old_amount;
  public java.math.BigDecimal get_inv_old_amount() {
    return inv_old_amount;
  }
  public void set_inv_old_amount(java.math.BigDecimal inv_old_amount) {
    this.inv_old_amount = inv_old_amount;
  }
  public JLC_TOPIC_USER_APP with_inv_old_amount(java.math.BigDecimal inv_old_amount) {
    this.inv_old_amount = inv_old_amount;
    return this;
  }
  private java.math.BigDecimal inv_old_premium_diff;
  public java.math.BigDecimal get_inv_old_premium_diff() {
    return inv_old_premium_diff;
  }
  public void set_inv_old_premium_diff(java.math.BigDecimal inv_old_premium_diff) {
    this.inv_old_premium_diff = inv_old_premium_diff;
  }
  public JLC_TOPIC_USER_APP with_inv_old_premium_diff(java.math.BigDecimal inv_old_premium_diff) {
    this.inv_old_premium_diff = inv_old_premium_diff;
    return this;
  }
  private Integer before_reg_inv1st_num;
  public Integer get_before_reg_inv1st_num() {
    return before_reg_inv1st_num;
  }
  public void set_before_reg_inv1st_num(Integer before_reg_inv1st_num) {
    this.before_reg_inv1st_num = before_reg_inv1st_num;
  }
  public JLC_TOPIC_USER_APP with_before_reg_inv1st_num(Integer before_reg_inv1st_num) {
    this.before_reg_inv1st_num = before_reg_inv1st_num;
    return this;
  }
  private java.math.BigDecimal before_reg_inv1st_all_amount;
  public java.math.BigDecimal get_before_reg_inv1st_all_amount() {
    return before_reg_inv1st_all_amount;
  }
  public void set_before_reg_inv1st_all_amount(java.math.BigDecimal before_reg_inv1st_all_amount) {
    this.before_reg_inv1st_all_amount = before_reg_inv1st_all_amount;
  }
  public JLC_TOPIC_USER_APP with_before_reg_inv1st_all_amount(java.math.BigDecimal before_reg_inv1st_all_amount) {
    this.before_reg_inv1st_all_amount = before_reg_inv1st_all_amount;
    return this;
  }
  private java.math.BigDecimal before_reg_inv1st_premium_diff;
  public java.math.BigDecimal get_before_reg_inv1st_premium_diff() {
    return before_reg_inv1st_premium_diff;
  }
  public void set_before_reg_inv1st_premium_diff(java.math.BigDecimal before_reg_inv1st_premium_diff) {
    this.before_reg_inv1st_premium_diff = before_reg_inv1st_premium_diff;
  }
  public JLC_TOPIC_USER_APP with_before_reg_inv1st_premium_diff(java.math.BigDecimal before_reg_inv1st_premium_diff) {
    this.before_reg_inv1st_premium_diff = before_reg_inv1st_premium_diff;
    return this;
  }
  private java.math.BigDecimal inv1st_premium_diff;
  public java.math.BigDecimal get_inv1st_premium_diff() {
    return inv1st_premium_diff;
  }
  public void set_inv1st_premium_diff(java.math.BigDecimal inv1st_premium_diff) {
    this.inv1st_premium_diff = inv1st_premium_diff;
  }
  public JLC_TOPIC_USER_APP with_inv1st_premium_diff(java.math.BigDecimal inv1st_premium_diff) {
    this.inv1st_premium_diff = inv1st_premium_diff;
    return this;
  }
  private java.math.BigDecimal reg_inv1st_premium_diff;
  public java.math.BigDecimal get_reg_inv1st_premium_diff() {
    return reg_inv1st_premium_diff;
  }
  public void set_reg_inv1st_premium_diff(java.math.BigDecimal reg_inv1st_premium_diff) {
    this.reg_inv1st_premium_diff = reg_inv1st_premium_diff;
  }
  public JLC_TOPIC_USER_APP with_reg_inv1st_premium_diff(java.math.BigDecimal reg_inv1st_premium_diff) {
    this.reg_inv1st_premium_diff = reg_inv1st_premium_diff;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof JLC_TOPIC_USER_APP)) {
      return false;
    }
    JLC_TOPIC_USER_APP that = (JLC_TOPIC_USER_APP) o;
    boolean equal = true;
    equal = equal && (this.create_date == null ? that.create_date == null : this.create_date.equals(that.create_date));
    equal = equal && (this.end_date == null ? that.end_date == null : this.end_date.equals(that.end_date));
    equal = equal && (this.channel == null ? that.channel == null : this.channel.equals(that.channel));
    equal = equal && (this.period == null ? that.period == null : this.period.equals(that.period));
    equal = equal && (this.activity_num == null ? that.activity_num == null : this.activity_num.equals(that.activity_num));
    equal = equal && (this.reg_num == null ? that.reg_num == null : this.reg_num.equals(that.reg_num));
    equal = equal && (this.open_num == null ? that.open_num == null : this.open_num.equals(that.open_num));
    equal = equal && (this.inv_num == null ? that.inv_num == null : this.inv_num.equals(that.inv_num));
    equal = equal && (this.inv_freq == null ? that.inv_freq == null : this.inv_freq.equals(that.inv_freq));
    equal = equal && (this.inv_amount == null ? that.inv_amount == null : this.inv_amount.equals(that.inv_amount));
    equal = equal && (this.inv100_num == null ? that.inv100_num == null : this.inv100_num.equals(that.inv100_num));
    equal = equal && (this.inv100_freq == null ? that.inv100_freq == null : this.inv100_freq.equals(that.inv100_freq));
    equal = equal && (this.inv100_amount == null ? that.inv100_amount == null : this.inv100_amount.equals(that.inv100_amount));
    equal = equal && (this.inv1st_num == null ? that.inv1st_num == null : this.inv1st_num.equals(that.inv1st_num));
    equal = equal && (this.inv1st_amount == null ? that.inv1st_amount == null : this.inv1st_amount.equals(that.inv1st_amount));
    equal = equal && (this.inv1st100_num == null ? that.inv1st100_num == null : this.inv1st100_num.equals(that.inv1st100_num));
    equal = equal && (this.inv1st100_amount == null ? that.inv1st100_amount == null : this.inv1st100_amount.equals(that.inv1st100_amount));
    equal = equal && (this.inv1st_all_amont == null ? that.inv1st_all_amont == null : this.inv1st_all_amont.equals(that.inv1st_all_amont));
    equal = equal && (this.inv1st_all100_num == null ? that.inv1st_all100_num == null : this.inv1st_all100_num.equals(that.inv1st_all100_num));
    equal = equal && (this.inv1st_all100_amount == null ? that.inv1st_all100_amount == null : this.inv1st_all100_amount.equals(that.inv1st_all100_amount));
    equal = equal && (this.inv2nd_num == null ? that.inv2nd_num == null : this.inv2nd_num.equals(that.inv2nd_num));
    equal = equal && (this.inv2nd_amount == null ? that.inv2nd_amount == null : this.inv2nd_amount.equals(that.inv2nd_amount));
    equal = equal && (this.invre_num == null ? that.invre_num == null : this.invre_num.equals(that.invre_num));
    equal = equal && (this.invre_freq == null ? that.invre_freq == null : this.invre_freq.equals(that.invre_freq));
    equal = equal && (this.invre_amount == null ? that.invre_amount == null : this.invre_amount.equals(that.invre_amount));
    equal = equal && (this.redeem_num == null ? that.redeem_num == null : this.redeem_num.equals(that.redeem_num));
    equal = equal && (this.redeem_freq == null ? that.redeem_freq == null : this.redeem_freq.equals(that.redeem_freq));
    equal = equal && (this.redeem_amount == null ? that.redeem_amount == null : this.redeem_amount.equals(that.redeem_amount));
    equal = equal && (this.regular1st_num == null ? that.regular1st_num == null : this.regular1st_num.equals(that.regular1st_num));
    equal = equal && (this.regular1st_amount == null ? that.regular1st_amount == null : this.regular1st_amount.equals(that.regular1st_amount));
    equal = equal && (this.regular_num == null ? that.regular_num == null : this.regular_num.equals(that.regular_num));
    equal = equal && (this.regular_freq == null ? that.regular_freq == null : this.regular_freq.equals(that.regular_freq));
    equal = equal && (this.regular_amount == null ? that.regular_amount == null : this.regular_amount.equals(that.regular_amount));
    equal = equal && (this.reg_open_num == null ? that.reg_open_num == null : this.reg_open_num.equals(that.reg_open_num));
    equal = equal && (this.reg_inv1st_num == null ? that.reg_inv1st_num == null : this.reg_inv1st_num.equals(that.reg_inv1st_num));
    equal = equal && (this.reg_inv1st_amount == null ? that.reg_inv1st_amount == null : this.reg_inv1st_amount.equals(that.reg_inv1st_amount));
    equal = equal && (this.reg_inv2nd_num == null ? that.reg_inv2nd_num == null : this.reg_inv2nd_num.equals(that.reg_inv2nd_num));
    equal = equal && (this.reg_inv2nd_amount == null ? that.reg_inv2nd_amount == null : this.reg_inv2nd_amount.equals(that.reg_inv2nd_amount));
    equal = equal && (this.reg_inv3rdm_num == null ? that.reg_inv3rdm_num == null : this.reg_inv3rdm_num.equals(that.reg_inv3rdm_num));
    equal = equal && (this.reg_inv3rdm_amount == null ? that.reg_inv3rdm_amount == null : this.reg_inv3rdm_amount.equals(that.reg_inv3rdm_amount));
    equal = equal && (this.reg_inv1st_all_amount == null ? that.reg_inv1st_all_amount == null : this.reg_inv1st_all_amount.equals(that.reg_inv1st_all_amount));
    equal = equal && (this.reg_inv1st_all100_num == null ? that.reg_inv1st_all100_num == null : this.reg_inv1st_all100_num.equals(that.reg_inv1st_all100_num));
    equal = equal && (this.reg_inv1st_all100_amount == null ? that.reg_inv1st_all100_amount == null : this.reg_inv1st_all100_amount.equals(that.reg_inv1st_all100_amount));
    equal = equal && (this.inv1st_inv2nd_num == null ? that.inv1st_inv2nd_num == null : this.inv1st_inv2nd_num.equals(that.inv1st_inv2nd_num));
    equal = equal && (this.inv1st_inv2nd_amount == null ? that.inv1st_inv2nd_amount == null : this.inv1st_inv2nd_amount.equals(that.inv1st_inv2nd_amount));
    equal = equal && (this.inv1st_inv3rdm_num == null ? that.inv1st_inv3rdm_num == null : this.inv1st_inv3rdm_num.equals(that.inv1st_inv3rdm_num));
    equal = equal && (this.inv1st_inv3rdm_amount == null ? that.inv1st_inv3rdm_amount == null : this.inv1st_inv3rdm_amount.equals(that.inv1st_inv3rdm_amount));
    equal = equal && (this.exp_amount == null ? that.exp_amount == null : this.exp_amount.equals(that.exp_amount));
    equal = equal && (this.exp_int_amount == null ? that.exp_int_amount == null : this.exp_int_amount.equals(that.exp_int_amount));
    equal = equal && (this.exp_recover_amount == null ? that.exp_recover_amount == null : this.exp_recover_amount.equals(that.exp_recover_amount));
    equal = equal && (this.regular_1_num == null ? that.regular_1_num == null : this.regular_1_num.equals(that.regular_1_num));
    equal = equal && (this.regular_1_amount == null ? that.regular_1_amount == null : this.regular_1_amount.equals(that.regular_1_amount));
    equal = equal && (this.regular_2_num == null ? that.regular_2_num == null : this.regular_2_num.equals(that.regular_2_num));
    equal = equal && (this.regular_2_amount == null ? that.regular_2_amount == null : this.regular_2_amount.equals(that.regular_2_amount));
    equal = equal && (this.regular_3_num == null ? that.regular_3_num == null : this.regular_3_num.equals(that.regular_3_num));
    equal = equal && (this.regular_3_amount == null ? that.regular_3_amount == null : this.regular_3_amount.equals(that.regular_3_amount));
    equal = equal && (this.regular_4_num == null ? that.regular_4_num == null : this.regular_4_num.equals(that.regular_4_num));
    equal = equal && (this.regular_4_amount == null ? that.regular_4_amount == null : this.regular_4_amount.equals(that.regular_4_amount));
    equal = equal && (this.regular_5_num == null ? that.regular_5_num == null : this.regular_5_num.equals(that.regular_5_num));
    equal = equal && (this.regular_5_amount == null ? that.regular_5_amount == null : this.regular_5_amount.equals(that.regular_5_amount));
    equal = equal && (this.regular_6_num == null ? that.regular_6_num == null : this.regular_6_num.equals(that.regular_6_num));
    equal = equal && (this.regular_6_amount == null ? that.regular_6_amount == null : this.regular_6_amount.equals(that.regular_6_amount));
    equal = equal && (this.regular_7_num == null ? that.regular_7_num == null : this.regular_7_num.equals(that.regular_7_num));
    equal = equal && (this.regular_7_amount == null ? that.regular_7_amount == null : this.regular_7_amount.equals(that.regular_7_amount));
    equal = equal && (this.regular_8_num == null ? that.regular_8_num == null : this.regular_8_num.equals(that.regular_8_num));
    equal = equal && (this.regular_8_amount == null ? that.regular_8_amount == null : this.regular_8_amount.equals(that.regular_8_amount));
    equal = equal && (this.regular_9_num == null ? that.regular_9_num == null : this.regular_9_num.equals(that.regular_9_num));
    equal = equal && (this.regular_9_amount == null ? that.regular_9_amount == null : this.regular_9_amount.equals(that.regular_9_amount));
    equal = equal && (this.regular_10_num == null ? that.regular_10_num == null : this.regular_10_num.equals(that.regular_10_num));
    equal = equal && (this.regular_10_amount == null ? that.regular_10_amount == null : this.regular_10_amount.equals(that.regular_10_amount));
    equal = equal && (this.regular_11_num == null ? that.regular_11_num == null : this.regular_11_num.equals(that.regular_11_num));
    equal = equal && (this.regular_11_amount == null ? that.regular_11_amount == null : this.regular_11_amount.equals(that.regular_11_amount));
    equal = equal && (this.regular_12_num == null ? that.regular_12_num == null : this.regular_12_num.equals(that.regular_12_num));
    equal = equal && (this.regular_12_amount == null ? that.regular_12_amount == null : this.regular_12_amount.equals(that.regular_12_amount));
    equal = equal && (this.regular_premium == null ? that.regular_premium == null : this.regular_premium.equals(that.regular_premium));
    equal = equal && (this.regular_expire == null ? that.regular_expire == null : this.regular_expire.equals(that.regular_expire));
    equal = equal && (this.regular_premium_1 == null ? that.regular_premium_1 == null : this.regular_premium_1.equals(that.regular_premium_1));
    equal = equal && (this.regular_premium_2 == null ? that.regular_premium_2 == null : this.regular_premium_2.equals(that.regular_premium_2));
    equal = equal && (this.regular_premium_3 == null ? that.regular_premium_3 == null : this.regular_premium_3.equals(that.regular_premium_3));
    equal = equal && (this.regular_premium_4 == null ? that.regular_premium_4 == null : this.regular_premium_4.equals(that.regular_premium_4));
    equal = equal && (this.regular_premium_5 == null ? that.regular_premium_5 == null : this.regular_premium_5.equals(that.regular_premium_5));
    equal = equal && (this.regular_premium_6 == null ? that.regular_premium_6 == null : this.regular_premium_6.equals(that.regular_premium_6));
    equal = equal && (this.regular_premium_7 == null ? that.regular_premium_7 == null : this.regular_premium_7.equals(that.regular_premium_7));
    equal = equal && (this.regular_premium_8 == null ? that.regular_premium_8 == null : this.regular_premium_8.equals(that.regular_premium_8));
    equal = equal && (this.regular_premium_9 == null ? that.regular_premium_9 == null : this.regular_premium_9.equals(that.regular_premium_9));
    equal = equal && (this.regular_premium_10 == null ? that.regular_premium_10 == null : this.regular_premium_10.equals(that.regular_premium_10));
    equal = equal && (this.regular_premium_11 == null ? that.regular_premium_11 == null : this.regular_premium_11.equals(that.regular_premium_11));
    equal = equal && (this.regular_premium_12 == null ? that.regular_premium_12 == null : this.regular_premium_12.equals(that.regular_premium_12));
    equal = equal && (this.inv_interval_1k == null ? that.inv_interval_1k == null : this.inv_interval_1k.equals(that.inv_interval_1k));
    equal = equal && (this.inv_interval_5k == null ? that.inv_interval_5k == null : this.inv_interval_5k.equals(that.inv_interval_5k));
    equal = equal && (this.inv_interval_1w == null ? that.inv_interval_1w == null : this.inv_interval_1w.equals(that.inv_interval_1w));
    equal = equal && (this.inv_interval_2w == null ? that.inv_interval_2w == null : this.inv_interval_2w.equals(that.inv_interval_2w));
    equal = equal && (this.inv_interval_5w == null ? that.inv_interval_5w == null : this.inv_interval_5w.equals(that.inv_interval_5w));
    equal = equal && (this.inv_interval_10w == null ? that.inv_interval_10w == null : this.inv_interval_10w.equals(that.inv_interval_10w));
    equal = equal && (this.inv_interval_20w == null ? that.inv_interval_20w == null : this.inv_interval_20w.equals(that.inv_interval_20w));
    equal = equal && (this.inv_interval_20wm == null ? that.inv_interval_20wm == null : this.inv_interval_20wm.equals(that.inv_interval_20wm));
    equal = equal && (this.red_interval_1h == null ? that.red_interval_1h == null : this.red_interval_1h.equals(that.red_interval_1h));
    equal = equal && (this.red_interval_1k == null ? that.red_interval_1k == null : this.red_interval_1k.equals(that.red_interval_1k));
    equal = equal && (this.red_interval_5k == null ? that.red_interval_5k == null : this.red_interval_5k.equals(that.red_interval_5k));
    equal = equal && (this.red_interval_1w == null ? that.red_interval_1w == null : this.red_interval_1w.equals(that.red_interval_1w));
    equal = equal && (this.red_interval_2w == null ? that.red_interval_2w == null : this.red_interval_2w.equals(that.red_interval_2w));
    equal = equal && (this.red_interval_5w == null ? that.red_interval_5w == null : this.red_interval_5w.equals(that.red_interval_5w));
    equal = equal && (this.red_interval_10w == null ? that.red_interval_10w == null : this.red_interval_10w.equals(that.red_interval_10w));
    equal = equal && (this.red_interval_20w == null ? that.red_interval_20w == null : this.red_interval_20w.equals(that.red_interval_20w));
    equal = equal && (this.inv_diff == null ? that.inv_diff == null : this.inv_diff.equals(that.inv_diff));
    equal = equal && (this.inv100_diff == null ? that.inv100_diff == null : this.inv100_diff.equals(that.inv100_diff));
    equal = equal && (this.inv1st_diff == null ? that.inv1st_diff == null : this.inv1st_diff.equals(that.inv1st_diff));
    equal = equal && (this.inv1st_all_diff == null ? that.inv1st_all_diff == null : this.inv1st_all_diff.equals(that.inv1st_all_diff));
    equal = equal && (this.reg_inv_diff == null ? that.reg_inv_diff == null : this.reg_inv_diff.equals(that.reg_inv_diff));
    equal = equal && (this.invre_red_num == null ? that.invre_red_num == null : this.invre_red_num.equals(that.invre_red_num));
    equal = equal && (this.invre_red_amount == null ? that.invre_red_amount == null : this.invre_red_amount.equals(that.invre_red_amount));
    equal = equal && (this.churn_num == null ? that.churn_num == null : this.churn_num.equals(that.churn_num));
    equal = equal && (this.premium == null ? that.premium == null : this.premium.equals(that.premium));
    equal = equal && (this.premium_diff == null ? that.premium_diff == null : this.premium_diff.equals(that.premium_diff));
    equal = equal && (this.premium_cur == null ? that.premium_cur == null : this.premium_cur.equals(that.premium_cur));
    equal = equal && (this.inv_old_num == null ? that.inv_old_num == null : this.inv_old_num.equals(that.inv_old_num));
    equal = equal && (this.inv_old_amount == null ? that.inv_old_amount == null : this.inv_old_amount.equals(that.inv_old_amount));
    equal = equal && (this.inv_old_premium_diff == null ? that.inv_old_premium_diff == null : this.inv_old_premium_diff.equals(that.inv_old_premium_diff));
    equal = equal && (this.before_reg_inv1st_num == null ? that.before_reg_inv1st_num == null : this.before_reg_inv1st_num.equals(that.before_reg_inv1st_num));
    equal = equal && (this.before_reg_inv1st_all_amount == null ? that.before_reg_inv1st_all_amount == null : this.before_reg_inv1st_all_amount.equals(that.before_reg_inv1st_all_amount));
    equal = equal && (this.before_reg_inv1st_premium_diff == null ? that.before_reg_inv1st_premium_diff == null : this.before_reg_inv1st_premium_diff.equals(that.before_reg_inv1st_premium_diff));
    equal = equal && (this.inv1st_premium_diff == null ? that.inv1st_premium_diff == null : this.inv1st_premium_diff.equals(that.inv1st_premium_diff));
    equal = equal && (this.reg_inv1st_premium_diff == null ? that.reg_inv1st_premium_diff == null : this.reg_inv1st_premium_diff.equals(that.reg_inv1st_premium_diff));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof JLC_TOPIC_USER_APP)) {
      return false;
    }
    JLC_TOPIC_USER_APP that = (JLC_TOPIC_USER_APP) o;
    boolean equal = true;
    equal = equal && (this.create_date == null ? that.create_date == null : this.create_date.equals(that.create_date));
    equal = equal && (this.end_date == null ? that.end_date == null : this.end_date.equals(that.end_date));
    equal = equal && (this.channel == null ? that.channel == null : this.channel.equals(that.channel));
    equal = equal && (this.period == null ? that.period == null : this.period.equals(that.period));
    equal = equal && (this.activity_num == null ? that.activity_num == null : this.activity_num.equals(that.activity_num));
    equal = equal && (this.reg_num == null ? that.reg_num == null : this.reg_num.equals(that.reg_num));
    equal = equal && (this.open_num == null ? that.open_num == null : this.open_num.equals(that.open_num));
    equal = equal && (this.inv_num == null ? that.inv_num == null : this.inv_num.equals(that.inv_num));
    equal = equal && (this.inv_freq == null ? that.inv_freq == null : this.inv_freq.equals(that.inv_freq));
    equal = equal && (this.inv_amount == null ? that.inv_amount == null : this.inv_amount.equals(that.inv_amount));
    equal = equal && (this.inv100_num == null ? that.inv100_num == null : this.inv100_num.equals(that.inv100_num));
    equal = equal && (this.inv100_freq == null ? that.inv100_freq == null : this.inv100_freq.equals(that.inv100_freq));
    equal = equal && (this.inv100_amount == null ? that.inv100_amount == null : this.inv100_amount.equals(that.inv100_amount));
    equal = equal && (this.inv1st_num == null ? that.inv1st_num == null : this.inv1st_num.equals(that.inv1st_num));
    equal = equal && (this.inv1st_amount == null ? that.inv1st_amount == null : this.inv1st_amount.equals(that.inv1st_amount));
    equal = equal && (this.inv1st100_num == null ? that.inv1st100_num == null : this.inv1st100_num.equals(that.inv1st100_num));
    equal = equal && (this.inv1st100_amount == null ? that.inv1st100_amount == null : this.inv1st100_amount.equals(that.inv1st100_amount));
    equal = equal && (this.inv1st_all_amont == null ? that.inv1st_all_amont == null : this.inv1st_all_amont.equals(that.inv1st_all_amont));
    equal = equal && (this.inv1st_all100_num == null ? that.inv1st_all100_num == null : this.inv1st_all100_num.equals(that.inv1st_all100_num));
    equal = equal && (this.inv1st_all100_amount == null ? that.inv1st_all100_amount == null : this.inv1st_all100_amount.equals(that.inv1st_all100_amount));
    equal = equal && (this.inv2nd_num == null ? that.inv2nd_num == null : this.inv2nd_num.equals(that.inv2nd_num));
    equal = equal && (this.inv2nd_amount == null ? that.inv2nd_amount == null : this.inv2nd_amount.equals(that.inv2nd_amount));
    equal = equal && (this.invre_num == null ? that.invre_num == null : this.invre_num.equals(that.invre_num));
    equal = equal && (this.invre_freq == null ? that.invre_freq == null : this.invre_freq.equals(that.invre_freq));
    equal = equal && (this.invre_amount == null ? that.invre_amount == null : this.invre_amount.equals(that.invre_amount));
    equal = equal && (this.redeem_num == null ? that.redeem_num == null : this.redeem_num.equals(that.redeem_num));
    equal = equal && (this.redeem_freq == null ? that.redeem_freq == null : this.redeem_freq.equals(that.redeem_freq));
    equal = equal && (this.redeem_amount == null ? that.redeem_amount == null : this.redeem_amount.equals(that.redeem_amount));
    equal = equal && (this.regular1st_num == null ? that.regular1st_num == null : this.regular1st_num.equals(that.regular1st_num));
    equal = equal && (this.regular1st_amount == null ? that.regular1st_amount == null : this.regular1st_amount.equals(that.regular1st_amount));
    equal = equal && (this.regular_num == null ? that.regular_num == null : this.regular_num.equals(that.regular_num));
    equal = equal && (this.regular_freq == null ? that.regular_freq == null : this.regular_freq.equals(that.regular_freq));
    equal = equal && (this.regular_amount == null ? that.regular_amount == null : this.regular_amount.equals(that.regular_amount));
    equal = equal && (this.reg_open_num == null ? that.reg_open_num == null : this.reg_open_num.equals(that.reg_open_num));
    equal = equal && (this.reg_inv1st_num == null ? that.reg_inv1st_num == null : this.reg_inv1st_num.equals(that.reg_inv1st_num));
    equal = equal && (this.reg_inv1st_amount == null ? that.reg_inv1st_amount == null : this.reg_inv1st_amount.equals(that.reg_inv1st_amount));
    equal = equal && (this.reg_inv2nd_num == null ? that.reg_inv2nd_num == null : this.reg_inv2nd_num.equals(that.reg_inv2nd_num));
    equal = equal && (this.reg_inv2nd_amount == null ? that.reg_inv2nd_amount == null : this.reg_inv2nd_amount.equals(that.reg_inv2nd_amount));
    equal = equal && (this.reg_inv3rdm_num == null ? that.reg_inv3rdm_num == null : this.reg_inv3rdm_num.equals(that.reg_inv3rdm_num));
    equal = equal && (this.reg_inv3rdm_amount == null ? that.reg_inv3rdm_amount == null : this.reg_inv3rdm_amount.equals(that.reg_inv3rdm_amount));
    equal = equal && (this.reg_inv1st_all_amount == null ? that.reg_inv1st_all_amount == null : this.reg_inv1st_all_amount.equals(that.reg_inv1st_all_amount));
    equal = equal && (this.reg_inv1st_all100_num == null ? that.reg_inv1st_all100_num == null : this.reg_inv1st_all100_num.equals(that.reg_inv1st_all100_num));
    equal = equal && (this.reg_inv1st_all100_amount == null ? that.reg_inv1st_all100_amount == null : this.reg_inv1st_all100_amount.equals(that.reg_inv1st_all100_amount));
    equal = equal && (this.inv1st_inv2nd_num == null ? that.inv1st_inv2nd_num == null : this.inv1st_inv2nd_num.equals(that.inv1st_inv2nd_num));
    equal = equal && (this.inv1st_inv2nd_amount == null ? that.inv1st_inv2nd_amount == null : this.inv1st_inv2nd_amount.equals(that.inv1st_inv2nd_amount));
    equal = equal && (this.inv1st_inv3rdm_num == null ? that.inv1st_inv3rdm_num == null : this.inv1st_inv3rdm_num.equals(that.inv1st_inv3rdm_num));
    equal = equal && (this.inv1st_inv3rdm_amount == null ? that.inv1st_inv3rdm_amount == null : this.inv1st_inv3rdm_amount.equals(that.inv1st_inv3rdm_amount));
    equal = equal && (this.exp_amount == null ? that.exp_amount == null : this.exp_amount.equals(that.exp_amount));
    equal = equal && (this.exp_int_amount == null ? that.exp_int_amount == null : this.exp_int_amount.equals(that.exp_int_amount));
    equal = equal && (this.exp_recover_amount == null ? that.exp_recover_amount == null : this.exp_recover_amount.equals(that.exp_recover_amount));
    equal = equal && (this.regular_1_num == null ? that.regular_1_num == null : this.regular_1_num.equals(that.regular_1_num));
    equal = equal && (this.regular_1_amount == null ? that.regular_1_amount == null : this.regular_1_amount.equals(that.regular_1_amount));
    equal = equal && (this.regular_2_num == null ? that.regular_2_num == null : this.regular_2_num.equals(that.regular_2_num));
    equal = equal && (this.regular_2_amount == null ? that.regular_2_amount == null : this.regular_2_amount.equals(that.regular_2_amount));
    equal = equal && (this.regular_3_num == null ? that.regular_3_num == null : this.regular_3_num.equals(that.regular_3_num));
    equal = equal && (this.regular_3_amount == null ? that.regular_3_amount == null : this.regular_3_amount.equals(that.regular_3_amount));
    equal = equal && (this.regular_4_num == null ? that.regular_4_num == null : this.regular_4_num.equals(that.regular_4_num));
    equal = equal && (this.regular_4_amount == null ? that.regular_4_amount == null : this.regular_4_amount.equals(that.regular_4_amount));
    equal = equal && (this.regular_5_num == null ? that.regular_5_num == null : this.regular_5_num.equals(that.regular_5_num));
    equal = equal && (this.regular_5_amount == null ? that.regular_5_amount == null : this.regular_5_amount.equals(that.regular_5_amount));
    equal = equal && (this.regular_6_num == null ? that.regular_6_num == null : this.regular_6_num.equals(that.regular_6_num));
    equal = equal && (this.regular_6_amount == null ? that.regular_6_amount == null : this.regular_6_amount.equals(that.regular_6_amount));
    equal = equal && (this.regular_7_num == null ? that.regular_7_num == null : this.regular_7_num.equals(that.regular_7_num));
    equal = equal && (this.regular_7_amount == null ? that.regular_7_amount == null : this.regular_7_amount.equals(that.regular_7_amount));
    equal = equal && (this.regular_8_num == null ? that.regular_8_num == null : this.regular_8_num.equals(that.regular_8_num));
    equal = equal && (this.regular_8_amount == null ? that.regular_8_amount == null : this.regular_8_amount.equals(that.regular_8_amount));
    equal = equal && (this.regular_9_num == null ? that.regular_9_num == null : this.regular_9_num.equals(that.regular_9_num));
    equal = equal && (this.regular_9_amount == null ? that.regular_9_amount == null : this.regular_9_amount.equals(that.regular_9_amount));
    equal = equal && (this.regular_10_num == null ? that.regular_10_num == null : this.regular_10_num.equals(that.regular_10_num));
    equal = equal && (this.regular_10_amount == null ? that.regular_10_amount == null : this.regular_10_amount.equals(that.regular_10_amount));
    equal = equal && (this.regular_11_num == null ? that.regular_11_num == null : this.regular_11_num.equals(that.regular_11_num));
    equal = equal && (this.regular_11_amount == null ? that.regular_11_amount == null : this.regular_11_amount.equals(that.regular_11_amount));
    equal = equal && (this.regular_12_num == null ? that.regular_12_num == null : this.regular_12_num.equals(that.regular_12_num));
    equal = equal && (this.regular_12_amount == null ? that.regular_12_amount == null : this.regular_12_amount.equals(that.regular_12_amount));
    equal = equal && (this.regular_premium == null ? that.regular_premium == null : this.regular_premium.equals(that.regular_premium));
    equal = equal && (this.regular_expire == null ? that.regular_expire == null : this.regular_expire.equals(that.regular_expire));
    equal = equal && (this.regular_premium_1 == null ? that.regular_premium_1 == null : this.regular_premium_1.equals(that.regular_premium_1));
    equal = equal && (this.regular_premium_2 == null ? that.regular_premium_2 == null : this.regular_premium_2.equals(that.regular_premium_2));
    equal = equal && (this.regular_premium_3 == null ? that.regular_premium_3 == null : this.regular_premium_3.equals(that.regular_premium_3));
    equal = equal && (this.regular_premium_4 == null ? that.regular_premium_4 == null : this.regular_premium_4.equals(that.regular_premium_4));
    equal = equal && (this.regular_premium_5 == null ? that.regular_premium_5 == null : this.regular_premium_5.equals(that.regular_premium_5));
    equal = equal && (this.regular_premium_6 == null ? that.regular_premium_6 == null : this.regular_premium_6.equals(that.regular_premium_6));
    equal = equal && (this.regular_premium_7 == null ? that.regular_premium_7 == null : this.regular_premium_7.equals(that.regular_premium_7));
    equal = equal && (this.regular_premium_8 == null ? that.regular_premium_8 == null : this.regular_premium_8.equals(that.regular_premium_8));
    equal = equal && (this.regular_premium_9 == null ? that.regular_premium_9 == null : this.regular_premium_9.equals(that.regular_premium_9));
    equal = equal && (this.regular_premium_10 == null ? that.regular_premium_10 == null : this.regular_premium_10.equals(that.regular_premium_10));
    equal = equal && (this.regular_premium_11 == null ? that.regular_premium_11 == null : this.regular_premium_11.equals(that.regular_premium_11));
    equal = equal && (this.regular_premium_12 == null ? that.regular_premium_12 == null : this.regular_premium_12.equals(that.regular_premium_12));
    equal = equal && (this.inv_interval_1k == null ? that.inv_interval_1k == null : this.inv_interval_1k.equals(that.inv_interval_1k));
    equal = equal && (this.inv_interval_5k == null ? that.inv_interval_5k == null : this.inv_interval_5k.equals(that.inv_interval_5k));
    equal = equal && (this.inv_interval_1w == null ? that.inv_interval_1w == null : this.inv_interval_1w.equals(that.inv_interval_1w));
    equal = equal && (this.inv_interval_2w == null ? that.inv_interval_2w == null : this.inv_interval_2w.equals(that.inv_interval_2w));
    equal = equal && (this.inv_interval_5w == null ? that.inv_interval_5w == null : this.inv_interval_5w.equals(that.inv_interval_5w));
    equal = equal && (this.inv_interval_10w == null ? that.inv_interval_10w == null : this.inv_interval_10w.equals(that.inv_interval_10w));
    equal = equal && (this.inv_interval_20w == null ? that.inv_interval_20w == null : this.inv_interval_20w.equals(that.inv_interval_20w));
    equal = equal && (this.inv_interval_20wm == null ? that.inv_interval_20wm == null : this.inv_interval_20wm.equals(that.inv_interval_20wm));
    equal = equal && (this.red_interval_1h == null ? that.red_interval_1h == null : this.red_interval_1h.equals(that.red_interval_1h));
    equal = equal && (this.red_interval_1k == null ? that.red_interval_1k == null : this.red_interval_1k.equals(that.red_interval_1k));
    equal = equal && (this.red_interval_5k == null ? that.red_interval_5k == null : this.red_interval_5k.equals(that.red_interval_5k));
    equal = equal && (this.red_interval_1w == null ? that.red_interval_1w == null : this.red_interval_1w.equals(that.red_interval_1w));
    equal = equal && (this.red_interval_2w == null ? that.red_interval_2w == null : this.red_interval_2w.equals(that.red_interval_2w));
    equal = equal && (this.red_interval_5w == null ? that.red_interval_5w == null : this.red_interval_5w.equals(that.red_interval_5w));
    equal = equal && (this.red_interval_10w == null ? that.red_interval_10w == null : this.red_interval_10w.equals(that.red_interval_10w));
    equal = equal && (this.red_interval_20w == null ? that.red_interval_20w == null : this.red_interval_20w.equals(that.red_interval_20w));
    equal = equal && (this.inv_diff == null ? that.inv_diff == null : this.inv_diff.equals(that.inv_diff));
    equal = equal && (this.inv100_diff == null ? that.inv100_diff == null : this.inv100_diff.equals(that.inv100_diff));
    equal = equal && (this.inv1st_diff == null ? that.inv1st_diff == null : this.inv1st_diff.equals(that.inv1st_diff));
    equal = equal && (this.inv1st_all_diff == null ? that.inv1st_all_diff == null : this.inv1st_all_diff.equals(that.inv1st_all_diff));
    equal = equal && (this.reg_inv_diff == null ? that.reg_inv_diff == null : this.reg_inv_diff.equals(that.reg_inv_diff));
    equal = equal && (this.invre_red_num == null ? that.invre_red_num == null : this.invre_red_num.equals(that.invre_red_num));
    equal = equal && (this.invre_red_amount == null ? that.invre_red_amount == null : this.invre_red_amount.equals(that.invre_red_amount));
    equal = equal && (this.churn_num == null ? that.churn_num == null : this.churn_num.equals(that.churn_num));
    equal = equal && (this.premium == null ? that.premium == null : this.premium.equals(that.premium));
    equal = equal && (this.premium_diff == null ? that.premium_diff == null : this.premium_diff.equals(that.premium_diff));
    equal = equal && (this.premium_cur == null ? that.premium_cur == null : this.premium_cur.equals(that.premium_cur));
    equal = equal && (this.inv_old_num == null ? that.inv_old_num == null : this.inv_old_num.equals(that.inv_old_num));
    equal = equal && (this.inv_old_amount == null ? that.inv_old_amount == null : this.inv_old_amount.equals(that.inv_old_amount));
    equal = equal && (this.inv_old_premium_diff == null ? that.inv_old_premium_diff == null : this.inv_old_premium_diff.equals(that.inv_old_premium_diff));
    equal = equal && (this.before_reg_inv1st_num == null ? that.before_reg_inv1st_num == null : this.before_reg_inv1st_num.equals(that.before_reg_inv1st_num));
    equal = equal && (this.before_reg_inv1st_all_amount == null ? that.before_reg_inv1st_all_amount == null : this.before_reg_inv1st_all_amount.equals(that.before_reg_inv1st_all_amount));
    equal = equal && (this.before_reg_inv1st_premium_diff == null ? that.before_reg_inv1st_premium_diff == null : this.before_reg_inv1st_premium_diff.equals(that.before_reg_inv1st_premium_diff));
    equal = equal && (this.inv1st_premium_diff == null ? that.inv1st_premium_diff == null : this.inv1st_premium_diff.equals(that.inv1st_premium_diff));
    equal = equal && (this.reg_inv1st_premium_diff == null ? that.reg_inv1st_premium_diff == null : this.reg_inv1st_premium_diff.equals(that.reg_inv1st_premium_diff));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.create_date = JdbcWritableBridge.readString(1, __dbResults);
    this.end_date = JdbcWritableBridge.readString(2, __dbResults);
    this.channel = JdbcWritableBridge.readString(3, __dbResults);
    this.period = JdbcWritableBridge.readInteger(4, __dbResults);
    this.activity_num = JdbcWritableBridge.readInteger(5, __dbResults);
    this.reg_num = JdbcWritableBridge.readInteger(6, __dbResults);
    this.open_num = JdbcWritableBridge.readInteger(7, __dbResults);
    this.inv_num = JdbcWritableBridge.readInteger(8, __dbResults);
    this.inv_freq = JdbcWritableBridge.readInteger(9, __dbResults);
    this.inv_amount = JdbcWritableBridge.readBigDecimal(10, __dbResults);
    this.inv100_num = JdbcWritableBridge.readInteger(11, __dbResults);
    this.inv100_freq = JdbcWritableBridge.readInteger(12, __dbResults);
    this.inv100_amount = JdbcWritableBridge.readBigDecimal(13, __dbResults);
    this.inv1st_num = JdbcWritableBridge.readInteger(14, __dbResults);
    this.inv1st_amount = JdbcWritableBridge.readBigDecimal(15, __dbResults);
    this.inv1st100_num = JdbcWritableBridge.readInteger(16, __dbResults);
    this.inv1st100_amount = JdbcWritableBridge.readBigDecimal(17, __dbResults);
    this.inv1st_all_amont = JdbcWritableBridge.readBigDecimal(18, __dbResults);
    this.inv1st_all100_num = JdbcWritableBridge.readInteger(19, __dbResults);
    this.inv1st_all100_amount = JdbcWritableBridge.readBigDecimal(20, __dbResults);
    this.inv2nd_num = JdbcWritableBridge.readInteger(21, __dbResults);
    this.inv2nd_amount = JdbcWritableBridge.readBigDecimal(22, __dbResults);
    this.invre_num = JdbcWritableBridge.readInteger(23, __dbResults);
    this.invre_freq = JdbcWritableBridge.readInteger(24, __dbResults);
    this.invre_amount = JdbcWritableBridge.readBigDecimal(25, __dbResults);
    this.redeem_num = JdbcWritableBridge.readInteger(26, __dbResults);
    this.redeem_freq = JdbcWritableBridge.readInteger(27, __dbResults);
    this.redeem_amount = JdbcWritableBridge.readBigDecimal(28, __dbResults);
    this.regular1st_num = JdbcWritableBridge.readInteger(29, __dbResults);
    this.regular1st_amount = JdbcWritableBridge.readBigDecimal(30, __dbResults);
    this.regular_num = JdbcWritableBridge.readInteger(31, __dbResults);
    this.regular_freq = JdbcWritableBridge.readInteger(32, __dbResults);
    this.regular_amount = JdbcWritableBridge.readBigDecimal(33, __dbResults);
    this.reg_open_num = JdbcWritableBridge.readInteger(34, __dbResults);
    this.reg_inv1st_num = JdbcWritableBridge.readInteger(35, __dbResults);
    this.reg_inv1st_amount = JdbcWritableBridge.readBigDecimal(36, __dbResults);
    this.reg_inv2nd_num = JdbcWritableBridge.readInteger(37, __dbResults);
    this.reg_inv2nd_amount = JdbcWritableBridge.readBigDecimal(38, __dbResults);
    this.reg_inv3rdm_num = JdbcWritableBridge.readInteger(39, __dbResults);
    this.reg_inv3rdm_amount = JdbcWritableBridge.readBigDecimal(40, __dbResults);
    this.reg_inv1st_all_amount = JdbcWritableBridge.readBigDecimal(41, __dbResults);
    this.reg_inv1st_all100_num = JdbcWritableBridge.readInteger(42, __dbResults);
    this.reg_inv1st_all100_amount = JdbcWritableBridge.readBigDecimal(43, __dbResults);
    this.inv1st_inv2nd_num = JdbcWritableBridge.readInteger(44, __dbResults);
    this.inv1st_inv2nd_amount = JdbcWritableBridge.readBigDecimal(45, __dbResults);
    this.inv1st_inv3rdm_num = JdbcWritableBridge.readInteger(46, __dbResults);
    this.inv1st_inv3rdm_amount = JdbcWritableBridge.readBigDecimal(47, __dbResults);
    this.exp_amount = JdbcWritableBridge.readBigDecimal(48, __dbResults);
    this.exp_int_amount = JdbcWritableBridge.readBigDecimal(49, __dbResults);
    this.exp_recover_amount = JdbcWritableBridge.readBigDecimal(50, __dbResults);
    this.regular_1_num = JdbcWritableBridge.readInteger(51, __dbResults);
    this.regular_1_amount = JdbcWritableBridge.readBigDecimal(52, __dbResults);
    this.regular_2_num = JdbcWritableBridge.readInteger(53, __dbResults);
    this.regular_2_amount = JdbcWritableBridge.readBigDecimal(54, __dbResults);
    this.regular_3_num = JdbcWritableBridge.readInteger(55, __dbResults);
    this.regular_3_amount = JdbcWritableBridge.readBigDecimal(56, __dbResults);
    this.regular_4_num = JdbcWritableBridge.readInteger(57, __dbResults);
    this.regular_4_amount = JdbcWritableBridge.readBigDecimal(58, __dbResults);
    this.regular_5_num = JdbcWritableBridge.readInteger(59, __dbResults);
    this.regular_5_amount = JdbcWritableBridge.readBigDecimal(60, __dbResults);
    this.regular_6_num = JdbcWritableBridge.readInteger(61, __dbResults);
    this.regular_6_amount = JdbcWritableBridge.readBigDecimal(62, __dbResults);
    this.regular_7_num = JdbcWritableBridge.readInteger(63, __dbResults);
    this.regular_7_amount = JdbcWritableBridge.readBigDecimal(64, __dbResults);
    this.regular_8_num = JdbcWritableBridge.readInteger(65, __dbResults);
    this.regular_8_amount = JdbcWritableBridge.readBigDecimal(66, __dbResults);
    this.regular_9_num = JdbcWritableBridge.readInteger(67, __dbResults);
    this.regular_9_amount = JdbcWritableBridge.readBigDecimal(68, __dbResults);
    this.regular_10_num = JdbcWritableBridge.readInteger(69, __dbResults);
    this.regular_10_amount = JdbcWritableBridge.readBigDecimal(70, __dbResults);
    this.regular_11_num = JdbcWritableBridge.readInteger(71, __dbResults);
    this.regular_11_amount = JdbcWritableBridge.readBigDecimal(72, __dbResults);
    this.regular_12_num = JdbcWritableBridge.readInteger(73, __dbResults);
    this.regular_12_amount = JdbcWritableBridge.readBigDecimal(74, __dbResults);
    this.regular_premium = JdbcWritableBridge.readBigDecimal(75, __dbResults);
    this.regular_expire = JdbcWritableBridge.readBigDecimal(76, __dbResults);
    this.regular_premium_1 = JdbcWritableBridge.readBigDecimal(77, __dbResults);
    this.regular_premium_2 = JdbcWritableBridge.readBigDecimal(78, __dbResults);
    this.regular_premium_3 = JdbcWritableBridge.readBigDecimal(79, __dbResults);
    this.regular_premium_4 = JdbcWritableBridge.readBigDecimal(80, __dbResults);
    this.regular_premium_5 = JdbcWritableBridge.readBigDecimal(81, __dbResults);
    this.regular_premium_6 = JdbcWritableBridge.readBigDecimal(82, __dbResults);
    this.regular_premium_7 = JdbcWritableBridge.readBigDecimal(83, __dbResults);
    this.regular_premium_8 = JdbcWritableBridge.readBigDecimal(84, __dbResults);
    this.regular_premium_9 = JdbcWritableBridge.readBigDecimal(85, __dbResults);
    this.regular_premium_10 = JdbcWritableBridge.readBigDecimal(86, __dbResults);
    this.regular_premium_11 = JdbcWritableBridge.readBigDecimal(87, __dbResults);
    this.regular_premium_12 = JdbcWritableBridge.readBigDecimal(88, __dbResults);
    this.inv_interval_1k = JdbcWritableBridge.readInteger(89, __dbResults);
    this.inv_interval_5k = JdbcWritableBridge.readInteger(90, __dbResults);
    this.inv_interval_1w = JdbcWritableBridge.readInteger(91, __dbResults);
    this.inv_interval_2w = JdbcWritableBridge.readInteger(92, __dbResults);
    this.inv_interval_5w = JdbcWritableBridge.readInteger(93, __dbResults);
    this.inv_interval_10w = JdbcWritableBridge.readInteger(94, __dbResults);
    this.inv_interval_20w = JdbcWritableBridge.readInteger(95, __dbResults);
    this.inv_interval_20wm = JdbcWritableBridge.readInteger(96, __dbResults);
    this.red_interval_1h = JdbcWritableBridge.readInteger(97, __dbResults);
    this.red_interval_1k = JdbcWritableBridge.readInteger(98, __dbResults);
    this.red_interval_5k = JdbcWritableBridge.readInteger(99, __dbResults);
    this.red_interval_1w = JdbcWritableBridge.readInteger(100, __dbResults);
    this.red_interval_2w = JdbcWritableBridge.readInteger(101, __dbResults);
    this.red_interval_5w = JdbcWritableBridge.readInteger(102, __dbResults);
    this.red_interval_10w = JdbcWritableBridge.readInteger(103, __dbResults);
    this.red_interval_20w = JdbcWritableBridge.readInteger(104, __dbResults);
    this.inv_diff = JdbcWritableBridge.readBigDecimal(105, __dbResults);
    this.inv100_diff = JdbcWritableBridge.readBigDecimal(106, __dbResults);
    this.inv1st_diff = JdbcWritableBridge.readBigDecimal(107, __dbResults);
    this.inv1st_all_diff = JdbcWritableBridge.readBigDecimal(108, __dbResults);
    this.reg_inv_diff = JdbcWritableBridge.readBigDecimal(109, __dbResults);
    this.invre_red_num = JdbcWritableBridge.readInteger(110, __dbResults);
    this.invre_red_amount = JdbcWritableBridge.readBigDecimal(111, __dbResults);
    this.churn_num = JdbcWritableBridge.readInteger(112, __dbResults);
    this.premium = JdbcWritableBridge.readBigDecimal(113, __dbResults);
    this.premium_diff = JdbcWritableBridge.readBigDecimal(114, __dbResults);
    this.premium_cur = JdbcWritableBridge.readBigDecimal(115, __dbResults);
    this.inv_old_num = JdbcWritableBridge.readInteger(116, __dbResults);
    this.inv_old_amount = JdbcWritableBridge.readBigDecimal(117, __dbResults);
    this.inv_old_premium_diff = JdbcWritableBridge.readBigDecimal(118, __dbResults);
    this.before_reg_inv1st_num = JdbcWritableBridge.readInteger(119, __dbResults);
    this.before_reg_inv1st_all_amount = JdbcWritableBridge.readBigDecimal(120, __dbResults);
    this.before_reg_inv1st_premium_diff = JdbcWritableBridge.readBigDecimal(121, __dbResults);
    this.inv1st_premium_diff = JdbcWritableBridge.readBigDecimal(122, __dbResults);
    this.reg_inv1st_premium_diff = JdbcWritableBridge.readBigDecimal(123, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.create_date = JdbcWritableBridge.readString(1, __dbResults);
    this.end_date = JdbcWritableBridge.readString(2, __dbResults);
    this.channel = JdbcWritableBridge.readString(3, __dbResults);
    this.period = JdbcWritableBridge.readInteger(4, __dbResults);
    this.activity_num = JdbcWritableBridge.readInteger(5, __dbResults);
    this.reg_num = JdbcWritableBridge.readInteger(6, __dbResults);
    this.open_num = JdbcWritableBridge.readInteger(7, __dbResults);
    this.inv_num = JdbcWritableBridge.readInteger(8, __dbResults);
    this.inv_freq = JdbcWritableBridge.readInteger(9, __dbResults);
    this.inv_amount = JdbcWritableBridge.readBigDecimal(10, __dbResults);
    this.inv100_num = JdbcWritableBridge.readInteger(11, __dbResults);
    this.inv100_freq = JdbcWritableBridge.readInteger(12, __dbResults);
    this.inv100_amount = JdbcWritableBridge.readBigDecimal(13, __dbResults);
    this.inv1st_num = JdbcWritableBridge.readInteger(14, __dbResults);
    this.inv1st_amount = JdbcWritableBridge.readBigDecimal(15, __dbResults);
    this.inv1st100_num = JdbcWritableBridge.readInteger(16, __dbResults);
    this.inv1st100_amount = JdbcWritableBridge.readBigDecimal(17, __dbResults);
    this.inv1st_all_amont = JdbcWritableBridge.readBigDecimal(18, __dbResults);
    this.inv1st_all100_num = JdbcWritableBridge.readInteger(19, __dbResults);
    this.inv1st_all100_amount = JdbcWritableBridge.readBigDecimal(20, __dbResults);
    this.inv2nd_num = JdbcWritableBridge.readInteger(21, __dbResults);
    this.inv2nd_amount = JdbcWritableBridge.readBigDecimal(22, __dbResults);
    this.invre_num = JdbcWritableBridge.readInteger(23, __dbResults);
    this.invre_freq = JdbcWritableBridge.readInteger(24, __dbResults);
    this.invre_amount = JdbcWritableBridge.readBigDecimal(25, __dbResults);
    this.redeem_num = JdbcWritableBridge.readInteger(26, __dbResults);
    this.redeem_freq = JdbcWritableBridge.readInteger(27, __dbResults);
    this.redeem_amount = JdbcWritableBridge.readBigDecimal(28, __dbResults);
    this.regular1st_num = JdbcWritableBridge.readInteger(29, __dbResults);
    this.regular1st_amount = JdbcWritableBridge.readBigDecimal(30, __dbResults);
    this.regular_num = JdbcWritableBridge.readInteger(31, __dbResults);
    this.regular_freq = JdbcWritableBridge.readInteger(32, __dbResults);
    this.regular_amount = JdbcWritableBridge.readBigDecimal(33, __dbResults);
    this.reg_open_num = JdbcWritableBridge.readInteger(34, __dbResults);
    this.reg_inv1st_num = JdbcWritableBridge.readInteger(35, __dbResults);
    this.reg_inv1st_amount = JdbcWritableBridge.readBigDecimal(36, __dbResults);
    this.reg_inv2nd_num = JdbcWritableBridge.readInteger(37, __dbResults);
    this.reg_inv2nd_amount = JdbcWritableBridge.readBigDecimal(38, __dbResults);
    this.reg_inv3rdm_num = JdbcWritableBridge.readInteger(39, __dbResults);
    this.reg_inv3rdm_amount = JdbcWritableBridge.readBigDecimal(40, __dbResults);
    this.reg_inv1st_all_amount = JdbcWritableBridge.readBigDecimal(41, __dbResults);
    this.reg_inv1st_all100_num = JdbcWritableBridge.readInteger(42, __dbResults);
    this.reg_inv1st_all100_amount = JdbcWritableBridge.readBigDecimal(43, __dbResults);
    this.inv1st_inv2nd_num = JdbcWritableBridge.readInteger(44, __dbResults);
    this.inv1st_inv2nd_amount = JdbcWritableBridge.readBigDecimal(45, __dbResults);
    this.inv1st_inv3rdm_num = JdbcWritableBridge.readInteger(46, __dbResults);
    this.inv1st_inv3rdm_amount = JdbcWritableBridge.readBigDecimal(47, __dbResults);
    this.exp_amount = JdbcWritableBridge.readBigDecimal(48, __dbResults);
    this.exp_int_amount = JdbcWritableBridge.readBigDecimal(49, __dbResults);
    this.exp_recover_amount = JdbcWritableBridge.readBigDecimal(50, __dbResults);
    this.regular_1_num = JdbcWritableBridge.readInteger(51, __dbResults);
    this.regular_1_amount = JdbcWritableBridge.readBigDecimal(52, __dbResults);
    this.regular_2_num = JdbcWritableBridge.readInteger(53, __dbResults);
    this.regular_2_amount = JdbcWritableBridge.readBigDecimal(54, __dbResults);
    this.regular_3_num = JdbcWritableBridge.readInteger(55, __dbResults);
    this.regular_3_amount = JdbcWritableBridge.readBigDecimal(56, __dbResults);
    this.regular_4_num = JdbcWritableBridge.readInteger(57, __dbResults);
    this.regular_4_amount = JdbcWritableBridge.readBigDecimal(58, __dbResults);
    this.regular_5_num = JdbcWritableBridge.readInteger(59, __dbResults);
    this.regular_5_amount = JdbcWritableBridge.readBigDecimal(60, __dbResults);
    this.regular_6_num = JdbcWritableBridge.readInteger(61, __dbResults);
    this.regular_6_amount = JdbcWritableBridge.readBigDecimal(62, __dbResults);
    this.regular_7_num = JdbcWritableBridge.readInteger(63, __dbResults);
    this.regular_7_amount = JdbcWritableBridge.readBigDecimal(64, __dbResults);
    this.regular_8_num = JdbcWritableBridge.readInteger(65, __dbResults);
    this.regular_8_amount = JdbcWritableBridge.readBigDecimal(66, __dbResults);
    this.regular_9_num = JdbcWritableBridge.readInteger(67, __dbResults);
    this.regular_9_amount = JdbcWritableBridge.readBigDecimal(68, __dbResults);
    this.regular_10_num = JdbcWritableBridge.readInteger(69, __dbResults);
    this.regular_10_amount = JdbcWritableBridge.readBigDecimal(70, __dbResults);
    this.regular_11_num = JdbcWritableBridge.readInteger(71, __dbResults);
    this.regular_11_amount = JdbcWritableBridge.readBigDecimal(72, __dbResults);
    this.regular_12_num = JdbcWritableBridge.readInteger(73, __dbResults);
    this.regular_12_amount = JdbcWritableBridge.readBigDecimal(74, __dbResults);
    this.regular_premium = JdbcWritableBridge.readBigDecimal(75, __dbResults);
    this.regular_expire = JdbcWritableBridge.readBigDecimal(76, __dbResults);
    this.regular_premium_1 = JdbcWritableBridge.readBigDecimal(77, __dbResults);
    this.regular_premium_2 = JdbcWritableBridge.readBigDecimal(78, __dbResults);
    this.regular_premium_3 = JdbcWritableBridge.readBigDecimal(79, __dbResults);
    this.regular_premium_4 = JdbcWritableBridge.readBigDecimal(80, __dbResults);
    this.regular_premium_5 = JdbcWritableBridge.readBigDecimal(81, __dbResults);
    this.regular_premium_6 = JdbcWritableBridge.readBigDecimal(82, __dbResults);
    this.regular_premium_7 = JdbcWritableBridge.readBigDecimal(83, __dbResults);
    this.regular_premium_8 = JdbcWritableBridge.readBigDecimal(84, __dbResults);
    this.regular_premium_9 = JdbcWritableBridge.readBigDecimal(85, __dbResults);
    this.regular_premium_10 = JdbcWritableBridge.readBigDecimal(86, __dbResults);
    this.regular_premium_11 = JdbcWritableBridge.readBigDecimal(87, __dbResults);
    this.regular_premium_12 = JdbcWritableBridge.readBigDecimal(88, __dbResults);
    this.inv_interval_1k = JdbcWritableBridge.readInteger(89, __dbResults);
    this.inv_interval_5k = JdbcWritableBridge.readInteger(90, __dbResults);
    this.inv_interval_1w = JdbcWritableBridge.readInteger(91, __dbResults);
    this.inv_interval_2w = JdbcWritableBridge.readInteger(92, __dbResults);
    this.inv_interval_5w = JdbcWritableBridge.readInteger(93, __dbResults);
    this.inv_interval_10w = JdbcWritableBridge.readInteger(94, __dbResults);
    this.inv_interval_20w = JdbcWritableBridge.readInteger(95, __dbResults);
    this.inv_interval_20wm = JdbcWritableBridge.readInteger(96, __dbResults);
    this.red_interval_1h = JdbcWritableBridge.readInteger(97, __dbResults);
    this.red_interval_1k = JdbcWritableBridge.readInteger(98, __dbResults);
    this.red_interval_5k = JdbcWritableBridge.readInteger(99, __dbResults);
    this.red_interval_1w = JdbcWritableBridge.readInteger(100, __dbResults);
    this.red_interval_2w = JdbcWritableBridge.readInteger(101, __dbResults);
    this.red_interval_5w = JdbcWritableBridge.readInteger(102, __dbResults);
    this.red_interval_10w = JdbcWritableBridge.readInteger(103, __dbResults);
    this.red_interval_20w = JdbcWritableBridge.readInteger(104, __dbResults);
    this.inv_diff = JdbcWritableBridge.readBigDecimal(105, __dbResults);
    this.inv100_diff = JdbcWritableBridge.readBigDecimal(106, __dbResults);
    this.inv1st_diff = JdbcWritableBridge.readBigDecimal(107, __dbResults);
    this.inv1st_all_diff = JdbcWritableBridge.readBigDecimal(108, __dbResults);
    this.reg_inv_diff = JdbcWritableBridge.readBigDecimal(109, __dbResults);
    this.invre_red_num = JdbcWritableBridge.readInteger(110, __dbResults);
    this.invre_red_amount = JdbcWritableBridge.readBigDecimal(111, __dbResults);
    this.churn_num = JdbcWritableBridge.readInteger(112, __dbResults);
    this.premium = JdbcWritableBridge.readBigDecimal(113, __dbResults);
    this.premium_diff = JdbcWritableBridge.readBigDecimal(114, __dbResults);
    this.premium_cur = JdbcWritableBridge.readBigDecimal(115, __dbResults);
    this.inv_old_num = JdbcWritableBridge.readInteger(116, __dbResults);
    this.inv_old_amount = JdbcWritableBridge.readBigDecimal(117, __dbResults);
    this.inv_old_premium_diff = JdbcWritableBridge.readBigDecimal(118, __dbResults);
    this.before_reg_inv1st_num = JdbcWritableBridge.readInteger(119, __dbResults);
    this.before_reg_inv1st_all_amount = JdbcWritableBridge.readBigDecimal(120, __dbResults);
    this.before_reg_inv1st_premium_diff = JdbcWritableBridge.readBigDecimal(121, __dbResults);
    this.inv1st_premium_diff = JdbcWritableBridge.readBigDecimal(122, __dbResults);
    this.reg_inv1st_premium_diff = JdbcWritableBridge.readBigDecimal(123, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(create_date, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(end_date, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(channel, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(period, 4 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(activity_num, 5 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(reg_num, 6 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(open_num, 7 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_num, 8 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_freq, 9 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv_amount, 10 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv100_num, 11 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv100_freq, 12 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv100_amount, 13 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv1st_num, 14 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st_amount, 15 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv1st100_num, 16 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st100_amount, 17 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st_all_amont, 18 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv1st_all100_num, 19 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st_all100_amount, 20 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv2nd_num, 21 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv2nd_amount, 22 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(invre_num, 23 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(invre_freq, 24 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(invre_amount, 25 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(redeem_num, 26 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(redeem_freq, 27 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(redeem_amount, 28 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular1st_num, 29 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular1st_amount, 30 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_num, 31 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_freq, 32 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_amount, 33 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(reg_open_num, 34 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(reg_inv1st_num, 35 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(reg_inv1st_amount, 36 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(reg_inv2nd_num, 37 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(reg_inv2nd_amount, 38 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(reg_inv3rdm_num, 39 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(reg_inv3rdm_amount, 40 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(reg_inv1st_all_amount, 41 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(reg_inv1st_all100_num, 42 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(reg_inv1st_all100_amount, 43 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv1st_inv2nd_num, 44 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st_inv2nd_amount, 45 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv1st_inv3rdm_num, 46 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st_inv3rdm_amount, 47 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(exp_amount, 48 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(exp_int_amount, 49 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(exp_recover_amount, 50 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_1_num, 51 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_1_amount, 52 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_2_num, 53 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_2_amount, 54 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_3_num, 55 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_3_amount, 56 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_4_num, 57 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_4_amount, 58 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_5_num, 59 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_5_amount, 60 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_6_num, 61 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_6_amount, 62 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_7_num, 63 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_7_amount, 64 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_8_num, 65 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_8_amount, 66 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_9_num, 67 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_9_amount, 68 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_10_num, 69 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_10_amount, 70 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_11_num, 71 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_11_amount, 72 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_12_num, 73 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_12_amount, 74 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium, 75 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_expire, 76 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_1, 77 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_2, 78 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_3, 79 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_4, 80 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_5, 81 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_6, 82 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_7, 83 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_8, 84 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_9, 85 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_10, 86 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_11, 87 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_12, 88 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_interval_1k, 89 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_interval_5k, 90 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_interval_1w, 91 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_interval_2w, 92 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_interval_5w, 93 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_interval_10w, 94 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_interval_20w, 95 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_interval_20wm, 96 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(red_interval_1h, 97 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(red_interval_1k, 98 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(red_interval_5k, 99 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(red_interval_1w, 100 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(red_interval_2w, 101 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(red_interval_5w, 102 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(red_interval_10w, 103 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(red_interval_20w, 104 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv_diff, 105 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv100_diff, 106 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st_diff, 107 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st_all_diff, 108 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(reg_inv_diff, 109 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(invre_red_num, 110 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(invre_red_amount, 111 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(churn_num, 112 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(premium, 113 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(premium_diff, 114 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(premium_cur, 115 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_old_num, 116 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv_old_amount, 117 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv_old_premium_diff, 118 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(before_reg_inv1st_num, 119 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(before_reg_inv1st_all_amount, 120 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(before_reg_inv1st_premium_diff, 121 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st_premium_diff, 122 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(reg_inv1st_premium_diff, 123 + __off, 3, __dbStmt);
    return 123;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(create_date, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(end_date, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(channel, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(period, 4 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(activity_num, 5 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(reg_num, 6 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(open_num, 7 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_num, 8 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_freq, 9 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv_amount, 10 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv100_num, 11 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv100_freq, 12 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv100_amount, 13 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv1st_num, 14 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st_amount, 15 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv1st100_num, 16 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st100_amount, 17 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st_all_amont, 18 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv1st_all100_num, 19 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st_all100_amount, 20 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv2nd_num, 21 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv2nd_amount, 22 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(invre_num, 23 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(invre_freq, 24 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(invre_amount, 25 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(redeem_num, 26 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(redeem_freq, 27 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(redeem_amount, 28 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular1st_num, 29 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular1st_amount, 30 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_num, 31 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_freq, 32 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_amount, 33 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(reg_open_num, 34 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(reg_inv1st_num, 35 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(reg_inv1st_amount, 36 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(reg_inv2nd_num, 37 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(reg_inv2nd_amount, 38 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(reg_inv3rdm_num, 39 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(reg_inv3rdm_amount, 40 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(reg_inv1st_all_amount, 41 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(reg_inv1st_all100_num, 42 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(reg_inv1st_all100_amount, 43 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv1st_inv2nd_num, 44 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st_inv2nd_amount, 45 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv1st_inv3rdm_num, 46 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st_inv3rdm_amount, 47 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(exp_amount, 48 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(exp_int_amount, 49 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(exp_recover_amount, 50 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_1_num, 51 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_1_amount, 52 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_2_num, 53 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_2_amount, 54 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_3_num, 55 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_3_amount, 56 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_4_num, 57 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_4_amount, 58 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_5_num, 59 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_5_amount, 60 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_6_num, 61 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_6_amount, 62 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_7_num, 63 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_7_amount, 64 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_8_num, 65 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_8_amount, 66 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_9_num, 67 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_9_amount, 68 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_10_num, 69 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_10_amount, 70 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_11_num, 71 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_11_amount, 72 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(regular_12_num, 73 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_12_amount, 74 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium, 75 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_expire, 76 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_1, 77 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_2, 78 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_3, 79 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_4, 80 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_5, 81 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_6, 82 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_7, 83 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_8, 84 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_9, 85 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_10, 86 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_11, 87 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(regular_premium_12, 88 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_interval_1k, 89 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_interval_5k, 90 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_interval_1w, 91 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_interval_2w, 92 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_interval_5w, 93 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_interval_10w, 94 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_interval_20w, 95 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_interval_20wm, 96 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(red_interval_1h, 97 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(red_interval_1k, 98 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(red_interval_5k, 99 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(red_interval_1w, 100 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(red_interval_2w, 101 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(red_interval_5w, 102 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(red_interval_10w, 103 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(red_interval_20w, 104 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv_diff, 105 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv100_diff, 106 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st_diff, 107 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st_all_diff, 108 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(reg_inv_diff, 109 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(invre_red_num, 110 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(invre_red_amount, 111 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(churn_num, 112 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(premium, 113 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(premium_diff, 114 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(premium_cur, 115 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(inv_old_num, 116 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv_old_amount, 117 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv_old_premium_diff, 118 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeInteger(before_reg_inv1st_num, 119 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(before_reg_inv1st_all_amount, 120 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(before_reg_inv1st_premium_diff, 121 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(inv1st_premium_diff, 122 + __off, 3, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(reg_inv1st_premium_diff, 123 + __off, 3, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.create_date = null;
    } else {
    this.create_date = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.end_date = null;
    } else {
    this.end_date = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.channel = null;
    } else {
    this.channel = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.period = null;
    } else {
    this.period = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.activity_num = null;
    } else {
    this.activity_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.reg_num = null;
    } else {
    this.reg_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.open_num = null;
    } else {
    this.open_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv_num = null;
    } else {
    this.inv_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv_freq = null;
    } else {
    this.inv_freq = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv_amount = null;
    } else {
    this.inv_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.inv100_num = null;
    } else {
    this.inv100_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv100_freq = null;
    } else {
    this.inv100_freq = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv100_amount = null;
    } else {
    this.inv100_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.inv1st_num = null;
    } else {
    this.inv1st_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv1st_amount = null;
    } else {
    this.inv1st_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.inv1st100_num = null;
    } else {
    this.inv1st100_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv1st100_amount = null;
    } else {
    this.inv1st100_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.inv1st_all_amont = null;
    } else {
    this.inv1st_all_amont = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.inv1st_all100_num = null;
    } else {
    this.inv1st_all100_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv1st_all100_amount = null;
    } else {
    this.inv1st_all100_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.inv2nd_num = null;
    } else {
    this.inv2nd_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv2nd_amount = null;
    } else {
    this.inv2nd_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.invre_num = null;
    } else {
    this.invre_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.invre_freq = null;
    } else {
    this.invre_freq = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.invre_amount = null;
    } else {
    this.invre_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.redeem_num = null;
    } else {
    this.redeem_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.redeem_freq = null;
    } else {
    this.redeem_freq = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.redeem_amount = null;
    } else {
    this.redeem_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular1st_num = null;
    } else {
    this.regular1st_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.regular1st_amount = null;
    } else {
    this.regular1st_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_num = null;
    } else {
    this.regular_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.regular_freq = null;
    } else {
    this.regular_freq = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.regular_amount = null;
    } else {
    this.regular_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.reg_open_num = null;
    } else {
    this.reg_open_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.reg_inv1st_num = null;
    } else {
    this.reg_inv1st_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.reg_inv1st_amount = null;
    } else {
    this.reg_inv1st_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.reg_inv2nd_num = null;
    } else {
    this.reg_inv2nd_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.reg_inv2nd_amount = null;
    } else {
    this.reg_inv2nd_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.reg_inv3rdm_num = null;
    } else {
    this.reg_inv3rdm_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.reg_inv3rdm_amount = null;
    } else {
    this.reg_inv3rdm_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.reg_inv1st_all_amount = null;
    } else {
    this.reg_inv1st_all_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.reg_inv1st_all100_num = null;
    } else {
    this.reg_inv1st_all100_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.reg_inv1st_all100_amount = null;
    } else {
    this.reg_inv1st_all100_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.inv1st_inv2nd_num = null;
    } else {
    this.inv1st_inv2nd_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv1st_inv2nd_amount = null;
    } else {
    this.inv1st_inv2nd_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.inv1st_inv3rdm_num = null;
    } else {
    this.inv1st_inv3rdm_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv1st_inv3rdm_amount = null;
    } else {
    this.inv1st_inv3rdm_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.exp_amount = null;
    } else {
    this.exp_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.exp_int_amount = null;
    } else {
    this.exp_int_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.exp_recover_amount = null;
    } else {
    this.exp_recover_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_1_num = null;
    } else {
    this.regular_1_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.regular_1_amount = null;
    } else {
    this.regular_1_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_2_num = null;
    } else {
    this.regular_2_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.regular_2_amount = null;
    } else {
    this.regular_2_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_3_num = null;
    } else {
    this.regular_3_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.regular_3_amount = null;
    } else {
    this.regular_3_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_4_num = null;
    } else {
    this.regular_4_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.regular_4_amount = null;
    } else {
    this.regular_4_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_5_num = null;
    } else {
    this.regular_5_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.regular_5_amount = null;
    } else {
    this.regular_5_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_6_num = null;
    } else {
    this.regular_6_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.regular_6_amount = null;
    } else {
    this.regular_6_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_7_num = null;
    } else {
    this.regular_7_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.regular_7_amount = null;
    } else {
    this.regular_7_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_8_num = null;
    } else {
    this.regular_8_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.regular_8_amount = null;
    } else {
    this.regular_8_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_9_num = null;
    } else {
    this.regular_9_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.regular_9_amount = null;
    } else {
    this.regular_9_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_10_num = null;
    } else {
    this.regular_10_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.regular_10_amount = null;
    } else {
    this.regular_10_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_11_num = null;
    } else {
    this.regular_11_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.regular_11_amount = null;
    } else {
    this.regular_11_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_12_num = null;
    } else {
    this.regular_12_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.regular_12_amount = null;
    } else {
    this.regular_12_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_premium = null;
    } else {
    this.regular_premium = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_expire = null;
    } else {
    this.regular_expire = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_premium_1 = null;
    } else {
    this.regular_premium_1 = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_premium_2 = null;
    } else {
    this.regular_premium_2 = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_premium_3 = null;
    } else {
    this.regular_premium_3 = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_premium_4 = null;
    } else {
    this.regular_premium_4 = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_premium_5 = null;
    } else {
    this.regular_premium_5 = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_premium_6 = null;
    } else {
    this.regular_premium_6 = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_premium_7 = null;
    } else {
    this.regular_premium_7 = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_premium_8 = null;
    } else {
    this.regular_premium_8 = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_premium_9 = null;
    } else {
    this.regular_premium_9 = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_premium_10 = null;
    } else {
    this.regular_premium_10 = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_premium_11 = null;
    } else {
    this.regular_premium_11 = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.regular_premium_12 = null;
    } else {
    this.regular_premium_12 = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.inv_interval_1k = null;
    } else {
    this.inv_interval_1k = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv_interval_5k = null;
    } else {
    this.inv_interval_5k = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv_interval_1w = null;
    } else {
    this.inv_interval_1w = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv_interval_2w = null;
    } else {
    this.inv_interval_2w = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv_interval_5w = null;
    } else {
    this.inv_interval_5w = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv_interval_10w = null;
    } else {
    this.inv_interval_10w = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv_interval_20w = null;
    } else {
    this.inv_interval_20w = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv_interval_20wm = null;
    } else {
    this.inv_interval_20wm = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.red_interval_1h = null;
    } else {
    this.red_interval_1h = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.red_interval_1k = null;
    } else {
    this.red_interval_1k = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.red_interval_5k = null;
    } else {
    this.red_interval_5k = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.red_interval_1w = null;
    } else {
    this.red_interval_1w = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.red_interval_2w = null;
    } else {
    this.red_interval_2w = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.red_interval_5w = null;
    } else {
    this.red_interval_5w = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.red_interval_10w = null;
    } else {
    this.red_interval_10w = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.red_interval_20w = null;
    } else {
    this.red_interval_20w = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv_diff = null;
    } else {
    this.inv_diff = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.inv100_diff = null;
    } else {
    this.inv100_diff = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.inv1st_diff = null;
    } else {
    this.inv1st_diff = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.inv1st_all_diff = null;
    } else {
    this.inv1st_all_diff = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.reg_inv_diff = null;
    } else {
    this.reg_inv_diff = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.invre_red_num = null;
    } else {
    this.invre_red_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.invre_red_amount = null;
    } else {
    this.invre_red_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.churn_num = null;
    } else {
    this.churn_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.premium = null;
    } else {
    this.premium = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.premium_diff = null;
    } else {
    this.premium_diff = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.premium_cur = null;
    } else {
    this.premium_cur = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.inv_old_num = null;
    } else {
    this.inv_old_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.inv_old_amount = null;
    } else {
    this.inv_old_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.inv_old_premium_diff = null;
    } else {
    this.inv_old_premium_diff = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.before_reg_inv1st_num = null;
    } else {
    this.before_reg_inv1st_num = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.before_reg_inv1st_all_amount = null;
    } else {
    this.before_reg_inv1st_all_amount = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.before_reg_inv1st_premium_diff = null;
    } else {
    this.before_reg_inv1st_premium_diff = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.inv1st_premium_diff = null;
    } else {
    this.inv1st_premium_diff = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.reg_inv1st_premium_diff = null;
    } else {
    this.reg_inv1st_premium_diff = com.cloudera.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.create_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, create_date);
    }
    if (null == this.end_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, end_date);
    }
    if (null == this.channel) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, channel);
    }
    if (null == this.period) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.period);
    }
    if (null == this.activity_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.activity_num);
    }
    if (null == this.reg_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.reg_num);
    }
    if (null == this.open_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.open_num);
    }
    if (null == this.inv_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_num);
    }
    if (null == this.inv_freq) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_freq);
    }
    if (null == this.inv_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv_amount, __dataOut);
    }
    if (null == this.inv100_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv100_num);
    }
    if (null == this.inv100_freq) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv100_freq);
    }
    if (null == this.inv100_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv100_amount, __dataOut);
    }
    if (null == this.inv1st_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv1st_num);
    }
    if (null == this.inv1st_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st_amount, __dataOut);
    }
    if (null == this.inv1st100_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv1st100_num);
    }
    if (null == this.inv1st100_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st100_amount, __dataOut);
    }
    if (null == this.inv1st_all_amont) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st_all_amont, __dataOut);
    }
    if (null == this.inv1st_all100_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv1st_all100_num);
    }
    if (null == this.inv1st_all100_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st_all100_amount, __dataOut);
    }
    if (null == this.inv2nd_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv2nd_num);
    }
    if (null == this.inv2nd_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv2nd_amount, __dataOut);
    }
    if (null == this.invre_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.invre_num);
    }
    if (null == this.invre_freq) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.invre_freq);
    }
    if (null == this.invre_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.invre_amount, __dataOut);
    }
    if (null == this.redeem_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.redeem_num);
    }
    if (null == this.redeem_freq) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.redeem_freq);
    }
    if (null == this.redeem_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.redeem_amount, __dataOut);
    }
    if (null == this.regular1st_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular1st_num);
    }
    if (null == this.regular1st_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular1st_amount, __dataOut);
    }
    if (null == this.regular_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_num);
    }
    if (null == this.regular_freq) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_freq);
    }
    if (null == this.regular_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_amount, __dataOut);
    }
    if (null == this.reg_open_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.reg_open_num);
    }
    if (null == this.reg_inv1st_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.reg_inv1st_num);
    }
    if (null == this.reg_inv1st_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.reg_inv1st_amount, __dataOut);
    }
    if (null == this.reg_inv2nd_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.reg_inv2nd_num);
    }
    if (null == this.reg_inv2nd_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.reg_inv2nd_amount, __dataOut);
    }
    if (null == this.reg_inv3rdm_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.reg_inv3rdm_num);
    }
    if (null == this.reg_inv3rdm_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.reg_inv3rdm_amount, __dataOut);
    }
    if (null == this.reg_inv1st_all_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.reg_inv1st_all_amount, __dataOut);
    }
    if (null == this.reg_inv1st_all100_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.reg_inv1st_all100_num);
    }
    if (null == this.reg_inv1st_all100_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.reg_inv1st_all100_amount, __dataOut);
    }
    if (null == this.inv1st_inv2nd_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv1st_inv2nd_num);
    }
    if (null == this.inv1st_inv2nd_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st_inv2nd_amount, __dataOut);
    }
    if (null == this.inv1st_inv3rdm_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv1st_inv3rdm_num);
    }
    if (null == this.inv1st_inv3rdm_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st_inv3rdm_amount, __dataOut);
    }
    if (null == this.exp_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.exp_amount, __dataOut);
    }
    if (null == this.exp_int_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.exp_int_amount, __dataOut);
    }
    if (null == this.exp_recover_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.exp_recover_amount, __dataOut);
    }
    if (null == this.regular_1_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_1_num);
    }
    if (null == this.regular_1_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_1_amount, __dataOut);
    }
    if (null == this.regular_2_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_2_num);
    }
    if (null == this.regular_2_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_2_amount, __dataOut);
    }
    if (null == this.regular_3_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_3_num);
    }
    if (null == this.regular_3_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_3_amount, __dataOut);
    }
    if (null == this.regular_4_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_4_num);
    }
    if (null == this.regular_4_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_4_amount, __dataOut);
    }
    if (null == this.regular_5_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_5_num);
    }
    if (null == this.regular_5_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_5_amount, __dataOut);
    }
    if (null == this.regular_6_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_6_num);
    }
    if (null == this.regular_6_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_6_amount, __dataOut);
    }
    if (null == this.regular_7_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_7_num);
    }
    if (null == this.regular_7_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_7_amount, __dataOut);
    }
    if (null == this.regular_8_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_8_num);
    }
    if (null == this.regular_8_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_8_amount, __dataOut);
    }
    if (null == this.regular_9_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_9_num);
    }
    if (null == this.regular_9_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_9_amount, __dataOut);
    }
    if (null == this.regular_10_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_10_num);
    }
    if (null == this.regular_10_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_10_amount, __dataOut);
    }
    if (null == this.regular_11_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_11_num);
    }
    if (null == this.regular_11_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_11_amount, __dataOut);
    }
    if (null == this.regular_12_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_12_num);
    }
    if (null == this.regular_12_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_12_amount, __dataOut);
    }
    if (null == this.regular_premium) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium, __dataOut);
    }
    if (null == this.regular_expire) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_expire, __dataOut);
    }
    if (null == this.regular_premium_1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_1, __dataOut);
    }
    if (null == this.regular_premium_2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_2, __dataOut);
    }
    if (null == this.regular_premium_3) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_3, __dataOut);
    }
    if (null == this.regular_premium_4) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_4, __dataOut);
    }
    if (null == this.regular_premium_5) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_5, __dataOut);
    }
    if (null == this.regular_premium_6) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_6, __dataOut);
    }
    if (null == this.regular_premium_7) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_7, __dataOut);
    }
    if (null == this.regular_premium_8) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_8, __dataOut);
    }
    if (null == this.regular_premium_9) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_9, __dataOut);
    }
    if (null == this.regular_premium_10) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_10, __dataOut);
    }
    if (null == this.regular_premium_11) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_11, __dataOut);
    }
    if (null == this.regular_premium_12) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_12, __dataOut);
    }
    if (null == this.inv_interval_1k) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_interval_1k);
    }
    if (null == this.inv_interval_5k) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_interval_5k);
    }
    if (null == this.inv_interval_1w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_interval_1w);
    }
    if (null == this.inv_interval_2w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_interval_2w);
    }
    if (null == this.inv_interval_5w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_interval_5w);
    }
    if (null == this.inv_interval_10w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_interval_10w);
    }
    if (null == this.inv_interval_20w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_interval_20w);
    }
    if (null == this.inv_interval_20wm) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_interval_20wm);
    }
    if (null == this.red_interval_1h) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.red_interval_1h);
    }
    if (null == this.red_interval_1k) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.red_interval_1k);
    }
    if (null == this.red_interval_5k) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.red_interval_5k);
    }
    if (null == this.red_interval_1w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.red_interval_1w);
    }
    if (null == this.red_interval_2w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.red_interval_2w);
    }
    if (null == this.red_interval_5w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.red_interval_5w);
    }
    if (null == this.red_interval_10w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.red_interval_10w);
    }
    if (null == this.red_interval_20w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.red_interval_20w);
    }
    if (null == this.inv_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv_diff, __dataOut);
    }
    if (null == this.inv100_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv100_diff, __dataOut);
    }
    if (null == this.inv1st_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st_diff, __dataOut);
    }
    if (null == this.inv1st_all_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st_all_diff, __dataOut);
    }
    if (null == this.reg_inv_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.reg_inv_diff, __dataOut);
    }
    if (null == this.invre_red_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.invre_red_num);
    }
    if (null == this.invre_red_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.invre_red_amount, __dataOut);
    }
    if (null == this.churn_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.churn_num);
    }
    if (null == this.premium) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.premium, __dataOut);
    }
    if (null == this.premium_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.premium_diff, __dataOut);
    }
    if (null == this.premium_cur) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.premium_cur, __dataOut);
    }
    if (null == this.inv_old_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_old_num);
    }
    if (null == this.inv_old_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv_old_amount, __dataOut);
    }
    if (null == this.inv_old_premium_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv_old_premium_diff, __dataOut);
    }
    if (null == this.before_reg_inv1st_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.before_reg_inv1st_num);
    }
    if (null == this.before_reg_inv1st_all_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.before_reg_inv1st_all_amount, __dataOut);
    }
    if (null == this.before_reg_inv1st_premium_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.before_reg_inv1st_premium_diff, __dataOut);
    }
    if (null == this.inv1st_premium_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st_premium_diff, __dataOut);
    }
    if (null == this.reg_inv1st_premium_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.reg_inv1st_premium_diff, __dataOut);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.create_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, create_date);
    }
    if (null == this.end_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, end_date);
    }
    if (null == this.channel) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, channel);
    }
    if (null == this.period) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.period);
    }
    if (null == this.activity_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.activity_num);
    }
    if (null == this.reg_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.reg_num);
    }
    if (null == this.open_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.open_num);
    }
    if (null == this.inv_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_num);
    }
    if (null == this.inv_freq) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_freq);
    }
    if (null == this.inv_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv_amount, __dataOut);
    }
    if (null == this.inv100_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv100_num);
    }
    if (null == this.inv100_freq) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv100_freq);
    }
    if (null == this.inv100_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv100_amount, __dataOut);
    }
    if (null == this.inv1st_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv1st_num);
    }
    if (null == this.inv1st_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st_amount, __dataOut);
    }
    if (null == this.inv1st100_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv1st100_num);
    }
    if (null == this.inv1st100_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st100_amount, __dataOut);
    }
    if (null == this.inv1st_all_amont) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st_all_amont, __dataOut);
    }
    if (null == this.inv1st_all100_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv1st_all100_num);
    }
    if (null == this.inv1st_all100_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st_all100_amount, __dataOut);
    }
    if (null == this.inv2nd_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv2nd_num);
    }
    if (null == this.inv2nd_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv2nd_amount, __dataOut);
    }
    if (null == this.invre_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.invre_num);
    }
    if (null == this.invre_freq) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.invre_freq);
    }
    if (null == this.invre_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.invre_amount, __dataOut);
    }
    if (null == this.redeem_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.redeem_num);
    }
    if (null == this.redeem_freq) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.redeem_freq);
    }
    if (null == this.redeem_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.redeem_amount, __dataOut);
    }
    if (null == this.regular1st_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular1st_num);
    }
    if (null == this.regular1st_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular1st_amount, __dataOut);
    }
    if (null == this.regular_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_num);
    }
    if (null == this.regular_freq) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_freq);
    }
    if (null == this.regular_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_amount, __dataOut);
    }
    if (null == this.reg_open_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.reg_open_num);
    }
    if (null == this.reg_inv1st_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.reg_inv1st_num);
    }
    if (null == this.reg_inv1st_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.reg_inv1st_amount, __dataOut);
    }
    if (null == this.reg_inv2nd_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.reg_inv2nd_num);
    }
    if (null == this.reg_inv2nd_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.reg_inv2nd_amount, __dataOut);
    }
    if (null == this.reg_inv3rdm_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.reg_inv3rdm_num);
    }
    if (null == this.reg_inv3rdm_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.reg_inv3rdm_amount, __dataOut);
    }
    if (null == this.reg_inv1st_all_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.reg_inv1st_all_amount, __dataOut);
    }
    if (null == this.reg_inv1st_all100_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.reg_inv1st_all100_num);
    }
    if (null == this.reg_inv1st_all100_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.reg_inv1st_all100_amount, __dataOut);
    }
    if (null == this.inv1st_inv2nd_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv1st_inv2nd_num);
    }
    if (null == this.inv1st_inv2nd_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st_inv2nd_amount, __dataOut);
    }
    if (null == this.inv1st_inv3rdm_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv1st_inv3rdm_num);
    }
    if (null == this.inv1st_inv3rdm_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st_inv3rdm_amount, __dataOut);
    }
    if (null == this.exp_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.exp_amount, __dataOut);
    }
    if (null == this.exp_int_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.exp_int_amount, __dataOut);
    }
    if (null == this.exp_recover_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.exp_recover_amount, __dataOut);
    }
    if (null == this.regular_1_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_1_num);
    }
    if (null == this.regular_1_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_1_amount, __dataOut);
    }
    if (null == this.regular_2_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_2_num);
    }
    if (null == this.regular_2_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_2_amount, __dataOut);
    }
    if (null == this.regular_3_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_3_num);
    }
    if (null == this.regular_3_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_3_amount, __dataOut);
    }
    if (null == this.regular_4_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_4_num);
    }
    if (null == this.regular_4_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_4_amount, __dataOut);
    }
    if (null == this.regular_5_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_5_num);
    }
    if (null == this.regular_5_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_5_amount, __dataOut);
    }
    if (null == this.regular_6_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_6_num);
    }
    if (null == this.regular_6_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_6_amount, __dataOut);
    }
    if (null == this.regular_7_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_7_num);
    }
    if (null == this.regular_7_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_7_amount, __dataOut);
    }
    if (null == this.regular_8_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_8_num);
    }
    if (null == this.regular_8_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_8_amount, __dataOut);
    }
    if (null == this.regular_9_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_9_num);
    }
    if (null == this.regular_9_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_9_amount, __dataOut);
    }
    if (null == this.regular_10_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_10_num);
    }
    if (null == this.regular_10_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_10_amount, __dataOut);
    }
    if (null == this.regular_11_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_11_num);
    }
    if (null == this.regular_11_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_11_amount, __dataOut);
    }
    if (null == this.regular_12_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.regular_12_num);
    }
    if (null == this.regular_12_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_12_amount, __dataOut);
    }
    if (null == this.regular_premium) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium, __dataOut);
    }
    if (null == this.regular_expire) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_expire, __dataOut);
    }
    if (null == this.regular_premium_1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_1, __dataOut);
    }
    if (null == this.regular_premium_2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_2, __dataOut);
    }
    if (null == this.regular_premium_3) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_3, __dataOut);
    }
    if (null == this.regular_premium_4) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_4, __dataOut);
    }
    if (null == this.regular_premium_5) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_5, __dataOut);
    }
    if (null == this.regular_premium_6) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_6, __dataOut);
    }
    if (null == this.regular_premium_7) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_7, __dataOut);
    }
    if (null == this.regular_premium_8) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_8, __dataOut);
    }
    if (null == this.regular_premium_9) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_9, __dataOut);
    }
    if (null == this.regular_premium_10) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_10, __dataOut);
    }
    if (null == this.regular_premium_11) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_11, __dataOut);
    }
    if (null == this.regular_premium_12) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.regular_premium_12, __dataOut);
    }
    if (null == this.inv_interval_1k) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_interval_1k);
    }
    if (null == this.inv_interval_5k) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_interval_5k);
    }
    if (null == this.inv_interval_1w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_interval_1w);
    }
    if (null == this.inv_interval_2w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_interval_2w);
    }
    if (null == this.inv_interval_5w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_interval_5w);
    }
    if (null == this.inv_interval_10w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_interval_10w);
    }
    if (null == this.inv_interval_20w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_interval_20w);
    }
    if (null == this.inv_interval_20wm) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_interval_20wm);
    }
    if (null == this.red_interval_1h) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.red_interval_1h);
    }
    if (null == this.red_interval_1k) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.red_interval_1k);
    }
    if (null == this.red_interval_5k) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.red_interval_5k);
    }
    if (null == this.red_interval_1w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.red_interval_1w);
    }
    if (null == this.red_interval_2w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.red_interval_2w);
    }
    if (null == this.red_interval_5w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.red_interval_5w);
    }
    if (null == this.red_interval_10w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.red_interval_10w);
    }
    if (null == this.red_interval_20w) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.red_interval_20w);
    }
    if (null == this.inv_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv_diff, __dataOut);
    }
    if (null == this.inv100_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv100_diff, __dataOut);
    }
    if (null == this.inv1st_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st_diff, __dataOut);
    }
    if (null == this.inv1st_all_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st_all_diff, __dataOut);
    }
    if (null == this.reg_inv_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.reg_inv_diff, __dataOut);
    }
    if (null == this.invre_red_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.invre_red_num);
    }
    if (null == this.invre_red_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.invre_red_amount, __dataOut);
    }
    if (null == this.churn_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.churn_num);
    }
    if (null == this.premium) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.premium, __dataOut);
    }
    if (null == this.premium_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.premium_diff, __dataOut);
    }
    if (null == this.premium_cur) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.premium_cur, __dataOut);
    }
    if (null == this.inv_old_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.inv_old_num);
    }
    if (null == this.inv_old_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv_old_amount, __dataOut);
    }
    if (null == this.inv_old_premium_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv_old_premium_diff, __dataOut);
    }
    if (null == this.before_reg_inv1st_num) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.before_reg_inv1st_num);
    }
    if (null == this.before_reg_inv1st_all_amount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.before_reg_inv1st_all_amount, __dataOut);
    }
    if (null == this.before_reg_inv1st_premium_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.before_reg_inv1st_premium_diff, __dataOut);
    }
    if (null == this.inv1st_premium_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.inv1st_premium_diff, __dataOut);
    }
    if (null == this.reg_inv1st_premium_diff) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    com.cloudera.sqoop.lib.BigDecimalSerializer.write(this.reg_inv1st_premium_diff, __dataOut);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(create_date==null?"null":create_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(end_date==null?"null":end_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(channel==null?"null":channel, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(period==null?"null":"" + period, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(activity_num==null?"null":"" + activity_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_num==null?"null":"" + reg_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(open_num==null?"null":"" + open_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_num==null?"null":"" + inv_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_freq==null?"null":"" + inv_freq, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_amount==null?"null":inv_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv100_num==null?"null":"" + inv100_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv100_freq==null?"null":"" + inv100_freq, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv100_amount==null?"null":inv100_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_num==null?"null":"" + inv1st_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_amount==null?"null":inv1st_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st100_num==null?"null":"" + inv1st100_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st100_amount==null?"null":inv1st100_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_all_amont==null?"null":inv1st_all_amont.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_all100_num==null?"null":"" + inv1st_all100_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_all100_amount==null?"null":inv1st_all100_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv2nd_num==null?"null":"" + inv2nd_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv2nd_amount==null?"null":inv2nd_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(invre_num==null?"null":"" + invre_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(invre_freq==null?"null":"" + invre_freq, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(invre_amount==null?"null":invre_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(redeem_num==null?"null":"" + redeem_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(redeem_freq==null?"null":"" + redeem_freq, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(redeem_amount==null?"null":redeem_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular1st_num==null?"null":"" + regular1st_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular1st_amount==null?"null":regular1st_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_num==null?"null":"" + regular_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_freq==null?"null":"" + regular_freq, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_amount==null?"null":regular_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_open_num==null?"null":"" + reg_open_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv1st_num==null?"null":"" + reg_inv1st_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv1st_amount==null?"null":reg_inv1st_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv2nd_num==null?"null":"" + reg_inv2nd_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv2nd_amount==null?"null":reg_inv2nd_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv3rdm_num==null?"null":"" + reg_inv3rdm_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv3rdm_amount==null?"null":reg_inv3rdm_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv1st_all_amount==null?"null":reg_inv1st_all_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv1st_all100_num==null?"null":"" + reg_inv1st_all100_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv1st_all100_amount==null?"null":reg_inv1st_all100_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_inv2nd_num==null?"null":"" + inv1st_inv2nd_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_inv2nd_amount==null?"null":inv1st_inv2nd_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_inv3rdm_num==null?"null":"" + inv1st_inv3rdm_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_inv3rdm_amount==null?"null":inv1st_inv3rdm_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(exp_amount==null?"null":exp_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(exp_int_amount==null?"null":exp_int_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(exp_recover_amount==null?"null":exp_recover_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_1_num==null?"null":"" + regular_1_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_1_amount==null?"null":regular_1_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_2_num==null?"null":"" + regular_2_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_2_amount==null?"null":regular_2_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_3_num==null?"null":"" + regular_3_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_3_amount==null?"null":regular_3_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_4_num==null?"null":"" + regular_4_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_4_amount==null?"null":regular_4_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_5_num==null?"null":"" + regular_5_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_5_amount==null?"null":regular_5_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_6_num==null?"null":"" + regular_6_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_6_amount==null?"null":regular_6_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_7_num==null?"null":"" + regular_7_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_7_amount==null?"null":regular_7_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_8_num==null?"null":"" + regular_8_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_8_amount==null?"null":regular_8_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_9_num==null?"null":"" + regular_9_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_9_amount==null?"null":regular_9_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_10_num==null?"null":"" + regular_10_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_10_amount==null?"null":regular_10_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_11_num==null?"null":"" + regular_11_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_11_amount==null?"null":regular_11_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_12_num==null?"null":"" + regular_12_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_12_amount==null?"null":regular_12_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium==null?"null":regular_premium.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_expire==null?"null":regular_expire.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_1==null?"null":regular_premium_1.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_2==null?"null":regular_premium_2.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_3==null?"null":regular_premium_3.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_4==null?"null":regular_premium_4.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_5==null?"null":regular_premium_5.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_6==null?"null":regular_premium_6.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_7==null?"null":regular_premium_7.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_8==null?"null":regular_premium_8.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_9==null?"null":regular_premium_9.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_10==null?"null":regular_premium_10.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_11==null?"null":regular_premium_11.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_12==null?"null":regular_premium_12.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_interval_1k==null?"null":"" + inv_interval_1k, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_interval_5k==null?"null":"" + inv_interval_5k, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_interval_1w==null?"null":"" + inv_interval_1w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_interval_2w==null?"null":"" + inv_interval_2w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_interval_5w==null?"null":"" + inv_interval_5w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_interval_10w==null?"null":"" + inv_interval_10w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_interval_20w==null?"null":"" + inv_interval_20w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_interval_20wm==null?"null":"" + inv_interval_20wm, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(red_interval_1h==null?"null":"" + red_interval_1h, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(red_interval_1k==null?"null":"" + red_interval_1k, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(red_interval_5k==null?"null":"" + red_interval_5k, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(red_interval_1w==null?"null":"" + red_interval_1w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(red_interval_2w==null?"null":"" + red_interval_2w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(red_interval_5w==null?"null":"" + red_interval_5w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(red_interval_10w==null?"null":"" + red_interval_10w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(red_interval_20w==null?"null":"" + red_interval_20w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_diff==null?"null":inv_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv100_diff==null?"null":inv100_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_diff==null?"null":inv1st_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_all_diff==null?"null":inv1st_all_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv_diff==null?"null":reg_inv_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(invre_red_num==null?"null":"" + invre_red_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(invre_red_amount==null?"null":invre_red_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(churn_num==null?"null":"" + churn_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(premium==null?"null":premium.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(premium_diff==null?"null":premium_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(premium_cur==null?"null":premium_cur.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_old_num==null?"null":"" + inv_old_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_old_amount==null?"null":inv_old_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_old_premium_diff==null?"null":inv_old_premium_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(before_reg_inv1st_num==null?"null":"" + before_reg_inv1st_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(before_reg_inv1st_all_amount==null?"null":before_reg_inv1st_all_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(before_reg_inv1st_premium_diff==null?"null":before_reg_inv1st_premium_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_premium_diff==null?"null":inv1st_premium_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv1st_premium_diff==null?"null":reg_inv1st_premium_diff.toPlainString(), delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(create_date==null?"null":create_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(end_date==null?"null":end_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(channel==null?"null":channel, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(period==null?"null":"" + period, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(activity_num==null?"null":"" + activity_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_num==null?"null":"" + reg_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(open_num==null?"null":"" + open_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_num==null?"null":"" + inv_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_freq==null?"null":"" + inv_freq, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_amount==null?"null":inv_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv100_num==null?"null":"" + inv100_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv100_freq==null?"null":"" + inv100_freq, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv100_amount==null?"null":inv100_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_num==null?"null":"" + inv1st_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_amount==null?"null":inv1st_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st100_num==null?"null":"" + inv1st100_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st100_amount==null?"null":inv1st100_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_all_amont==null?"null":inv1st_all_amont.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_all100_num==null?"null":"" + inv1st_all100_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_all100_amount==null?"null":inv1st_all100_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv2nd_num==null?"null":"" + inv2nd_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv2nd_amount==null?"null":inv2nd_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(invre_num==null?"null":"" + invre_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(invre_freq==null?"null":"" + invre_freq, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(invre_amount==null?"null":invre_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(redeem_num==null?"null":"" + redeem_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(redeem_freq==null?"null":"" + redeem_freq, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(redeem_amount==null?"null":redeem_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular1st_num==null?"null":"" + regular1st_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular1st_amount==null?"null":regular1st_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_num==null?"null":"" + regular_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_freq==null?"null":"" + regular_freq, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_amount==null?"null":regular_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_open_num==null?"null":"" + reg_open_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv1st_num==null?"null":"" + reg_inv1st_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv1st_amount==null?"null":reg_inv1st_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv2nd_num==null?"null":"" + reg_inv2nd_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv2nd_amount==null?"null":reg_inv2nd_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv3rdm_num==null?"null":"" + reg_inv3rdm_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv3rdm_amount==null?"null":reg_inv3rdm_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv1st_all_amount==null?"null":reg_inv1st_all_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv1st_all100_num==null?"null":"" + reg_inv1st_all100_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv1st_all100_amount==null?"null":reg_inv1st_all100_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_inv2nd_num==null?"null":"" + inv1st_inv2nd_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_inv2nd_amount==null?"null":inv1st_inv2nd_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_inv3rdm_num==null?"null":"" + inv1st_inv3rdm_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_inv3rdm_amount==null?"null":inv1st_inv3rdm_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(exp_amount==null?"null":exp_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(exp_int_amount==null?"null":exp_int_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(exp_recover_amount==null?"null":exp_recover_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_1_num==null?"null":"" + regular_1_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_1_amount==null?"null":regular_1_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_2_num==null?"null":"" + regular_2_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_2_amount==null?"null":regular_2_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_3_num==null?"null":"" + regular_3_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_3_amount==null?"null":regular_3_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_4_num==null?"null":"" + regular_4_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_4_amount==null?"null":regular_4_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_5_num==null?"null":"" + regular_5_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_5_amount==null?"null":regular_5_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_6_num==null?"null":"" + regular_6_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_6_amount==null?"null":regular_6_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_7_num==null?"null":"" + regular_7_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_7_amount==null?"null":regular_7_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_8_num==null?"null":"" + regular_8_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_8_amount==null?"null":regular_8_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_9_num==null?"null":"" + regular_9_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_9_amount==null?"null":regular_9_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_10_num==null?"null":"" + regular_10_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_10_amount==null?"null":regular_10_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_11_num==null?"null":"" + regular_11_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_11_amount==null?"null":regular_11_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_12_num==null?"null":"" + regular_12_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_12_amount==null?"null":regular_12_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium==null?"null":regular_premium.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_expire==null?"null":regular_expire.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_1==null?"null":regular_premium_1.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_2==null?"null":regular_premium_2.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_3==null?"null":regular_premium_3.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_4==null?"null":regular_premium_4.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_5==null?"null":regular_premium_5.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_6==null?"null":regular_premium_6.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_7==null?"null":regular_premium_7.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_8==null?"null":regular_premium_8.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_9==null?"null":regular_premium_9.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_10==null?"null":regular_premium_10.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_11==null?"null":regular_premium_11.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(regular_premium_12==null?"null":regular_premium_12.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_interval_1k==null?"null":"" + inv_interval_1k, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_interval_5k==null?"null":"" + inv_interval_5k, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_interval_1w==null?"null":"" + inv_interval_1w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_interval_2w==null?"null":"" + inv_interval_2w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_interval_5w==null?"null":"" + inv_interval_5w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_interval_10w==null?"null":"" + inv_interval_10w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_interval_20w==null?"null":"" + inv_interval_20w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_interval_20wm==null?"null":"" + inv_interval_20wm, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(red_interval_1h==null?"null":"" + red_interval_1h, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(red_interval_1k==null?"null":"" + red_interval_1k, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(red_interval_5k==null?"null":"" + red_interval_5k, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(red_interval_1w==null?"null":"" + red_interval_1w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(red_interval_2w==null?"null":"" + red_interval_2w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(red_interval_5w==null?"null":"" + red_interval_5w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(red_interval_10w==null?"null":"" + red_interval_10w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(red_interval_20w==null?"null":"" + red_interval_20w, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_diff==null?"null":inv_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv100_diff==null?"null":inv100_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_diff==null?"null":inv1st_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_all_diff==null?"null":inv1st_all_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv_diff==null?"null":reg_inv_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(invre_red_num==null?"null":"" + invre_red_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(invre_red_amount==null?"null":invre_red_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(churn_num==null?"null":"" + churn_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(premium==null?"null":premium.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(premium_diff==null?"null":premium_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(premium_cur==null?"null":premium_cur.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_old_num==null?"null":"" + inv_old_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_old_amount==null?"null":inv_old_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv_old_premium_diff==null?"null":inv_old_premium_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(before_reg_inv1st_num==null?"null":"" + before_reg_inv1st_num, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(before_reg_inv1st_all_amount==null?"null":before_reg_inv1st_all_amount.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(before_reg_inv1st_premium_diff==null?"null":before_reg_inv1st_premium_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(inv1st_premium_diff==null?"null":inv1st_premium_diff.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(reg_inv1st_premium_diff==null?"null":reg_inv1st_premium_diff.toPlainString(), delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 9, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.create_date = null; } else {
      this.create_date = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.end_date = null; } else {
      this.end_date = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.channel = null; } else {
      this.channel = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.period = null; } else {
      this.period = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.activity_num = null; } else {
      this.activity_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_num = null; } else {
      this.reg_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.open_num = null; } else {
      this.open_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_num = null; } else {
      this.inv_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_freq = null; } else {
      this.inv_freq = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_amount = null; } else {
      this.inv_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv100_num = null; } else {
      this.inv100_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv100_freq = null; } else {
      this.inv100_freq = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv100_amount = null; } else {
      this.inv100_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_num = null; } else {
      this.inv1st_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_amount = null; } else {
      this.inv1st_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st100_num = null; } else {
      this.inv1st100_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st100_amount = null; } else {
      this.inv1st100_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_all_amont = null; } else {
      this.inv1st_all_amont = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_all100_num = null; } else {
      this.inv1st_all100_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_all100_amount = null; } else {
      this.inv1st_all100_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv2nd_num = null; } else {
      this.inv2nd_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv2nd_amount = null; } else {
      this.inv2nd_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.invre_num = null; } else {
      this.invre_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.invre_freq = null; } else {
      this.invre_freq = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.invre_amount = null; } else {
      this.invre_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.redeem_num = null; } else {
      this.redeem_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.redeem_freq = null; } else {
      this.redeem_freq = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.redeem_amount = null; } else {
      this.redeem_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular1st_num = null; } else {
      this.regular1st_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular1st_amount = null; } else {
      this.regular1st_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_num = null; } else {
      this.regular_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_freq = null; } else {
      this.regular_freq = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_amount = null; } else {
      this.regular_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_open_num = null; } else {
      this.reg_open_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv1st_num = null; } else {
      this.reg_inv1st_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv1st_amount = null; } else {
      this.reg_inv1st_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv2nd_num = null; } else {
      this.reg_inv2nd_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv2nd_amount = null; } else {
      this.reg_inv2nd_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv3rdm_num = null; } else {
      this.reg_inv3rdm_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv3rdm_amount = null; } else {
      this.reg_inv3rdm_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv1st_all_amount = null; } else {
      this.reg_inv1st_all_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv1st_all100_num = null; } else {
      this.reg_inv1st_all100_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv1st_all100_amount = null; } else {
      this.reg_inv1st_all100_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_inv2nd_num = null; } else {
      this.inv1st_inv2nd_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_inv2nd_amount = null; } else {
      this.inv1st_inv2nd_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_inv3rdm_num = null; } else {
      this.inv1st_inv3rdm_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_inv3rdm_amount = null; } else {
      this.inv1st_inv3rdm_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.exp_amount = null; } else {
      this.exp_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.exp_int_amount = null; } else {
      this.exp_int_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.exp_recover_amount = null; } else {
      this.exp_recover_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_1_num = null; } else {
      this.regular_1_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_1_amount = null; } else {
      this.regular_1_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_2_num = null; } else {
      this.regular_2_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_2_amount = null; } else {
      this.regular_2_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_3_num = null; } else {
      this.regular_3_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_3_amount = null; } else {
      this.regular_3_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_4_num = null; } else {
      this.regular_4_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_4_amount = null; } else {
      this.regular_4_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_5_num = null; } else {
      this.regular_5_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_5_amount = null; } else {
      this.regular_5_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_6_num = null; } else {
      this.regular_6_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_6_amount = null; } else {
      this.regular_6_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_7_num = null; } else {
      this.regular_7_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_7_amount = null; } else {
      this.regular_7_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_8_num = null; } else {
      this.regular_8_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_8_amount = null; } else {
      this.regular_8_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_9_num = null; } else {
      this.regular_9_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_9_amount = null; } else {
      this.regular_9_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_10_num = null; } else {
      this.regular_10_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_10_amount = null; } else {
      this.regular_10_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_11_num = null; } else {
      this.regular_11_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_11_amount = null; } else {
      this.regular_11_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_12_num = null; } else {
      this.regular_12_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_12_amount = null; } else {
      this.regular_12_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium = null; } else {
      this.regular_premium = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_expire = null; } else {
      this.regular_expire = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_1 = null; } else {
      this.regular_premium_1 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_2 = null; } else {
      this.regular_premium_2 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_3 = null; } else {
      this.regular_premium_3 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_4 = null; } else {
      this.regular_premium_4 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_5 = null; } else {
      this.regular_premium_5 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_6 = null; } else {
      this.regular_premium_6 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_7 = null; } else {
      this.regular_premium_7 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_8 = null; } else {
      this.regular_premium_8 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_9 = null; } else {
      this.regular_premium_9 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_10 = null; } else {
      this.regular_premium_10 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_11 = null; } else {
      this.regular_premium_11 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_12 = null; } else {
      this.regular_premium_12 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_interval_1k = null; } else {
      this.inv_interval_1k = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_interval_5k = null; } else {
      this.inv_interval_5k = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_interval_1w = null; } else {
      this.inv_interval_1w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_interval_2w = null; } else {
      this.inv_interval_2w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_interval_5w = null; } else {
      this.inv_interval_5w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_interval_10w = null; } else {
      this.inv_interval_10w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_interval_20w = null; } else {
      this.inv_interval_20w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_interval_20wm = null; } else {
      this.inv_interval_20wm = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.red_interval_1h = null; } else {
      this.red_interval_1h = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.red_interval_1k = null; } else {
      this.red_interval_1k = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.red_interval_5k = null; } else {
      this.red_interval_5k = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.red_interval_1w = null; } else {
      this.red_interval_1w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.red_interval_2w = null; } else {
      this.red_interval_2w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.red_interval_5w = null; } else {
      this.red_interval_5w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.red_interval_10w = null; } else {
      this.red_interval_10w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.red_interval_20w = null; } else {
      this.red_interval_20w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_diff = null; } else {
      this.inv_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv100_diff = null; } else {
      this.inv100_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_diff = null; } else {
      this.inv1st_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_all_diff = null; } else {
      this.inv1st_all_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv_diff = null; } else {
      this.reg_inv_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.invre_red_num = null; } else {
      this.invre_red_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.invre_red_amount = null; } else {
      this.invre_red_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.churn_num = null; } else {
      this.churn_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.premium = null; } else {
      this.premium = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.premium_diff = null; } else {
      this.premium_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.premium_cur = null; } else {
      this.premium_cur = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_old_num = null; } else {
      this.inv_old_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_old_amount = null; } else {
      this.inv_old_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_old_premium_diff = null; } else {
      this.inv_old_premium_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.before_reg_inv1st_num = null; } else {
      this.before_reg_inv1st_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.before_reg_inv1st_all_amount = null; } else {
      this.before_reg_inv1st_all_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.before_reg_inv1st_premium_diff = null; } else {
      this.before_reg_inv1st_premium_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_premium_diff = null; } else {
      this.inv1st_premium_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv1st_premium_diff = null; } else {
      this.reg_inv1st_premium_diff = new java.math.BigDecimal(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.create_date = null; } else {
      this.create_date = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.end_date = null; } else {
      this.end_date = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.channel = null; } else {
      this.channel = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.period = null; } else {
      this.period = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.activity_num = null; } else {
      this.activity_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_num = null; } else {
      this.reg_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.open_num = null; } else {
      this.open_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_num = null; } else {
      this.inv_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_freq = null; } else {
      this.inv_freq = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_amount = null; } else {
      this.inv_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv100_num = null; } else {
      this.inv100_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv100_freq = null; } else {
      this.inv100_freq = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv100_amount = null; } else {
      this.inv100_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_num = null; } else {
      this.inv1st_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_amount = null; } else {
      this.inv1st_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st100_num = null; } else {
      this.inv1st100_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st100_amount = null; } else {
      this.inv1st100_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_all_amont = null; } else {
      this.inv1st_all_amont = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_all100_num = null; } else {
      this.inv1st_all100_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_all100_amount = null; } else {
      this.inv1st_all100_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv2nd_num = null; } else {
      this.inv2nd_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv2nd_amount = null; } else {
      this.inv2nd_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.invre_num = null; } else {
      this.invre_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.invre_freq = null; } else {
      this.invre_freq = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.invre_amount = null; } else {
      this.invre_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.redeem_num = null; } else {
      this.redeem_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.redeem_freq = null; } else {
      this.redeem_freq = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.redeem_amount = null; } else {
      this.redeem_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular1st_num = null; } else {
      this.regular1st_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular1st_amount = null; } else {
      this.regular1st_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_num = null; } else {
      this.regular_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_freq = null; } else {
      this.regular_freq = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_amount = null; } else {
      this.regular_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_open_num = null; } else {
      this.reg_open_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv1st_num = null; } else {
      this.reg_inv1st_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv1st_amount = null; } else {
      this.reg_inv1st_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv2nd_num = null; } else {
      this.reg_inv2nd_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv2nd_amount = null; } else {
      this.reg_inv2nd_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv3rdm_num = null; } else {
      this.reg_inv3rdm_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv3rdm_amount = null; } else {
      this.reg_inv3rdm_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv1st_all_amount = null; } else {
      this.reg_inv1st_all_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv1st_all100_num = null; } else {
      this.reg_inv1st_all100_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv1st_all100_amount = null; } else {
      this.reg_inv1st_all100_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_inv2nd_num = null; } else {
      this.inv1st_inv2nd_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_inv2nd_amount = null; } else {
      this.inv1st_inv2nd_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_inv3rdm_num = null; } else {
      this.inv1st_inv3rdm_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_inv3rdm_amount = null; } else {
      this.inv1st_inv3rdm_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.exp_amount = null; } else {
      this.exp_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.exp_int_amount = null; } else {
      this.exp_int_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.exp_recover_amount = null; } else {
      this.exp_recover_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_1_num = null; } else {
      this.regular_1_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_1_amount = null; } else {
      this.regular_1_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_2_num = null; } else {
      this.regular_2_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_2_amount = null; } else {
      this.regular_2_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_3_num = null; } else {
      this.regular_3_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_3_amount = null; } else {
      this.regular_3_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_4_num = null; } else {
      this.regular_4_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_4_amount = null; } else {
      this.regular_4_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_5_num = null; } else {
      this.regular_5_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_5_amount = null; } else {
      this.regular_5_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_6_num = null; } else {
      this.regular_6_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_6_amount = null; } else {
      this.regular_6_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_7_num = null; } else {
      this.regular_7_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_7_amount = null; } else {
      this.regular_7_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_8_num = null; } else {
      this.regular_8_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_8_amount = null; } else {
      this.regular_8_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_9_num = null; } else {
      this.regular_9_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_9_amount = null; } else {
      this.regular_9_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_10_num = null; } else {
      this.regular_10_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_10_amount = null; } else {
      this.regular_10_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_11_num = null; } else {
      this.regular_11_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_11_amount = null; } else {
      this.regular_11_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_12_num = null; } else {
      this.regular_12_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_12_amount = null; } else {
      this.regular_12_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium = null; } else {
      this.regular_premium = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_expire = null; } else {
      this.regular_expire = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_1 = null; } else {
      this.regular_premium_1 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_2 = null; } else {
      this.regular_premium_2 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_3 = null; } else {
      this.regular_premium_3 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_4 = null; } else {
      this.regular_premium_4 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_5 = null; } else {
      this.regular_premium_5 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_6 = null; } else {
      this.regular_premium_6 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_7 = null; } else {
      this.regular_premium_7 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_8 = null; } else {
      this.regular_premium_8 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_9 = null; } else {
      this.regular_premium_9 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_10 = null; } else {
      this.regular_premium_10 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_11 = null; } else {
      this.regular_premium_11 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.regular_premium_12 = null; } else {
      this.regular_premium_12 = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_interval_1k = null; } else {
      this.inv_interval_1k = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_interval_5k = null; } else {
      this.inv_interval_5k = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_interval_1w = null; } else {
      this.inv_interval_1w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_interval_2w = null; } else {
      this.inv_interval_2w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_interval_5w = null; } else {
      this.inv_interval_5w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_interval_10w = null; } else {
      this.inv_interval_10w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_interval_20w = null; } else {
      this.inv_interval_20w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_interval_20wm = null; } else {
      this.inv_interval_20wm = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.red_interval_1h = null; } else {
      this.red_interval_1h = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.red_interval_1k = null; } else {
      this.red_interval_1k = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.red_interval_5k = null; } else {
      this.red_interval_5k = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.red_interval_1w = null; } else {
      this.red_interval_1w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.red_interval_2w = null; } else {
      this.red_interval_2w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.red_interval_5w = null; } else {
      this.red_interval_5w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.red_interval_10w = null; } else {
      this.red_interval_10w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.red_interval_20w = null; } else {
      this.red_interval_20w = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_diff = null; } else {
      this.inv_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv100_diff = null; } else {
      this.inv100_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_diff = null; } else {
      this.inv1st_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_all_diff = null; } else {
      this.inv1st_all_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv_diff = null; } else {
      this.reg_inv_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.invre_red_num = null; } else {
      this.invre_red_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.invre_red_amount = null; } else {
      this.invre_red_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.churn_num = null; } else {
      this.churn_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.premium = null; } else {
      this.premium = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.premium_diff = null; } else {
      this.premium_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.premium_cur = null; } else {
      this.premium_cur = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_old_num = null; } else {
      this.inv_old_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_old_amount = null; } else {
      this.inv_old_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv_old_premium_diff = null; } else {
      this.inv_old_premium_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.before_reg_inv1st_num = null; } else {
      this.before_reg_inv1st_num = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.before_reg_inv1st_all_amount = null; } else {
      this.before_reg_inv1st_all_amount = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.before_reg_inv1st_premium_diff = null; } else {
      this.before_reg_inv1st_premium_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.inv1st_premium_diff = null; } else {
      this.inv1st_premium_diff = new java.math.BigDecimal(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.reg_inv1st_premium_diff = null; } else {
      this.reg_inv1st_premium_diff = new java.math.BigDecimal(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    JLC_TOPIC_USER_APP o = (JLC_TOPIC_USER_APP) super.clone();
    return o;
  }

  public void clone0(JLC_TOPIC_USER_APP o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("create_date", this.create_date);
    __sqoop$field_map.put("end_date", this.end_date);
    __sqoop$field_map.put("channel", this.channel);
    __sqoop$field_map.put("period", this.period);
    __sqoop$field_map.put("activity_num", this.activity_num);
    __sqoop$field_map.put("reg_num", this.reg_num);
    __sqoop$field_map.put("open_num", this.open_num);
    __sqoop$field_map.put("inv_num", this.inv_num);
    __sqoop$field_map.put("inv_freq", this.inv_freq);
    __sqoop$field_map.put("inv_amount", this.inv_amount);
    __sqoop$field_map.put("inv100_num", this.inv100_num);
    __sqoop$field_map.put("inv100_freq", this.inv100_freq);
    __sqoop$field_map.put("inv100_amount", this.inv100_amount);
    __sqoop$field_map.put("inv1st_num", this.inv1st_num);
    __sqoop$field_map.put("inv1st_amount", this.inv1st_amount);
    __sqoop$field_map.put("inv1st100_num", this.inv1st100_num);
    __sqoop$field_map.put("inv1st100_amount", this.inv1st100_amount);
    __sqoop$field_map.put("inv1st_all_amont", this.inv1st_all_amont);
    __sqoop$field_map.put("inv1st_all100_num", this.inv1st_all100_num);
    __sqoop$field_map.put("inv1st_all100_amount", this.inv1st_all100_amount);
    __sqoop$field_map.put("inv2nd_num", this.inv2nd_num);
    __sqoop$field_map.put("inv2nd_amount", this.inv2nd_amount);
    __sqoop$field_map.put("invre_num", this.invre_num);
    __sqoop$field_map.put("invre_freq", this.invre_freq);
    __sqoop$field_map.put("invre_amount", this.invre_amount);
    __sqoop$field_map.put("redeem_num", this.redeem_num);
    __sqoop$field_map.put("redeem_freq", this.redeem_freq);
    __sqoop$field_map.put("redeem_amount", this.redeem_amount);
    __sqoop$field_map.put("regular1st_num", this.regular1st_num);
    __sqoop$field_map.put("regular1st_amount", this.regular1st_amount);
    __sqoop$field_map.put("regular_num", this.regular_num);
    __sqoop$field_map.put("regular_freq", this.regular_freq);
    __sqoop$field_map.put("regular_amount", this.regular_amount);
    __sqoop$field_map.put("reg_open_num", this.reg_open_num);
    __sqoop$field_map.put("reg_inv1st_num", this.reg_inv1st_num);
    __sqoop$field_map.put("reg_inv1st_amount", this.reg_inv1st_amount);
    __sqoop$field_map.put("reg_inv2nd_num", this.reg_inv2nd_num);
    __sqoop$field_map.put("reg_inv2nd_amount", this.reg_inv2nd_amount);
    __sqoop$field_map.put("reg_inv3rdm_num", this.reg_inv3rdm_num);
    __sqoop$field_map.put("reg_inv3rdm_amount", this.reg_inv3rdm_amount);
    __sqoop$field_map.put("reg_inv1st_all_amount", this.reg_inv1st_all_amount);
    __sqoop$field_map.put("reg_inv1st_all100_num", this.reg_inv1st_all100_num);
    __sqoop$field_map.put("reg_inv1st_all100_amount", this.reg_inv1st_all100_amount);
    __sqoop$field_map.put("inv1st_inv2nd_num", this.inv1st_inv2nd_num);
    __sqoop$field_map.put("inv1st_inv2nd_amount", this.inv1st_inv2nd_amount);
    __sqoop$field_map.put("inv1st_inv3rdm_num", this.inv1st_inv3rdm_num);
    __sqoop$field_map.put("inv1st_inv3rdm_amount", this.inv1st_inv3rdm_amount);
    __sqoop$field_map.put("exp_amount", this.exp_amount);
    __sqoop$field_map.put("exp_int_amount", this.exp_int_amount);
    __sqoop$field_map.put("exp_recover_amount", this.exp_recover_amount);
    __sqoop$field_map.put("regular_1_num", this.regular_1_num);
    __sqoop$field_map.put("regular_1_amount", this.regular_1_amount);
    __sqoop$field_map.put("regular_2_num", this.regular_2_num);
    __sqoop$field_map.put("regular_2_amount", this.regular_2_amount);
    __sqoop$field_map.put("regular_3_num", this.regular_3_num);
    __sqoop$field_map.put("regular_3_amount", this.regular_3_amount);
    __sqoop$field_map.put("regular_4_num", this.regular_4_num);
    __sqoop$field_map.put("regular_4_amount", this.regular_4_amount);
    __sqoop$field_map.put("regular_5_num", this.regular_5_num);
    __sqoop$field_map.put("regular_5_amount", this.regular_5_amount);
    __sqoop$field_map.put("regular_6_num", this.regular_6_num);
    __sqoop$field_map.put("regular_6_amount", this.regular_6_amount);
    __sqoop$field_map.put("regular_7_num", this.regular_7_num);
    __sqoop$field_map.put("regular_7_amount", this.regular_7_amount);
    __sqoop$field_map.put("regular_8_num", this.regular_8_num);
    __sqoop$field_map.put("regular_8_amount", this.regular_8_amount);
    __sqoop$field_map.put("regular_9_num", this.regular_9_num);
    __sqoop$field_map.put("regular_9_amount", this.regular_9_amount);
    __sqoop$field_map.put("regular_10_num", this.regular_10_num);
    __sqoop$field_map.put("regular_10_amount", this.regular_10_amount);
    __sqoop$field_map.put("regular_11_num", this.regular_11_num);
    __sqoop$field_map.put("regular_11_amount", this.regular_11_amount);
    __sqoop$field_map.put("regular_12_num", this.regular_12_num);
    __sqoop$field_map.put("regular_12_amount", this.regular_12_amount);
    __sqoop$field_map.put("regular_premium", this.regular_premium);
    __sqoop$field_map.put("regular_expire", this.regular_expire);
    __sqoop$field_map.put("regular_premium_1", this.regular_premium_1);
    __sqoop$field_map.put("regular_premium_2", this.regular_premium_2);
    __sqoop$field_map.put("regular_premium_3", this.regular_premium_3);
    __sqoop$field_map.put("regular_premium_4", this.regular_premium_4);
    __sqoop$field_map.put("regular_premium_5", this.regular_premium_5);
    __sqoop$field_map.put("regular_premium_6", this.regular_premium_6);
    __sqoop$field_map.put("regular_premium_7", this.regular_premium_7);
    __sqoop$field_map.put("regular_premium_8", this.regular_premium_8);
    __sqoop$field_map.put("regular_premium_9", this.regular_premium_9);
    __sqoop$field_map.put("regular_premium_10", this.regular_premium_10);
    __sqoop$field_map.put("regular_premium_11", this.regular_premium_11);
    __sqoop$field_map.put("regular_premium_12", this.regular_premium_12);
    __sqoop$field_map.put("inv_interval_1k", this.inv_interval_1k);
    __sqoop$field_map.put("inv_interval_5k", this.inv_interval_5k);
    __sqoop$field_map.put("inv_interval_1w", this.inv_interval_1w);
    __sqoop$field_map.put("inv_interval_2w", this.inv_interval_2w);
    __sqoop$field_map.put("inv_interval_5w", this.inv_interval_5w);
    __sqoop$field_map.put("inv_interval_10w", this.inv_interval_10w);
    __sqoop$field_map.put("inv_interval_20w", this.inv_interval_20w);
    __sqoop$field_map.put("inv_interval_20wm", this.inv_interval_20wm);
    __sqoop$field_map.put("red_interval_1h", this.red_interval_1h);
    __sqoop$field_map.put("red_interval_1k", this.red_interval_1k);
    __sqoop$field_map.put("red_interval_5k", this.red_interval_5k);
    __sqoop$field_map.put("red_interval_1w", this.red_interval_1w);
    __sqoop$field_map.put("red_interval_2w", this.red_interval_2w);
    __sqoop$field_map.put("red_interval_5w", this.red_interval_5w);
    __sqoop$field_map.put("red_interval_10w", this.red_interval_10w);
    __sqoop$field_map.put("red_interval_20w", this.red_interval_20w);
    __sqoop$field_map.put("inv_diff", this.inv_diff);
    __sqoop$field_map.put("inv100_diff", this.inv100_diff);
    __sqoop$field_map.put("inv1st_diff", this.inv1st_diff);
    __sqoop$field_map.put("inv1st_all_diff", this.inv1st_all_diff);
    __sqoop$field_map.put("reg_inv_diff", this.reg_inv_diff);
    __sqoop$field_map.put("invre_red_num", this.invre_red_num);
    __sqoop$field_map.put("invre_red_amount", this.invre_red_amount);
    __sqoop$field_map.put("churn_num", this.churn_num);
    __sqoop$field_map.put("premium", this.premium);
    __sqoop$field_map.put("premium_diff", this.premium_diff);
    __sqoop$field_map.put("premium_cur", this.premium_cur);
    __sqoop$field_map.put("inv_old_num", this.inv_old_num);
    __sqoop$field_map.put("inv_old_amount", this.inv_old_amount);
    __sqoop$field_map.put("inv_old_premium_diff", this.inv_old_premium_diff);
    __sqoop$field_map.put("before_reg_inv1st_num", this.before_reg_inv1st_num);
    __sqoop$field_map.put("before_reg_inv1st_all_amount", this.before_reg_inv1st_all_amount);
    __sqoop$field_map.put("before_reg_inv1st_premium_diff", this.before_reg_inv1st_premium_diff);
    __sqoop$field_map.put("inv1st_premium_diff", this.inv1st_premium_diff);
    __sqoop$field_map.put("reg_inv1st_premium_diff", this.reg_inv1st_premium_diff);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("create_date", this.create_date);
    __sqoop$field_map.put("end_date", this.end_date);
    __sqoop$field_map.put("channel", this.channel);
    __sqoop$field_map.put("period", this.period);
    __sqoop$field_map.put("activity_num", this.activity_num);
    __sqoop$field_map.put("reg_num", this.reg_num);
    __sqoop$field_map.put("open_num", this.open_num);
    __sqoop$field_map.put("inv_num", this.inv_num);
    __sqoop$field_map.put("inv_freq", this.inv_freq);
    __sqoop$field_map.put("inv_amount", this.inv_amount);
    __sqoop$field_map.put("inv100_num", this.inv100_num);
    __sqoop$field_map.put("inv100_freq", this.inv100_freq);
    __sqoop$field_map.put("inv100_amount", this.inv100_amount);
    __sqoop$field_map.put("inv1st_num", this.inv1st_num);
    __sqoop$field_map.put("inv1st_amount", this.inv1st_amount);
    __sqoop$field_map.put("inv1st100_num", this.inv1st100_num);
    __sqoop$field_map.put("inv1st100_amount", this.inv1st100_amount);
    __sqoop$field_map.put("inv1st_all_amont", this.inv1st_all_amont);
    __sqoop$field_map.put("inv1st_all100_num", this.inv1st_all100_num);
    __sqoop$field_map.put("inv1st_all100_amount", this.inv1st_all100_amount);
    __sqoop$field_map.put("inv2nd_num", this.inv2nd_num);
    __sqoop$field_map.put("inv2nd_amount", this.inv2nd_amount);
    __sqoop$field_map.put("invre_num", this.invre_num);
    __sqoop$field_map.put("invre_freq", this.invre_freq);
    __sqoop$field_map.put("invre_amount", this.invre_amount);
    __sqoop$field_map.put("redeem_num", this.redeem_num);
    __sqoop$field_map.put("redeem_freq", this.redeem_freq);
    __sqoop$field_map.put("redeem_amount", this.redeem_amount);
    __sqoop$field_map.put("regular1st_num", this.regular1st_num);
    __sqoop$field_map.put("regular1st_amount", this.regular1st_amount);
    __sqoop$field_map.put("regular_num", this.regular_num);
    __sqoop$field_map.put("regular_freq", this.regular_freq);
    __sqoop$field_map.put("regular_amount", this.regular_amount);
    __sqoop$field_map.put("reg_open_num", this.reg_open_num);
    __sqoop$field_map.put("reg_inv1st_num", this.reg_inv1st_num);
    __sqoop$field_map.put("reg_inv1st_amount", this.reg_inv1st_amount);
    __sqoop$field_map.put("reg_inv2nd_num", this.reg_inv2nd_num);
    __sqoop$field_map.put("reg_inv2nd_amount", this.reg_inv2nd_amount);
    __sqoop$field_map.put("reg_inv3rdm_num", this.reg_inv3rdm_num);
    __sqoop$field_map.put("reg_inv3rdm_amount", this.reg_inv3rdm_amount);
    __sqoop$field_map.put("reg_inv1st_all_amount", this.reg_inv1st_all_amount);
    __sqoop$field_map.put("reg_inv1st_all100_num", this.reg_inv1st_all100_num);
    __sqoop$field_map.put("reg_inv1st_all100_amount", this.reg_inv1st_all100_amount);
    __sqoop$field_map.put("inv1st_inv2nd_num", this.inv1st_inv2nd_num);
    __sqoop$field_map.put("inv1st_inv2nd_amount", this.inv1st_inv2nd_amount);
    __sqoop$field_map.put("inv1st_inv3rdm_num", this.inv1st_inv3rdm_num);
    __sqoop$field_map.put("inv1st_inv3rdm_amount", this.inv1st_inv3rdm_amount);
    __sqoop$field_map.put("exp_amount", this.exp_amount);
    __sqoop$field_map.put("exp_int_amount", this.exp_int_amount);
    __sqoop$field_map.put("exp_recover_amount", this.exp_recover_amount);
    __sqoop$field_map.put("regular_1_num", this.regular_1_num);
    __sqoop$field_map.put("regular_1_amount", this.regular_1_amount);
    __sqoop$field_map.put("regular_2_num", this.regular_2_num);
    __sqoop$field_map.put("regular_2_amount", this.regular_2_amount);
    __sqoop$field_map.put("regular_3_num", this.regular_3_num);
    __sqoop$field_map.put("regular_3_amount", this.regular_3_amount);
    __sqoop$field_map.put("regular_4_num", this.regular_4_num);
    __sqoop$field_map.put("regular_4_amount", this.regular_4_amount);
    __sqoop$field_map.put("regular_5_num", this.regular_5_num);
    __sqoop$field_map.put("regular_5_amount", this.regular_5_amount);
    __sqoop$field_map.put("regular_6_num", this.regular_6_num);
    __sqoop$field_map.put("regular_6_amount", this.regular_6_amount);
    __sqoop$field_map.put("regular_7_num", this.regular_7_num);
    __sqoop$field_map.put("regular_7_amount", this.regular_7_amount);
    __sqoop$field_map.put("regular_8_num", this.regular_8_num);
    __sqoop$field_map.put("regular_8_amount", this.regular_8_amount);
    __sqoop$field_map.put("regular_9_num", this.regular_9_num);
    __sqoop$field_map.put("regular_9_amount", this.regular_9_amount);
    __sqoop$field_map.put("regular_10_num", this.regular_10_num);
    __sqoop$field_map.put("regular_10_amount", this.regular_10_amount);
    __sqoop$field_map.put("regular_11_num", this.regular_11_num);
    __sqoop$field_map.put("regular_11_amount", this.regular_11_amount);
    __sqoop$field_map.put("regular_12_num", this.regular_12_num);
    __sqoop$field_map.put("regular_12_amount", this.regular_12_amount);
    __sqoop$field_map.put("regular_premium", this.regular_premium);
    __sqoop$field_map.put("regular_expire", this.regular_expire);
    __sqoop$field_map.put("regular_premium_1", this.regular_premium_1);
    __sqoop$field_map.put("regular_premium_2", this.regular_premium_2);
    __sqoop$field_map.put("regular_premium_3", this.regular_premium_3);
    __sqoop$field_map.put("regular_premium_4", this.regular_premium_4);
    __sqoop$field_map.put("regular_premium_5", this.regular_premium_5);
    __sqoop$field_map.put("regular_premium_6", this.regular_premium_6);
    __sqoop$field_map.put("regular_premium_7", this.regular_premium_7);
    __sqoop$field_map.put("regular_premium_8", this.regular_premium_8);
    __sqoop$field_map.put("regular_premium_9", this.regular_premium_9);
    __sqoop$field_map.put("regular_premium_10", this.regular_premium_10);
    __sqoop$field_map.put("regular_premium_11", this.regular_premium_11);
    __sqoop$field_map.put("regular_premium_12", this.regular_premium_12);
    __sqoop$field_map.put("inv_interval_1k", this.inv_interval_1k);
    __sqoop$field_map.put("inv_interval_5k", this.inv_interval_5k);
    __sqoop$field_map.put("inv_interval_1w", this.inv_interval_1w);
    __sqoop$field_map.put("inv_interval_2w", this.inv_interval_2w);
    __sqoop$field_map.put("inv_interval_5w", this.inv_interval_5w);
    __sqoop$field_map.put("inv_interval_10w", this.inv_interval_10w);
    __sqoop$field_map.put("inv_interval_20w", this.inv_interval_20w);
    __sqoop$field_map.put("inv_interval_20wm", this.inv_interval_20wm);
    __sqoop$field_map.put("red_interval_1h", this.red_interval_1h);
    __sqoop$field_map.put("red_interval_1k", this.red_interval_1k);
    __sqoop$field_map.put("red_interval_5k", this.red_interval_5k);
    __sqoop$field_map.put("red_interval_1w", this.red_interval_1w);
    __sqoop$field_map.put("red_interval_2w", this.red_interval_2w);
    __sqoop$field_map.put("red_interval_5w", this.red_interval_5w);
    __sqoop$field_map.put("red_interval_10w", this.red_interval_10w);
    __sqoop$field_map.put("red_interval_20w", this.red_interval_20w);
    __sqoop$field_map.put("inv_diff", this.inv_diff);
    __sqoop$field_map.put("inv100_diff", this.inv100_diff);
    __sqoop$field_map.put("inv1st_diff", this.inv1st_diff);
    __sqoop$field_map.put("inv1st_all_diff", this.inv1st_all_diff);
    __sqoop$field_map.put("reg_inv_diff", this.reg_inv_diff);
    __sqoop$field_map.put("invre_red_num", this.invre_red_num);
    __sqoop$field_map.put("invre_red_amount", this.invre_red_amount);
    __sqoop$field_map.put("churn_num", this.churn_num);
    __sqoop$field_map.put("premium", this.premium);
    __sqoop$field_map.put("premium_diff", this.premium_diff);
    __sqoop$field_map.put("premium_cur", this.premium_cur);
    __sqoop$field_map.put("inv_old_num", this.inv_old_num);
    __sqoop$field_map.put("inv_old_amount", this.inv_old_amount);
    __sqoop$field_map.put("inv_old_premium_diff", this.inv_old_premium_diff);
    __sqoop$field_map.put("before_reg_inv1st_num", this.before_reg_inv1st_num);
    __sqoop$field_map.put("before_reg_inv1st_all_amount", this.before_reg_inv1st_all_amount);
    __sqoop$field_map.put("before_reg_inv1st_premium_diff", this.before_reg_inv1st_premium_diff);
    __sqoop$field_map.put("inv1st_premium_diff", this.inv1st_premium_diff);
    __sqoop$field_map.put("reg_inv1st_premium_diff", this.reg_inv1st_premium_diff);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("create_date".equals(__fieldName)) {
      this.create_date = (String) __fieldVal;
    }
    else    if ("end_date".equals(__fieldName)) {
      this.end_date = (String) __fieldVal;
    }
    else    if ("channel".equals(__fieldName)) {
      this.channel = (String) __fieldVal;
    }
    else    if ("period".equals(__fieldName)) {
      this.period = (Integer) __fieldVal;
    }
    else    if ("activity_num".equals(__fieldName)) {
      this.activity_num = (Integer) __fieldVal;
    }
    else    if ("reg_num".equals(__fieldName)) {
      this.reg_num = (Integer) __fieldVal;
    }
    else    if ("open_num".equals(__fieldName)) {
      this.open_num = (Integer) __fieldVal;
    }
    else    if ("inv_num".equals(__fieldName)) {
      this.inv_num = (Integer) __fieldVal;
    }
    else    if ("inv_freq".equals(__fieldName)) {
      this.inv_freq = (Integer) __fieldVal;
    }
    else    if ("inv_amount".equals(__fieldName)) {
      this.inv_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("inv100_num".equals(__fieldName)) {
      this.inv100_num = (Integer) __fieldVal;
    }
    else    if ("inv100_freq".equals(__fieldName)) {
      this.inv100_freq = (Integer) __fieldVal;
    }
    else    if ("inv100_amount".equals(__fieldName)) {
      this.inv100_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("inv1st_num".equals(__fieldName)) {
      this.inv1st_num = (Integer) __fieldVal;
    }
    else    if ("inv1st_amount".equals(__fieldName)) {
      this.inv1st_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("inv1st100_num".equals(__fieldName)) {
      this.inv1st100_num = (Integer) __fieldVal;
    }
    else    if ("inv1st100_amount".equals(__fieldName)) {
      this.inv1st100_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("inv1st_all_amont".equals(__fieldName)) {
      this.inv1st_all_amont = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("inv1st_all100_num".equals(__fieldName)) {
      this.inv1st_all100_num = (Integer) __fieldVal;
    }
    else    if ("inv1st_all100_amount".equals(__fieldName)) {
      this.inv1st_all100_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("inv2nd_num".equals(__fieldName)) {
      this.inv2nd_num = (Integer) __fieldVal;
    }
    else    if ("inv2nd_amount".equals(__fieldName)) {
      this.inv2nd_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("invre_num".equals(__fieldName)) {
      this.invre_num = (Integer) __fieldVal;
    }
    else    if ("invre_freq".equals(__fieldName)) {
      this.invre_freq = (Integer) __fieldVal;
    }
    else    if ("invre_amount".equals(__fieldName)) {
      this.invre_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("redeem_num".equals(__fieldName)) {
      this.redeem_num = (Integer) __fieldVal;
    }
    else    if ("redeem_freq".equals(__fieldName)) {
      this.redeem_freq = (Integer) __fieldVal;
    }
    else    if ("redeem_amount".equals(__fieldName)) {
      this.redeem_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular1st_num".equals(__fieldName)) {
      this.regular1st_num = (Integer) __fieldVal;
    }
    else    if ("regular1st_amount".equals(__fieldName)) {
      this.regular1st_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_num".equals(__fieldName)) {
      this.regular_num = (Integer) __fieldVal;
    }
    else    if ("regular_freq".equals(__fieldName)) {
      this.regular_freq = (Integer) __fieldVal;
    }
    else    if ("regular_amount".equals(__fieldName)) {
      this.regular_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("reg_open_num".equals(__fieldName)) {
      this.reg_open_num = (Integer) __fieldVal;
    }
    else    if ("reg_inv1st_num".equals(__fieldName)) {
      this.reg_inv1st_num = (Integer) __fieldVal;
    }
    else    if ("reg_inv1st_amount".equals(__fieldName)) {
      this.reg_inv1st_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("reg_inv2nd_num".equals(__fieldName)) {
      this.reg_inv2nd_num = (Integer) __fieldVal;
    }
    else    if ("reg_inv2nd_amount".equals(__fieldName)) {
      this.reg_inv2nd_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("reg_inv3rdm_num".equals(__fieldName)) {
      this.reg_inv3rdm_num = (Integer) __fieldVal;
    }
    else    if ("reg_inv3rdm_amount".equals(__fieldName)) {
      this.reg_inv3rdm_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("reg_inv1st_all_amount".equals(__fieldName)) {
      this.reg_inv1st_all_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("reg_inv1st_all100_num".equals(__fieldName)) {
      this.reg_inv1st_all100_num = (Integer) __fieldVal;
    }
    else    if ("reg_inv1st_all100_amount".equals(__fieldName)) {
      this.reg_inv1st_all100_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("inv1st_inv2nd_num".equals(__fieldName)) {
      this.inv1st_inv2nd_num = (Integer) __fieldVal;
    }
    else    if ("inv1st_inv2nd_amount".equals(__fieldName)) {
      this.inv1st_inv2nd_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("inv1st_inv3rdm_num".equals(__fieldName)) {
      this.inv1st_inv3rdm_num = (Integer) __fieldVal;
    }
    else    if ("inv1st_inv3rdm_amount".equals(__fieldName)) {
      this.inv1st_inv3rdm_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("exp_amount".equals(__fieldName)) {
      this.exp_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("exp_int_amount".equals(__fieldName)) {
      this.exp_int_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("exp_recover_amount".equals(__fieldName)) {
      this.exp_recover_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_1_num".equals(__fieldName)) {
      this.regular_1_num = (Integer) __fieldVal;
    }
    else    if ("regular_1_amount".equals(__fieldName)) {
      this.regular_1_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_2_num".equals(__fieldName)) {
      this.regular_2_num = (Integer) __fieldVal;
    }
    else    if ("regular_2_amount".equals(__fieldName)) {
      this.regular_2_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_3_num".equals(__fieldName)) {
      this.regular_3_num = (Integer) __fieldVal;
    }
    else    if ("regular_3_amount".equals(__fieldName)) {
      this.regular_3_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_4_num".equals(__fieldName)) {
      this.regular_4_num = (Integer) __fieldVal;
    }
    else    if ("regular_4_amount".equals(__fieldName)) {
      this.regular_4_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_5_num".equals(__fieldName)) {
      this.regular_5_num = (Integer) __fieldVal;
    }
    else    if ("regular_5_amount".equals(__fieldName)) {
      this.regular_5_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_6_num".equals(__fieldName)) {
      this.regular_6_num = (Integer) __fieldVal;
    }
    else    if ("regular_6_amount".equals(__fieldName)) {
      this.regular_6_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_7_num".equals(__fieldName)) {
      this.regular_7_num = (Integer) __fieldVal;
    }
    else    if ("regular_7_amount".equals(__fieldName)) {
      this.regular_7_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_8_num".equals(__fieldName)) {
      this.regular_8_num = (Integer) __fieldVal;
    }
    else    if ("regular_8_amount".equals(__fieldName)) {
      this.regular_8_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_9_num".equals(__fieldName)) {
      this.regular_9_num = (Integer) __fieldVal;
    }
    else    if ("regular_9_amount".equals(__fieldName)) {
      this.regular_9_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_10_num".equals(__fieldName)) {
      this.regular_10_num = (Integer) __fieldVal;
    }
    else    if ("regular_10_amount".equals(__fieldName)) {
      this.regular_10_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_11_num".equals(__fieldName)) {
      this.regular_11_num = (Integer) __fieldVal;
    }
    else    if ("regular_11_amount".equals(__fieldName)) {
      this.regular_11_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_12_num".equals(__fieldName)) {
      this.regular_12_num = (Integer) __fieldVal;
    }
    else    if ("regular_12_amount".equals(__fieldName)) {
      this.regular_12_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_premium".equals(__fieldName)) {
      this.regular_premium = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_expire".equals(__fieldName)) {
      this.regular_expire = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_premium_1".equals(__fieldName)) {
      this.regular_premium_1 = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_premium_2".equals(__fieldName)) {
      this.regular_premium_2 = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_premium_3".equals(__fieldName)) {
      this.regular_premium_3 = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_premium_4".equals(__fieldName)) {
      this.regular_premium_4 = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_premium_5".equals(__fieldName)) {
      this.regular_premium_5 = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_premium_6".equals(__fieldName)) {
      this.regular_premium_6 = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_premium_7".equals(__fieldName)) {
      this.regular_premium_7 = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_premium_8".equals(__fieldName)) {
      this.regular_premium_8 = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_premium_9".equals(__fieldName)) {
      this.regular_premium_9 = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_premium_10".equals(__fieldName)) {
      this.regular_premium_10 = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_premium_11".equals(__fieldName)) {
      this.regular_premium_11 = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("regular_premium_12".equals(__fieldName)) {
      this.regular_premium_12 = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("inv_interval_1k".equals(__fieldName)) {
      this.inv_interval_1k = (Integer) __fieldVal;
    }
    else    if ("inv_interval_5k".equals(__fieldName)) {
      this.inv_interval_5k = (Integer) __fieldVal;
    }
    else    if ("inv_interval_1w".equals(__fieldName)) {
      this.inv_interval_1w = (Integer) __fieldVal;
    }
    else    if ("inv_interval_2w".equals(__fieldName)) {
      this.inv_interval_2w = (Integer) __fieldVal;
    }
    else    if ("inv_interval_5w".equals(__fieldName)) {
      this.inv_interval_5w = (Integer) __fieldVal;
    }
    else    if ("inv_interval_10w".equals(__fieldName)) {
      this.inv_interval_10w = (Integer) __fieldVal;
    }
    else    if ("inv_interval_20w".equals(__fieldName)) {
      this.inv_interval_20w = (Integer) __fieldVal;
    }
    else    if ("inv_interval_20wm".equals(__fieldName)) {
      this.inv_interval_20wm = (Integer) __fieldVal;
    }
    else    if ("red_interval_1h".equals(__fieldName)) {
      this.red_interval_1h = (Integer) __fieldVal;
    }
    else    if ("red_interval_1k".equals(__fieldName)) {
      this.red_interval_1k = (Integer) __fieldVal;
    }
    else    if ("red_interval_5k".equals(__fieldName)) {
      this.red_interval_5k = (Integer) __fieldVal;
    }
    else    if ("red_interval_1w".equals(__fieldName)) {
      this.red_interval_1w = (Integer) __fieldVal;
    }
    else    if ("red_interval_2w".equals(__fieldName)) {
      this.red_interval_2w = (Integer) __fieldVal;
    }
    else    if ("red_interval_5w".equals(__fieldName)) {
      this.red_interval_5w = (Integer) __fieldVal;
    }
    else    if ("red_interval_10w".equals(__fieldName)) {
      this.red_interval_10w = (Integer) __fieldVal;
    }
    else    if ("red_interval_20w".equals(__fieldName)) {
      this.red_interval_20w = (Integer) __fieldVal;
    }
    else    if ("inv_diff".equals(__fieldName)) {
      this.inv_diff = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("inv100_diff".equals(__fieldName)) {
      this.inv100_diff = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("inv1st_diff".equals(__fieldName)) {
      this.inv1st_diff = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("inv1st_all_diff".equals(__fieldName)) {
      this.inv1st_all_diff = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("reg_inv_diff".equals(__fieldName)) {
      this.reg_inv_diff = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("invre_red_num".equals(__fieldName)) {
      this.invre_red_num = (Integer) __fieldVal;
    }
    else    if ("invre_red_amount".equals(__fieldName)) {
      this.invre_red_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("churn_num".equals(__fieldName)) {
      this.churn_num = (Integer) __fieldVal;
    }
    else    if ("premium".equals(__fieldName)) {
      this.premium = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("premium_diff".equals(__fieldName)) {
      this.premium_diff = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("premium_cur".equals(__fieldName)) {
      this.premium_cur = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("inv_old_num".equals(__fieldName)) {
      this.inv_old_num = (Integer) __fieldVal;
    }
    else    if ("inv_old_amount".equals(__fieldName)) {
      this.inv_old_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("inv_old_premium_diff".equals(__fieldName)) {
      this.inv_old_premium_diff = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("before_reg_inv1st_num".equals(__fieldName)) {
      this.before_reg_inv1st_num = (Integer) __fieldVal;
    }
    else    if ("before_reg_inv1st_all_amount".equals(__fieldName)) {
      this.before_reg_inv1st_all_amount = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("before_reg_inv1st_premium_diff".equals(__fieldName)) {
      this.before_reg_inv1st_premium_diff = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("inv1st_premium_diff".equals(__fieldName)) {
      this.inv1st_premium_diff = (java.math.BigDecimal) __fieldVal;
    }
    else    if ("reg_inv1st_premium_diff".equals(__fieldName)) {
      this.reg_inv1st_premium_diff = (java.math.BigDecimal) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
  public boolean setField0(String __fieldName, Object __fieldVal) {
    if ("create_date".equals(__fieldName)) {
      this.create_date = (String) __fieldVal;
      return true;
    }
    else    if ("end_date".equals(__fieldName)) {
      this.end_date = (String) __fieldVal;
      return true;
    }
    else    if ("channel".equals(__fieldName)) {
      this.channel = (String) __fieldVal;
      return true;
    }
    else    if ("period".equals(__fieldName)) {
      this.period = (Integer) __fieldVal;
      return true;
    }
    else    if ("activity_num".equals(__fieldName)) {
      this.activity_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("reg_num".equals(__fieldName)) {
      this.reg_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("open_num".equals(__fieldName)) {
      this.open_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv_num".equals(__fieldName)) {
      this.inv_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv_freq".equals(__fieldName)) {
      this.inv_freq = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv_amount".equals(__fieldName)) {
      this.inv_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("inv100_num".equals(__fieldName)) {
      this.inv100_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv100_freq".equals(__fieldName)) {
      this.inv100_freq = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv100_amount".equals(__fieldName)) {
      this.inv100_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("inv1st_num".equals(__fieldName)) {
      this.inv1st_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv1st_amount".equals(__fieldName)) {
      this.inv1st_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("inv1st100_num".equals(__fieldName)) {
      this.inv1st100_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv1st100_amount".equals(__fieldName)) {
      this.inv1st100_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("inv1st_all_amont".equals(__fieldName)) {
      this.inv1st_all_amont = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("inv1st_all100_num".equals(__fieldName)) {
      this.inv1st_all100_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv1st_all100_amount".equals(__fieldName)) {
      this.inv1st_all100_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("inv2nd_num".equals(__fieldName)) {
      this.inv2nd_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv2nd_amount".equals(__fieldName)) {
      this.inv2nd_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("invre_num".equals(__fieldName)) {
      this.invre_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("invre_freq".equals(__fieldName)) {
      this.invre_freq = (Integer) __fieldVal;
      return true;
    }
    else    if ("invre_amount".equals(__fieldName)) {
      this.invre_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("redeem_num".equals(__fieldName)) {
      this.redeem_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("redeem_freq".equals(__fieldName)) {
      this.redeem_freq = (Integer) __fieldVal;
      return true;
    }
    else    if ("redeem_amount".equals(__fieldName)) {
      this.redeem_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular1st_num".equals(__fieldName)) {
      this.regular1st_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("regular1st_amount".equals(__fieldName)) {
      this.regular1st_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_num".equals(__fieldName)) {
      this.regular_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("regular_freq".equals(__fieldName)) {
      this.regular_freq = (Integer) __fieldVal;
      return true;
    }
    else    if ("regular_amount".equals(__fieldName)) {
      this.regular_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("reg_open_num".equals(__fieldName)) {
      this.reg_open_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("reg_inv1st_num".equals(__fieldName)) {
      this.reg_inv1st_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("reg_inv1st_amount".equals(__fieldName)) {
      this.reg_inv1st_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("reg_inv2nd_num".equals(__fieldName)) {
      this.reg_inv2nd_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("reg_inv2nd_amount".equals(__fieldName)) {
      this.reg_inv2nd_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("reg_inv3rdm_num".equals(__fieldName)) {
      this.reg_inv3rdm_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("reg_inv3rdm_amount".equals(__fieldName)) {
      this.reg_inv3rdm_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("reg_inv1st_all_amount".equals(__fieldName)) {
      this.reg_inv1st_all_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("reg_inv1st_all100_num".equals(__fieldName)) {
      this.reg_inv1st_all100_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("reg_inv1st_all100_amount".equals(__fieldName)) {
      this.reg_inv1st_all100_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("inv1st_inv2nd_num".equals(__fieldName)) {
      this.inv1st_inv2nd_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv1st_inv2nd_amount".equals(__fieldName)) {
      this.inv1st_inv2nd_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("inv1st_inv3rdm_num".equals(__fieldName)) {
      this.inv1st_inv3rdm_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv1st_inv3rdm_amount".equals(__fieldName)) {
      this.inv1st_inv3rdm_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("exp_amount".equals(__fieldName)) {
      this.exp_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("exp_int_amount".equals(__fieldName)) {
      this.exp_int_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("exp_recover_amount".equals(__fieldName)) {
      this.exp_recover_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_1_num".equals(__fieldName)) {
      this.regular_1_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("regular_1_amount".equals(__fieldName)) {
      this.regular_1_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_2_num".equals(__fieldName)) {
      this.regular_2_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("regular_2_amount".equals(__fieldName)) {
      this.regular_2_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_3_num".equals(__fieldName)) {
      this.regular_3_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("regular_3_amount".equals(__fieldName)) {
      this.regular_3_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_4_num".equals(__fieldName)) {
      this.regular_4_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("regular_4_amount".equals(__fieldName)) {
      this.regular_4_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_5_num".equals(__fieldName)) {
      this.regular_5_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("regular_5_amount".equals(__fieldName)) {
      this.regular_5_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_6_num".equals(__fieldName)) {
      this.regular_6_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("regular_6_amount".equals(__fieldName)) {
      this.regular_6_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_7_num".equals(__fieldName)) {
      this.regular_7_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("regular_7_amount".equals(__fieldName)) {
      this.regular_7_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_8_num".equals(__fieldName)) {
      this.regular_8_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("regular_8_amount".equals(__fieldName)) {
      this.regular_8_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_9_num".equals(__fieldName)) {
      this.regular_9_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("regular_9_amount".equals(__fieldName)) {
      this.regular_9_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_10_num".equals(__fieldName)) {
      this.regular_10_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("regular_10_amount".equals(__fieldName)) {
      this.regular_10_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_11_num".equals(__fieldName)) {
      this.regular_11_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("regular_11_amount".equals(__fieldName)) {
      this.regular_11_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_12_num".equals(__fieldName)) {
      this.regular_12_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("regular_12_amount".equals(__fieldName)) {
      this.regular_12_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_premium".equals(__fieldName)) {
      this.regular_premium = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_expire".equals(__fieldName)) {
      this.regular_expire = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_premium_1".equals(__fieldName)) {
      this.regular_premium_1 = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_premium_2".equals(__fieldName)) {
      this.regular_premium_2 = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_premium_3".equals(__fieldName)) {
      this.regular_premium_3 = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_premium_4".equals(__fieldName)) {
      this.regular_premium_4 = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_premium_5".equals(__fieldName)) {
      this.regular_premium_5 = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_premium_6".equals(__fieldName)) {
      this.regular_premium_6 = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_premium_7".equals(__fieldName)) {
      this.regular_premium_7 = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_premium_8".equals(__fieldName)) {
      this.regular_premium_8 = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_premium_9".equals(__fieldName)) {
      this.regular_premium_9 = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_premium_10".equals(__fieldName)) {
      this.regular_premium_10 = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_premium_11".equals(__fieldName)) {
      this.regular_premium_11 = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("regular_premium_12".equals(__fieldName)) {
      this.regular_premium_12 = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("inv_interval_1k".equals(__fieldName)) {
      this.inv_interval_1k = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv_interval_5k".equals(__fieldName)) {
      this.inv_interval_5k = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv_interval_1w".equals(__fieldName)) {
      this.inv_interval_1w = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv_interval_2w".equals(__fieldName)) {
      this.inv_interval_2w = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv_interval_5w".equals(__fieldName)) {
      this.inv_interval_5w = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv_interval_10w".equals(__fieldName)) {
      this.inv_interval_10w = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv_interval_20w".equals(__fieldName)) {
      this.inv_interval_20w = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv_interval_20wm".equals(__fieldName)) {
      this.inv_interval_20wm = (Integer) __fieldVal;
      return true;
    }
    else    if ("red_interval_1h".equals(__fieldName)) {
      this.red_interval_1h = (Integer) __fieldVal;
      return true;
    }
    else    if ("red_interval_1k".equals(__fieldName)) {
      this.red_interval_1k = (Integer) __fieldVal;
      return true;
    }
    else    if ("red_interval_5k".equals(__fieldName)) {
      this.red_interval_5k = (Integer) __fieldVal;
      return true;
    }
    else    if ("red_interval_1w".equals(__fieldName)) {
      this.red_interval_1w = (Integer) __fieldVal;
      return true;
    }
    else    if ("red_interval_2w".equals(__fieldName)) {
      this.red_interval_2w = (Integer) __fieldVal;
      return true;
    }
    else    if ("red_interval_5w".equals(__fieldName)) {
      this.red_interval_5w = (Integer) __fieldVal;
      return true;
    }
    else    if ("red_interval_10w".equals(__fieldName)) {
      this.red_interval_10w = (Integer) __fieldVal;
      return true;
    }
    else    if ("red_interval_20w".equals(__fieldName)) {
      this.red_interval_20w = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv_diff".equals(__fieldName)) {
      this.inv_diff = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("inv100_diff".equals(__fieldName)) {
      this.inv100_diff = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("inv1st_diff".equals(__fieldName)) {
      this.inv1st_diff = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("inv1st_all_diff".equals(__fieldName)) {
      this.inv1st_all_diff = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("reg_inv_diff".equals(__fieldName)) {
      this.reg_inv_diff = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("invre_red_num".equals(__fieldName)) {
      this.invre_red_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("invre_red_amount".equals(__fieldName)) {
      this.invre_red_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("churn_num".equals(__fieldName)) {
      this.churn_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("premium".equals(__fieldName)) {
      this.premium = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("premium_diff".equals(__fieldName)) {
      this.premium_diff = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("premium_cur".equals(__fieldName)) {
      this.premium_cur = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("inv_old_num".equals(__fieldName)) {
      this.inv_old_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("inv_old_amount".equals(__fieldName)) {
      this.inv_old_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("inv_old_premium_diff".equals(__fieldName)) {
      this.inv_old_premium_diff = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("before_reg_inv1st_num".equals(__fieldName)) {
      this.before_reg_inv1st_num = (Integer) __fieldVal;
      return true;
    }
    else    if ("before_reg_inv1st_all_amount".equals(__fieldName)) {
      this.before_reg_inv1st_all_amount = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("before_reg_inv1st_premium_diff".equals(__fieldName)) {
      this.before_reg_inv1st_premium_diff = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("inv1st_premium_diff".equals(__fieldName)) {
      this.inv1st_premium_diff = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else    if ("reg_inv1st_premium_diff".equals(__fieldName)) {
      this.reg_inv1st_premium_diff = (java.math.BigDecimal) __fieldVal;
      return true;
    }
    else {
      return false;    }
  }
}
