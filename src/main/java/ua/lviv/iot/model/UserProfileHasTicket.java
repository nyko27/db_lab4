package ua.lviv.iot.model;


public class UserProfileHasTicket {

    private Integer id;
    private Integer ticketId;
    private Integer userProfileId;

    public UserProfileHasTicket(Integer id, Integer ticketId, Integer userProfileId) {
        this.id = id;
        this.ticketId = ticketId;
        this.userProfileId = userProfileId;
    }

    public UserProfileHasTicket(Integer ticketId, Integer userProfileId) {
        this(null, ticketId, userProfileId);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Integer userProfileId) {
        this.userProfileId = userProfileId;
    }

    @Override
    public String toString() {
        return "\nUserProfileHasTicket: " +
                "id:" + id +
                ", ticketId" + ticketId +
                ", userProfileId:" + userProfileId;
    }
}


