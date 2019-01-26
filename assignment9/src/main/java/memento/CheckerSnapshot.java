package memento;

import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class CheckerSnapshot {
    private URL address;
    private URLConnection connection;
    private Date latestTime;
    private boolean shouldRun;

    public CheckerSnapshot(URL address, URLConnection connection, Date latestTime, boolean shouldRun) {
        this.address = address;
        this.connection = connection;
        this.latestTime = latestTime;
        this.shouldRun = shouldRun;
    }

    public URL getAddress() {
        return address;
    }

    public URLConnection getConnection() {
        return connection;
    }

    public Date getLatestTime() {
        return latestTime;
    }

    public boolean isShouldRun() {
        return shouldRun;
    }
}
