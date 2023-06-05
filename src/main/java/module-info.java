module com.example.oop_finalproject_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.oop_finalproject_2 to javafx.fxml;
    exports com.example.oop_finalproject_2;
    exports com.example.oop_finalproject_2.domainmodel;
    opens com.example.oop_finalproject_2.domainmodel to javafx.fxml;
    exports com.example.oop_finalproject_2.controller;
    opens com.example.oop_finalproject_2.controller to javafx.fxml;
    exports com.example.oop_finalproject_2.view;
    opens com.example.oop_finalproject_2.view to javafx.fxml;
}