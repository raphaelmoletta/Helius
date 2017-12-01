package br.edu.utfpr.dainf.eex23.helius.a.beans;

import java.io.Serializable;

/**
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */

public class DTO implements Serializable {
    private static final long serialVersionUID = 7641492432724322344L;

    public enum STATUS {ERROR,OK,EMPTY}
    private String data = "";
    private String url = "";
    private STATUS status = STATUS.EMPTY;

    public DTO(String data, String url, STATUS status) {
        this.data = data;
        this.url = url;
        this.status = status;
    }

    public DTO(STATUS status) {
        this.status = status;
    }

    public DTO(String data) {
        this(data, "", STATUS.OK);
    }

    public DTO(String data, STATUS status) {
        this(data,"", status);
    }

    public DTO(String data, String url) {
        this("", "", STATUS.OK);
    }

    public DTO() {
        this("", "", STATUS.EMPTY);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
