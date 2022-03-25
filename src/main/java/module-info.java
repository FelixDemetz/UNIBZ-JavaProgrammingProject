module projectgrouplf.projectlf {
    requires javafx.controls;
    requires javafx.fxml;


    opens projectgrouplf.projectlf to javafx.fxml;
    exports projectgrouplf.projectlf;
}