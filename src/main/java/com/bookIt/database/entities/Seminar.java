package com.bookIt.database.entities;

import java.sql.Array;
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
}
