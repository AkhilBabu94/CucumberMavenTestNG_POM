package impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hello {
    private Integer page;
    private Integer perPage;
    private Integer total;
    private Integer totalPages;
    private Data data;
    private List<String> datatwo = new ArrayList<String>();


    public Hello(Integer page, Integer perPage, Integer total, Integer totalPages, Data data, List<String> datatwo) {
        super();
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPages = totalPages;
        this.data = data;
        this.datatwo = datatwo;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Hello withPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Hello withPerPage(Integer perPage) {
        this.perPage = perPage;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Hello withTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Hello withTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Hello withData(Data data) {
        this.data = data;
        return this;
    }

    public List<String> getDatatwo() {
        return datatwo;
    }

    public void setDatatwo(List<String> datatwo) {
        this.datatwo = datatwo;
    }

    public Hello withDatatwo(List<String> datatwo) {
        this.datatwo = datatwo;
        return this;
    }
}
