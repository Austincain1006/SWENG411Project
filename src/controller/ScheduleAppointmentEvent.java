package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ScheduleAppointmentEvent  implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        System.out.println("Button Clicked!");
    }
}
