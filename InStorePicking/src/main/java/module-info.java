module com.teamai.hackitall.instorepicking {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.teamai.hackitall.instorepicking to javafx.fxml;
    exports com.teamai.hackitall.instorepicking;
}