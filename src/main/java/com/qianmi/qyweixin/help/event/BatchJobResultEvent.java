package com.qianmi.qyweixin.help.event;

import com.qianmi.qyweixin.help.IMessage;

/**
 * 异步任务完成事件推送
 */
public class BatchJobResultEvent extends IMessage {

    /**
     *事件类型，此时固定为：batch_job_result
     * */
    private String event;

    /**
     *异步任务id，最大长度为64字符
     * */
    private String jobId;

    /**
     *操作类型，字符串，目前分别有：
     *1. sync_user(增量更新成员)
     *2. replace_user(全量覆盖成员)
     *3. invite_user(邀请成员关注)
     *4. replace_party(全量覆盖部门)
     * */
    private String jobType;

    /**
     *返回码
     * */
    private String errCode;

    /**
     *对返回码的文本描述内容
     * */
    private String errMsg;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
