package checker;

import memento.Caretaker;
import memento.CheckerSnapshot;
import memento.Originator;
import obeserver.Publisher;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class Checker extends Publisher implements Runnable, Originator<CheckerSnapshot> {
    private URL address;
    private URLConnection connection;
    private Date latestTime;
    private boolean shouldRun = true;
    private Caretaker<CheckerSnapshot> caretaker = null;

    public Checker(URL address) {
        this.address = address;
    }

    private void openConnection() {
        try {
            this.connection = this.address.openConnection();
        } catch (IOException e) {
            this.connection = null;
            e.printStackTrace();
        }
    }

    public void handleNewDate(long time) {
        if (latestTime != null) {
            System.out.println(time);
            if (new Date(time).compareTo(latestTime) > 0) {
                updateLatestTime(time);
                super.notifySubscribers(address.toString() + " was updated " + latestTime.toString());
            }
        } else {
            updateLatestTime(time);
            super.notifySubscribers(address.toString() + " was updated " + latestTime.toString());
        }
    }

    private void updateLatestTime(long time) {
        this.latestTime = new Date(time);
    }

    public Caretaker<CheckerSnapshot> getCaretaker() {
        return caretaker;
    }

    private void handleMemento() {
        if (this.caretaker == null) {
            this.caretaker = new Caretaker<>(this);
        }
        this.caretaker.makeBackup();

    }

    public Date getLatestTime() {
        return latestTime;
    }

    public void stop() {
        this.shouldRun = false;
    }

    @Override
    public void run() {
        while (shouldRun) {
            handleMemento();

            System.out.println("Checking");
            openConnection();
            if (connection != null) {
                long lastModifiedTime = connection.getLastModified();
                handleNewDate(lastModifiedTime);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public CheckerSnapshot makeSnapshot() {
        return new CheckerSnapshot(address, connection, latestTime, shouldRun);
    }

    @Override
    public void restore(CheckerSnapshot snapshot) {
        this.address = snapshot.getAddress();
        this.connection = snapshot.getConnection();
        this.latestTime = snapshot.getLatestTime();
        this.shouldRun = snapshot.isShouldRun();
    }

}
