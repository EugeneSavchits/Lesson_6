package models;

import lombok.Data;

@Data
public class Project {
    private String name;
    private String announcement;
    private boolean isShowAnnouncement;
    private String typeOfProject;
    private boolean isCompleted;


}
