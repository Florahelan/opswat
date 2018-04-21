public class ApiKey {

    public final String api_key;

    public ApiKey(String key) {
        this.api_key = key;
    }

    @Override
    public String toString() {
        return api_key;
    }
}
