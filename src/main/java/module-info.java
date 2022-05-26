module projectgrouplf.projectlf {
    requires javafx.fxml;
    requires transitive javafx.controls;
    requires transitive javafx.graphics;

    opens projectgrouplf.projectlf to javafx.fxml;
    exports projectgrouplf.projectlf;
}