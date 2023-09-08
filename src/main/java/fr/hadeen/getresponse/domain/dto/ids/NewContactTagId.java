package fr.hadeen.getresponse.domain.dto.ids;

import java.util.Objects;

public class NewContactTagId {
    private String tagId;

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewContactTagId)) return false;
        NewContactTagId that = (NewContactTagId) o;
        return Objects.equals(tagId, that.tagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId);
    }
}
