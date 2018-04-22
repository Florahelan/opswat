package com.interview.opswat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FileInfo {

    @SerializedName("file_size")
    @Expose
    private Integer fileSize;
    @SerializedName("upload_timestamp")
    @Expose
    private String uploadTimestamp;
    @SerializedName("md5")
    @Expose
    private String md5;
    @SerializedName("sha1")
    @Expose
    private String sha1;
    @SerializedName("sha256")
    @Expose
    private String sha256;
    @SerializedName("file_type_category")
    @Expose
    private String fileTypeCategory;
    @SerializedName("file_type_description")
    @Expose
    private String fileTypeDescription;
    @SerializedName("file_type_extension")
    @Expose
    private String fileTypeExtension;
    @SerializedName("display_name")
    @Expose
    private String displayName;

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getUploadTimestamp() {
        return uploadTimestamp;
    }

    public void setUploadTimestamp(String uploadTimestamp) {
        this.uploadTimestamp = uploadTimestamp;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    public String getFileTypeCategory() {
        return fileTypeCategory;
    }

    public void setFileTypeCategory(String fileTypeCategory) {
        this.fileTypeCategory = fileTypeCategory;
    }

    public String getFileTypeDescription() {
        return fileTypeDescription;
    }

    public void setFileTypeDescription(String fileTypeDescription) {
        this.fileTypeDescription = fileTypeDescription;
    }

    public String getFileTypeExtension() {
        return fileTypeExtension;
    }

    public void setFileTypeExtension(String fileTypeExtension) {
        this.fileTypeExtension = fileTypeExtension;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

}