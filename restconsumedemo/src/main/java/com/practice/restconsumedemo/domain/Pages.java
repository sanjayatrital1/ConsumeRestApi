package com.practice.restconsumedemo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Pages {
    private int page;
    private int pages;
    @JsonProperty("per_page")
    private String perPage;
    private int total;

    public Pages(){
        //
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

    public String getPerPage() {
        return perPage;
    }

    public void setPerPage(String perPage) {
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
                total == pages1.total &&
                Objects.equals(perPage, pages1.perPage);
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
                ", perPage='" + perPage + '\'' +
                ", total=" + total +
                '}';
    }

}
