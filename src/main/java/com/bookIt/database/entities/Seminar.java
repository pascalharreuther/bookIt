package com.bookIt.database.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Seminar {
    private long id;
    private String name;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private Location location;
    private long numberParticipiants;
    private long maxNumberParticipiants;
    private List<Leader> leaderList = new ArrayList<>();
    private List<Participiant> participiantList = new ArrayList<>();
    private List<Attachment> attachmentList = new ArrayList<>();
    private List<Requirement> requirementList = new ArrayList<>();
    private List<ContactPerson> contactPersonList = new ArrayList<>();
    private boolean showMoreInformation = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public long getNumberParticipiants() {
        return numberParticipiants;
    }

    public void setNumberParticipiants(long numberParticipiants) {
        this.numberParticipiants = numberParticipiants;
    }

    public long getMaxNumberParticipiants() {
        return maxNumberParticipiants;
    }

    public void setMaxNumberParticipiants(long maxNumberParticipiants) {
        this.maxNumberParticipiants = maxNumberParticipiants;
    }

    public List<Leader> getLeaderList() {
        return leaderList;
    }

    public void setLeaderList(List<Leader> leaderList) {
        this.leaderList = leaderList;
    }

    public List<Participiant> getParticipiantList() {
        return participiantList;
    }

    public void setParticipiantList(List<Participiant> participiantList) {
        this.participiantList = participiantList;
    }

    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<Attachment> attachmentList) {
        this.attachmentList = attachmentList;
    }

    public List<Requirement> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<Requirement> requirementList) {
        this.requirementList = requirementList;
    }

    public List<ContactPerson> getContactPersonList() {
        return contactPersonList;
    }

    public void setContactPersonList(List<ContactPerson> contactPersonList) {
        this.contactPersonList = contactPersonList;
    }

    public boolean isShowMoreInformation() {
        return showMoreInformation;
    }

    public void setShowMoreInformation(boolean showMoreInformation) {
        this.showMoreInformation = showMoreInformation;
    }
}
