package id.co.imastudio.santri.datakaryawan;

/**
 * Created by Server on 31/07/2017.
 */

public class Barang {
    private long id;
    private String nama;
    private String jk;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    private String umur;



    @Override
    public String toString() {
        return "Barang" + nama+" " +jk+ "" +umur+" ";
    }
}
