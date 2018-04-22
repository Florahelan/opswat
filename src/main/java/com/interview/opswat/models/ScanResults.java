package com.interview.opswat.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ScanResults {

    @SerializedName("scan_details")
    @Expose
    private ScanDetails scanDetails;
    @SerializedName("rescan_available")
    @Expose
    private Boolean rescanAvailable;
    @SerializedName("data_id")
    @Expose
    private String dataId;
    @SerializedName("scan_all_result_i")
    @Expose
    private Integer scanAllResultI;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("total_time")
    @Expose
    private Integer totalTime;
    @SerializedName("total_avs")
    @Expose
    private Integer totalAvs;
    @SerializedName("total_detected_avs")
    @Expose
    private Integer totalDetectedAvs;
    @SerializedName("progress_percentage")
    @Expose
    private Integer progressPercentage;
    @SerializedName("in_queue")
    @Expose
    private Integer inQueue;
    @SerializedName("scan_all_result_a")
    @Expose
    private String scanAllResultA;

    public ScanDetails getScanDetails() {
        return scanDetails;
    }

    public void setScanDetails(ScanDetails scanDetails) {
        this.scanDetails = scanDetails;
    }

    public Boolean getRescanAvailable() {
        return rescanAvailable;
    }

    public void setRescanAvailable(Boolean rescanAvailable) {
        this.rescanAvailable = rescanAvailable;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public Integer getScanAllResultI() {
        return scanAllResultI;
    }

    public void setScanAllResultI(Integer scanAllResultI) {
        this.scanAllResultI = scanAllResultI;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getTotalAvs() {
        return totalAvs;
    }

    public void setTotalAvs(Integer totalAvs) {
        this.totalAvs = totalAvs;
    }

    public Integer getTotalDetectedAvs() {
        return totalDetectedAvs;
    }

    public void setTotalDetectedAvs(Integer totalDetectedAvs) {
        this.totalDetectedAvs = totalDetectedAvs;
    }

    public Integer getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(Integer progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public Integer getInQueue() {
        return inQueue;
    }

    public void setInQueue(Integer inQueue) {
        this.inQueue = inQueue;
    }

    public String getScanAllResultA() {
        return scanAllResultA;
    }

    public void setScanAllResultA(String scanAllResultA) {
        this.scanAllResultA = scanAllResultA;
    }

}