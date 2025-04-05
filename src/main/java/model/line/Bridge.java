package model.line;

public enum Bridge {
    CONNECTED,
    NOT_CONNECTED;

    public boolean isConnected() {
        return this == CONNECTED;
    }

    public static Bridge from(boolean connected) {
        return connected ? CONNECTED : NOT_CONNECTED;
    }
}
