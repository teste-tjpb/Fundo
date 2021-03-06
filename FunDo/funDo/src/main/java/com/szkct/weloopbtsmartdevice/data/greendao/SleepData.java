package com.szkct.weloopbtsmartdevice.data.greendao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table SLEEP.
 */
public class SleepData {

    private Long id;
    /** Not-null value. */
    private String mac;
    /** Not-null value. */
    private String mid;
    /** Not-null value. */

    private String starttimes;
    /** Not-null value. */
    private String endTime;
    /** Not-null value. */
    private String sleepmillisecond;
    /** Not-null value. */
    private String date;
    private String deepsleep;

    /** Not-null value. */
    private String lightsleep;

    /** Not-null value. */
    private String autosleep;   //  Currently used as total sleep time ----- whether it has an impact on the previous, to be verified

    /** Not-null value. */
    private String sleeptype;

    /** Not-null value. */

    public SleepData() {
    }

    public SleepData(Long id) {
        this.id = id;
    }

    public SleepData(Long id, String mac, String mid, String starttimes, String endTime, String sleepmillisecond, String date, String deepsleep, String lightsleep, String autosleep,String sleeptype) {
        this.id = id;
        this.mac = mac;
        this.mid = mid;
        this.starttimes = starttimes;
        this.endTime = endTime;
        this.sleepmillisecond = sleepmillisecond;
        this.date = date;
        this.deepsleep = deepsleep;
        this.lightsleep = lightsleep;
        this.autosleep = autosleep;
        this.sleeptype = sleeptype;

    }

    public String getDeepsleep() {
        return deepsleep;
    }

    public void setDeepsleep(String deepsleep) {
        this.deepsleep = deepsleep;
    }

    public String getLightsleep() {
        return lightsleep;
    }

    public void setLightsleep(String lightsleep) {
        this.lightsleep = lightsleep;
    }

    public String getAutosleep() {
        return autosleep;
    }

    public void setAutosleep(String autosleep) {
        this.autosleep = autosleep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getMac() {
        return mac;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setMac(String mac) {
        this.mac = mac;
    }

    /** Not-null value. */
    public String getMid() {
        return mid;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setMid(String mid) {
        this.mid = mid;
    }


    public String getSleeptype() {
        return sleeptype;
    }

    public void setSleeptype(String sleeptype) {
        this.sleeptype = sleeptype;
    }

    public String getSleepmillisecond() {
        return sleepmillisecond;
    }

    public void setSleepmillisecond(String sleepmillisecond) {
        this.sleepmillisecond = sleepmillisecond;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStarttimes() {
        return starttimes;
    }

    public void setStarttimes(String starttimes) {
        this.starttimes = starttimes;
    }

    /** Not-null value. */
    public String getDate() {
        return date;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setDate(String date) {
        this.date = date;
    }

}
