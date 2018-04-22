package com.interview.opswat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HashWrapper {

    @SerializedName("file_id")
    @Expose
    private String fileId;
    @SerializedName("data_id")
    @Expose
    private String dataId;
    @SerializedName("archived")
    @Expose
    private Boolean archived;
    @SerializedName("process_info")
    @Expose
    private ProcessInfo processInfo;
    @SerializedName("scan_results")
    @Expose
    private ScanResults scanResults;
    @SerializedName("file_info")
    @Expose
    private FileInfo fileInfo;
    @SerializedName("top_threat")
    @Expose
    private Integer topThreat;
    @SerializedName("share_file")
    @Expose
    private Integer shareFile;
    @SerializedName("rest_version")
    @Expose
    private String restVersion;
    @SerializedName("original_file")
    @Expose
    private OriginalFile originalFile;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public ProcessInfo getProcessInfo() {
        return processInfo;
    }

    public void setProcessInfo(ProcessInfo processInfo) {
        this.processInfo = processInfo;
    }

    public ScanResults getScanResults() {
        return scanResults;
    }

    public void setScanResults(ScanResults scanResults) {
        this.scanResults = scanResults;
    }

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }

    public Integer getTopThreat() {
        return topThreat;
    }

    public void setTopThreat(Integer topThreat) {
        this.topThreat = topThreat;
    }

    public Integer getShareFile() {
        return shareFile;
    }

    public void setShareFile(Integer shareFile) {
        this.shareFile = shareFile;
    }

    public String getRestVersion() {
        return restVersion;
    }

    public void setRestVersion(String restVersion) {
        this.restVersion = restVersion;
    }

    public OriginalFile getOriginalFile() {
        return originalFile;
    }

    public void setOriginalFile(OriginalFile originalFile) {
        this.originalFile = originalFile;
    }

}