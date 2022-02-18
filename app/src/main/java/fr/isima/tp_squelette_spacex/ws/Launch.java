package fr.isima.tp_squelette_spacex.ws;

import java.io.Serializable;

public class Launch implements Serializable {

    public String mission_name;
    public Long launch_date_unix;
    public LaunchInfoRocket rocket;
    public LaunchInfoLinks links;
}
