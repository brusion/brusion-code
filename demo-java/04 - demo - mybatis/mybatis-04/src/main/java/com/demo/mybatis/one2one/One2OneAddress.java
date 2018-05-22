package com.demo.mybatis.one2one;

/**
 * @author brusion
 * @date 2018/5/21
 */
public class One2OneAddress {
    /**
     * one2one_addr_id int(3) auto_increment not null primary key,
     * one2one_street varchar(20) not null,
     * one2one_city varchar(20) not null,
     * one2one_state varchar(20) not null,
     * one2one_zip varchar(10),
     * one2one_country varchar(20));
     */

    private int addrId;
    private String addrStreet;
    private String addrCity;
    private String addrState;
    private String addrZip;
    private String addrCountry;

    public int getAddrId() {
        return addrId;
    }

    public void setAddrId(int addrId) {
        this.addrId = addrId;
    }

    public String getAddrStreet() {
        return addrStreet;
    }

    public void setAddrStreet(String addrStreet) {
        this.addrStreet = addrStreet;
    }

    public String getAddrCity() {
        return addrCity;
    }

    public void setAddrCity(String addrCity) {
        this.addrCity = addrCity;
    }

    public String getAddrState() {
        return addrState;
    }

    public void setAddrState(String addrState) {
        this.addrState = addrState;
    }

    public String getAddrZip() {
        return addrZip;
    }

    public void setAddrZip(String addrZip) {
        this.addrZip = addrZip;
    }

    public String getAddrCountry() {
        return addrCountry;
    }

    public void setAddrCountry(String addrCountry) {
        this.addrCountry = addrCountry;
    }

    @Override
    public String toString() {
        return "One2OneAddress{" +
                "addrId=" + addrId +
                ", addrStreet='" + addrStreet + '\'' +
                ", addrCity='" + addrCity + '\'' +
                ", addrState='" + addrState + '\'' +
                ", addrZip='" + addrZip + '\'' +
                ", addrCountry='" + addrCountry + '\'' +
                '}';
    }
}
