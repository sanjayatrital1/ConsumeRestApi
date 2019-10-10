package com.practice.com.altrimetrikdemo.worldbank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long rid;

    private String id;

    private String iso2code;

    private String value;

    public Region() {
        //
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIso2code() {
        return iso2code;
    }

    public void setIso2code(String iso2code) {
        this.iso2code = iso2code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(id, region.id) &&
                Objects.equals(iso2code, region.iso2code) &&
                Objects.equals(value, region.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iso2code, value);
    }

    @Override
    public String toString() {
        return "Region{" +
                "id='" + id + '\'' +
                ", iso2code='" + iso2code + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
