package com.beniregev.bigpandahomeexercise.models;

public class StreamEvent {

    private String type;
    private String data;
    private String timestamp;

    /**
     *
     * @return {@code Event-Type} as {@link String}.
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type The event-type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return {@code data} property of the Event
     */
    public String getData() {
        return data;
    }

    /**
     *
     * @param dataThe value to set {@code data} property
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     *
     * @return {@code timestamp} property of the Event
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     *
     * @param timestampthe timestamp value to set
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
