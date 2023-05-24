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
    exports com.example.oop_finalproject_2.moviepages;
    opens com.example.oop_finalproject_2.moviepages to javafx.fxml;
    exports com.example.oop_finalproject_2.purchaseticket;
    opens com.example.oop_finalproject_2.purchaseticket to javafx.fxml;
    exports com.example.oop_finalproject_2.login_register;
    opens com.example.oop_finalproject_2.login_register to javafx.fxml;
    exports com.example.oop_finalproject_2.mainmenu;
    opens com.example.oop_finalproject_2.mainmenu to javafx.fxml;
    exports com.example.oop_finalproject_2.account;
    opens com.example.oop_finalproject_2.account to javafx.fxml;
    exports com.example.oop_finalproject_2.purchaseconfirm;
    opens com.example.oop_finalproject_2.purchaseconfirm to javafx.fxml;
    exports com.example.oop_finalproject_2.purchasehistory;
    opens com.example.oop_finalproject_2.purchasehistory to javafx.fxml;
}