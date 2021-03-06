package ru.vtb.internship.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlRootElement(name = "tag")
@XmlType(propOrder = {"id", "name"})
@JsonPropertyOrder({"id", "name"})
public class Tag {
    @JsonAlias({"ID", "Id"})
    private long id;
    private String name;

    @JsonIgnore
    private static final Logger log = LogManager.getLogger(Team.class);

    public Tag() {
    }

    public Tag(long id, String name) {
        if (name == null) {
            log.warn("Created new tag with null : name = " + name);
        }
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            log.warn("Tag->name set to null");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return id == tag.id &&
                Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
