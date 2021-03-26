package com.etf.editknjiga;


import org.springframework.data.annotation.Id;

public class Autor {
	@Id
    public Long id;
    public String ime;
    public String prezime;
    public String opis;
   

    public Autor() {
    	super();
    }

    public Autor(Long id, String ime, String prezime, String opis) {
        super();
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.opis = opis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    
}
