package com.practice.com.altrimetrikdemo.worldbank;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Pagination response from WorldBank API
 */

public class Pages {

    private Long id;

    private int page;

    private int pages;

    @JsonProperty("per_page")
    private int perPage;

    private int total;

    public Pages() {
        //
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pages pages1 = (Pages) o;
        return page == pages1.page &&
                pages == pages1.pages &&
                perPage == pages1.perPage &&
                total == pages1.total;
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, pages, perPage, total);
    }

    @Override
    public String toString() {
        return "Pages{" +
                "page=" + page +
                ", pages=" + pages +
                ", perPage=" + perPage +
                ", total=" + total +
                '}';
    }
}
