package com.interview.opswat.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostProcessing {

    @SerializedName("actions_failed")
    @Expose
    private String actionsFailed;
    @SerializedName("actions_ran")
    @Expose
    private String actionsRan;
    @SerializedName("converted_destination")
    @Expose
    private String convertedDestination;
    @SerializedName("converted_to")
    @Expose
    private String convertedTo;
    @SerializedName("copy_move_destination")
    @Expose
    private String copyMoveDestination;

    public String getActionsFailed() {
        return actionsFailed;
    }

    public void setActionsFailed(String actionsFailed) {
        this.actionsFailed = actionsFailed;
    }

    public String getActionsRan() {
        return actionsRan;
    }

    public void setActionsRan(String actionsRan) {
        this.actionsRan = actionsRan;
    }

    public String getConvertedDestination() {
        return convertedDestination;
    }

    public void setConvertedDestination(String convertedDestination) {
        this.convertedDestination = convertedDestination;
    }

    public String getConvertedTo() {
        return convertedTo;
    }

    public void setConvertedTo(String convertedTo) {
        this.convertedTo = convertedTo;
    }

    public String getCopyMoveDestination() {
        return copyMoveDestination;
    }

    public void setCopyMoveDestination(String copyMoveDestination) {
        this.copyMoveDestination = copyMoveDestination;
    }

}
