package com.cskaoyan.bean;

import java.util.List;

public class ResponseVo<T> {
    List<T> rows;
    int total;

    public ResponseVo() {
    }

    public ResponseVo(List<T> rows, int total) {
        this.rows = rows;
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
