package com.interview.opswat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OriginalFile {

    @SerializedName("detected_by")
    @Expose
    private Integer detectedBy;
    @SerializedName("progress_percentage")
    @Expose
    private Integer progressPercentage;
    @SerializedName("scan_result_i")
    @Expose
    private Integer scanResultI;
    @SerializedName("data_id")
    @Expose
    private String dataId;

    public Integer getDetectedBy() {
        return detectedBy;
    }

    public void setDetectedBy(Integer detectedBy) {
        this.detectedBy = detectedBy;
    }

    public Integer getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(Integer progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public Integer getScanResultI() {
        return scanResultI;
    }

    public void setScanResultI(Integer scanResultI) {
        this.scanResultI = scanResultI;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

}