import com.google.gson.annotations.SerializedName;

public class Scanning {
    @SerializedName("data_id")
    String  data_id;

    @SerializedName("status")
    String status;

    @SerializedName("in_queue")
    int in_queue;

    @SerializedName("queue_priority")
    String queue_priority;

    @SerializedName("rest_ip")
    String rest_ip;

    public Scanning(int id, String name ) {
        this.data_id = data_id;
        this.status = status;
        this.in_queue = in_queue;
        this.queue_priority = queue_priority;
        this.rest_ip = rest_ip;

    }
}

