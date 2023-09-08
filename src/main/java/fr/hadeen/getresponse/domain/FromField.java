package fr.hadeen.getresponse.domain;

import java.util.Date;

public class FromField {
    private String fromFieldId;
    private String email;
    private String name;
    private Boolean isDefault;
    private Boolean isActive;
    private String href;
    private Date createdOn;

    public String getFromFieldId() {
        return fromFieldId;
    }

    public void setFromFieldId(String fromFieldId) {
        this.fromFieldId = fromFieldId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
