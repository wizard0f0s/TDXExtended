package com.wizard0f0s.tdxextended;

public class ServerItem {

    private String name;
    private String baseSite;
    private String username;
    private String password;
    private boolean isAdmin;
    private boolean isActive;

    public ServerItem() {
        this("", "", "", "", false, false);
    }

    public ServerItem(String name, String baseSite, String username, String password, boolean isAdmin, boolean isActive) {
        this.name = name;
        this.baseSite = baseSite;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseSite() {
        return baseSite;
    }

    public void setBaseSite(String baseSite) {
        this.baseSite = baseSite;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object obj) {
        if (!this.baseSite.equalsIgnoreCase(((ServerItem) obj).getBaseSite()))
            return false;
        if (!this.username.equalsIgnoreCase(((ServerItem) obj).getUsername()))
            return false;
        if (!this.password.equalsIgnoreCase(((ServerItem) obj).getPassword()))
            return false;
        return this.isAdmin == ((ServerItem) obj).isAdmin;
    }

    public boolean copy(ServerItem item) {
        if (item == null) {
            return false;
        }
        this.name = item.getName();
        this.baseSite = item.getBaseSite();
        this.username = item.getUsername();
        this.password = item.getPassword();
        this.isAdmin = item.isAdmin();
        this.isActive = item.isActive();

        return true;
    }
}
