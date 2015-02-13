package com.qq.weixin.api.model.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * 事件推送群发结果
 * <p/>
 * <p/>
 * User : developer
 * Date : 2015/2/12
 * Version : 1.0.1
 */
@XStreamAlias("xml")
public class EventJobFinishMessage extends BaseEventMessage {

    /**
     * group_id下粉丝数；或者openid_list中的粉丝数
     */
    private Long TotalCount;

    /**
     * 过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数，原则上，FilterCount = SentCount + ErrorCount
     */
    private Long FilterCount;

    /**
     * 发送成功的粉丝数
     */
    private Long SentCount;
    /**
     * 发送失败的粉丝数
     */
    private Long ErrorCount;

    /**
     * 群发的结构，为“send success”或“send fail”或“err(num)”。
     * 但send success时，也有可能因用户拒收公众号的消息、系统错误等原因造成少量用户接收失败。
     * err(num)是审核失败的具体原因，可能的情况如下：
     * err(10001), //涉嫌广告
     * err(20001), //涉嫌政治
     * err(20004), //涉嫌社会
     * err(20002), //涉嫌色情
     * err(20006), //涉嫌违法犯罪
     * err(20008), //涉嫌欺诈
     * err(20013), //涉嫌版权
     * err(22000), //涉嫌互推(互相宣传)
     * err(21000), //涉嫌其他
     */
    private String Status;

    /**
     * 群发的消息ID
     */
    private Long MsgID;

    /**
     * 公众号群发助手的微信号，为mphelper
     */
    public static final String JOB_FINISH_PUSH_USER = "mphelper";

    public EventJobFinishMessage() {
        MsgType = WX_MSG_TYPE_EVENT_MASSSENDJOBFINISH;
    }

    public Long getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(Long totalCount) {
        TotalCount = totalCount;
    }

    public Long getFilterCount() {
        return FilterCount;
    }

    public void setFilterCount(Long filterCount) {
        FilterCount = filterCount;
    }

    public Long getSentCount() {
        return SentCount;
    }

    public void setSentCount(Long sentCount) {
        SentCount = sentCount;
    }

    public Long getErrorCount() {
        return ErrorCount;
    }

    public void setErrorCount(Long errorCount) {
        ErrorCount = errorCount;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Long getMsgID() {
        return MsgID;
    }

    public void setMsgID(Long msgID) {
        MsgID = msgID;
    }

    @Override
    public String toString() {
        return "EventJobFinishMessage{" +
                "TotalCount=" + TotalCount +
                ", FilterCount=" + FilterCount +
                ", SentCount=" + SentCount +
                ", ErrorCount=" + ErrorCount +
                ", Status='" + Status + '\'' +
                ", MsgID=" + MsgID +
                "} " + super.toString();
    }
}
