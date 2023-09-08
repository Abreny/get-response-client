package fr.hadeen.getresponse.domain;

import java.util.Date;
public class Contact {
    private String contactId;
    private String name;
    private String origin;
    private String timeZone;
    private String activities;
    private Date changedOn;
    private Date createdOn;
    private Campaign campaign;
    private String email;
    private String dayOfCycle;
    private String scoring;
    private Integer engagementScore;
    private String href;
    private String note;
    private String ipAddress;

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDayOfCycle() {
        return dayOfCycle;
    }

    public void setDayOfCycle(String dayOfCycle) {
        this.dayOfCycle = dayOfCycle;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getScoring() {
        return scoring;
    }

    public void setScoring(String scoring) {
        this.scoring = scoring;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Integer getEngagementScore() {
        return engagementScore;
    }

    public void setEngagementScore(Integer engagementScore) {
        this.engagementScore = engagementScore;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getChangedOn() {
        return changedOn;
    }

    public void setChangedOn(Date changedOn) {
        this.changedOn = changedOn;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public static enum Origin {
        IMPORT("import"),
        EMAIL("email"),
        WWW("www"),
        PANEL("panel"),
        LEADS("leads"),
        SALE("sale"),
        API("api"),
        FORWARD("forward"),
        SURVEY("survey"),
        IPHONE("iphone"),
        COPY("copy"),
        LANDING_PAGE("landing_page"),
        WEBSITE_BUILDER_ELEGANT("website_builder_elegant");

        private final String formatted;

        Origin(String formatted) {
            this.formatted = formatted;
        }

        @Override
        public String toString() {
            return formatted;
        }
    }
}
