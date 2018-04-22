package com.interview.opswat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProcessInfo {

    @SerializedName("blocked_reason")
    @Expose
    private String blockedReason;
    @SerializedName("file_type_skipped_scan")
    @Expose
    private Boolean fileTypeSkippedScan;
    @SerializedName("post_processing")
    @Expose
    private PostProcessing postProcessing;
    @SerializedName("processing_time")
    @Expose
    private Integer processingTime;
    @SerializedName("profile")
    @Expose
    private String profile;
    @SerializedName("progress_percentage")
    @Expose
    private Integer progressPercentage;
    @SerializedName("queue_time")
    @Expose
    private String queueTime;
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("user_agent")
    @Expose
    private String userAgent;

    public String getBlockedReason() {
        return blockedReason;
    }

    public void setBlockedReason(String blockedReason) {
        this.blockedReason = blockedReason;
    }

    public Boolean getFileTypeSkippedScan() {
        return fileTypeSkippedScan;
    }

    public void setFileTypeSkippedScan(Boolean fileTypeSkippedScan) {
        this.fileTypeSkippedScan = fileTypeSkippedScan;
    }

    public PostProcessing getPostProcessing() {
        return postProcessing;
    }

    public void setPostProcessing(PostProcessing postProcessing) {
        this.postProcessing = postProcessing;
    }

    public Integer getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(Integer processingTime) {
        this.processingTime = processingTime;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Integer getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(Integer progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public String getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(String queueTime) {
        this.queueTime = queueTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

}
