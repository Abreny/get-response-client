package fr.hadeen.getresponse.domain;
public class Autoresponder {
    private String autoresponderId;
    private String campaignId;
    private String href;
    private String name;
    private String subject;
    private String status;
    private FromField fromField;
    private FromField replyTo;

    public String getAutoresponderId() {
        return autoresponderId;
    }

    public void setAutoresponderId(String autoresponderId) {
        this.autoresponderId = autoresponderId;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public FromField getFromField() {
        return fromField;
    }

    public void setFromField(FromField fromField) {
        this.fromField = fromField;
    }

    public FromField getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(FromField replyTo) {
        this.replyTo = replyTo;
    }
}
