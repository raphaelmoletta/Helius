package br.edu.utfpr.dainf.eex23.helius.beans;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
public class Data implements Serializable {

    private static final long serialVersionUID = 7640412432724321891L;

    public enum STATUS {
        ok, error, empty, incomplete
    };
    @SerializedName(value = "s", alternate = "status")
    protected STATUS status = STATUS.empty;
    @SerializedName(value = "id")
    protected String id;
    @SerializedName(value = "e", alternate = "eletrical")
    protected List<Eletrical> eletrical;
    @SerializedName(value = "w", alternate = "wheather")
    protected List<Wheather> wheater;

    public Data(String id, STATUS status, List<Eletrical> eletrical, List<Wheather> wheater) {
        this.id = id;
        this.status = status;
        this.eletrical = eletrical;
        this.wheater = wheater;
    }

    public Data(List<Eletrical> eletrical, List<Wheather> wheater) {
        this("", STATUS.incomplete, eletrical, wheater);
        this.changeStatus();
    }

    public Data(STATUS status) {
        this("", status, new ArrayList<Eletrical>(), new ArrayList<Wheather>());
    }

    public Data(String id) {
        this(id, STATUS.incomplete, new ArrayList<Eletrical>(), new ArrayList<Wheather>());
    }

    public Data() {
        this("", STATUS.empty, new ArrayList<Eletrical>(), new ArrayList<Wheather>());
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        this.changeStatus();
    }

    public List<Eletrical> getEletrical() {
        return eletrical;
    }

    public void setEletrical(List<Eletrical> eletrical) {
        this.eletrical = eletrical;
        this.changeStatus();
    }

    public List<Wheather> getWheater() {
        return wheater;
    }

    public void setWheater(List<Wheather> wheater) {
        this.wheater = wheater;
        this.changeStatus();
    }

    private void changeStatus() {
        if (!this.id.isEmpty() && this.status != STATUS.error
                && this.eletrical != null && !this.eletrical.isEmpty()
                && this.wheater != null && !this.wheater.isEmpty()) {
            this.status = STATUS.ok;
        } else if (this.status != STATUS.error) {
            this.status = STATUS.incomplete;
        }
    }
}
